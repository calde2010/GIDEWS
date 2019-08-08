package co.gide.traslate.firma;

import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.signature.XMLSignature;

import xades4j.UnsupportedAlgorithmException;
import xades4j.providers.AlgorithmsProvider;


public class AlgorithmsProviderImpl implements AlgorithmsProvider{

	

	

	@Override
	public String getCanonicalizationAlgorithmForSignature()
	{
		return Canonicalizer.ALGO_ID_C14N_OMIT_COMMENTS;
	}

	@Override
	public String getCanonicalizationAlgorithmForTimeStampProperties()
	{
		return Canonicalizer.ALGO_ID_C14N_OMIT_COMMENTS;
	}

	@Override
	public String getDigestAlgorithmForDataObjsReferences()
	{
		return MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA1;
	}

	@Override
	public String getDigestAlgorithmForReferenceProperties()
	{
		return MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA1;
	}

	@Override
	public String getDigestAlgorithmForTimeStampProperties()
	{
		return MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA1;
	}

	@Override
	public String getSignatureAlgorithm(String keyAlgorithmName)
			throws UnsupportedAlgorithmException {
		return XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA1;
	}

	
	
	
	    
	    
}
