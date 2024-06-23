package remotewithundo;

public interface Command {
	public void execute();
	public void undo();
}
