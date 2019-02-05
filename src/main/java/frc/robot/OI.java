package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	public Joystick joystickLeft;
	public Joystick joystickRight;
	public Joystick gamepad1;
	public Joystick xBoxController;
	public JoystickButton xBoxGreen;
	public JoystickButton xBoxRed;
	public JoystickButton xBoxBlue;
	public JoystickButton xBoxYellow;
	public boolean redOn = false;
	public boolean greenOn = false;
	public boolean blueOn = false;

	public OI() {
		joystickLeft = new Joystick(1);
		joystickRight = new Joystick(2);
		gamepad1 = new Joystick(0);
		xBoxController = new Joystick(3);
		xBoxGreen = new JoystickButton(gamepad1, 1);
		xBoxGreen.whenPressed(new RunGreenOn());
		xBoxGreen.whenReleased(new RunGreenOff());
		xBoxRed = new JoystickButton(gamepad1, 2);
		xBoxRed.whenPressed(new RunRedOn());
		xBoxRed.whenReleased(new RunRedOff());
		xBoxBlue = new JoystickButton(gamepad1, 3);
		xBoxBlue.whenPressed(new RunBlueOn());
		xBoxBlue.whenReleased(new RunBlueOff());
		xBoxYellow = new JoystickButton(gamepad1, 4);
		xBoxYellow.toggleWhenPressed(new SolenoidCommand());
	}

	public void startDriveCommand() {
		Command command = new RunJoystickTank();
		command.start();
	}

	public double joystickLeftAxis() {
		return joystickLeft.getRawAxis(1);
	}

	public double joystickLeftThrottleAxis() {
		return joystickLeft.getRawAxis(3);
	}

	public double joystickRightAxis() {
		return joystickRight.getRawAxis(1);
	}

	public double joystickRightThrottleAxis() {
		return joystickRight.getRawAxis(3);
	}

	public double gamepadLeftAxis() {
		return gamepad1.getRawAxis(1);
	}

	public double gamepadRightAxis() {
		return gamepad1.getRawAxis(5);
	}

	public double gamePadLeftTrigger() {
		return gamepad1.getRawAxis(2);
	}

	public double gamePadRightTrigger() {
		return gamepad1.getRawAxis(3);
	}
/*
	public double xBoxLeftAxis() {
		return xBoxController.getRawAxis(1);
	}

	public double xBoxRightAxis() {
		return xBoxController.getRawAxis(5);
	}

	public double xBoxLeftTrigger() {
		return xBoxController.getRawAxis(2);
	}

	public double xBoxRightTrigger() {
		return xBoxController.getRawAxis(3);
	}
*/
	public double getRawAxis(int axis) {
		return gamepad1.getRawAxis(axis);
	}

	public void setXBoxRumble(double intensity) {
		xBoxController.setRumble(RumbleType.kRightRumble,intensity);
		xBoxController.setRumble(RumbleType.kLeftRumble,intensity);
	}

}
