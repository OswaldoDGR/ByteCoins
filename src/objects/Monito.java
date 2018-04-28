package objects;

import observers.Strategy;

public class Monito{
	private Strategy strategy;
	
	public Monito(Strategy strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy() {
		strategy.message();
	}
}
