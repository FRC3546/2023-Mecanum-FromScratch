// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// gyro
import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;
import edu.wpi.first.wpilibj.SPI;


public final class Constants {
  public static final class DriveConstants {

      // The gyro sensor
    public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

    public static final int kFrontLeftMotorPort = 8;
    public static final int kRearLeftMotorPort = 1;
    public static final int kFrontRightMotorPort = 9;
    public static final int kRearRightMotorPort = 0;

    
  }
  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
  }
}