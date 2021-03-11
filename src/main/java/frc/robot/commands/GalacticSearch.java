
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
    addCommands(
      new LowerArm(arm).withTimeout(1),
      new StopArm(arm).withTimeout(0.02),
      new Harvest(intake),
      new AutoDrive(drive, 1).withTimeout(0.375),
      new AutoTurn(drive, 1).withTimeout(.25),
      new AutoDrive(drive, 1).withTimeout(0.5),
      new AutoTurn(drive, -1).withTimeout(0.75),
      new AutoDrive(drive, 1).withTimeout(0.5),
      new AutoTurn(drive, 1).withTimeout(0.75),
      new AutoDrive(drive, 1).withTimeout(0.5),
      new AutoTurn(drive, -1).withTimeout(0.25),
      new AutoDrive(drive, 1).withTimeout(0.375),
      new AutoDrive(drive, 0),
      new StopHarvest(intake)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive, arm, intake);
  }
}