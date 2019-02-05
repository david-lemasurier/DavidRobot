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

	public static WPI_TalonSRX armTalon;
	public static WPI_VictorSPX intakeVictor;

	public static MotorControllerConfig motorControllerConfig = new MotorControllerConfig();

	public static void init() {
		motorControllerConfig.init();

		armTalon = new WPI_TalonSRX(11);
		intakeVictor = new WPI_VictorSPX(12);

		motorControllerConfig.initJoystickDrive();
	}

}


