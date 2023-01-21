// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class OpenArmCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final ArmSubsystem m_armSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public OpenArmCommand(ArmSubsystem subsystem) {
    
    m_armSubsystem = subsystem;

    addRequirements(m_armSubsystem);
  }

  @Override
  public void initialize() {}
 
  @Override
  public void execute() {
    m_armSubsystem.OpenClamp();
  }

  @Override
  public void end(boolean interrupted) {
    ;
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
