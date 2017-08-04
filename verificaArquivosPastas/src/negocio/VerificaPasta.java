package negocio;

import java.io.File;

public class VerificaPasta {

	String nomeArquivo;
	double tamanhoArquivos;
	double tamanhoArquivos2;
	
	double converteTotal;
	
	
	public double buscaArquivos(){		
		
		double tamanhoTotal = 0;
		int contador = 0;
		String arquivos[] = new String[10];
		double tamanho[] = new double[10];
		
		File arquivo = new File("C:\\edi\\elavon\\destino\\outbox"); 
        File[] file = arquivo.listFiles(); 
        if(file != null){ 
            int length = file.length; 
            //System.out.println("Verifica os arquivos");
            for(int i = 0; i < length; ++i){ 
                File f = file[i]; 
                if(f.isFile()){
                	
                	arquivos[contador] = f.getName();
                	tamanho[contador] = f.length();
                	tamanho[contador] = tamanho[contador] / 1000;
                    //System.out.println(arquivos[contador] + ", " + tamanho[contador] + " KB");
                	tamanhoTotal = tamanhoTotal + tamanho[contador];
                	contador++;
                } 
                else if(f.isDirectory()){ 
                    //System.out.println("Diretorio: " + f.getName()); 
                } 
            }
            System.out.println("Total de Arquivos encontrado: " + contador);
            converteTotal = tamanhoTotal / 1000;
            System.out.println("Tamanho Total: " + converteTotal + " KB"); 
        }
        return tamanhoTotal;
	}
	
	public void comparaTamanhos(){
		
		System.out.println("Verifica Tamanho!");
		tamanhoArquivos = buscaArquivos();
		
		System.out.println("Delay 10000.");
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tamanhoArquivos2 = buscaArquivos();
		
		if(tamanhoArquivos2 > tamanhoArquivos){
			System.out.println("N�o faz nada");
		}else if(tamanhoArquivos2 == tamanhoArquivos){
			System.out.println("Executa tarefa!!!");
			//colocar delay de 5min depois que executar a tarefa!
		}
	}
}