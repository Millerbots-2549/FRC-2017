package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManipulatorCommand extends Command {

    public ManipulatorCommand() {
        requires(Robot.manipulatorSubsystem);
    }

    protected void initialize() {
    	Robot.manipulatorSubsystem.setClosed();
    }

    protected void execute() {
    	if(Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonGearOpen) == true) {
    		Robot.manipulatorSubsystem.setOpen();
    		SmartDashboard.putBoolean("Manipulator Open?", Robot.manipulatorSubsystem.getOpen());
    	}
    	else if(Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonGearOpen) == true) {
    		Robot.manipulatorSubsystem.setClosed();
    		SmartDashboard.putBoolean("Manipulator Open?", Robot.manipulatorSubsystem.getOpen());
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}
    protected void interrupted() {}
}
