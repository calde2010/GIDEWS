package co.gide.traslate.complementos.negocio;



public class ValidarPassword {
	
	public ValidarPassword(){
		
	}
	
	public int cantidadDeNumeros(String password){
		int contador=0;
		String numeros="1234567890";
		int tamanoPassword=password.length();
		for(int i=0;i<tamanoPassword;i++){
			for(int j=0;j<numeros.length();j++){
				if(password.charAt(i)==numeros.charAt(j)){
					contador++;
					break;
				}
			}
		}
		return contador;
	}
	
	public int cantidadDeLetras(String password){
		int contador=0;
		String letras="qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
		int tamanoPassword=password.length();
		for(int i=0;i<tamanoPassword;i++){
			for(int j=0;j<letras.length();j++){
				if(password.charAt(i)==letras.charAt(j)){
					contador++;
					break;
				}
			}
		}
		return contador;
	}
	
	public int cantidadCaracteresEspeciales(String password){
		String letras="1234567890qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
		int tamanoPassword=password.length();
		int contador=tamanoPassword;
		for(int i=0;i<tamanoPassword;i++){
			for(int j=0;j<letras.length();j++){
				if(password.charAt(i)==letras.charAt(j)){
					contador--;
					break;
				}
			}
		}
		return contador;
	}
	

	public int cantidadDeCaracteresDiferentes(String passwordNuevo , String passwordActual){
		int contador=0;
		
		for(int i=0;i<passwordNuevo.length();i++){
			
			boolean control=true;
			for(int j=0;j<passwordActual.length();j++){
				if(passwordNuevo.charAt(i)==passwordActual.charAt(j)){
					control=false;
					break;
				}
			}
			
			if(control){
				contador++;
			}
			
		}
		return contador;
	}

}
