package remote.command;

import remote.receiver.AutomaticBlind;

public class AutomaticBlindDownCommand implements Command {
    
    private AutomaticBlind automaticBlind;
    
    public AutomaticBlindDownCommand(AutomaticBlind automaticBlind) {
        this.automaticBlind = automaticBlind;
    }

    public void execute() {
        automaticBlind.minHeight();
    }
}