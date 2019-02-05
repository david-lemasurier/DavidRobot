
package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Preferences;
import frc.robot.subsystems.*;
import frc.robot.commands.*;



/* The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

	public static OI oi;
	public static Drive drive = new Drive();
	public static SolenoidSubsystem solSub;	
	private static double robotSpeed = 0.35;
	public static CompressorSubsystem compSub;
	private ArmSubsystem armSubsystem;
	private InTakeSubsystem intakeSubsystem;

	private Preferences prefs;

	/* Used to build string throughout loop */
	StringBuilder talonOutputBuffer = new StringBuilder();


	public static double getRobotSpeed(){
		return robotSpeed;
	}


	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */


	public void robotInit() {
		RobotMap.init();
		solSub = new SolenoidSubsystem();
		compSub = new CompressorSubsystem();
		compSub.runCompressor();
		oi = new OI();

		prefs = Preferences.getInstance();
		robotSpeed = prefs.getDouble("RobotSpeed", 0.35);

		armSubsystem = new ArmSubsystem();
		intakeSubsystem = new InTakeSubsystem();
	}
	
  	/**
   	 * This function is called every robot packet, no matter the mode. Use
   	 * this for items like diagnostics that you want ran during disabled,
   	 * autonomous, teleoperated and test.
   	 *
   	 * <p>This runs after the mode specific periodic functions, but before
   	 * LiveWindow and SmartDashboard integrated updating.
   	 */
	@Override
	public void robotPeriodic() {
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		oi.startDriveCommand();	
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		robotSpeed = prefs.getDouble("RobotSpeed", 0.35);
		compSub.updateSmartDashboard();
		
		armSubsystem.runArm();

		intakeSubsystem.intakeBall();
//		intakeSubsystem.ejectBall();
		//dimLED();
	}

	private void dimLED() {
		double value=oi.getRawAxis(1);
		int newvalue=0;
		if (value==1){
			newvalue=0;	
		} else if(value>0.34){
			newvalue=50;
		} else if(value==-1){
			newvalue=255;
		} else if(value<-0.34){
			newvalue=197;
		} else {
			newvalue=127;
		}
		ChangeLedValue led=new ChangeLedValue();
		led.setvalue("green",newvalue);	
	}

	private static int periodicLoops = 0;

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		/* Get gamepad axis - forward stick is positive */
		double leftYstick = -1.0 * oi.xBoxController.getRawAxis(1);
		if (Math.abs(leftYstick) < 0.10) { leftYstick = 0;} /* deadband 10% */

		/* Get current Talon SRX motor output */
		double leftMotorOutput = RobotMap.robotLeftTalon.getMotorOutputPercent();
		double rightMotorOutput = RobotMap.robotRightTalon.getMotorOutputPercent();

		/* Prepare line to print */
		talonOutputBuffer.append("\tOutLeft%:");
		talonOutputBuffer.append(leftMotorOutput);
		talonOutputBuffer.append("\tOutRight%:");
		talonOutputBuffer.append(rightMotorOutput);
		talonOutputBuffer.append("\tVelLeft:");
		talonOutputBuffer.append(RobotMap.robotLeftTalon.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
		talonOutputBuffer.append("\tVelRight:");
		talonOutputBuffer.append(RobotMap.robotRightTalon.getSelectedSensorVelocity(Constants.kPIDLoopIdx));

		/**
		 * Peform Motion Magic when Button 5 is held,
		 * else run Percent Output, which can be used to confirm hardware setup.
		 */
		if (oi.xBoxController.getRawButton(5)) {
			/* Motion Magic */ 
			
			/*4096 ticks/rev * 10 Rotations in either direction */
			double targetPos = leftYstick * 4096 * 10.0;
			RobotMap.robotLeftTalon.set(ControlMode.MotionMagic, targetPos);
			RobotMap.robotRightTalon.set(ControlMode.MotionMagic, targetPos);

			/* Append more signals to print when in speed mode */
			talonOutputBuffer.append("\terrLeft:");
			talonOutputBuffer.append(RobotMap.robotLeftTalon.getClosedLoopError(Constants.kPIDLoopIdx));
			talonOutputBuffer.append("\terrRight:");
			talonOutputBuffer.append(RobotMap.robotRightTalon.getClosedLoopError(Constants.kPIDLoopIdx));
			talonOutputBuffer.append("\ttrg:");
			talonOutputBuffer.append(targetPos);
		} else {
			/* Percent Output */

			RobotMap.robotLeftTalon.set(ControlMode.PercentOutput, leftYstick);
			RobotMap.robotRightTalon.set(ControlMode.PercentOutput, leftYstick);
		}

		/* Instrumentation */
		Instrum.Process(RobotMap.robotLeftTalon, "Left");	
		Instrum.Process(RobotMap.robotRightTalon, "Right");	
		
		/* Periodically print to console */
		if (++_loops >= 20) {
			_loops = 0;
			System.out.println(talonOutputBuffer.toString());
		}
		/* Reset created string for next loop */
		talonOutputBuffer.setLength(0);
	}	
}