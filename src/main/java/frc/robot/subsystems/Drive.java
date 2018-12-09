
package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem {
	
	
	public Drive() {
	
	}
	public void joystickTank() {
		RobotMap.myRobot.tankDrive(Robot.oi.joystickLeftAxis(), Robot.oi.joystickRightAxis());
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
}