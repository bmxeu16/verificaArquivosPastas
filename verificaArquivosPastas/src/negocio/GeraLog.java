package negocio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class GeraLog {
	
	public void gravaLog(String conteudo){
		
		String textoQueSeraEscrito = conteudo;  
		
	    try { 
	    	PrintWriter out = new PrintWriter(new BufferedWriter(
	    			new FileWriter("C:\\Users\\wmeier\\Desktop\\log.txt", true)));  
	        out.println(dataHoraServidor()+" linha: "+textoQueSeraEscrito+ "\n");  
	        out.close(); 
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } catch (Exception e) {  
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
}
