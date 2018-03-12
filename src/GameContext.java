import java.awt.Graphics;

public class GameContext {
	private GameStateRunning running;
	private GameStatePause pause;
	private GameStateGameOver gameOver;
	private GameStateShop shop;
	private GameStateStart start;
	private GameState current;
	
	public GameContext(){
		running = new GameStateRunning(this);
		pause = new GameStatePause(this);
		gameOver = new GameStateGameOver(this);
		shop = new GameStateShop(this);
		start = new GameStateStart(this);
		current = running;
	}

	public GameStateRunning getRunning() {
		return running;
	}
	public GameStatePause getPause() {
		return pause;
	}
	public GameStateGameOver getGameOver() {
		return gameOver;
	}
	public GameStateShop getShop() {
		return shop;
	}
	public GameStateStart getStart() {
		return start;
	}
	public void setCurrent(GameState current) {
		this.current = current;
	}
	
	public void end(){
		current.end();
	}
	public void start() {
		current.start();
	}
	public void running(){
		current.running();
	}
	public void pause(){
		current.pause();
	}
	public void shop() {
		current.shop();
	}
	public void gameOver() {
		current.gameOver();
	}
	public void update(){
		current.update();
	}
	public void render(Graphics g){
		current.render(g);
	}
}
