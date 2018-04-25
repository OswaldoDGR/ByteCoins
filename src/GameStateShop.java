import java.awt.*;

public class GameStateShop implements GameState{
	GameContext gc;
	
	public GameStateShop(GameContext gc){
		this.gc = gc;
	}
	public void end(){
	}
	
	public void start() {
		
	}
	
	public void pause(){
	}
	
	public void running(){
	}
	
	public void shop() {
		
	}
	
	public void gameOver() {
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.drawString("Estoy Terminado",20,20);
	}
	
	public void update(){
	
	}
}
