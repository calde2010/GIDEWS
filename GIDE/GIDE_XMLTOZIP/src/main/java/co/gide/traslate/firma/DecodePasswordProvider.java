/*
 * XAdES4j - A Java library for generation and verification of XAdES signatures.
 * Copyright (C) 2010 Luis Goncalves.
 *
 * XAdES4j is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or any later version.
 *
 * XAdES4j is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with XAdES4j. If not, see <http://www.gnu.org/licenses/>.
 */
package co.gide.traslate.firma;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

import co.gide.traslate.firma.KeyStoreKeyingDataProviderImpl.KeyEntryPasswordProvider;
import co.gide.traslate.firma.KeyStoreKeyingDataProviderImpl.KeyStorePasswordProvider;
import co.gide.traslate.complementos.negocio.CipherUtils;




public class DecodePasswordProvider implements KeyStorePasswordProvider,
        KeyEntryPasswordProvider
{
    private char[] password;

    public DecodePasswordProvider(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException
    {
    	
    	
    	String decryptedPassword = CipherUtils.decrypt(password);
    	if(decryptedPassword != null)
    		this.password = decryptedPassword.toCharArray();		
    }

    @Override
    public char[] getPassword()
    {
        return password;
    }

    @Override
    public char[] getPassword(String entryAlias, X509Certificate entryCert)
    {
        return password;
    }
}
