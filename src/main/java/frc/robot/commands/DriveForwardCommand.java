// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveForwardCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final DrivetrainSubsystem m_driveSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForwardCommand(DrivetrainSubsystem subsystem) {;
    
    m_driveSubsystem = subsystem;

    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveSubsystem.drive(0, 0.5, 0, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.drive(0, 0, 0, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
