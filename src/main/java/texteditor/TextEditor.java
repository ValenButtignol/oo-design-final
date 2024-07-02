package texteditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import texteditor.command.Command;

public class TextEditor {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void execute(Integer index) {
        Command command = commands.get(index);
        command.scanData();
        command.execute();
        Command copyCommand = command.copy();
        undoStack.push(copyCommand);
        redoStack.clear();
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }
        Command command = undoStack.pop();
        command.undo();
        redoStack.push(command);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }
        Command command = redoStack.pop();
        command.execute();
        undoStack.push(command);
    }

    @Override
    public String toString() {
        String result = "Available commands: \n";
        for (int i = 0; i < commands.size() - 1; i++) {
            result += i + ") " + commands.get(i).getClass().getSimpleName() + "\n";
        }
        result += commands.size()-1 + ") " + commands.get(commands.size()-1).getClass().getSimpleName();

        return result;
    }
}