package co.gide.tx.Exception;



public class ComponenteException extends Exception implements CodigoErrores{

	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -2501880417744078585L;
	
	private java.lang.Throwable originalException = null;
	private String message;
	private String errorCode;
	
	
	/**
	 * CONSTRUCTORES 
	 */
	
	
	public ComponenteException(String message, String errorCode, Throwable originalException) {
		super(message);
		this.originalException = originalException;
		this.message = message;
		this.errorCode = errorCode;
	}

	public ComponenteException(String message, String errorCode)
	{
		super(message);
		this.message = message;
		this.errorCode = errorCode;
		this.originalException = null;
	}
	
	/**Retorna la excepcion original
	 * @param message
	 * @param originalException
	 */
	public java.lang.Throwable getOriginalException() {
		return originalException;
	}	

	public String getErrorCode() {
		return errorCode;
	}	
	
	
	@Override
	public String toString()
	{
		StringBuilder msg = new StringBuilder(super.toString());
		msg.append(" ## Codigo Error: ");
		msg.append(this.errorCode);
		msg.append(" ## Mensaje Error: ");
		msg.append(this.message);		

		if (this.originalException!=null)
		{
		   msg.append(" ## Excepción Original : ");
		   msg.append(this.originalException.toString());
		}		
		return msg.toString();		
	}	
}
