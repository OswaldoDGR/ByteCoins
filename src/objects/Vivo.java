package objects;

import observers.Strategy;

public class Vivo implements Strategy{
	public void message() {
		System.out.println("Ahora estoy vivo");
	}
}
