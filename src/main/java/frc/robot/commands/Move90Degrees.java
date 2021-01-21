/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class Move90Degrees extends CommandBase {
  
  private DriveTrain drivetrain;
  private static double increment = 90;
  private static final double tolerance = 5;

  public Move90Degrees() {
    addRequirements(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      drivetrain = Robot.driveTrain;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if(drivetrain.getGyroReading() > 270 && drivetrain.getGyroReading() < 360) {
          if(increment*4 < drivetrain.getGyroReading() + tolerance && increment*4 > drivetrain.getGyroReading() - tolerance) {
              drivetrain.drive(0, 0);
          } else {
              drivetrain.drive(-0.5, 0.5);
          }
      } else if(drivetrain.getGyroReading() > 180 && drivetrain.getGyroReading() < 270) {
        if(increment*3 < drivetrain.getGyroReading() + tolerance && increment*3 > drivetrain.getGyroReading() - tolerance) {
            drivetrain.drive(0, 0);
        } else {
            drivetrain.drive(-0.5, 0.5);
        }
      } else if(drivetrain.getGyroReading() > 90 && drivetrain.getGyroReading() < 180) {
        if(increment*2 < drivetrain.getGyroReading() + tolerance && increment*2 > drivetrain.getGyroReading() - tolerance) {
            drivetrain.drive(0, 0);
        } else {
            drivetrain.drive(-0.5, 0.5);
        }
      } else if(drivetrain.getGyroReading() > 0 && drivetrain.getGyroReading() < 90) {
        if(increment < drivetrain.getGyroReading() + tolerance && increment > drivetrain.getGyroReading() - tolerance) {
            drivetrain.drive(0, 0);
        } else {
            drivetrain.drive(-0.5, 0.5);
        }
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return ( (drivetrain.getGyroReading() > 70 && drivetrain.getGyroReading() < 90)||(drivetrain.getGyroReading() > 160 && drivetrain.getGyroReading() < 180)||
    (drivetrain.getGyroReading() > 250 && drivetrain.getGyroReading() < 270)||(drivetrain.getGyroReading() > 340 && drivetrain.getGyroReading() < 360) );
  }
}
