package remotecontrol.remotewithundo.command;

public interface Command {
	public void execute();
	public void undo();
}
