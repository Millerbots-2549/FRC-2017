package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

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

		for (int i = 0; i < 4; i++) {
			SmartDashboard.putNumber("Motor " + i, Robot.drivetrainSubsystem.getMotor(i));
			SmartDashboard.putNumber("Encoder " + i, Robot.drivetrainSubsystem.getEncoder(i));
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}
	protected void interrupted() {}
}
