package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends Command {

	public DriveCommand() {
		requires(Robot.drivetrainSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.drivetrainSubsystem.driveMecanum(Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisX),
				Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisY), Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisR));

		SmartDashboard.putNumber("Joystick X Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisX));
		SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisY));
		SmartDashboard.putNumber("Joystick Rotation Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisR));

		SmartDashboard.putNumber("Left Front Motor", Robot.drivetrainSubsystem.motors[0].get());
		SmartDashboard.putNumber("Left Back Motor", Robot.drivetrainSubsystem.motors[1].get());
		SmartDashboard.putNumber("Front Front Motor", Robot.drivetrainSubsystem.motors[2].get());
		SmartDashboard.putNumber("Right Back Motor", Robot.drivetrainSubsystem.motors[3].get());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
