package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchCommand extends Command {

    public WinchCommand() {
        requires(Robot.winchSubsystem);
    }
    
    protected void initialize() {}

    protected void execute() {
    	Robot.winchSubsystem.setMotor(1 - Robot.oi.axisW);
    	
    	if(Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonClampOpen) == true)
    		Robot.winchSubsystem.openClamp();
    	else if(Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonClampClose) == true)
    		Robot.winchSubsystem.closeClamp();
    }

    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {}
    protected void interrupted() {}
}
