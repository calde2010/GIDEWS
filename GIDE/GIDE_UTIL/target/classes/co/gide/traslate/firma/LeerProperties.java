package co.gide.traslate.firma;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeerProperties {
	Properties propiedades;
	
	
	
	public LeerProperties(){
		propiedades = new Properties();
		
	}
	
	public   Properties leerArchivo() {
		try {

			/** Creamos un Objeto de tipo Properties */
		

			/** Cargamos el archivo desde la ruta especificada */
			propiedades.load(new FileInputStream("C://home//properties//web.properties"));

			/** Obtenemos los parametros definidos en el archivo 
			String nombre = propiedades.getProperty("nombre");
			String pagina = propiedades.getProperty("pagina");
                */

		} catch (FileNotFoundException e) {
			System.out.println("Error, El archivo no exite C://home//properties//web.properties");
		} catch (IOException e) {
			System.out.println("Error, No se puede leer el archivo C://home//properties//web.properties");
		}
		return propiedades;
	}

}
