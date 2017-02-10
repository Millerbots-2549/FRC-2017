package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;
import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WinchCommand extends Command {

	public WinchCommand() {
		requires(Robot.winch);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.winch.setMotor(Robot.oi.axisW);
		SmartDashboard.putNumber("Winch Motor", RobotMap.liftMotor.get());

		if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonClampOpen) == true) {
			Robot.winch.openClamp();
			SmartDashboard.putBoolean("Winch Forward?", Robot.winch.isForward());
		} else if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonClampClose) == true) {
			Robot.winch.closeClamp();
			SmartDashboard.putBoolean("Winch Forward?", Robot.winch.isForward());
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
