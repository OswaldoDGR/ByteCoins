package observers;

public interface Subject {
	public void addObserver(Observer obs);
	public void notifier();
}
