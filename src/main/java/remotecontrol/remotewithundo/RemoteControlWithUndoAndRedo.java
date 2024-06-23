package remotecontrol.remotewithundo;

import remotecontrol.remotewithundo.command.Command;
import remotecontrol.remotewithundo.command.NoCommand;
import java.util.Stack;

public class RemoteControlWithUndoAndRedo {
    Command[] onCommands;
    Command[] offCommands;
    Stack<Command> undoStack;
    Stack<Command> redoStack;
    int k;

    public RemoteControlWithUndoAndRedo(int k) {
        onCommands = new Command[7];
        offCommands = new Command[7];
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        this.k = k;

        Command noCommand = new NoCommand();
        for(int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        if (undoStack.size() == k) {
            undoStack.remove(0);
        }
        undoStack.push(onCommands[slot]);
        redoStack.clear(); // Clear the redo stack since we have a new action
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        if (undoStack.size() == k) {
            undoStack.remove(0);
        }
        undoStack.push(offCommands[slot]);
        redoStack.clear(); // Clear the redo stack since we have a new action
    }

    public void undoButtonWasPushed() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            if (redoStack.size() == k) {
                redoStack.remove(0);
            }
            redoStack.push(command);
        }
    }

    public void redoButtonWasPushed() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            if (undoStack.size() == k) {
                undoStack.remove(0);
            }
            undoStack.push(command);
        }
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "    " + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("[undo stack] " + undoStack + "\n");
        stringBuff.append("[redo stack] " + redoStack + "\n");
        return stringBuff.toString();
    }
}