package remote;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import remotecontrol.remotewithundo.receiver.CeilingFan;
import remotecontrol.remotewithundo.receiver.Light;
import remotecontrol.remotewithundo.command.Command;
import remotecontrol.remotewithundo.RemoteControlWithUndo;
import remotecontrol.remotewithundo.command.AutomaticBlindDownCommand;
import remotecontrol.remotewithundo.command.AutomaticBlindMediumCommand;
import remotecontrol.remotewithundo.command.AutomaticBlindUpCommand;
import remotecontrol.remotewithundo.command.CeilingFanHighCommand;
import remotecontrol.remotewithundo.command.CeilingFanLowCommand;
import remotecontrol.remotewithundo.command.CeilingFanMediumCommand;
import remotecontrol.remotewithundo.command.CeilingFanOffCommand;
import remotecontrol.remotewithundo.command.DimmerLightOffCommand;
import remotecontrol.remotewithundo.command.DimmerLightOnCommand;
import remotecontrol.remotewithundo.command.MacroCommand;
import remotecontrol.remotewithundo.receiver.AutomaticBlind;


public class TestUndoRemote {
    private RemoteControlWithUndo remoteControlWithUndo;
    private AutomaticBlind automaticBlind;
    private CeilingFan ceilingFan;
    private Light light;

    @BeforeEach
    public void setUp() {
        remoteControlWithUndo = new RemoteControlWithUndo();
        automaticBlind = new AutomaticBlind("living room");

        Command automaticBlindDownCommand = new AutomaticBlindDownCommand(automaticBlind);
        Command automaticBlindUpCommand = new AutomaticBlindUpCommand(automaticBlind);
        Command automaticBlindMediumCommand = new AutomaticBlindMediumCommand(automaticBlind);

        ceilingFan = new CeilingFan("living room");
        Command ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        Command ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
        Command ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        light = new Light("bathroom");
        Command dimmerLightOffCommand = new DimmerLightOffCommand(light);
        Command dimmerLightOnCommand = new DimmerLightOnCommand(light);

        Command[] partyOn = {automaticBlindUpCommand, ceilingFanHighCommand, dimmerLightOnCommand};
        Command[] partyOff = {automaticBlindDownCommand, ceilingFanOffCommand, dimmerLightOffCommand};
        MacroCommand partyOnCommand = new MacroCommand(partyOn);
        MacroCommand partyOffCommand = new MacroCommand(partyOff);

        remoteControlWithUndo.setCommand(0, automaticBlindUpCommand, automaticBlindDownCommand);
        remoteControlWithUndo.setCommand(1, automaticBlindMediumCommand, automaticBlindDownCommand);
        remoteControlWithUndo.setCommand(2, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControlWithUndo.setCommand(3, ceilingFanMediumCommand, ceilingFanOffCommand);
        remoteControlWithUndo.setCommand(4, dimmerLightOnCommand, dimmerLightOffCommand);
        remoteControlWithUndo.setCommand(5, partyOnCommand, partyOffCommand);
    }
    
    @Test
    public void testAutomaticBlindsWithUndo() {

        remoteControlWithUndo.onButtonWasPushed(0);
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MAX_HEIGHT);
        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MIN_HEIGHT);
        remoteControlWithUndo.onButtonWasPushed(1);
        remoteControlWithUndo.onButtonWasPushed(0);
        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MEDIUM_HEIGHT);

    }

    @Test
    public void testDimmerLightAndCeilingFanWithUndo() {

        remoteControlWithUndo.onButtonWasPushed(2);
        assertEquals(ceilingFan.getSpeed(), CeilingFan.HIGH);
        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.OFF);
        remoteControlWithUndo.onButtonWasPushed(3);
        remoteControlWithUndo.onButtonWasPushed(2);
        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.MEDIUM);

        remoteControlWithUndo.onButtonWasPushed(4);
        remoteControlWithUndo.offButtonWasPushed(4);
        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(light.getLevel(), 75);

    }

    @Test
    public void testMacroCommand() {

        remoteControlWithUndo.onButtonWasPushed(5);
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MAX_HEIGHT);
        assertEquals(ceilingFan.getSpeed(), CeilingFan.HIGH);
        assertEquals(light.getLevel(), 75);

        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MIN_HEIGHT);
        assertEquals(ceilingFan.getSpeed(), CeilingFan.OFF);
        assertEquals(light.getLevel(), 0);
    }
}