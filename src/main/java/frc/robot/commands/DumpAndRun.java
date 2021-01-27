/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class DumpAndRun extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public DumpAndRun(DriveTrain drive, Arm arm, Intake intake) {
    addCommands(
      new StopHarvest(intake).withTimeout(3),
      new Eject(intake).withTimeout(1.5),
      new StopHarvest(intake),
      new AutoDrive(drive, -0.5).withTimeout(1),
      new LowerArm(arm).withTimeout(0.5),
      new RaiseArm(arm).withTimeout(0.25),
      new StopArm(arm).withTimeout(0.02)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive, arm, intake);
  }
}
