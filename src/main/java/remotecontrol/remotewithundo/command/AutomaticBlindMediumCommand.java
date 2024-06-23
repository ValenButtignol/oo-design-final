package remotecontrol.remotewithundo.command;

import remotecontrol.remotewithundo.receiver.AutomaticBlind;

public class AutomaticBlindMediumCommand implements Command {
    private AutomaticBlind automaticBlind;
    private int prevHeight;
    
    public AutomaticBlindMediumCommand(AutomaticBlind automaticBlind) {
        this.automaticBlind = automaticBlind;
    }

    public void execute() {
        prevHeight = automaticBlind.getHeight();
        automaticBlind.mediumHeight();
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
