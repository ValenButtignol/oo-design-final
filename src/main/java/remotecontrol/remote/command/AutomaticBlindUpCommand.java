package remotecontrol.remote.command;

import remotecontrol.remote.receiver.AutomaticBlind;

public class AutomaticBlindUpCommand implements Command {
    private AutomaticBlind automaticBlind;
    
    public AutomaticBlindUpCommand(AutomaticBlind automaticBlind) {
        this.automaticBlind = automaticBlind;
    }

    public void execute() {
        automaticBlind.maxHeight();
    }
}
