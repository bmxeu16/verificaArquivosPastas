package negocio;

import javax.swing.JOptionPane;

public class ThreadControle {

	public void pause(int time){
		
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void botaoDesligar(){
		
		int i = JOptionPane.showConfirmDialog(null ,"Deseja fechar a aplicação?",
				"Saída",JOptionPane.YES_NO_OPTION);
		if (i == JOptionPane.YES_OPTION ) {
			System.exit(0); //desliga Java
		}else{
			
		}
	}
}
