package objects;

import observers.KeyListenerSubject;
import observers.Observer;
import observers.Subject;

public class DemoManager implements Observer{

	public DemoManager() {
		KeyListenerSubject.getInstance().addObserver(this);
	}
	private int x = 0;
	public void updateObs(Subject subj) {
		System.out.println(x++);
	}
	
}
