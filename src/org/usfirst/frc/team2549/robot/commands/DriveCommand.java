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
		Robot.drivetrainSubsystem.driveMecanum(Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisX)/3,
				Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisY)/3, Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisR)/3);

		SmartDashboard.putNumber("Joystick X Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisX));
		SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisY));
		SmartDashboard.putNumber("Joystick Rotation Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisR));

		SmartDashboard.putNumber("Front Left Motor", RobotMap.frontLeftMotor.get());
		SmartDashboard.putNumber("Rear Left Motor", RobotMap.rearLeftMotor.get());
		SmartDashboard.putNumber("Front Right Motor", RobotMap.frontRightMotor.get());
		SmartDashboard.putNumber("Rear Right Motor", RobotMap.rearRightMotor.get());
		
		SmartDashboard.putNumber("Front Left Encoder" , RobotMap.frontLeftEncoder.get());
		SmartDashboard.putNumber("Rear Left Encoder" , RobotMap.rearLeftEncoder.get());
		SmartDashboard.putNumber("Front Right Encoder" , RobotMap.frontRightEncoder.get());
		SmartDashboard.putNumber("Rear Right Encoder" , RobotMap.rearRightEncoder.get());
		
		SmartDashboard.putNumber("Front Left Ultrasonic" , RobotMap.frontLeftUS.getValue());
		SmartDashboard.putNumber("Rear Left Ultrasonic" , RobotMap.rearLeftUS.getValue());
		SmartDashboard.putNumber("Front Right Ultrasonic" , RobotMap.frontRightUS.getValue());
		SmartDashboard.putNumber("Rear Right Ultrasonic" , RobotMap.rearRightUS.getValue());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}
	protected void interrupted() {}
}
