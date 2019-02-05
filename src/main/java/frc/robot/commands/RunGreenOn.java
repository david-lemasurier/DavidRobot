package frc.robot.commands;

import frc.robot.Robot;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;

public class RunGreenOn extends Command{
    protected void initialize(){    
    }

    protected void execute(){
        NetworkTableInstance inst =  NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("rgbled");
        NetworkTableEntry entry = table.getEntry("green");
        entry.setValue(100);
        Robot.oi.greenOn = true;
    }
    protected boolean isFinished(){
        return (Robot.oi.greenOn == false);
    }
    protected void end(){

    }
    protected void interrupted(){

    }

}