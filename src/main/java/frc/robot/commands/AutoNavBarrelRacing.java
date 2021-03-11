
package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class AutoNavBarrelRacing extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public AutoNavBarrelRacing(DriveTrain drive) {
    double turn90 = 0.25;
    addCommands(
      new AutoDrive(drive, 1).withTimeout(0.375),
      new AutoTurn(drive, 1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.1),
      new AutoTurn(drive, 1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.1),
      new AutoTurn(drive, 1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.1),
      new AutoTurn(drive, 1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(1),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.1),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.1),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.75),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.75),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(0.1),
      new AutoTurn(drive, -1).withTimeout(turn90),
      new AutoDrive(drive, 1).withTimeout(1.5),
      new AutoDrive(drive, 0)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }
}