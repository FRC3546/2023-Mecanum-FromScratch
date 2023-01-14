// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrivetrainSubsystem m_driveSubsystem;
  private final Supplier<Double> xValue, yValue, rot;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(DrivetrainSubsystem m_driveSubsystem, Supplier<Double> xValue, Supplier<Double> yValue, Supplier<Double> rot) {;
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_driveSubsystem = m_driveSubsystem;
    this.xValue = xValue;
    this.yValue = yValue;
    this.rot = rot;
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = xValue.get();
    double y = yValue.get();
    double rotation = rot.get(); 
    m_driveSubsystem.drive(
      x,
      y,
      rotation,
      true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
