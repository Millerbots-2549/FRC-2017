 package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;
import org.usfirst.frc.team2549.robot.RobotMap;

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

		SmartDashboard.putNumber("Front Left Motor", Robot.drivetrain.getMotor(0));
		SmartDashboard.putNumber("Front Right Motor", Robot.drivetrain.getMotor(1));
		SmartDashboard.putNumber("Rear Left Motor", Robot.drivetrain.getMotor(2));
		SmartDashboard.putNumber("Rear Right Motor", Robot.drivetrain.getMotor(3));
		
		SmartDashboard.putNumber("Front Left Encoder", Robot.sensors.getEncoder(0));
		SmartDashboard.putNumber("Front Right Encoder", Robot.sensors.getEncoder(1));
		SmartDashboard.putNumber("Rear Left Encoder", Robot.sensors.getEncoder(2));
		SmartDashboard.putNumber("Rear Right Encoder", Robot.sensors.getEncoder(3));
		
		SmartDashboard.putNumber("Left Ultrasonic", Robot.sensors.getUltrasonic(0));
		SmartDashboard.putNumber("Right Ultrasonic", Robot.sensors.getUltrasonic(1));
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}
	protected void interrupted() {}
}
