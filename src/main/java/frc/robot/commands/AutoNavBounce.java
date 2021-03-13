
package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class AutoNavBounce extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public AutoNavBounce(DriveTrain drive) {
    double turn90 = 0.47;
    double turn22 = turn90 * 0.4;
    double turn68 = (turn90 - turn22) * 1.45;
    double drive5 = 1.15;
    double drive4 = drive5 * 0.8;
    double speed = 0.675;
    double clockwise = 3;
    addCommands(
      new AutoDrive(drive, speed).withTimeout(drive4*1.1),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive4),
      new AutoTurn(drive, -clockwise).withTimeout(turn22),
      new AutoDrive(drive, -speed).withTimeout(drive5*1.85),
      new AutoTurn(drive, -clockwise).withTimeout(turn68),
      new AutoDrive(drive, -speed).withTimeout(drive4*0.9),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, -speed).withTimeout(drive5*1.75),
      new AutoDrive(drive, speed).withTimeout(drive5*1.75),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*1.3),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*1.75),
      new AutoDrive(drive, -speed).withTimeout(drive5*0.9),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, -speed).withTimeout(drive4*1.125),
      new AutoDrive(drive, speed).withTimeout(0.15),
      new AutoDrive(drive, 0)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }
}