package factory;

import java.awt.Graphics;

import states.GameState;

public class GameContext {
	private GameState start, running, pause, shop, gameOver, current;
	
	public GameContext() {
		start = StateFactory.getInstance().getState('S');
		running = StateFactory.getInstance().getState('R');
		pause = StateFactory.getInstance().getState('P');
		shop = StateFactory.getInstance().getState('H');
		gameOver = StateFactory.getInstance().getState('G');
		
		start.setContext(this);
		running.setContext(this);
		pause.setContext(this);
		shop.setContext(this);
		gameOver.setContext(this);
		current = getStart();
	}
	
	public void setState(GameState s) {current = s;}
	
	public GameState getStart() 	{return start;}
	public GameState getRunning() 	{return running;}
	public GameState getPause() 	{return pause;}
	public GameState getShop() 	{return shop;}
	public GameState getGameOver() 	{return gameOver;}
	
	public void draw(Graphics g){ current.draw(g);}
	public void update() {current.update();}
}
