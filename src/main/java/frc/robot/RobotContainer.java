// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
// import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.DrivetrainCommands.DriveCommand;
// import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



public class RobotContainer {
  
  // The robot's subsystems
  public static DrivetrainSubsystem m_robotDrive = new DrivetrainSubsystem();
  // public static ArmSubsystem m_robotArm = new ArmSubsystem();


  
  // The driver's controller
//   Joystick m_driverController = new Joystick(OIConstants.kDriverControllerPort);

  XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new RunCommand(
            () ->
                m_robotDrive.drive(
                    m_driverController.getLeftX(),
                    m_driverController.getLeftY(),
                    m_driverController.getRawAxis(2),
                    true),
            m_robotDrive));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling passing it to a
   * {@link JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(m_driverController, Button.kA.value)
        .onTrue(new InstantCommand(() -> m_robotDrive.zeroHeading()));

    // Drive at half speed when the right bumper is held
    new JoystickButton(m_driverController, Button.kRightBumper.value)
        .onTrue(new InstantCommand(() -> m_robotDrive.setMaxOutput(0.5)))
        .onFalse(new InstantCommand(() -> m_robotDrive.setMaxOutput(1)));
    
    // new JoystickButton(m_driverController, Button.kA.value)
    //     .onTrue(new InstantCommand(() -> m_robotArm.OpenClamp()))
    //     .onFalse(new InstantCommand(() -> m_robotArm.CloseClamp()));


    // new JoystickButton(m_driverController, Button.kX.value)
    //     .toggleOnTrue(new InstantCommand(() -> m_robotArm.toggleArm()));

    // new JoystickButton(m_driverController, Button.kY.value)
    //     .onTrue(new InstantCommand(() -> m_robotArm.LowerArm()));

  }

  // public Command getAutonomousCommand() {
  //   return new SequentialCommandGroup(
  //     new DriveForwardCommand(2)
  //   );
  // }

}