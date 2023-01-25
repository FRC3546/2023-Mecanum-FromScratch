package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Robot;

import frc.robot.commands.DrivetrainCommands.DriveCommand;
import frc.robot.commands.PneumaticCommands.ClampArmCommand;
import frc.robot.commands.PneumaticCommands.RaiseLowerArmCommand;


public class PickUpCommand extends SequentialCommandGroup{

    public PickUpCommand(){
        

        addCommands(
            new SequentialCommandGroup(
                new ClampArmCommand(false)
                )); // opens arm
        
        addCommands(
            new ParallelCommandGroup(
                new DriveCommand(0, 0.5, 0, 1, true), // drive to gamepiece
                new RaiseLowerArmCommand(false) // lowers arm
            ));


        addCommands(
            new SequentialCommandGroup(
                new ClampArmCommand(false), // closes arm around gamepiece
                new RaiseLowerArmCommand(true), // raises gamepiece
                new DriveCommand(0, -0.5, 0, 1, true)
            )); // drives backwards

    }

}
