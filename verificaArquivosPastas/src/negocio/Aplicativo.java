package negocio;


/*
 * Executar por linha de comando em Linux
 
   java -jar Aplicativo.jar "caminho"
 */

public class Aplicativo {

	public static void main(String[] args) {
		
		VerificaPasta pasta = new VerificaPasta();
		ThreadControle painel = new ThreadControle();
	
		//String caminho = args[0];
		//String comando = args[1];
		String caminho = "C:\\edi\\elavon\\destino\\outbox";
		String comando = "C:\\Users\\wmeier\\Desktop\\executavel.bat";
		
		//fica verificando a pasta fulltime
		while(true){ 
			
			//painel.botaoDesligar();	
			pasta.comparaTamanhos(caminho, comando);
			
		}
	}
}