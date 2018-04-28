package objects;

import observers.Strategy;

public class Muerto implements Strategy{
	public void message() {
		System.out.println("Y ahora me morí");
	}
}
