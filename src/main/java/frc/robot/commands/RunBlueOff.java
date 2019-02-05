package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;

public class RunBlueOff extends Command{
  
 
    protected void initialize(){
//        NetworkTableInstance inst =  NetworkTableInstance.getDefault();
//        NetworkTable table = inst.getTable("rgbled");
//        NetworkTableEntry entry = table.getEntry("blue");
///        entry.setValue(0);
        Robot.oi.blueOn = false;
        
    }

    protected void execute(){
        Robot.compSub.stopCompressor();
    }
    protected boolean isFinished(){
        return true;
    }
    protected void end(){

    }
    protected void interrupted(){

    }

}