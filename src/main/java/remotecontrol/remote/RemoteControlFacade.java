package remotecontrol.remote;

import remotecontrol.remote.command.AutomaticBlindDownCommand;
import remotecontrol.remote.command.AutomaticBlindUpCommand;
import remotecontrol.remote.command.HottubOffCommand;
import remotecontrol.remote.command.HottubOnCommand;
import remotecontrol.remote.command.LightOffCommand;
import remotecontrol.remote.command.LightOnCommand;
import remotecontrol.remote.command.StereoOffCommand;
import remotecontrol.remote.command.StereoOnWithCDCommand;
import remotecontrol.remote.receiver.AutomaticBlind;
import remotecontrol.remote.receiver.Hottub;
import remotecontrol.remote.receiver.Light;
import remotecontrol.remote.receiver.Stereo;

public class RemoteControlFacade {

    private RemoteControl remoteControl;
    private AutomaticBlind automaticBlind;
    private Light light;
    private Stereo stereo;
    private Hottub hottub;

    public RemoteControlFacade(AutomaticBlind automaticBlind, Light light, Stereo stereo, Hottub hottub) {
        this.remoteControl = new RemoteControl();
        this.automaticBlind = automaticBlind;
        this.light = light;
        this.stereo = stereo;
        this.hottub = hottub;

        this.remoteControl = new RemoteControl();
        this.remoteControl.setCommand(0, new AutomaticBlindUpCommand(automaticBlind), new AutomaticBlindDownCommand(automaticBlind));
        this.remoteControl.setCommand(1, new LightOnCommand(light), new LightOffCommand(light));
        this.remoteControl.setCommand(2, new StereoOnWithCDCommand(stereo), new StereoOffCommand(stereo));
        this.remoteControl.setCommand(3, new HottubOnCommand(hottub), new HottubOffCommand(hottub));
    }

    public void startRelaxMode() {
        System.out.println();
        System.out.println("Starting the relax mode...");
        remoteControl.offButtonWasPushed(0);    //Turn down the blinds
        remoteControl.offButtonWasPushed(1);    //Turn off the lights
        remoteControl.onButtonWasPushed(2);    //Turn on the stereo
        remoteControl.onButtonWasPushed(3);    //Turn on the hottub
    }
    
    public void startPartyMode() {
        System.out.println();
        System.out.println("Starting the party mode...");
        remoteControl.onButtonWasPushed(0);    //Turn up the blinds
        remoteControl.onButtonWasPushed(1);    //Turn on the lights
        remoteControl.onButtonWasPushed(2);    //Turn on the stereo
        remoteControl.onButtonWasPushed(3);    //Turn on the hottub
    }
    
    public void offMode() {
        System.out.println();
        System.out.println("Turning off the devices...");
        remoteControl.offButtonWasPushed(0);    //Turn down the blinds
        remoteControl.offButtonWasPushed(1);    //Turn off the lights
        remoteControl.offButtonWasPushed(2);    //Turn off the stereo
        remoteControl.offButtonWasPushed(3);    //Turn off the hottub
    }

}
