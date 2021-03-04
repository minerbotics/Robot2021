/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private final Spark shooterMotor;
  /**
   * Creates a new ExampleSubsystem.
   */
  public Shooter() {

    shooterMotor = new Spark(Constants.ShooterConstants.kShooterMotorPort);
  }

  public void shoot1() {
    shooterMotor.set(0.25);
  }

  public void shoot2() {
    shooterMotor.set(0.5);
  }

  public void shoot3() {
    shooterMotor.set(0.75);
  }

  public void shoot4() {
    shooterMotor.set(1);
  }

  public void stop() {
    shooterMotor.set(0);
  }

  public void clearball() {
    shooterMotor.set(0.25);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
