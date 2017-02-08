package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.WinchCommand;
import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchSubsystem extends Subsystem {

	public boolean isForward = true;

	public void initDefaultCommand() {
		setDefaultCommand(new WinchCommand());
	}

	public void setMotor(double value) {
		if (isForward == true)
			RobotMap.winchMotor.set(value);
		else if (isForward == false)
			RobotMap.winchMotor.set(-value);
	}

	public void openClamp() {
		RobotMap.winchSolenoid.set(true);
	}

	public void closeClamp() {
		RobotMap.winchSolenoid.set(false);
	}
}

