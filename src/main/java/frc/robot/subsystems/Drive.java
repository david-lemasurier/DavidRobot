
package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Drive extends Subsystem {
	
	
	public Drive() {
	
	}

	public void joystickTank() {
		//RobotMap.myRobot.tankDrive(Robot.oi.joystickLeftAxis(), Robot.oi.joystickRightAxis());
		RobotMap.robotLeftTalon.set(ControlMode.PercentOutput, Robot.oi.joystickLeftAxis());
		RobotMap.robotRightTalon.set(ControlMode.PercentOutput, Robot.oi.joystickRightAxis());
}

	public void gameTank() {
		//RobotMap.myRobot.tankDrive(Robot.oi.xBoxController.getRawAxis(1), Robot.oi.xBoxController.getRawAxis(5));
		RobotMap.robotLeftTalon.set(ControlMode.PercentOutput, Robot.oi.gamepad1.getRawAxis(1));
		RobotMap.robotRightTalon.set(ControlMode.PercentOutput, Robot.oi.gamepad1.getRawAxis(5));
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
}