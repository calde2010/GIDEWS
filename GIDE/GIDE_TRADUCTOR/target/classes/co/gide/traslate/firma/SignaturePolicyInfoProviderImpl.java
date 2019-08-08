package co.gide.traslate.firma;

import java.io.ByteArrayInputStream;

import xades4j.properties.IdentifierType;
import xades4j.properties.ObjectIdentifier;
import xades4j.properties.SignaturePolicyBase;
import xades4j.properties.SignaturePolicyIdentifierProperty;
import xades4j.providers.SignaturePolicyInfoProvider;


public class SignaturePolicyInfoProviderImpl implements SignaturePolicyInfoProvider{

	private byte[] policyBytes;
	private String identifier;
	IdentifierType type;

	public SignaturePolicyInfoProviderImpl(byte[] policyBytes, String identifier, IdentifierType type) {
		this.policyBytes=policyBytes;
		this.identifier=identifier;
		this.type=type;
	}
	@Override
	public SignaturePolicyBase getSignaturePolicy() {
					return new SignaturePolicyIdentifierProperty(
					new ObjectIdentifier(identifier, type),
					new ByteArrayInputStream(policyBytes));
		
	}
	public byte[] getPolicyBytes() {
		return policyBytes;
	}
	public void setPolicyBytes(byte[] policyBytes) {
		this.policyBytes = policyBytes;
	}
	public IdentifierType getType() {
		return type;
	}
	public void setType(IdentifierType type) {
		this.type = type;
	}



}
