package states;

import java.awt.Graphics;

import factory.GameContext;

public class StateRunning implements GameState{
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
}
