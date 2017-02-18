package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ManipulatorCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorSubsystem extends Subsystem {

	private boolean isOpen;

	public ManipulatorSubsystem() {
		isOpen = false;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ManipulatorCommand());
	}

	public void open() {
		//RobotMap.gearSolenoid.set(true);
		isOpen = true;
	}

	public void close() {
		//RobotMap.gearSolenoid.set(false);
		isOpen = false;
	}

	public boolean isOpen() {
		return isOpen;
	}//*/
}
