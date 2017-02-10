package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.DriveCommand;
import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

public class DrivetrainSubsystem extends Subsystem {

	private RobotDrive drive;

	public DrivetrainSubsystem() {
		drive = new RobotDrive(RobotMap.driveMotors[0], RobotMap.driveMotors[2], RobotMap.driveMotors[1],
				RobotMap.driveMotors[3]);
		RobotMap.driveMotors[1].setInverted(true);
		RobotMap.driveMotors[3].setInverted(true);
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
	
	public void drivePolar(double magnitude, double direction, double rotation) {
		drive.mecanumDrive_Polar(magnitude, direction, rotation);
	}
	
	public double getMotor(int port) {
		return RobotMap.driveMotors[port].get();
	}
}