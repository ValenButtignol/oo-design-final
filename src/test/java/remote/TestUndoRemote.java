package remote;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import remotecontrol.remotewithundo.receiver.CeilingFan;
import remotecontrol.remotewithundo.receiver.Light;
import remotecontrol.remotewithundo.RemoteControlWithUndo;
import remotecontrol.remotewithundo.command.AutomaticBlindDownCommand;
import remotecontrol.remotewithundo.command.AutomaticBlindMediumCommand;
import remotecontrol.remotewithundo.command.AutomaticBlindUpCommand;
import remotecontrol.remotewithundo.command.CeilingFanHighCommand;
import remotecontrol.remotewithundo.command.CeilingFanLowCommand;
import remotecontrol.remotewithundo.command.CeilingFanMediumCommand;
import remotecontrol.remotewithundo.command.DimmerLightOffCommand;
import remotecontrol.remotewithundo.command.DimmerLightOnCommand;
import remotecontrol.remotewithundo.receiver.AutomaticBlind;


public class TestUndoRemote {
    
    @Test
    public void testAutomaticBlindsWithUndo() {
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();

        AutomaticBlind automaticBlind = new AutomaticBlind("living room");
        AutomaticBlindDownCommand automaticBlindDownCommand = new AutomaticBlindDownCommand(automaticBlind);
        AutomaticBlindUpCommand automaticBlindUpCommand = new AutomaticBlindUpCommand(automaticBlind);
        AutomaticBlindMediumCommand automaticBlindMediumCommand = new AutomaticBlindMediumCommand(automaticBlind);

        remoteControlWithUndo.setCommand(0, automaticBlindUpCommand, automaticBlindDownCommand);
        remoteControlWithUndo.setCommand(1, automaticBlindMediumCommand, automaticBlindDownCommand);

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
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("living room");
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanLowCommand ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);

        Light light = new Light("bathroom");
        DimmerLightOffCommand dimmerLightOffCommand = new DimmerLightOffCommand(light);
        DimmerLightOnCommand dimmerLightOnCommand = new DimmerLightOnCommand(light);

        remoteControlWithUndo.setCommand(0, ceilingFanHighCommand, ceilingFanLowCommand);
        remoteControlWithUndo.setCommand(1, ceilingFanMediumCommand, ceilingFanLowCommand);
        remoteControlWithUndo.setCommand(2, dimmerLightOnCommand, dimmerLightOffCommand);

        remoteControlWithUndo.onButtonWasPushed(0);
        assertEquals(ceilingFan.getSpeed(), CeilingFan.HIGH);
        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.OFF);
        remoteControlWithUndo.onButtonWasPushed(1);
        remoteControlWithUndo.onButtonWasPushed(0);
        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(ceilingFan.getSpeed(), CeilingFan.MEDIUM);

        remoteControlWithUndo.onButtonWasPushed(2);
        remoteControlWithUndo.offButtonWasPushed(2);
        remoteControlWithUndo.undoButtonWasPushed();
        assertEquals(light.getLevel(), 75);

    }
}