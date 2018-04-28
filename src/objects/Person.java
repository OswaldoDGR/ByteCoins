package objects;

import observers.KeyListenerSubject;
import observers.Observer;
import observers.Subject;

public class Person implements Observer{
	
	public Person() {
		KeyListenerSubject.getInstance().addObserver(this);
	}
	
	Monito monito;
	
	public void updateObs(Subject subj) {
		int x;
		x = KeyListenerSubject.getInstance().getKeyCode();
		if(x == 10) monito = new Monito(new Vivo());
		else monito = new Monito(new Muerto());
		monito.executeStrategy();
	}
}
