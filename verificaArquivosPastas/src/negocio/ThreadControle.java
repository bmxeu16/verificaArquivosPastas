package negocio;

public class ThreadControle {

	public void pause(int time){
		
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
