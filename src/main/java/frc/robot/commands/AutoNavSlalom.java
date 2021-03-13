
package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class AutoNavSlalom extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public AutoNavSlalom(DriveTrain drive) {
    double turn90 = 0.525;
    double drive5 = 1;
    double speed = 0.75;
    double clockwise = 3;
    addCommands(
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*3),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*3),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoDrive(drive, 0)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }
}