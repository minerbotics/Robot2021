
package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class AutoNavBounce extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public AutoNavBounce(DriveTrain drive) {
    double turn90 = 0.25;
    addCommands(
      new AutoDrive(drive, 1).withTimeout(0.2),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, -1).withTimeout(.1),
      new AutoDrive(drive, -1).withTimeout(0.5),
      new AutoTurn(drive, -1).withTimeout(0.15),
      new AutoDrive(drive, -1).withTimeout(0.2),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, -1).withTimeout(0.5),
      new AutoDrive(drive, 1).withTimeout(0.5),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.25),
      new AutoTurn(drive, 1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.375),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.5),
      new AutoDrive(drive, -1).withTimeout(0.25),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, -1).withTimeout(0.25),
      new AutoDrive(drive, 0)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }
}