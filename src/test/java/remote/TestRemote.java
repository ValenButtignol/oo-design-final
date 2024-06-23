package remote;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import remotecontrol.remote.RemoteControl;
import remotecontrol.remote.command.AutomaticBlindDownCommand;
import remotecontrol.remote.command.AutomaticBlindMediumCommand;
import remotecontrol.remote.command.AutomaticBlindUpCommand;
import remotecontrol.remote.command.CeilingFanOffCommand;
import remotecontrol.remote.command.CeilingFanOnCommand;
import remotecontrol.remote.command.HottubOffCommand;
import remotecontrol.remote.command.HottubOnCommand;
import remotecontrol.remote.receiver.AutomaticBlind;
import remotecontrol.remote.receiver.CeilingFan;
import remotecontrol.remote.receiver.Hottub;

public class TestRemote {
    
    @Test
    public void testAutomaticBlinds() {
        RemoteControl remote = new RemoteControl();

        AutomaticBlind automaticBlind = new AutomaticBlind("bedroom");
        AutomaticBlindDownCommand automaticBlindDownCommand = new AutomaticBlindDownCommand(automaticBlind);
        AutomaticBlindUpCommand automaticBlindUpCommand = new AutomaticBlindUpCommand(automaticBlind);
        AutomaticBlindMediumCommand automaticBlindMediumCommand = new AutomaticBlindMediumCommand(automaticBlind);

        remote.setCommand(0, automaticBlindUpCommand, automaticBlindDownCommand);
        remote.setCommand(1, automaticBlindMediumCommand, automaticBlindDownCommand);

        remote.onButtonWasPushed(0);
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MAX_HEIGHT);
        remote.offButtonWasPushed(0);
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MIN_HEIGHT);


        remote.onButtonWasPushed(1);
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MEDIUM_HEIGHT);
        remote.offButtonWasPushed(1);
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MIN_HEIGHT);
    }

    @Test
    public void testHottubAndCeilingFan() {
        RemoteControl remote = new RemoteControl();

        CeilingFan ceilingFan = new CeilingFan("living room");
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);

        remote.setCommand(0, ceilingFanOnCommand, ceilingFanOffCommand);

        remote.onButtonWasPushed(0);
        assertEquals(ceilingFan.getSpeed(), 2);
        remote.offButtonWasPushed(0);
        assertEquals(ceilingFan.getSpeed(), 0);


        Hottub hottub = new Hottub();
        HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);
        HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);

        remote.setCommand(1, hottubOnCommand, hottubOffCommand);


        remote.onButtonWasPushed(1);
        assertEquals(hottub.getTemperature(), 105);
        remote.offButtonWasPushed(1);
        assertEquals(hottub.getTemperature(), 98);
    }
}