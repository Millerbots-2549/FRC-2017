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

		SmartDashboard.putNumber("Encoder 0", RobotMap.encoders[0].getDistance());
		SmartDashboard.putNumber("Encoder 1", RobotMap.encoders[1].getDistance());
		SmartDashboard.putNumber("Encoder 2", RobotMap.encoders[2].getDistance());
		SmartDashboard.putNumber("Encoder 3", RobotMap.encoders[3].getDistance());
		
		SmartDashboard.putNumber("Motor 0", RobotMap.driveMotors[0].get());
		SmartDashboard.putNumber("Motor 1", RobotMap.driveMotors[1].get());
		SmartDashboard.putNumber("Motor 2", RobotMap.driveMotors[2].get());
		SmartDashboard.putNumber("Motor 3", RobotMap.driveMotors[3].get());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}

	protected void interrupted() {}
}
