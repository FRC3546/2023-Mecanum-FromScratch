// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.PneumaticCommands;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RaiseLowerArmCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final ArmSubsystem m_armSubsystem;
  private final boolean isRaised;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RaiseLowerArmCommand(boolean isRaisedParameter) {
    
    m_armSubsystem = RobotContainer.m_robotArm;
    isRaised = isRaisedParameter;


    addRequirements(m_armSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("Raise Lower Arm Command Initialized");
  }
 
  @Override
  public void execute() {
    
    if(isRaised == true){
        m_armSubsystem.RaiseArm();
    }

    if(isRaised == false){
        m_armSubsystem.LowerArm();
    }

    else{
        System.out.println("No value for RaiseLowerArmCommand");
    }

  }

  @Override
  public void end(boolean interrupted) {
    ;
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
