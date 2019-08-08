package co.gide.traslate.firma;

import xades4j.providers.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStore.Builder;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import xades4j.verification.UnexpectedJCAException;


/**
 * A KeyStore-based implementation of {@code KeyingDataProvider}. The keystore is
 * loaded on first access.
 * <p>
 * The following procedure is done to get the signing certificate:
 * <ol>
 *  <li>Get all the X509Certificates in private key entries</li>
 *  <li>Invoke the supplied {@code SigningCertSelector} to choose the certificate and thus the entry</li>
 *  <li>Get the entry alias matching the selected certificate</li>
 *  <li>Get the certificate chain for that entry</li>
 * </ol>
 * <p>
 * The following procedure is done to get the signing key:
 * <ol>
 *  <li>Get the entry alias matching the provided certificate</li>
 *  <li>Get the protection to access that entry</li>
 *  <li>Return the entry's private key</li>
 * </ol>
 *
 * @see FileSystemKeyStoreKeyingDataProvider
 * @see PKCS11KeyStoreKeyingDataProvider * 
 */

public abstract class KeyStoreKeyingDataProviderImpl implements KeyingDataProvider
{
	/**
	 * Provides a password to load the keystore.
	 */
	public interface KeyStorePasswordProvider
	{
		char[] getPassword();
	}

	/**
	 * Provides a password to access a keystore entry.
	 */
	public interface KeyEntryPasswordProvider
	{
		char[] getPassword(String entryAlias, X509Certificate entryCert);
	}

	/**
	 * Used to select a certificate from the available certificates. All the
	 * X509Certificates in private key entries are passed.
	 */
	public interface SigningCertSelector
	{
		X509Certificate selectCertificate(
				List<X509Certificate> availableCertificates);
	}
	/**/

	/**
	 * Gets a builder that will create the keystore instance. This is usued because
	 * different types of keystores may be configured differently.
	 */
	protected interface KeyStoreBuilderCreator
	{
		/**
		 * @param loadProtection the protection that should be used to load the keystore (may be null)
		 * @return the builder
		 */
		Builder getBuilder(ProtectionParameter loadProtection);
	}
	/**/
	/**/
	private KeyStore keyStore;
	private final KeyStoreBuilderCreator builderCreator;
	private final SigningCertSelector certificateSelector;
	private final KeyStorePasswordProvider storePasswordProvider;
	private final KeyEntryPasswordProvider entryPasswordProvider;
	private final boolean returnFullChain;
	private boolean initialized;
	private final String alias;

	/**
	 *
	 * @param builderCreator
	 * @param certificateSelector
	 * @param storePasswordProvider
	 * @param entryPasswordProvider
	 * @param returnFullChain return the full certificate chain, if available
	 * @throws KeyStoreException
	 */
	protected KeyStoreKeyingDataProviderImpl(
			KeyStoreBuilderCreator builderCreator,
			SigningCertSelector certificateSelector,
			KeyStorePasswordProvider storePasswordProvider,
			KeyEntryPasswordProvider entryPasswordProvider,
			boolean returnFullChain,String alias) throws KeyStoreException
			{
		this.builderCreator = builderCreator;
		this.keyStore = null;
		this.certificateSelector = certificateSelector;
		this.storePasswordProvider = storePasswordProvider;
		this.entryPasswordProvider = entryPasswordProvider;
		this.returnFullChain = returnFullChain;
		this.initialized = false;
		this.alias=alias;
			}

	private void ensureInitialized() throws UnexpectedJCAException
	{
		if (!this.initialized)
		{
			try
			{
				KeyStore.CallbackHandlerProtection storeLoadProtec = null;
				if (storePasswordProvider != null)
					// Create the load protection with callback.
					storeLoadProtec = new KeyStore.CallbackHandlerProtection(new CallbackHandler()
					{
						@Override
						public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
						{
							PasswordCallback c = (PasswordCallback)callbacks[0];
							c.setPassword(storePasswordProvider.getPassword());
						}
					});
				else
					// If no load password provider is supplied is because it shouldn't
					// be needed. Create a dummy protection because the keystore
					// builder needs it to be non-null.
					storeLoadProtec = new KeyStore.CallbackHandlerProtection(new CallbackHandler()
					{
						@Override
						public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
						{
							throw new UnsupportedOperationException("No KeyStorePasswordProvider");
						}
					});
				this.keyStore = builderCreator.getBuilder(storeLoadProtec).getKeyStore();
			} catch (KeyStoreException ex)
			{
				throw new UnexpectedJCAException("The keystore couldn't be initialized", ex);
			}
			this.initialized = true;
		}
	}

	@Override
	public List<X509Certificate> getSigningCertificateChain() throws SigningCertChainException, UnexpectedJCAException
	{
		ensureInitialized();
		try
		{
			List<X509Certificate> availableSignCerts = new ArrayList<X509Certificate>(keyStore.size());

			for (Enumeration<String> aliases = keyStore.aliases(); aliases.hasMoreElements();)
			{
				String alias = aliases.nextElement();
				if(alias.equals(this.alias))
				{
					if (keyStore.entryInstanceOf(alias, KeyStore.PrivateKeyEntry.class))
					{
						Certificate cer = keyStore.getCertificate(alias);
						if (cer instanceof X509Certificate)
							availableSignCerts.add((X509Certificate)cer);
					}
				}
			}

			if (availableSignCerts.isEmpty())
				throw new SigningCertChainException("No certificates available in the key store");

			// Select the signing certificate from the available certificates.
			X509Certificate signingCert = certificateSelector.selectCertificate(availableSignCerts);

			String signingCertAlias = keyStore.getCertificateAlias(signingCert);
			if (null == signingCertAlias)
				throw new SigningCertChainException("Selected certificate not present in the key store");

			Certificate[] signingCertChain = keyStore.getCertificateChain(signingCertAlias);
			if (null == signingCertChain)
				throw new SigningCertChainException("Selected certificate doesn't match a key and corresponding certificate chain");

			if (this.returnFullChain)
			{
				List lChain = Arrays.asList(signingCertChain);
				return Collections.checkedList(lChain, X509Certificate.class);
			} else
				return Collections.singletonList((X509Certificate)signingCertChain[0]);

		} catch (KeyStoreException ex)
		{
			// keyStore.getCertificateAlias, keyStore.getCertificateChain -> if the
			// keystore is not loaded.
			throw new UnexpectedJCAException(ex.getMessage(), ex);
		}
	}

	@Override
	public PrivateKey getSigningKey(X509Certificate signingCert) throws SigningKeyException, UnexpectedJCAException
	{
		ensureInitialized();
		try
		{
			// The certificate supplied by the library is always the first certificate
			// in the chain supplied by getSigningCertificateChain, which means
			// that an entry will always be present. Also, this entry is always
			// a PrivateKeyEntry.
			String entryAlias = keyStore.getCertificateAlias(signingCert);
			KeyStore.PrivateKeyEntry entry = (KeyStore.PrivateKeyEntry)keyStore.getEntry(
					entryAlias,
					getKeyProtection(entryAlias, signingCert, entryPasswordProvider));
			return entry.getPrivateKey();

		} catch (UnrecoverableKeyException ex)
		{
			throw new SigningKeyException("Invalid key entry password", ex);
		} catch (GeneralSecurityException ex)
		{
			// NoSuchAlgorithmException
			// UnrecoverableEntryException
			// KeyStoreException
			throw new UnexpectedJCAException(ex.getMessage(), ex);
		}
	}

	/**
	 * Gets a protection parameter to access the specified entry.
	 * @param entryAlias the alias of the entry that is being accessed
	 * @param entryCert the cerificate in the entry
	 * @param entryPasswordProvider the password provider that should be used to
	 *      get the actual password (may be {@code null})
	 * @return the protection
	 */
	protected abstract KeyStore.ProtectionParameter getKeyProtection(
			String entryAlias,
			X509Certificate entryCert,
			KeyEntryPasswordProvider entryPasswordProvider);
}

