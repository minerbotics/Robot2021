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

public class Arm extends SubsystemBase {

  private final Spark armMotor;
  /**
   * Creates a new ExampleSubsystem.
   */
  public Arm() {

    armMotor = new Spark(Constants.ArmConstants.kArmMotorPort);
  }

  public void raise() {
    armMotor.set(0.66);
  }

  public void stop() {
    armMotor.set(0);
  }

  public void lower() {
    armMotor.set(-0.25);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
