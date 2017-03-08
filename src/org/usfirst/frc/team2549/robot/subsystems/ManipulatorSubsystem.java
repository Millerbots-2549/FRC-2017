package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ManipulatorCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorSubsystem extends Subsystem {

	private boolean isOpen;
	private int pos0 = 0;
	private int pos1 = 0;

	public ManipulatorSubsystem() {
		isOpen = false;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ManipulatorCommand());
	}

	public void open() {
		//RobotMap.gearSolenoid.set(true);
		RobotMap.flagServos[0].set(pos1);
		RobotMap.flagServos[1].set(pos1);
		isOpen = true;
	}

	public void close() {
		//RobotMap.gearSolenoid.set(false);
		RobotMap.flagServos[0].set(pos0);
		RobotMap.flagServos[1].set(pos0);
		isOpen = false;
	}

	public boolean isOpen() {
		return isOpen;
	}//*/
}
