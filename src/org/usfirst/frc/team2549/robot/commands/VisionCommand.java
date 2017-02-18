package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionCommand extends Command {

	public VisionCommand() {
		requires(Robot.cameras);
	}

	protected void initialize() {
		Robot.cameras.start();
		System.out.println("WEYYAYAAYAAAAAAAAAA");
	}

	protected void execute() {
    	if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonCameraGear))
    		Robot.cameras.setCamera(Robot.cameras.gearCamera);
    	else if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonCameraWinch))
    		Robot.cameras.setCamera(Robot.cameras.winchCamera);
    	
    	SmartDashboard.putString("Camera", Robot.cameras.cam);
    }

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
