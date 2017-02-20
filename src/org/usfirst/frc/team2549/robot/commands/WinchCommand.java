package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;
import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WinchCommand extends Command {
	
	private double input;

	public WinchCommand() {
		requires(Robot.winch);
	}

	protected void initialize() {
	}

	protected void execute() {
		input = Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisW);
		
		if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonWinchForward))
			Robot.winch.isForward = true;
		else if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonWinchReverse))
			Robot.winch.isForward = false;
		
		Robot.winch.setMotor(1 - (input + 1) / 2);
		
		SmartDashboard.putNumber("Winch Motor", RobotMap.liftMotor.get());
		SmartDashboard.putNumber("Joystick W Axis", Robot.oi.ctrlMain.getRawAxis(Robot.oi.axisW));
		
//		if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonWinchForward))
//			Robot.winch.setMotor(.8);
//		else if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonWinchReverse))
//			Robot.winch.setMotor(-.5);
//		else if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonWinchStop))
//			Robot.winch.setMotor(0);

		if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonClampOpen))
			Robot.winch.openClamp();
		else if (Robot.oi.ctrlMain.getRawButton(Robot.oi.buttonClampClose))
			Robot.winch.closeClamp();
		
		SmartDashboard.putBoolean("Winch Forward?", Robot.winch.isForward());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
