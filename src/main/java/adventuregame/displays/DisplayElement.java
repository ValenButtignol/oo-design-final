package adventuregame.displays;

public abstract class DisplayElement {

	protected boolean isEnabled;

	public DisplayElement() {
		this.isEnabled = true;
	}

	public void enable() {
		this.isEnabled = true;
	}

	public void disable() {
		this.isEnabled = false;
	}

	public boolean isEnabled() {
		return this.isEnabled;
	}

	public abstract void display(String str);
}

