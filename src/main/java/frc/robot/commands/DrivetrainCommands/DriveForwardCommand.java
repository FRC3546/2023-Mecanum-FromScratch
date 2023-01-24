// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DrivetrainCommands;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveForwardCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final DrivetrainSubsystem m_driveSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForwardCommand() {
    
    m_driveSubsystem = RobotContainer.m_robotDrive;

    addRequirements(m_driveSubsystem);
  }

  @Override
  public void initialize() {}
 
  @Override
  public void execute() {
    m_driveSubsystem.drive(0, 0.5, 0, true);
  }

  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.drive(0, 0, 0, false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
