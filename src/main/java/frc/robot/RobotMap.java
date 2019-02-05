package frc.robot;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.utils.MotorControllerConfig;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static TalonSRX robotLeftTalon;
	public static VictorSPX robotLeftVictor;
	public static TalonSRX robotRightTalon;
	public static VictorSPX robotRightVictor;
	public static DifferentialDrive myRobot;
	public static SpeedController leftDrive;
	public static SpeedController rightDrive;

	// CAN bus IDs
	public static final int ARM_TALON_PORT = 11;
	public static final int INTAKE_VICTOR_PORT = 12;
	public static final int LEFT_TALON_PORT = 23;
	public static final int LEFT_VICTOR_PORT = 20;
	public static final int RIGHT_TALON_PORT = 22;
	public static final int RIGHT_VICTOR_PORT = 21;

	public static WPI_TalonSRX armTalon;
	public static WPI_VictorSPX intakeVictor;

	public static MotorControllerConfig motorControllerConfig = new MotorControllerConfig();

	public static void init() {
		motorControllerConfig.init();

		armTalon = new WPI_TalonSRX(ARM_TALON_PORT);
		intakeVictor = new WPI_VictorSPX(INTAKE_VICTOR_PORT);

		motorControllerConfig.initJoystickDrive();
	}

}


