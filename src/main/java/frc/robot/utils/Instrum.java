/**
 * Instrumentation Class that handles how telemetry from the Talon SRX interacts
 * with Driverstation and Smart Dashboard.
 */
package frc.robot.utils;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Instrum {
	/* Tracking variables for instrumentation */
	private static int _timesInMotionMagic = 0;

	public static void Process(TalonSRX talon, String side) {
		/* Smart dash plots */
		SmartDashboard.putNumber("SensorVel["+side+"]", talon.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
		SmartDashboard.putNumber("SensorPos["+side+"]", talon.getSelectedSensorPosition(Constants.kPIDLoopIdx));
		SmartDashboard.putNumber("MotorOutputPercent["+side+"]", talon.getMotorOutputPercent());
		SmartDashboard.putNumber("ClosedLoopError["+side+"]", talon.getClosedLoopError(Constants.kPIDLoopIdx));
		
		/* Check if Talon SRX is performing Motion Magic */
		if (talon.getControlMode() == ControlMode.MotionMagic) {
			++_timesInMotionMagic;
		} else {
			_timesInMotionMagic = 0;
		}

		if (_timesInMotionMagic > 10) {
			/* Print the Active Trajectory Point Motion Magic is servoing towards */
			SmartDashboard.putNumber("ClosedLoopTarget["+side+"]", talon.getClosedLoopTarget(Constants.kPIDLoopIdx));
    		SmartDashboard.putNumber("ActTrajVelocity["+side+"]", talon.getActiveTrajectoryVelocity());
    		SmartDashboard.putNumber("ActTrajPosition["+side+"]", talon.getActiveTrajectoryPosition());
		}

	}
}