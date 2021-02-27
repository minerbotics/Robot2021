/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ClearBall;
import frc.robot.commands.Eject;
import frc.robot.commands.Feed;
import frc.robot.commands.Harvest;
import frc.robot.commands.LowerArm;
import frc.robot.commands.RaiseArm;
import frc.robot.commands.Shoot1;
import frc.robot.commands.Shoot2;
import frc.robot.commands.Shoot3;
import frc.robot.commands.Shoot4;
import frc.robot.commands.StopArm;
import frc.robot.commands.StopFeed;
import frc.robot.commands.StopHarvest;
import frc.robot.commands.StopShooter;
import frc.robot.commands.Unfeed;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveTrain m_driveTrain;
  private final Intake m_intake;
  private final Arm m_arm;
  private final Feeder m_feeder;
  private final Shooter m_shooter;

  // The robot's commands
  private final ArcadeDrive m_driveCommand;
  private final Harvest m_harvestCommand;
  private final StopHarvest m_stopHarvestCommand;
  private final Eject m_ejectCommand;
  private final RaiseArm m_raiseArmCommand;
  private final StopArm m_stopArmCommand;
  private final LowerArm m_lowerArmCommand;
  private final Feed m_feedCommand;
  private final StopFeed m_stopFeedCommand;
  private final Unfeed m_unfeedCommand;
  private final Shoot1 m_shoot1Command;
  private final Shoot2 m_shoot2Command;
  private final Shoot3 m_shoot3Command;
  private final Shoot4 m_shoot4Command;
  private final StopShooter m_stopShooterCommand;
  private final ClearBall m_clearBallCommand;
 
  // The Xbox controller
  XboxController m_driverController1;
  XboxController m_driverController2;

  //The command buttons
  JoystickButton m_harvestButton;
  JoystickButton m_ejectButton;
  JoystickButton m_raiseArmButton;
  JoystickButton m_lowerArmButton;
  JoystickButton m_feedButton;
  JoystickButton m_unfeedButton;
  JoystickButton m_shoot1Button;
  JoystickButton m_shoot2Button;
  JoystickButton m_shoot3Button;
  JoystickButton m_shoot4Button;
  JoystickButton m_clearBallButton;

  public static SendableChooser<Command> m_chooser;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_driveTrain = new DriveTrain();
    m_intake = new Intake();
    m_arm = new Arm();
    m_feeder = new Feeder();
    m_shooter = new Shooter();
    m_driverController1 = new XboxController(Constants.IOConstants.kControllerPort1);
    m_driverController2 = new XboxController(Constants.IOConstants.kControllerPort2);

    m_driveCommand = new ArcadeDrive(m_driveTrain, m_driverController1);
    m_driveTrain.setDefaultCommand(m_driveCommand);

    m_harvestCommand = new Harvest(m_intake);
    m_stopHarvestCommand = new StopHarvest(m_intake);
    m_ejectCommand = new Eject(m_intake);

    m_raiseArmCommand = new RaiseArm(m_arm);
    m_stopArmCommand = new StopArm(m_arm);
    m_lowerArmCommand = new LowerArm(m_arm);

    m_feedCommand = new Feed(m_feeder);
    m_stopFeedCommand = new StopFeed(m_feeder);
    m_unfeedCommand = new Unfeed(m_feeder);

    m_shoot1Command = new Shoot1(m_shooter);
    m_shoot2Command = new Shoot2(m_shooter);
    m_shoot3Command = new Shoot3(m_shooter);
    m_shoot4Command = new Shoot4(m_shooter);
    m_stopShooterCommand = new StopShooter(m_shooter);
    m_clearBallCommand = new ClearBall(m_shooter);

    m_harvestButton = new JoystickButton(m_driverController1, Constants.IOConstants.kRBButton);
    m_ejectButton = new JoystickButton(m_driverController1, Constants.IOConstants.kLBButton);
    m_raiseArmButton = new JoystickButton(m_driverController1, Constants.IOConstants.kYButton);
    m_lowerArmButton = new JoystickButton(m_driverController1, Constants.IOConstants.kAButton);

    m_clearBallButton = new JoystickButton(m_driverController2, Constants.IOConstants.kRBButton);
    m_unfeedButton = new JoystickButton(m_driverController2, Constants.IOConstants.kStartButton);
    m_feedButton = new JoystickButton(m_driverController2, Constants.IOConstants.kBackButton);
    m_shoot1Button = new JoystickButton(m_driverController2, Constants.IOConstants.kAButton);
    m_shoot2Button = new JoystickButton(m_driverController2, Constants.IOConstants.kBButton);
    m_shoot3Button = new JoystickButton(m_driverController2, Constants.IOConstants.kXButton);
    m_shoot4Button = new JoystickButton(m_driverController2, Constants.IOConstants.kYButton);


    m_chooser = new SendableChooser<Command>();

    Shuffleboard.getTab("ComboBox Chooser").add(m_chooser);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    m_harvestButton.whenPressed(m_harvestCommand);
    m_harvestButton.whenReleased(m_stopHarvestCommand);
    m_ejectButton.whenPressed(m_ejectCommand);
    m_ejectButton.whenReleased(m_stopHarvestCommand);

    m_raiseArmButton.whenPressed(m_raiseArmCommand);
    m_raiseArmButton.whenReleased(m_stopArmCommand);
    m_lowerArmButton.whenPressed(m_lowerArmCommand);
    m_lowerArmButton.whenReleased(m_stopArmCommand);

    m_clearBallButton.whenPressed(m_clearBallCommand);
    m_clearBallButton.whenReleased(m_stopShooterCommand);

    m_feedButton.whenPressed(m_feedCommand);
    m_feedButton.whenReleased(m_stopFeedCommand);
    m_unfeedButton.whenPressed(m_unfeedCommand);
    m_unfeedButton.whenReleased(m_stopFeedCommand);

    m_shoot1Button.whenPressed(m_shoot1Command);
    m_shoot1Button.whenReleased(m_stopShooterCommand);
    m_shoot2Button.whenPressed(m_shoot2Command);
    m_shoot2Button.whenReleased(m_stopShooterCommand);
    m_shoot3Button.whenPressed(m_shoot3Command);
    m_shoot3Button.whenReleased(m_stopShooterCommand);
    m_shoot4Button.whenPressed(m_shoot4Command);
    m_shoot4Button.whenReleased(m_stopShooterCommand);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}
