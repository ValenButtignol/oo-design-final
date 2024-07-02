package texteditor.command;

public interface Command {
    void execute();
    void undo();
    void scanData();
    Command copy();
}