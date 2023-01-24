// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.PneumaticCommands;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClampArmCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final ArmSubsystem m_armSubsystem;
  private final boolean open;

  
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ClampArmCommand(boolean openParameter) {
    
    m_armSubsystem = RobotContainer.m_robotArm;
    open = openParameter;

    addRequirements(m_armSubsystem);
  }

  @Override
  public void initialize() {}
 
  @Override
  public void execute() {

    if(open == true){
        m_armSubsystem.OpenClamp();
    }

    if(open == false){
        m_armSubsystem.CloseClamp();
    }

    else{
        System.out.print("No value for ClampArmCommand");
    }


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
