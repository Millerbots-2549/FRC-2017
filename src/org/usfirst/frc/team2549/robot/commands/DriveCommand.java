package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;
import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends Command {

	public DriveCommand() {
		requires(Robot.drivetrainSubsystem);
	}

	protected void initialize() {
		Robot.drivetrainSubsystem.resetDistance();
	}

	protected void execute() {
		Robot.drivetrainSubsystem.driveMecanum(Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisX),
				Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisY), Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisR));

		SmartDashboard.putNumber("Joystick X Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisX));
		SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisY));
		SmartDashboard.putNumber("Joystick Rotation Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisR));

		SmartDashboard.putNumber("Motor Front Left", RobotMap.driveMotors[0].get());
		SmartDashboard.putNumber("Motor Front Right", RobotMap.driveMotors[1].get());
		SmartDashboard.putNumber("Motor Rear Left", RobotMap.driveMotors[2].get());
		SmartDashboard.putNumber("Motor Rear Right", RobotMap.driveMotors[3].get());
		
		SmartDashboard.putNumber("Encoder Front Left", RobotMap.encoders[0].get());
		SmartDashboard.putNumber("Encoder Front Right", RobotMap.encoders[1].get());
		SmartDashboard.putNumber("Encoder Rear Left", RobotMap.encoders[2].get());
		SmartDashboard.putNumber("Encoder Rear Right", RobotMap.encoders[3].get());
		
		SmartDashboard.putNumber("Ultrasonic Front Left", RobotMap.ultrasonicSensors[0].getValue());
		SmartDashboard.putNumber("Ultrasonic Front Right", RobotMap.ultrasonicSensors[1].getValue());
		SmartDashboard.putNumber("Ultrasonic Rear Left", RobotMap.ultrasonicSensors[2].getValue());
		SmartDashboard.putNumber("Ultrasonic Rear Right", RobotMap.ultrasonicSensors[3].getValue());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}
	protected void interrupted() {}
}
