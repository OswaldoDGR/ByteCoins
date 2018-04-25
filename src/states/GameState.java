package states;

import java.awt.Graphics;

import factory.GameContext;

public interface GameState {
	public void setContext(GameContext gameContext);
	
	public void start();
	public void running();
	public void pause();
	public void shop();
	public void gameOver();
	
	public void update();
	public void draw(Graphics g);
}
