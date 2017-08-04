package negocio;

import java.io.File;

public class Aplicativo {

	public static void main(String[] args) {
		
		String nomeArquivo;
		float tamanhoArquivo;
		
		File arquivo = new File("/home/william/Documentos"); 
        File[] file = arquivo.listFiles(); 
        if(file != null){ 
            int length = file.length; 
            for(int i = 0; i < length; ++i){ 
                File f = file[i]; 
                if(f.isFile()){ 
                    nomeArquivo = f.getName();
                	tamanhoArquivo = f.length();
                    System.out.println(nomeArquivo + ", " + tamanhoArquivo); 
                } 
                else if(f.isDirectory()){ 
                    //System.out.println("Diretorio: " + f.getName()); 
                } 
            }
        }

	}

}
