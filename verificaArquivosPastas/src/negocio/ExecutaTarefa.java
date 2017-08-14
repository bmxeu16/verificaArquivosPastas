package negocio;

import java.io.IOException;

public class ExecutaTarefa {

	
	public void tarefa(String comando){
		try{
			Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+comando);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
