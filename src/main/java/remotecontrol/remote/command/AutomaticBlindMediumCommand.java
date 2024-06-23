package remotecontrol.remote.command;

import remotecontrol.remote.receiver.AutomaticBlind;

public class AutomaticBlindMediumCommand implements Command {
    private AutomaticBlind automaticBlind;
    
    public AutomaticBlindMediumCommand(AutomaticBlind automaticBlind) {
        this.automaticBlind = automaticBlind;
    }

    public void execute() {
        automaticBlind.mediumHeight();
    }
}