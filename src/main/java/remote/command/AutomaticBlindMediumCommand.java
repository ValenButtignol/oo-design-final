package remote.command;

import remote.receiver.AutomaticBlind;

public class AutomaticBlindMediumCommand implements Command {
    private AutomaticBlind automaticBlind;
    
    public AutomaticBlindMediumCommand(AutomaticBlind automaticBlind) {
        this.automaticBlind = automaticBlind;
    }

    public void execute() {
        automaticBlind.mediumHeight();
    }
}
