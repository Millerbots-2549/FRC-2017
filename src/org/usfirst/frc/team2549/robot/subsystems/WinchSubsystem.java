package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.WinchCommand;
import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;

public class WinchSubsystem extends Subsystem {

	private Spark motor;
	private Solenoid solenoid;

	public boolean isForward = true;

	public WinchSubsystem() {
		motor = new Spark(RobotMap.motorPorts[4]);
		solenoid = new Solenoid(RobotMap.solenoidPorts[2]);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new WinchCommand());
	}

	public void setMotor(double value) {
		if (isForward == true)
			motor.set(value);
		else if (isForward == false)
			motor.set(-value);
	}

	public void openClamp() {
		solenoid.set(true);
	}

	public void closeClamp() {
		solenoid.set(false);
	}
}
