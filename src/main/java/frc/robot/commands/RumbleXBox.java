/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class RumbleXBox extends Command {
  public RumbleXBox() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  private static final long DURATION = 1000;
  private long endTime;

  @Override
  protected void initialize() {
    endTime = System.currentTimeMillis() + DURATION;
    Robot.oi.setXBoxRumble(1);
  }

  @Override
  protected void end() {
    Robot.oi.setXBoxRumble(0);
  }

  @Override
  protected boolean isFinished() {
    return System.currentTimeMillis() > endTime;
  }
}
