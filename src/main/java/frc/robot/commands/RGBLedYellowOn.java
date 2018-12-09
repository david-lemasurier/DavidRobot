package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.networktables.NetworkTable;

public class RGBLedYellowOn extends Command{

	// Called just before this Command runs the first time
    protected void initialize() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("rgbled");
        NetworkTableEntry redEntry = table.getEntry("red");
        NetworkTableEntry greenEntry = table.getEntry("green");
        NetworkTableEntry blueEntry = table.getEntry("blue");
        redEntry.setDouble(255);   
        greenEntry.setDouble(255);   
        blueEntry.setDouble(255);   
        Robot.oi.rgbYellowOn = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Robot.oi.rgbYellowOn==false);

    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
