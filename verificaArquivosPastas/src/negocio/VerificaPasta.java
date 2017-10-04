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
	
	/*
	 * Busca tamanho total da raiz definida para analise.
	 */
	public double buscaArquivos(String path)  {     
		File folder = new File(path);     
		int size = 0;
		if (folder.isDirectory()) {     	
			String[] dirList = folder.list();     
			if (dirList != null) {     
		        for (int i = 0; i < dirList.length; i++) {     
		            String fileName = dirList[i];     
		            File f = new File(path, fileName);     
		            if (f.isDirectory()) {
		                String filePath = f.getPath();
		                size += buscaArquivos(filePath);     
		                continue;     
		            }
		            size += f.length();     
		        }     
		    }     
		}
		return size;
	}
	
	/*
	 * Saida com caminho da pasta e arquivos analisados, cuspindo no log os arquivos analisado.
	 */
	public void listaDiretorio(File directory) {
		log.gravaLog("Verificando pasta "+ directory);
    	for(File arquivo: directory.listFiles()) {
    		if(arquivo.isFile()){ 
				float tamanho = arquivo.length(); //pega tamanho do arquivo
				log.gravaLog( "*** " +arquivo.getName() + ", " + tamanho + " bytes");
			}else{
				if(arquivo.isFile()) {
					log.gravaLog("Nenhum arquivo encontrado!");
				}
				
				listaDiretorio(arquivo);
			}
		}
	}
	
	/*
	public double buscaArquivos2(String caminho){		
		
		double tamanhoTotal = 0;
		int contador = 0;
		String arquivos[] = new String[100];
		float tamanho[] = new float[100];
		
		
        File arquivo = new File(caminho);
		File[] file = arquivo.listFiles(); 
        if(file != null){ 
            int length = file.length; 
            log.gravaLog("============= Verificando a pasta =============");
            log.gravaLog("Arquivos encontrados no caminho: ");
            log.gravaLog(caminho);
            for(int i = 0; i < length; ++i){ 
                File f = file[i]; 
                if(f.isFile()){
                	arquivos[contador] = f.getName();
                	tamanho[contador] = f.length();
                	log.gravaLog(arquivos[contador] + ", " + tamanho[contador] + " bytes");
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
	}*/
	
	public void comparaTamanhos(String caminho, String comando, 
			String caminhoLog, int tempoAnalise, int tempoEsperaComando){
		
		File arquivos = new File(caminho);
		
		log.setCaminhoLog(caminhoLog);
		
		log.gravaLog("Comparando tamanho total da pasta.");
		
		listaDiretorio(arquivos);
		tamanhoArquivos = buscaArquivos(caminho);
		log.gravaLog("Tamanho total: " + buscaArquivos(caminho));
		log.gravaLog("Espera para comparar tamanho das pastas " + tempoAnalise +".");
		
		controle.pause(tempoAnalise);
		log.gravaLog("Segunda Verificação");
		listaDiretorio(arquivos);
		log.gravaLog("Tamanho total: " + buscaArquivos(caminho));
		tamanhoArquivos2 = buscaArquivos(caminho);
		
		if(tamanhoArquivos == 0 && tamanhoArquivos2 == 0){
			log.gravaLog("Pasta Vazia, não faz nada!");
		}else if(tamanhoArquivos2 > tamanhoArquivos){
			log.gravaLog("Volume de dados na pasta foi alterado.");
		}else if(tamanhoArquivos2 < tamanhoArquivos){
			log.gravaLog("Volume de dados na pasta foi alterado.");
		}else if(tamanhoArquivos2 == tamanhoArquivos){
			if(comando == null || comando.trim().equals("")){
				log.gravaLog("Executavel não encontrado!");
			}else{
				log.gravaLog("Executando tarefa");
				log.gravaLog("Caminho do executavel: " + comando);
				exe.tarefa(comando);
				log.gravaLog("Delay: " + tempoEsperaComando +".");
				controle.pause(tempoEsperaComando);
			}
		}
	}
}