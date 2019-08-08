package co.gide.traslate.complementos.negocio;



public class ComponenteConstantes {

	public static final String FACE_CODIGO_IMPUESTO_IVA = "01";
	public static final String FACE_CODIGO_IMPUESTO_2 = "02";
	public static final String FACE_CODIGO_IMPUESTO_3 = "03";
	
	public enum EnumTipoDocumento {
		INVOICE("Factura"), 
		DEBITNOTE("Nota Debito"), 
		CREDITNOTE("Nota Crédito");

		private final String descripcion;

		
		public String getDescripcion() {
			return descripcion;
		}

		EnumTipoDocumento(String descripcion) {
			this.descripcion = descripcion;
		}
	}
	
	/**
	 * Enumerador para el tipo de ambiente del componente
	 *
	 */
	public enum EnumTipoAmbiente
	{ 
	   PRUEBAS(Integer.valueOf(0), "AMBIENTE PRUEBAS"), 
	   PRODUCCION(Integer.valueOf(1), "AMBIENTE PRODUCCION");
		
       private final Integer codigo;
       private final String descripcion;
       /**
		 * Obitiene el codigo
		 * @return codigo
		 */
		public Integer getCodigo() {
			return codigo;
		}
		/**
		 * Obtiene la descripción
		 * @return descripción
		 */
		public String getDescripcion() {
			return descripcion;
		}
		/**
		 * Obtiene un enumerador de tipo de ambiente del componente
		 * @param codigo
		 * @param descripcion
		 */
		EnumTipoAmbiente(Integer codigo, String descripcion) {
			  this.codigo = codigo;
			  this.descripcion = descripcion;
		  }	
	  }
	
	public enum EnumScheme {
		SCHEMEAGENCYID("195"), 
		SCHEMEAGENCYNAME("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)"), 
		SCHEMEID("31"),
		SCHEMEVERSIONID("1.0"),
		SCHEMELANGUAGEID("ES");
		

		private final String descripcion;

		
		public String getDescripcion() {
			return descripcion;
		}

		EnumScheme(String descripcion) {
			this.descripcion = descripcion;
		}
	}
}
