package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveDistance extends Command {

	private int distance;
	private double speed, angle;
	private boolean isFinished;

	public DriveDistance(int distance, int angle, double speed) {
		requires(Robot.drivetrain);
		this.distance = distance;
		this.angle = angle;
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		isFinished = false;
		Robot.sensors.resetGyro();

		if (angle < 0)
			while (Robot.sensors.getGyroAngle() > angle)
				Robot.drivetrain.driveMecanum(0, 0, -speed);
		else if (angle > 0)
			while (Robot.sensors.getGyroAngle() < angle)
				Robot.drivetrain.driveMecanum(0, 0, speed);

		Robot.sensors.resetEncoders();

		while (Robot.sensors.getEncoderAverage() < distance) {
			Robot.drivetrain.driveMecanum(0, -speed, 0);

			SmartDashboard.putNumber("Front Left Encoder", Robot.sensors.getEncoder(0));
			SmartDashboard.putNumber("Front Right Encoder", Robot.sensors.getEncoder(1));
			SmartDashboard.putNumber("Rear Left Encoder", Robot.sensors.getEncoder(2));
			SmartDashboard.putNumber("Rear Right Encoder", Robot.sensors.getEncoder(3));
		}

		isFinished = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
	}

	protected void interrupted() {
		isFinished = true;
	}
}
