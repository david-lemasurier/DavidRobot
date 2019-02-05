package frc.robot.utils;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import edu.wpi.first.wpilibj.SpeedController;

import frc.robot.RobotMap;
import frc.robot.MultiSpeedController;

public class MotorControllerConfig {

	public void init() {
		RobotMap.robotLeftTalon = new TalonSRX(RobotMap.LEFT_TALON_PORT);
		RobotMap.robotLeftVictor = new VictorSPX(RobotMap.LEFT_VICTOR_PORT);
		RobotMap.robotRightTalon = new TalonSRX(RobotMap.RIGHT_TALON_PORT);
		RobotMap.robotRightVictor = new VictorSPX(RobotMap.RIGHT_VICTOR_PORT);

		/* Factory default hardware to prevent unexpected behavior */
		RobotMap.robotLeftTalon.configFactoryDefault();
		RobotMap.robotLeftVictor.configFactoryDefault();

		RobotMap.robotRightTalon.configFactoryDefault();
		RobotMap.robotRightVictor.configFactoryDefault();

		/* setup the followers */
		RobotMap.robotLeftVictor.follow(RobotMap.robotLeftTalon);
		RobotMap.robotRightVictor.follow(RobotMap.robotRightTalon);

		/* Configure Sensor Source for Pirmary PID */
		RobotMap.robotLeftTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

		/**
		 * Configure Talon SRX Output and Sesnor direction accordingly Invert Motor to
		 * have green LEDs when driving Talon Forward / Requesting Postiive Output Phase
		 * sensor to have positive increment when driving Talon Forward (Green LED)
		 */
		RobotMap.robotLeftTalon.setSensorPhase(true);
		RobotMap.robotLeftTalon.setInverted(true);
		//RobotMap.robotLeftVictor.setInverted(true);

		RobotMap.robotRightTalon.setSensorPhase(true);
		RobotMap.robotRightTalon.setInverted(true);
		//RobotMap.robotRightVictor.setInverted(true);

		/* Set relevant frame periods to be at least as fast as periodic rate */
		RobotMap.robotLeftTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		RobotMap.robotLeftTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);

		RobotMap.robotRightTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);

		/* Set the peak and nominal outputs */
		RobotMap.robotLeftTalon.configNominalOutputForward(0, Constants.kTimeoutMs);
		RobotMap.robotLeftTalon.configNominalOutputReverse(0, Constants.kTimeoutMs);
		RobotMap.robotLeftTalon.configPeakOutputForward(1, Constants.kTimeoutMs);
		RobotMap.robotLeftTalon.configPeakOutputReverse(-1, Constants.kTimeoutMs);

		RobotMap.robotRightTalon.configNominalOutputForward(0, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.configNominalOutputReverse(0, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.configPeakOutputForward(1, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.configPeakOutputReverse(-1, Constants.kTimeoutMs);

		/* Set Motion Magic gains in slot0 - see documentation */
		RobotMap.robotLeftTalon.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		RobotMap.robotLeftTalon.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
		RobotMap.robotLeftTalon.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
		RobotMap.robotLeftTalon.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
		RobotMap.robotLeftTalon.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);

		RobotMap.robotRightTalon.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		RobotMap.robotRightTalon.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);

		/* Set acceleration and vcruise velocity - see documentation */
		RobotMap.robotLeftTalon.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
		RobotMap.robotLeftTalon.configMotionAcceleration(6000, Constants.kTimeoutMs);

		RobotMap.robotRightTalon.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.configMotionAcceleration(6000, Constants.kTimeoutMs);

		/* Zero the sensor */
		RobotMap.robotLeftTalon.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		RobotMap.robotRightTalon.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

	}

	public void initJoystickDrive() {
		RobotMap.leftDrive = new MultiSpeedController(RobotMap.robotLeftTalon, RobotMap.robotLeftTalon);
		RobotMap.rightDrive = new MultiSpeedController(RobotMap.robotRightTalon, RobotMap.robotRightTalon);
		RobotMap.myRobot = new DifferentialDrive(leftDrive, rightDrive);

	}
}
