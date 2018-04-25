package objects;

import observers.KeyListenerSubject;
import observers.Observer;
import observers.Subject;

public class DemoManager implements Observer{

	public DemoManager() {
		KeyListenerSubject.getInstance().addObserver(this);
	}
	
	public void updateObs(Subject subj) {
		System.out.println("He funcionado!");
	}
	
}
