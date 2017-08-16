package negocio;


/*
  
  Aplicativo para execução de um arquivo bat, a aplicação faz a verificação 
  do tamanho de uma pasta
  comparando o volude de dados em um periodo de tempo.
  
  Executar por linha de comando em Linux
 
  java -jar Aplicativo.jar "" "" ""
   
  Ocultar terminal na execução!
  start javaw -jar Aplicativo.jar "caminho analise" "comando bat" 
  "caminho log" "tempo delay analise caminho" 
   
 */

public class Aplicativo {

	public static void main(String[] args) {
		
		VerificaPasta pasta = new VerificaPasta();
		Painel pan = new Painel();
		GeraLog log = new GeraLog();
		
		//String caminho = args[0];
		//String comando = args[1];
		//String caminhoLog = args[2];
		//String tempoAnalise = args[3];
		//String tempoEsperaComando = args[4];
		
		String caminho = "C:\\edi\\elavon\\destino\\outbox";
		String comando = "C:\\Users\\wmeier\\Desktop\\executavel.bat";
		String caminhoLog = "C:\\Users\\wmeier\\Desktop\\executa_tarefa\\log";	
		String tempoAnalise = "60000"; //1 minuto
		String tempoEsperaComando = "120000"; //4 minutos
		
		if(caminho == null || caminho.trim().equals("")){
			pan.showCustomAlert("Caminho origem não configurado!");
			System.exit(0);
		}else if(comando == null || comando.trim().equals("")){
			pan.showCustomAlert("Caminho comando não configurado!");
			System.exit(0);
		}else if(caminhoLog == null || caminhoLog.trim().equals("")){
			pan.showCustomAlert("Caminho Log não configurado!");
			System.exit(0);
		}else if(!comando.toLowerCase().contains("bat".toLowerCase())){
			pan.showCustomAlert("Executavel precisa estar na extensão .bat!");
			System.exit(0);
		}else if(tempoAnalise == null || tempoAnalise.trim().equals("")){
			pan.showCustomAlert("Tempo de comparação não configurado!");
			System.exit(0);
		}else{
			
			int convertTempo = Integer.parseInt(tempoAnalise);
			int convertempoEsperaComando = Integer.parseInt(tempoEsperaComando);
			
			log.setCaminhoLog(caminhoLog);
			log.gravaLog("Inicio da aplicação");
			
			pan.carregaPainel(); // carrega painel swing.
			while(true){ 
				
				//painel.botaoDesligar();	
				pasta.comparaTamanhos(caminho, comando, caminhoLog,
						convertTempo, convertempoEsperaComando);
				
			}
		}
	}
}



    
