package co.gide.traslate.firma;


public class ReturnCodes {

	// Codigos de retorno producidos por ManagerKeystore.
	public static final String MK_KO="manager.keysignatureore.ok";
	public static final String MK_OK="manager.keysignatureore.ko";
	public static final String MK_FILE_NOT_FOUND_EXCEPTION="manager.keysignatureore.file.not.found.exception";
	public static final String MK_IO_EXCEPTION_LOADING_KEYSTORE="manager.keysignatureore.io.exception.loading.keysignatureore";
	public static final String MK_EXCEPTION="manager.keysignature.exception";
	public static final String MK_UNRECOVERABLE_KEY_EXCEPTION_LOADING_PRIVATE_KEY="manager.keysignatureore.unrecoverable.key.exception.loading.private.key";
	public static final String MK_NO_SUCH_ALGORITHM_EXCEPTION_LOADING_PRIVATE_KEY="manager.keysignatureore.no.such.algorithm.exception.loading.private.key";
	public static final String MK_CERTIFICATE_NOT_FOUND="manager.keysignatureore.certificate.not.found";
	public static final String MK_INVALID_KEY_EXCEPTION_VERIFYING_CERTIFICATE="manager.keysignatureore.invalid.key.exception.verifying.certificate";
	public static final String MK_CERTIFICATE_EXCEPTION_VERIFYING_CERTIFICATE="manager.keysignatureore.certificate.exception.verifying.certificate";
	public static final String MK_NO_SUCH_ALGORITHM_EXCEPTION_VERIFYING_CERTIFICATE="manager.keysignatureore.no.such.algorithm.exception.verifying.certificate";
	public static final String MK_NO_SUCH_PROVIDER_EXCEPTION_VERIFYING_CERTIFICATE="manager.keysignatureore.no.such.provider.exception.verifying.certificate";
	public static final String MK_SIGNATURE_EXCEPTION_VERIFYING_CERTIFICATE="manager.keysignatureore.signature.exception.verifying.certificate";
	public static final String MK_THROWABLE="manager.keysignatureore.throwable";
	public static final String MK_ERROR_DECODE_PASSWORD_EXCEPTION="manager.keysignatureore.error.decode.password.exception";

	

	// Codigos de retorno producidos por CRLStandard.
	public static final String CRL_KO="crl.ko";
	public static final String CRL_OK="crl.ok";
	public static final String CRL_CERTIFICATE_EXCEPTION="crl.certificate.exception";
	public static final String CRL_INVALID_KEY_EXCEPTION="crl.invalid.key.exception";
	public static final String CRL_NO_SUCH_ALGORITHM_EXCEPTION="crl.no.such.algorithm.exception";
	public static final String CRL_MALFORMED_URL_EXCEPTION="crl.malformed.url.exception";
	public static final String CRL_UNKNOWN_RESPONSE_EXCEPTION="crl.unknown.response.exception";
	public static final String CRL_SIGNATURE_EXCEPTION="crl.signature.exception";
	public static final String CRL_IO_EXCEPTION_GETTING_RESPONSE="crl.io.exception.getting.response";
	public static final String CRL_CRL_EXCEPTION_GETTING_RESPONSE="crl.crl.exception.getting.response";
	public static final String CRL_COMMUNICATION_EXCEPTION="crl.communication.exception";
	public static final String CRL_NO_CERTIFICATION_AUTHORITY="crl.no.certification.authority";
	public static final String CRL_THROWABLE="crl.throwable";
	public static final String CRL_INVALID_CERTIFICATE="crl.invalid.certificate";
	public static final String CRL_MALFORMED_REQUEST="crl.malformed.requesignature";
	public static final String CRL_INTERNAL_ERROR="crl.internal.error";
	public static final String CRL_TRY_LATER="crl.try.later";
	public static final String CRL_SIGN_REQUIRED="crl.sign.required";
	public static final String CRL_UNAUTHORIZED="crl.unauthorized";
	public static final String CRL_NO_MORE_DATA="crl.no.more.data";
	public static final String CRL_CERTIFICATE_UNKNOWN="crl.certificate.unknown";
	public static final String CRL_CERTIFICATE_REVOKED="crl.certificate.revoked";
	public static final String CRL_CERTIFICATE_GOOD="crl.certificate.good";



	// Codigos de retorno producidos por SingTypes.
	public static final String ST_OK="signature.ok";
	public static final String ST_KO="signature.ko";
	public static final String ST_NO_SUCH_ALGORITHM_EXCEPTION_CREATING_DIGEST="signature.no.such.algorithm.exception.creating.digesignature";
	public static final String ST_INVALID_ALGORITHM_PARAMETER_EXCEPTION_CREATING_DIGEST="signature.invalid.algorithm.parameter.exception.creating.digesignature";
	public static final String ST_NO_SUCH_ALGORITHM_EXCEPTION_CREATING_SIGNATURE="signature.no.such.algorithm.exception.creating.signature";
	public static final String ST_INVALID_ALGORITHM_PARAMETER_EXCEPTION_CREATING_SIGNATURE="signature.invalid.algorithm.parameter.exception.creating.signature";
	public static final String ST_SAX_EXCEPTION_PARSING_DOCUMENT="signature.sax.exception.parsing.document";
	public static final String ST_IO_EXCEPTION_PARSING_DOCUMENT="signature.io.exception.parsing.document";
	public static final String ST_PARSER_CONFIGURATION_EXCEPTION_PARSING_DOCUMENT="signature.parser.configuration.exception.parsing.document";
	public static final String ST_SIGNATURE_EXCEPTION_SIGNING="signature.signature.exception.signing";
	public static final String ST_MARSHAL_EXCEPTION_SIGNING="signature.marshal.exception.signing";
	public static final String ST_NO_SUCH_ALGORITHM_EXCEPTION_CANONALIZATING="signature.no.such.algorithm.exception.canonalizating";
	public static final String ST_NO_SUCH_PROVIDER_EXCEPTION_MIME_MULTIPART = "signature.no.such.provider.exception.mime.multipart";
	public static final String ST_INVALID_ALGORITHM_PARAMETER_EXCEPTION_CANONALIZATING="signature.invalid.algorithm.parameter.exception.canonalizating";
	public static final String ST_MALFORMED_URL_EXCEPTION_CREATING_TIMESTAMPROCESSOR="signature.malformed.url.exception.creating.timesignatureamprocessor";
	public static final String ST_XML_SIGNATURE_EXCEPTION_APENDING_TIMESTAMP="signature.xml.signature.exception.apending.timesignatureamp";
	public static final String ST_MARSHAL_EXCEPTION_APENDING_TIMESTAMP="signature.marshal.exception.apending.timesignatureamp";
	public static final String ST_INVALID_TSA_DATES="signature.invalid.tsa.dates";
	public static final String ST_TSA_VALIDATING_ERROR_FOR_SIGNATURE="signature.tsa.validating.error.for.signature";
	public static final String ST_SIGNATURE_EXCEPTION_VALIDATING_TSA="signature.signature.exception.validating.tsa";
	public static final String ST_NOT_TSA_CERTIFICATE="signature.not.tsa.certificate";
	public static final String ST_TSA_VALIDATING_ERROR_FOR_CERTIFICATE="signature.tsa.validating.error.for.certificate";
	public static final String ST_TIME_STAMP_TOKEN_EXCEPTION_VALIDATING_TSA_CERTIFICATE="signature.time.signatureamp.token.exception.validating.tsa.certificate";
	public static final String ST_FILE_NOT_FOUND_EXCEPTION_OPENING_FILE="signature.file.not.found.exception.opening.file";
	public static final String ST_FILE_NOT_FOUND_EXCEPTION_CREATING_FILE="signature.file.not.found.exception.creating.file";
	public static final String ST_TRANSFORMER_CONFIGURATION_EXCEPTION_CREATING_FILE="signature.transformer.configuration.exception.creating.file";
	public static final String ST_TRANSFORMER_EXCEPTION_CREATING_FILE="signature.transformer.exception.creating.file";
	public static final String ST_OPEN_FILE_EXCEPTION_NOT_PERMISSIONS="signature.open.file.exception.not.permissions";
	public static final String ST_IO_EXCEPTION_OPENING_DOCUMENT="signature.io.exception.opening.document";
	public static final String ST_CERTIFICATE_ENCODING_EXCEPTION="signature.certificate.encoding.exception";
	public static final String ST_CERTIFICATE_EXCEPTION="signature.certificate.exception";
	public static final String ST_UNSUPPORTED_ENCODING_EXCEPTION="signature.unsupported.encoding.exception";
	public static final String ST_IO_EXCEPTION_WRITTING_DOCUMENT="signature.io.exception.writting.document";
	public static final String ST_DOCUMENT_EXCEPTION_SIGNING="signature.document.exception.signing";
	public static final String ST_IO_EXCEPTION_SIGNING="signature.io.exception.signing";
	public static final String ST_DOCUMENT_EXCEPTION_CLOSING_STAMPER="signature.document.exception.closing.signatureamper";
	public static final String ST_IO_EXCEPTION_CLOSING_STAMPER="signature.io.exception.closing.signatureamper";
	public static final String ST_MESSAGING_EXCEPTION="signature.messaging.exception";
	public static final String ST_IO_EXCEPTION_GENERATING_MIME_MESSAGE="signature.io.exception.generating.mime.message";
	public static final String ST_MESSAGING_EXCEPTION_GENERATING_MIME_MESSAGE="signature.messaging.exception.generating.mime.message";
	public static final String ST_NO_SUCH_ALGORITHM_EXCEPTION_MIME_MULTIPART="signature.no.such.algorithm.exception.mime.multipart";
	public static final String ST_SMIMEEXCEPTION_MIME_MULTIPART="signature.smimeexception.mime.multipart";
	public static final String ST_IO_EXCEPTION_GENERATING_WRITTING_MESSAGE="signature.io.exception.generating.writting.message";
	public static final String ST_MESSAGING_EXCEPTION_GENERATING_WRITTING_MESSAGE="signature.messaging.exception.generating.writting.message";
	public static final String ST_EXPIRED_CERTIFICATE="signature.expired.certificate";
	public static final String ST_KEY_EXCEPTION="signature.key.exception";
	public static final String ST_THROWABLE="signature.throwable";
	public static final String ST_ERROR_PARSING_CERTIFICATE_VALIDITY_DATE="signature.error.parsing.certificate.validity.date";
	public static final String ST_ERROR_PARSING_TSA_CERTIFICATE_VALIDITY_DATE="signature.error.parsing.tsa.certificate.validity.date";
	public static final String ST_SIGNER_INFO_GENERATOR_EXCEPTION="signature.signer.info.generator.exception";
	public static final String ST_GENERATE_INFO_CERTIFICATE_EXCEPTION="signature.generate.info.certificate.exception";
	public static final String ST_SMIME_CERT_STORE_EXCEPTION_SIGNED_GENERATOR_SMIME = "signature.smime.cert.store.exception.signed.generator.smime";
	public static final String ST_SMIME_EXCEPTION_SIGNED_GENERATOR_SMIME = "signature.smime.exception.signed.generator.smime";
	public static final String ST_INVALID_ALGORITHM_PARAMETER_EXCEPTION_CREATING_CERTSTORE_SMIME = "signature.invalid.algorithm.prameter.exception.creating.certstore.smime";
	public static final String ST_NO_SUCH_ALGORITHM_EXCEPTION_CREATING_CERTSTORE_SMIME = "signature.no.such.algorithm.exception.creating.certstore.smime";
	public static final String ST_NO_SUCH_PROVIDER_EXCEPTION_CREATING_CERTSTORE_SMIME = "signature.no.such.provider.exception.creating.certstore.smime";




	// Codigos de retorno producidos por ValidateTypes.
	public static final String VT_OK="validate.ok";
	public static final String VT_KO="validate.ko";
	public static final String VT_SAX_EXCEPTION_PARSING_DOCUMENT="validate.sax.exception.parsing.document";
	public static final String VT_IO_EXCEPTION_PARSING_DOCUMENT="validate.io.exception.parsing.document";
	public static final String VT_PARSER_CONFIGURATION_EXCEPTION_PARSING_DOCUMENT="validate.parser.configuration.exception.parsing.document";
	public static final String VT_SIGNATURE_NOT_FOUND="validate.signature.not.found";
	public static final String VT_SIGNATURE_NUMBER_EXCEPTION="validate.signature.number.exception";
	public static final String VT_NULL_DOM_VALIDATE_CONTEXT="validate.null.dom.validate.context";
	public static final String VT_MARSHAL_EXCEPTION_GETTING_SIGNATURE="validate.marshal.exception.getting.signature";
	public static final String VT_INVALID_SIGNATURE="validate.invalid.signature";
	public static final String VT_XML_SIGNATURE_EXCEPTION_VALIDATING_SIGNATURE="validate.xml.signature.exception.validating.signature";
	public static final String VT_XML_SIGNATURE_EXCEPTION_VALIDATING_SIGNATURE_VALUE="validate.xml.signature.exception.validating.signature.value";
	public static final String VT_XML_SIGNATURE_EXCEPTION_VALIDATING_SIGNATURE_REFERENCE="validate.xml.signature.exception.validating.signature.reference";
	public static final String VT_EXCEPTION_OBTAINING_CERTIFICATE="validate.exception.obtaining.certificate";
	public static final String VT_TIMESTAMP_NOT_FOUND="validate.timesignatureamp.not.found";
	public static final String VT_ERROR_VALIDATING_SIGNATURE_TIMESTAMP="validate.error.validating.signature.timesignatureamp";
	public static final String VT_XML_SIGNATURE_EXCEPTION_VALIDATING_SIGNATURE_TIMESTAMP="validate.xml.signature.exception.validating.signature.timesignatureamp";
	public static final String VT_ERROR_VALIDATING_TIMESTAMP_TOKEN="validate.error.validating.timesignatureamp.token";
	public static final String VT_TIMESTAMP_TOKEN_EXCEPTION="validate.timesignatureamp.token.exception";
	public static final String VT_EDI_MESSAGE_VALIDATION_EXCEPTION_CREATING_VALIDATION="validate.edi.message.validation.exception.creating.validation";
	public static final String VT_EDI_MESSAGE_VALIDATION_EXCEPTION_VALIDATING="validate.edi.message.validation.exception.validating";
	public static final String VT_EDI_WRONG_CERTIFICATE_EXCEPTION="validate.edi.wrong.certificate.exception";
	public static final String VT_EDI_UNSUPORTED_ENCODING_EXCEPTION="validate.edi.unsuported.encoding.exception";
	public static final String VT_EDI_UNSUPPORTED_ALGORITHM_EXCEPTION="validate.edi.unsupported.algorithm.exception";
	public static final String VT_EDI_UNSUPPORTED_HASH_EXCEPTION="validate.edi.unsupported.hash.exception";
	public static final String VT_EDI_UNSUPPORTED_SECURITY_PARAMETER_EXCEPTION="validate.edi.unsupported.security.parameter.exception";
	public static final String VT_EDI_INSUFFICIENT_SECURITY_PARAMETERS_EXCEPTION="validate.edi.insufficient.security.parameters.exception";
	public static final String VT_EDI_NO_SECURITY_FOUND_EXCEPTION="validate.edi.no.security.found.exception";
	public static final String VT_EDI_EXCEPTION="validate.edi.exception";
	public static final String VT_FILE_NOT_FOUND_EXCEPTION_PARSING_DOCUMENT="validate.file.not.found.exception.parsing.document";
	public static final String VT_IO_EXCEPTION_CREATING_PDF_READER="validate.io.exception.creating.pdf.reader";
	public static final String VT_SIGNATURE_EXCEPTION_VERIFYING_SIGNATURE="validate.signature.exception.verifying.signature";
	public static final String VT_ERROR_VERIFYING_CERTIFICATE="validate.error.verifying.certificate";
	public static final String VT_ERROR_VERIFYING_SIGNATURE="validate.error.verifying.signature";
	public static final String VT_FILE_NOT_FOUND_EXCEPTION_OPENING_DOCUMENT="validate.file.not.found.exception.opening.document";
	public static final String VT_MESSAGING_EXCEPTION_OPENING_DOCUMENT="validate.messaging.exception.opening.document";
	public static final String VT_CMS_EXCEPTION_OPENING_DOCUMENT="validate.cms.exception.opening.document";
	public static final String VT_IO_EXCEPTION_OPENING_DOCUMENT="validate.io.exception.opening.document";
	public static final String VT_CMS_EXCEPTION_VERIFYING_SIGNER="validate.cms.exception.verifying.signer";
	public static final String VT_THROWABLE="validate.throwable";
	public static final String VT_ERROR_PARSING_CERTIFICATE_VALIDITY_DATE="validate.error.parsing.certificate.validity.date";
	public static final String VT_ERROR_PARSING_TSA_CERTIFICATE_VALIDITY_DATE="validate.error.parsing.tsa.certificate.validity.date";
	public static final String VT_EXCEPTION_CREATE_SIGNER_INFORMATION_VERIFIER="validate.exception.create.signer.information.verifier";
	public static final String VT_OPEN_FILE_EXCEPTION_NOT_PERMISSIONS="validate.open.file.exception.not.permissions";
	public static final String VT_NO_SUCH_ALGORITHM_EXCEPTION_GETTING_CERTIFICATES_SMIME = "validate.no.such.algorithm.exception.getting.certificate.smime";
	public static final String VT_NO_SUCH_PROVIDER_EXCEPTION_GETTING_CERTIFICATES_SMIME = "validate.no.such.provider.exception.getting.certificate.smime";
	public static final String VT_CMS_EXCEPTION_GETTING_CERTIFICATES_SMIME = "validate.cms.exception.getting.certificate.smime";
	public static final String VT_CERT_STORE_EXCEPTION_SMIME = "validate.cert.store.exception.smime";
	public static final String VT_CERTIFICATE_EXPIRED_EXCEPTION_VERIFYING_SIGNER_SMIME = "validate.certificate.expired.exception.verifying.signer.smime";
	public static final String VT_CERTIFICATE_NOT_YET_VALID_EXCEPTION_VERIFYING_SIGNER_SMIME = "validate.certificate.not.yet.valid.exception.verifying.signer.smime";
	public static final String VT_NO_SUCH_ALGORITHM_EXCEPTION_VERIFYING_SIGNER_SMIME = "validate.no.such.algorithm.exception.verifying.signer.smime";
	public static final String VT_NO_SUCH_PROVIDER_EXCEPTION_VERIFYING_SIGNER_SMIME = "validate.no.such.provider.exception.verifying.signer.smime";
	public static final String VT_CERTIFICATE_CHAIN_NOT_FOUND = "validate.certificate.chain.not.found";

	//Codigos genoricos
	public static final String CONSTRUCTOR_NOT_FOUND_EXCEPTION="constructor.not.found.exception";
	public static final String CLASS_NOT_FOUND_EXCEPTION="class.not.found.exception";
	public static final String INSTANTIATION_EXCEPTION="insignatureantiation.exception";
	public static final String ILLEGAL_ACCESS_EXCEPTION="illegal.access.exception";
	public static final String CLASS_NOT_FOUND_EXCEPTION_VALIDATE_CERT="class.not.found.exception.validate.cert";
	public static final String INSTANTIATION_EXCEPTION_VALIDATE_CERT="insignatureantiation.exception.validate.cert";
	public static final String ILLEGAL_ACCESS_EXCEPTION_VALIDATE_CERT="illegal.access.exception.validate.cert";
	public static final String IO_EXCEPTION_LOADING_PROPERTIES="io.exception.loading.properties";
	public static final String VWS_DOCUMENT_NEEDED="vws.document.needed";
	public static final String VWS_THROWABLE="vws.throwable";
	public static final String VALIDATE_REQUEST_EXCEPTION="validate.requesignature.exception";
	public static final String ILLEGAL_DOCUMENT_EXCEPTION="illegal.document.exception";
	public static final String POLICY_BUILD_EXCEPTION="policy.build.exception";







}
