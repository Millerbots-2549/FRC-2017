package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveSound extends Command {
	
	double distance, speed;
	private boolean isFinished;

	public DriveSound(double distance, double speed) {
		requires(Robot.drivetrain);
		this.distance = distance;
		this.speed = speed;
	}

	protected void initialize() {
		isFinished = false;
	}

	protected void execute() {
		while(Robot.sensors.getUltrasonicAverage() > distance)
			Robot.drivetrain.driveMecanum(0, speed, 0);
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
