
package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class AutoNavBarrelRacing extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public AutoNavBarrelRacing(DriveTrain drive) {
    double turn90 = 0.78;
    double drive5 = 1.65;
    double speed = 0.59;
    double clockwise = 2.28;
    double counter = -2.11;
    addCommands(
      new AutoDrive(drive, speed).withTimeout(drive5*2),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*0.8),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*0.8),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*0.8),
      new AutoTurn(drive, clockwise).withTimeout(turn90*0.975),
      new AutoDrive(drive, speed).withTimeout(drive5*2),
      new AutoTurn(drive, counter).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*0.9),
      new AutoTurn(drive, counter).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*0.8),
      new AutoTurn(drive, counter).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive5*1.6),
      new AutoTurn(drive, counter).withTimeout(turn90*0.975),
      new AutoDrive(drive, speed).withTimeout(drive5*1.6),
      new AutoTurn(drive, counter).withTimeout(turn90*0.985),
      new AutoDrive(drive, speed).withTimeout(drive5*0.8),
      new AutoTurn(drive, counter).withTimeout(turn90*0.99),
      new AutoDrive(drive, speed).withTimeout(drive5*4.435),
      new AutoDrive(drive, -speed).withTimeout(0.15),
      new AutoDrive(drive, 0)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }
}