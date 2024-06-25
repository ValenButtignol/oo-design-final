package remote;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import remotecontrol.remotewithundo.RemoteControlWithUndoAndRedo;
import remotecontrol.remotewithundo.command.AutomaticBlindDownCommand;
import remotecontrol.remotewithundo.command.AutomaticBlindMediumCommand;
import remotecontrol.remotewithundo.command.AutomaticBlindUpCommand;
import remotecontrol.remotewithundo.command.CeilingFanHighCommand;
import remotecontrol.remotewithundo.command.CeilingFanLowCommand;
import remotecontrol.remotewithundo.command.CeilingFanMediumCommand;
import remotecontrol.remotewithundo.command.CeilingFanOffCommand;
import remotecontrol.remotewithundo.command.Command;
import remotecontrol.remotewithundo.receiver.AutomaticBlind;
import remotecontrol.remotewithundo.receiver.CeilingFan;
import remotecontrol.remotewithundo.receiver.Light;

public class TestUndoAndRedoRemote {
    private RemoteControlWithUndoAndRedo remoteControl;
    private AutomaticBlind automaticBlind;
    private CeilingFan ceilingFan;
    private Light light;

    @BeforeEach
    public void setUp() {
        remoteControl = new RemoteControlWithUndoAndRedo(3);
        automaticBlind = new AutomaticBlind("living room");

        Command automaticBlindDownCommand = new AutomaticBlindDownCommand(automaticBlind);
        Command automaticBlindUpCommand = new AutomaticBlindUpCommand(automaticBlind);
        Command automaticBlindMediumCommand = new AutomaticBlindMediumCommand(automaticBlind);

        ceilingFan = new CeilingFan("living room");
        Command ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        Command ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
        Command ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0, automaticBlindUpCommand, automaticBlindDownCommand);
        remoteControl.setCommand(1, automaticBlindMediumCommand, automaticBlindDownCommand);
        remoteControl.setCommand(2, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControl.setCommand(3, ceilingFanMediumCommand, ceilingFanOffCommand);
        remoteControl.setCommand(4, ceilingFanLowCommand, ceilingFanOffCommand);
    }

    @Test
    public void testRemoteControlWithCeilingFan() {

        remoteControl.onButtonWasPushed(4);
        remoteControl.onButtonWasPushed(3);
        remoteControl.onButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.MEDIUM);
        remoteControl.undoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.LOW);
        remoteControl.redoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.MEDIUM);
        remoteControl.redoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.HIGH);
    }

    @Test
    public void testRemoteControlWithAutomaticBlindsAndCeilingFan() {

        remoteControl.onButtonWasPushed(0); // Up blinds
        remoteControl.onButtonWasPushed(1); // Medium blinds
        remoteControl.offButtonWasPushed(0);    // Down blinds
        remoteControl.onButtonWasPushed(3);  // Medium Ceiling
        remoteControl.onButtonWasPushed(2); // High Ceiling

        remoteControl.undoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.MEDIUM);
        remoteControl.undoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.OFF);
        remoteControl.undoButtonWasPushed();
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MEDIUM_HEIGHT);
        remoteControl.undoButtonWasPushed();    // should stay in the same state bc k == 3
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MEDIUM_HEIGHT);

        remoteControl.redoButtonWasPushed();
        assertEquals(automaticBlind.getHeight(), AutomaticBlind.MIN_HEIGHT);
        remoteControl.redoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.MEDIUM);
        remoteControl.redoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.HIGH);

    }
}