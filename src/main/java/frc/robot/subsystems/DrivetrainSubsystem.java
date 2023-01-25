// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.MecanumDriveMotorVoltages;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


// gyro imports
import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;
import edu.wpi.first.wpilibj.SPI;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private final VictorSP m_frontLeft = new VictorSP(DriveConstants.kFrontLeftMotorPort);
    private final VictorSP m_rearLeft = new VictorSP(DriveConstants.kRearLeftMotorPort);
    private final VictorSP m_frontRight = new VictorSP(DriveConstants.kFrontRightMotorPort);
    private final VictorSP m_rearRight = new VictorSP(DriveConstants.kRearRightMotorPort);
  
    private static final AHRS gyro = DriveConstants.gyro;
  
  
    private final MecanumDrive m_drive =
        new MecanumDrive(m_frontLeft, m_rearLeft, m_frontRight, m_rearRight);

    public DrivetrainSubsystem() {
        // We need to invert one side of the drivetrain so that positive voltages
        // result in both sides moving forward. Depending on how your robot's
        // gearbox is constructed, you might have to invert the left side instead.
        m_frontRight.setInverted(true);
        m_rearRight.setInverted(true);
        m_frontLeft.setInverted(false);
        m_rearLeft.setInverted(false);
    }

    @Override
    public void periodic() {
    }

    @SuppressWarnings("ParameterName")
    public void drive(double xSpeed, double ySpeed, double rot, boolean fieldRelative) {
        if (fieldRelative) {
          m_drive.driveCartesian(xSpeed, ySpeed, Math.pow(rot, 3)*.3, new Rotation2d((gyro.getAngle()*Math.PI)/180));
        } else {
          // m_drive.driveCartesian(ySpeed, xSpeed, Math.pow(rot, 3))
          System.out.println("gyro failure");
        }
    }
    
    public void setDriveMotorControllersVolts(MecanumDriveMotorVoltages volts) {
        m_frontLeft.setVoltage(volts.frontLeftVoltage);
        m_rearLeft.setVoltage(volts.rearLeftVoltage);
        m_frontRight.setVoltage(volts.frontRightVoltage);
        m_rearRight.setVoltage(volts.rearRightVoltage);
    }


    public void setMaxOutput(double maxOutput) {
        m_drive.setMaxOutput(maxOutput);
    }

    public void zeroHeading() {
        gyro.zeroYaw();
    }

    public double getHeading() {
        return gyro.getAngle();
    }

      public double getTurnRate() {
        return -gyro.getRate();
    }
}

    