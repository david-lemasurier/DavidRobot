/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class InTakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void intakeBall() {
    // Right Trigger on xBox
    if (Robot.oi.xBoxController.getRawAxis(3) >= 0.15) {
      RobotMap.intakeVictor.set(Robot.oi.xBoxController.getRawAxis(3));
    } else if (Robot.oi.xBoxController.getRawAxis(2) >= 0.15) {
      RobotMap.intakeVictor.set(-(Robot.oi.xBoxController.getRawAxis(2)));
    }else {
      //new RumbleXBox().start();

      RobotMap.intakeVictor.set(0);
    }
  }
  public void ejectBall() {
    //Left Trigger on xBox
    if (Robot.oi.xBoxController.getRawAxis(2) >= 0.15) {
      RobotMap.intakeVictor.set(-(Robot.oi.xBoxController.getRawAxis(2)));
    } else {
      //new RumbleXBox().start();
      RobotMap.intakeVictor.set(0);
    }
  }
}
