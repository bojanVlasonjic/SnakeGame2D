package view;

public class RepaintScreen implements Runnable {

	private GameScreen screen;
	
	public RepaintScreen(GameScreen screen) {
		this.screen = screen;
	}
	
	@Override
	public void run() {
		this.screen.repaint();
	}
	
	

}
