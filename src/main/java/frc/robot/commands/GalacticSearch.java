
package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * An example command that uses an example subsystem.
 */
public class GalacticSearch extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  
  public GalacticSearch(DriveTrain drive, Arm arm, Intake intake) {
    double turn90 = 0.525;
    double turn135 = 0.675;
    double drive10 = 2;
    double drive7 = drive10 * 0.7;
    double clockwise = 3;
    double speed = 0.75;
    addCommands(
      new LowerArm(arm).withTimeout(1),
      new StopArm(arm).withTimeout(0.02),
      new Harvest(intake),
      new AutoDrive(drive, speed).withTimeout(drive7),
      new AutoTurn(drive, clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive10),
      new AutoTurn(drive, -clockwise).withTimeout(turn135),
      new AutoDrive(drive, speed).withTimeout(drive10),
      new AutoTurn(drive, clockwise).withTimeout(turn135),
      new AutoDrive(drive, speed).withTimeout(drive10),
      new AutoTurn(drive, -clockwise).withTimeout(turn90),
      new AutoDrive(drive, speed).withTimeout(drive7),
      new AutoDrive(drive, 0),
      new StopHarvest(intake)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive, arm, intake);
  }
}