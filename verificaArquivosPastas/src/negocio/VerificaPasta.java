package negocio;

import java.io.File;

public class VerificaPasta{

	String nomeArquivo;
	double tamanhoArquivos;
	double tamanhoArquivos2;
	
	double converteTotal;
	
	GeraLog log = new GeraLog();
	ExecutaTarefa exe = new ExecutaTarefa();
	ThreadControle controle = new ThreadControle();
	
	public double buscaArquivos(String caminho){		
			
		double tamanhoTotal = 0;
		int contador = 0;
		String arquivos[] = new String[10];
		double tamanho[] = new double[10];
		
        File arquivo = new File(caminho);
		File[] file = arquivo.listFiles(); 
        if(file != null){ 
            int length = file.length; 
            //System.out.println("Verifica os arquivos");
            log.gravaLog("Arquivos encontrados no caminho: ");
            log.gravaLog(caminho);
            for(int i = 0; i < length; ++i){ 
                File f = file[i]; 
                if(f.isFile()){
                	arquivos[contador] = f.getName();
                	tamanho[contador] = f.length();
                	tamanho[contador] = tamanho[contador] / 1000;
                	log.gravaLog(arquivos[contador] + ", " + tamanho[contador] + " KB");
                	tamanhoTotal = tamanhoTotal + tamanho[contador];
                	contador++;
                }else if(f.isDirectory()){ 
                    //System.out.println("Diretorio: " + f.getName()); 
                } 
            }
            
            log.gravaLog("Total de Arquivos encontrado: " + contador);
            converteTotal = tamanhoTotal / 1000;
            log.gravaLog("Tamanho Total: " + converteTotal + " KB");
        }
        return tamanhoTotal;
	}
	
	public void comparaTamanhos(String caminho, String comando){
		
		log.gravaLog("Comparando tamanho total da pasta.");
		tamanhoArquivos = buscaArquivos(caminho);
		log.gravaLog("Delay 10000.");
		controle.pause(10000);
		tamanhoArquivos2 = buscaArquivos(caminho);
		
		if(tamanhoArquivos2 > tamanhoArquivos){
			log.gravaLog("Volume de dados na pasta foi alterado.");
		}else if(tamanhoArquivos2 == tamanhoArquivos){
			log.gravaLog("Executa Tarefa.");
			exe.tarefa(comando);
			log.gravaLog("Tarefa executada no caminho: " + comando);
			log.gravaLog("Delay 10000");
			controle.pause(10000);
		}
	}
}