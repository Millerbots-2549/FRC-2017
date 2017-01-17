package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {
	private RobotDrive drive;

	public Talon motorLF;
	public Talon motorLB;
	public Talon motorRF;
	public Talon motorRB;

	public DrivetrainSubsystem() {
		drive = new RobotDrive(RobotMap.motorLF, RobotMap.motorLB, RobotMap.motorRF, RobotMap.motorRB);

		motorLF = new Talon(RobotMap.motorLF);
		motorLB = new Talon(RobotMap.motorLB);
		motorRF = new Talon(RobotMap.motorRF);
		motorRB = new Talon(RobotMap.motorRB);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}

	public void driveMecanum(double x, double y, double rotation) {
		drive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}

	public void driveMecanum(double x, double y, double rotation, double gyroAngle) {
		drive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}

	public void setMotor(Talon motor, int value) {
		motor.set(value);
	}
}
