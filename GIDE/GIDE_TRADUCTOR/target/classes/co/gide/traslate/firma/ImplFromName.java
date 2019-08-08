package co.gide.traslate.firma;



public class ImplFromName {

	
	
	public ImplFromName(ImplClass implClass)
	{
		this.implClass=implClass;
	}
	
	
	
	private ImplClass implClass;
	
	
	public enum ImplClass {

		 
		 SIGNATUREXADESBES( "co.simba.tx.firma.SignProcessXAdESBES"),
		 SIGNATUREXADESEPES( "co.simba.tx.firma.SignProcessXAdESEPES"),		 
		 VALIDATEXADESBES( "co.simba.tx.firma.ValidateProcessXAdESBES"),
		 VALIDATEXADESEPES( "co.simba.tx.firma.ValidateProcessXAdESEPES"),
		 CRLSTANDARD( "co.simba.tx.firma.CRLStandard");
		
		private String className;

		ImplClass(String className)
		{
			this.className=className;
		}

		public String getClassName()
		{
			return className;
		}

	}
}
