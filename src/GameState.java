import java.awt.*;

interface GameState {
	
	public void end();
	public void start();
	public void pause();
	public void running();
	public void shop();
	public void gameOver();
	
	public void render(Graphics g);
	public void update();
	
}

