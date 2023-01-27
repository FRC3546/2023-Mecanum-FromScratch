package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.Robot;

import frc.robot.commands.DrivetrainCommands.DriveCommand;
import frc.robot.commands.PneumaticCommands.ClampArmCommand;
import frc.robot.commands.PneumaticCommands.RaiseLowerArmCommand;


public class PickUpCommand extends SequentialCommandGroup{

    public PickUpCommand(){
        

        addCommands(new ClampArmCommand(true)); // opens arm
        
        addCommands(
            new ParallelDeadlineGroup(
                new DriveCommand(0.5, 0, 0, 3, true), // drive to gamepiece
                new RaiseLowerArmCommand(false) // lowers arm
            ));


        addCommands(
                new ClampArmCommand(false), // closes arm around gamepiece
                new RaiseLowerArmCommand(true), // raises gamepiece
                new DriveCommand(-0.5, 0, 0, 3, true)
            ); // drives backwards

    }

}
