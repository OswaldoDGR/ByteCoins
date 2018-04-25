package states;

import java.awt.Graphics;

import factory.GameContext;
import objects.*;

public class StateStart implements GameState{

	private GameContext gc;
	public void setContext(GameContext gc){
		this.gc = gc;
	}
	
	public void start() {}
	public void running() {}
	public void pause() {}
	public void shop() {}
	public void gameOver() {}
	
	public void update() {}
	public void draw(Graphics g) {}
	
	DemoManager prueba = new DemoManager();
	DemoManager2 p2 = new DemoManager2();
}
