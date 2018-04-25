package factory;

import states.GameState;
import states.StateGameOver;
import states.StatePause;
import states.StateRunning;
import states.StateShop;
import states.StateStart;

public class StateFactory {
	public static StateFactory states;
	private static GameState start, running, pause, shop, gameOver;
	
	public synchronized static StateFactory getInstance(){
		if(states == null){
			states = new StateFactory();
		}
		return states;
	}
	
	public GameState getState(char s) {
		GameState temp;
		switch(s) {
			case 'S':
				start = new StateStart();
				temp = start;
				break;
			case 'R':
				running = (GameState) new StateRunning();
				temp = running;
				break;
			case 'P':
				pause = new StatePause();
				temp = pause;
				break;
			case 'H':
				shop = new StateShop();
				temp = shop;
				break;
			case 'G':
				gameOver = new StateGameOver();
				temp = gameOver;
				break;
			default:
				temp = null;
		}
		return temp;
	}
}
