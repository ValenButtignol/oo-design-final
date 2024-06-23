package remote.command;

import remote.receiver.AutomaticBlind;

public class AutomaticBlindUpCommand implements Command {
    private AutomaticBlind automaticBlind;
    
    public AutomaticBlindUpCommand(AutomaticBlind automaticBlind) {
        this.automaticBlind = automaticBlind;
    }

    public void execute() {
        automaticBlind.maxHeight();
    }
}
