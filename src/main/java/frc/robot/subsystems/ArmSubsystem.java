// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ArmSubsystem extends SubsystemBase {
    
    private DoubleSolenoid clampSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    private boolean clampOpen = false;
    
    private DoubleSolenoid raiseArmSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 7);
    private boolean armRaised = false;

    @Override
    public void periodic() {
    }

    public void CloseClamp(){
        clampSolenoid.set(Value.kForward);
        clampOpen = false;
    }
    
    public void OpenClamp(){
        clampSolenoid.set(Value.kReverse);
        clampOpen = true;
    }

    public void RaiseArm(){
        raiseArmSolenoid.set(Value.kForward);
        armRaised = true;
    }

    public void LowerArm(){
        raiseArmSolenoid.set(Value.kReverse);
        armRaised = false;
    }
}

    