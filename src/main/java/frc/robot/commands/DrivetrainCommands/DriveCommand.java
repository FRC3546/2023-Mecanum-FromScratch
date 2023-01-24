// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DrivetrainCommands;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;


public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final DrivetrainSubsystem m_driveSubsystem;

  private final Timer timer = new Timer();

  private final double time;

  private final double xSpeed;
  private final double ySpeed;
  private final double rotation;
  private final boolean fieldRelative;



  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(double xSpeed, double ySpeed, double rotation, double driveTime, boolean fieldRelative) {
    
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
    this.rotation = rotation;
    this.fieldRelative = fieldRelative;
    
    m_driveSubsystem = RobotContainer.m_robotDrive;

    time = driveTime;

    addRequirements(m_driveSubsystem);
  }

  @Override
  public void initialize() {
    
    timer.reset();
  	timer.start();
  }
 
  @Override
  public void execute() {

    m_driveSubsystem.drive(xSpeed, ySpeed, rotation, fieldRelative);

  }

  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.drive(0, 0, 0, false);
    timer.reset();
  }

  @Override
  public boolean isFinished() {

    return timer.get() >= time;

  }
}
