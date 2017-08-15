package negocio;


/*
 * Executar por linha de comando em Linux
 
   java -jar Aplicativo.jar "caminho"
 */

public class Aplicativo {

	public static void main(String[] args) {
		
		VerificaPasta pasta = new VerificaPasta();
		Painel pan = new Painel();
		GeraLog log = new GeraLog();
		
		String caminho = args[0];
		String comando = args[1];
		String caminhoLog = args[2];
		
		//String caminho = "C:\\edi\\elavon\\destino\\outbox";
		//String comando = "C:\\Users\\wmeier\\Desktop\\executavel.bat";
		//String caminhoLog = "C:\\Users\\wmeier\\Desktop\\executa_tarefa\\log";	
		
		if(caminho == null || caminho.trim().equals("")){
			pan.showCustomAlert("Caminho origem não configurado!");
			System.exit(0);
		}else if(comando == null || comando.trim().equals("")){
			pan.showCustomAlert("Caminho comando não configurado!");
			System.exit(0);
		}else if(caminhoLog == null || caminhoLog.trim().equals("")){
			pan.showCustomAlert("Caminho Log não configurado!");
			System.exit(0);
		}else{
			log.setCaminhoLog(caminhoLog);
			log.gravaLog("Inicio da aplicação");
			
			pan.carregaPainel(); // carrega painel swing.
			while(true){ 
				
				//painel.botaoDesligar();	
				pasta.comparaTamanhos(caminho, comando, caminhoLog);
				
			}
		}
	}
}



    
