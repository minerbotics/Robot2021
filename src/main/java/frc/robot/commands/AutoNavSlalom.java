
package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class AutoNavSlalom extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public AutoNavSlalom(DriveTrain drive) {
    addCommands(
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, -1).withTimeout(0.25),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, 1).withTimeout(.25),
      new AutoDrive(drive, 1).withTimeout(0.75),
      new AutoTurn(drive, 1).withTimeout(.25),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, -1).withTimeout(.25),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, -1).withTimeout(0.25),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, -1).withTimeout(0.25),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, 1).withTimeout(0.25),
      new AutoDrive(drive, 1).withTimeout(0.75),
      new AutoTurn(drive, 1).withTimeout(0.25),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, -1).withTimeout(0.25),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoDrive(drive, 0)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }
}