package negocio;


/*
  
  Aplicativo para execu��o de um arquivo bat, a aplica��o faz a verifica��o 
  do tamanho de uma pasta
  comparando o volude de dados em um periodo de tempo.
  
  Executar por linha de comando em Linux
 
  java -jar Aplicativo.jar "" "" ""
   
  Ocultar terminal na execu��o!
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
			pan.showCustomAlert("Caminho origem n�o configurado!");
			System.exit(0);
		}else if(comando == null || comando.trim().equals("")){
			pan.showCustomAlert("Caminho comando n�o configurado!");
			System.exit(0);
		}else if(caminhoLog == null || caminhoLog.trim().equals("")){
			pan.showCustomAlert("Caminho Log n�o configurado!");
			System.exit(0);
		}else if(!comando.toLowerCase().contains("bat".toLowerCase())){
			pan.showCustomAlert("Executavel precisa estar na extens�o .bat!");
			System.exit(0);
		}else if(tempoAnalise == null || tempoAnalise.trim().equals("")){
			pan.showCustomAlert("Tempo de compara��o n�o configurado!");
			System.exit(0);
		}else{
			
			int convertTempo = Integer.parseInt(tempoAnalise);
			int convertempoEsperaComando = Integer.parseInt(tempoEsperaComando);
			
			log.setCaminhoLog(caminhoLog);
			log.gravaLog("Inicio da aplica��o");
			
			pan.carregaPainel(); // carrega painel swing.
			while(true){ 
				
				//painel.botaoDesligar();	
				pasta.comparaTamanhos(caminho, comando, caminhoLog,
						convertTempo, convertempoEsperaComando);
				
			}
		}
	}
}



    
