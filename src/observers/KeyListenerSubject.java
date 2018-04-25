package observers;

import java.util.ArrayList;

public  class KeyListenerSubject implements Subject{
	private static KeyListenerSubject keyL;
	
	public static KeyListenerSubject getInstance(){
		if (keyL == null) keyL = new KeyListenerSubject();
		return keyL;
	}
	int keyCode;
	public void setKeyCode(int kc) {
		keyCode = kc;
		notifier();
	}
	public int getKeyCode() {
		return keyCode;
	}
	
	private ArrayList <Observer> observers = new ArrayList<>();
	public void addObserver(Observer obs) {
		observers.add(obs);
	}
	public void notifier() {
		for(Observer obs: observers) {
			obs.updateObs(this);
		}
	}
	
	
}
