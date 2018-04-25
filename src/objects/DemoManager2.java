package objects;

import observers.KeyListenerSubject;
import observers.Observer;
import observers.Subject;

public class DemoManager2 implements Observer{

	public DemoManager2() {
		KeyListenerSubject.getInstance().addObserver(this);
	}
	
	public void updateObs(Subject subj) {
		int x;
		x = KeyListenerSubject.getInstance().getKeyCode();
		System.out.println(x);
	}
	
}