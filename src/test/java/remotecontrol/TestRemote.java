package remotecontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import remotecontrol.remote.RemoteControl;
import remotecontrol.remote.command.AutomaticBlindDownCommand;
import remotecontrol.remote.command.AutomaticBlindMediumCommand;
import remotecontrol.remote.command.AutomaticBlindUpCommand;
import remotecontrol.remote.command.CeilingFanOffCommand;
import remotecontrol.remote.command.CeilingFanOnCommand;
import remotecontrol.remote.command.Command;
import remotecontrol.remote.command.HottubOffCommand;
import remotecontrol.remote.command.HottubOnCommand;
import remotecontrol.remote.receiver.AutomaticBlind;
import remotecontrol.remote.receiver.CeilingFan;
import remotecontrol.remote.receiver.Hottub;

public class TestRemote {
    RemoteControl remote;
    AutomaticBlind automaticBlind;
    CeilingFan ceilingFan;
    Hottub hottub;

    @BeforeEach
    public void setUp() {
        remote = new RemoteControl();
        automaticBlind = new AutomaticBlind("bedroom");
        ceilingFan = new CeilingFan("living room");
        hottub = new Hottub();

        Command automaticBlindDownCommand = new AutomaticBlindDownCommand(automaticBlind);
        Command automaticBlindUpCommand = new AutomaticBlindUpCommand(automaticBlind);
        Command automaticBlindMediumCommand = new AutomaticBlindMediumCommand(automaticBlind);

        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        Command ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);

        Command hottubOffCommand = new HottubOffCommand(hottub);
        Command hottubOnCommand = new HottubOnCommand(hottub);

        remote.setCommand(0, automaticBlindUpCommand, automaticBlindDownCommand);
        remote.setCommand(1, automaticBlindMediumCommand, automaticBlindDownCommand);
        remote.setCommand(2, ceilingFanOnCommand, ceilingFanOffCommand);
        remote.setCommand(3, hottubOnCommand, hottubOffCommand);
    }

    @Test
    public void testAutomaticBlinds() {

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

        remote.onButtonWasPushed(2);
        assertEquals(ceilingFan.getSpeed(), 2);
        remote.offButtonWasPushed(2);
        assertEquals(ceilingFan.getSpeed(), 0);

        remote.onButtonWasPushed(3);
        assertEquals(hottub.getTemperature(), 105);
        remote.offButtonWasPushed(3);
        assertEquals(hottub.getTemperature(), 98);

    }
}