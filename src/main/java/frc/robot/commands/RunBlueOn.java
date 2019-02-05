package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;

public class RunBlueOn extends Command{
  
 
    protected void initialize(){
//        NetworkTableInstance inst = NetworkTableInstance.getDefault();
//        NetworkTable table = inst.getTable("rgbled");
//        NetworkTableEntry entry = table.getEntry("blue");
//        entry.setValue(100);
        Robot.oi.blueOn = true;
        
    }

    protected void execute(){
        Robot.compSub.runCompressor();
    }
    protected boolean isFinished(){
        return (Robot.oi.blueOn == false);
    }
    protected void end(){
        Robot.compSub.stopCompressor();

    }
    protected void interrupted(){

    }

}