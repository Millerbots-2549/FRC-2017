package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VisionCenter extends Command {

	private int cogX, cogY;
	private boolean isFinished;
	
	public VisionCenter() {
		requires(Robot.cameras);
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		isFinished = false;
	}

	protected void execute() {
		isFinished = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
