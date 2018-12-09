package frc.robot;


//import frc.robot.commands.Throttle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.RGBLedRedOff;
import frc.robot.commands.RGBLedRedOn;
import frc.robot.commands.RGBLedGreenOff;
import frc.robot.commands.RGBLedGreenOn;
import frc.robot.commands.RGBLedBlueOff;
import frc.robot.commands.RGBLedBlueOn;
import frc.robot.commands.RGBLedYellowOff;
import frc.robot.commands.RGBLedYellowOn;
import frc.robot.commands.RunJoystickTank;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	public Joystick joystickLeft;
	public Joystick joystickRight;
	public Joystick gamepad1;
	public Joystick xBoxController;

	public Button rgbLedRed;
	public Button rgbLedGreen;
	public Button rgbLedBlue;
	public Button rgbLedYellow;

	public boolean rgbRedOn = false;
	public boolean rgbGreenOn = false;
	public boolean rgbBlueOn = false;
	public boolean rgbYellowOn = false;

	public OI() {
		joystickLeft = new Joystick(1);
		joystickRight = new Joystick(2);
		gamepad1 = new Joystick(0);
		xBoxController = new Joystick(3);

		rgbLedRed = new JoystickButton(gamepad1, 2);
		rgbLedRed.whenPressed(new RGBLedRedOn());
		rgbLedRed.whenReleased(new RGBLedRedOff());
		
		
		rgbLedGreen = new JoystickButton(gamepad1, 1);
		rgbLedGreen.whenPressed(new RGBLedGreenOn());
		rgbLedGreen.whenReleased(new RGBLedGreenOff());
		
		
		rgbLedBlue = new JoystickButton(gamepad1, 3);
		rgbLedBlue.whenPressed(new RGBLedBlueOn());
		rgbLedBlue.whenReleased(new RGBLedBlueOff());
		
		
		rgbLedYellow = new JoystickButton(gamepad1, 4);
		rgbLedYellow.whenPressed(new RGBLedYellowOn());
		rgbLedYellow.whenReleased(new RGBLedYellowOff());	
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

}
