package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ManipulatorCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ManipulatorSubsystem extends Subsystem {

	private DoubleSolenoid solenoid;
	private boolean isOpen;

	public ManipulatorSubsystem() {
		solenoid = new DoubleSolenoid(RobotMap.solenoidPorts[0], RobotMap.solenoidPorts[1]);
		isOpen = false;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ManipulatorCommand());
	}

	public void open() {
		if (isOpen == false) {
			solenoid.set(DoubleSolenoid.Value.kForward);
			isOpen = true;
		}
	}

	public void close() {
		if (isOpen == true) {
			solenoid.set(DoubleSolenoid.Value.kReverse);
			isOpen = false;
		}
	}

	public boolean isOpen() {
		return isOpen;
	}
}
