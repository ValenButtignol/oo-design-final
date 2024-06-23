package remotecontrol.remotewithundo.command;

import remotecontrol.remotewithundo.receiver.AutomaticBlind;

public class AutomaticBlindDownCommand implements Command {
    
    private AutomaticBlind automaticBlind;
    private int prevHeight;
    
    public AutomaticBlindDownCommand(AutomaticBlind automaticBlind) {
        this.automaticBlind = automaticBlind;
    }

    public void execute() {
        prevHeight = automaticBlind.getHeight();
        automaticBlind.minHeight();
    }

    public void undo() {
        if (prevHeight == AutomaticBlind.MAX_HEIGHT) {
            automaticBlind.maxHeight();
        } else if (prevHeight == AutomaticBlind.MEDIUM_HEIGHT) {
            automaticBlind.mediumHeight();
        } else if (prevHeight == AutomaticBlind.MIN_HEIGHT) {
            automaticBlind.minHeight();
        }
    }
}