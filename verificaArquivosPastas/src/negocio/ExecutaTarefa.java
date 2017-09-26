package negocio;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExecutaTarefa {

	GeraLog log = new GeraLog();
	
	public void tarefa(String comando){
		try{
			Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " +comando);
			log.gravaLog("EXECUTA TAREFA!");
		}catch (Exception e){
			//e.printStackTrace();
			//log.gravaLog("???????Falha na Execução ta Terefa.???????");
			String temp = stack2string(e);
			System.out.println(temp);
			log.gravaLog(temp);
		}
	}
	
	public static String stack2string(Exception e) {
	    try {
	      StringWriter sw = new StringWriter();
	      PrintWriter pw = new PrintWriter(sw);
	      e.printStackTrace(pw);
	      return "------\r\n" + sw.toString() + "------\r\n";
	    }
	    catch(Exception e2) {
	      return "bad stack2string";
	    }
	  }
}
