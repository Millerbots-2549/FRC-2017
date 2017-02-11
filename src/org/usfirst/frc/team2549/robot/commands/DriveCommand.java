package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends Command {

	public DriveCommand() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		Robot.sensors.resetEncoders();
	}

	protected void execute() {
		Robot.drivetrain.driveMecanum(Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisX),
				Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisY), Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisR));

		SmartDashboard.putNumber("Joystick X Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisX));
		SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisY));
		SmartDashboard.putNumber("Joystick Rotation Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisR));

		SmartDashboard.putNumber("Motor Front Left", Robot.drivetrain.getMotor(0));
		SmartDashboard.putNumber("Motor Front Right", Robot.drivetrain.getMotor(1));
		SmartDashboard.putNumber("Motor Rear Left", Robot.drivetrain.getMotor(2));
		SmartDashboard.putNumber("Motor Rear Right", Robot.drivetrain.getMotor(3));
		
		SmartDashboard.putNumber("Encoder Front Left", Robot.sensors.getEncoder(0));
		SmartDashboard.putNumber("Encoder Front Right", Robot.sensors.getEncoder(1));
		SmartDashboard.putNumber("Encoder Rear Left", Robot.sensors.getEncoder(2));
		SmartDashboard.putNumber("Encoder Rear Right", Robot.sensors.getEncoder(3));
		
		SmartDashboard.putNumber("Ultrasonic Left", Robot.sensors.getUltrasonic(0));
		SmartDashboard.putNumber("Ultrasonic Right", Robot.sensors.getUltrasonic(1));
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}
	protected void interrupted() {}
}
