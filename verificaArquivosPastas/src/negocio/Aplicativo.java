package negocio;

public class Aplicativo {

	public static void main(String[] args) {
		
		VerificaPasta pasta = new VerificaPasta();
	
		
		while(true){
			pasta.comparaTamanhos();
		}
	}
}