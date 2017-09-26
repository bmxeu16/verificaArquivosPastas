package negocio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class GeraLog {
	
	String caminhoLog;

	public void gravaLog(String conteudo){
		
		String textoQueSeraEscrito = conteudo;  
		
	    try { 
	    	PrintWriter out = new PrintWriter(new BufferedWriter(
	    			new FileWriter(getCaminhoLog()+"log.log", true)));  
	        out.println(dataHoraServidor()+" linha: "+textoQueSeraEscrito+ "\n");
	        out.close();
	    }catch (Exception e) {  
	        e.printStackTrace();  
	    }
	}
	
	
	public String dataHoraServidor() {
		// cria um StringBuilder
		StringBuilder sb = new StringBuilder();
		// cria um GregorianCalendar que vai conter a hora atual
		GregorianCalendar d = new GregorianCalendar();
		// anexa do StringBuilder os dados da hora
		
		sb.append( d.get( GregorianCalendar.DAY_OF_MONTH ) );
		sb.append( "/" );
		sb.append( d.get( GregorianCalendar.MONTH ) );
		sb.append( "/" );
		sb.append( d.get( GregorianCalendar.YEAR ) );
		sb.append( " " );
		sb.append( d.get( GregorianCalendar.HOUR_OF_DAY ) );
		sb.append( ":" );
		sb.append( d.get( GregorianCalendar.MINUTE ) );
		sb.append( ":" );
		sb.append( d.get( GregorianCalendar.SECOND ) );
		// retorna a String do StringBuilder
		return sb.toString();
	}
	
	public String getCaminhoLog() {
		return caminhoLog;
	}

	public void setCaminhoLog(String caminhoLog) {
		this.caminhoLog = caminhoLog;
	}
}
