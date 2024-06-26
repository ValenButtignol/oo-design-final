package remotecontrol.remotewithundo;

import remotecontrol.remotewithundo.command.AutomaticBlindDownCommand;
import remotecontrol.remotewithundo.command.AutomaticBlindUpCommand;
import remotecontrol.remotewithundo.command.CeilingFanHighCommand;
import remotecontrol.remotewithundo.command.CeilingFanLowCommand;
import remotecontrol.remotewithundo.command.CeilingFanMediumCommand;
import remotecontrol.remotewithundo.command.CeilingFanOffCommand;
import remotecontrol.remotewithundo.receiver.AutomaticBlind;
import remotecontrol.remotewithundo.receiver.CeilingFan;

public class MainUndoRedo {
    public static void main(String[] args) {
        RemoteControlWithUndoAndRedo remoteControl = new RemoteControlWithUndoAndRedo(3);
 
		AutomaticBlind automaticBlind = new AutomaticBlind("Living Room");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
 
        AutomaticBlindDownCommand automaticBlindDownCommand = new AutomaticBlindDownCommand(automaticBlind);
        AutomaticBlindUpCommand automaticBlindUpCommand = new AutomaticBlindUpCommand(automaticBlind);
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
 
		remoteControl.setCommand(0, automaticBlindUpCommand, automaticBlindDownCommand);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
		remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(3, ceilingFanLow, ceilingFanOff);

        System.out.println("-- Lifting Automatic Blinds --");
        remoteControl.onButtonWasPushed(0);
        System.out.println();
        
        System.out.println("-- Lowering Automatic Blinds -- ");
        remoteControl.offButtonWasPushed(0);
        System.out.println();
        
        System.out.println("-- Undo: blinds should be up again. --");
        remoteControl.undoButtonWasPushed();
        System.out.println();
        
        System.out.println("-- Redo: blinds should be down. -- ");
        remoteControl.redoButtonWasPushed();
        System.out.println();
        
        System.out.println("-- Turning Ceiling fan on high -- ");
        remoteControl.onButtonWasPushed(1);
        System.out.println();

        System.out.println("-- Turning Ceiling fan on medium -- ");
        remoteControl.onButtonWasPushed(2);        
        System.out.println();

        System.out.println("-- Turning Ceiling fan on low -- ");
        remoteControl.onButtonWasPushed(3);        
        System.out.println();

        System.out.println("-- Undo: Ceiling fan should be on medium. -- ");
        remoteControl.undoButtonWasPushed();
        System.out.println();

        System.out.println("-- Undo: Ceiling fan should be on high. -- ");
        remoteControl.undoButtonWasPushed();
        System.out.println();
    
        System.out.println("-- Redo: Ceiling fan should be on medium. -- ");
        remoteControl.redoButtonWasPushed();
        System.out.println();

        System.out.println("-- Redo: Ceiling fan should be on low. -- ");
        remoteControl.redoButtonWasPushed();
        System.out.println();
    }
}

