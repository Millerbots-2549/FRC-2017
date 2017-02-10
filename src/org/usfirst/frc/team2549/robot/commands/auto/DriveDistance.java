package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {
	
	private int distance;
	private double speed;
	private boolean isFinished;

	public DriveDistance(int distance, int angle, double speed) {
		requires(Robot.drivetrain);
		this.distance = distance;
		this.speed = speed;
	}

	protected void initialize() {
		isFinished = false;
	}

	protected void execute() {
		while(Robot.sensors.getEncoderAverage() < distance)
			Robot.drivetrain.driveMecanum(speed, 0, 0);
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
