
package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class AutoNavBarrelRacing extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public AutoNavBarrelRacing(DriveTrain drive) {
    double turn90 = 0.54;
    double drive5 = 1.175;
    double speed = 0.675;
    double clockwise = 3;
    addCommands(
      new AutoDrive(drive, speed).withTimeout(drive5*2),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*0.8),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*2.25),
      new AutoTurn(drive, -clockwise).withTimeout(turn90*0.875),
      new AutoDrive(drive, speed).withTimeout(drive5*0.875),
      new AutoTurn(drive, -clockwise).withTimeout(turn90*0.85),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, -clockwise).withTimeout(turn90*0.85),
      new AutoDrive(drive, speed).withTimeout(drive5*1.75),
      new AutoTurn(drive, -clockwise).withTimeout(turn90*0.85),
      new AutoDrive(drive, speed).withTimeout(drive5*1.75),
      new AutoTurn(drive, -clockwise).withTimeout(turn90*0.85),
      new AutoDrive(drive, speed).withTimeout(drive5),
      new AutoTurn(drive, -clockwise).withTimeout(turn90*0.85),
      new AutoDrive(drive, speed).withTimeout(drive5*3),
      new AutoDrive(drive, -speed).withTimeout(0.15),
      new AutoDrive(drive, 0)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }
}