package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;

public class DrivetrainSubsystem extends Subsystem {

	private RobotDrive drive;

	public DrivetrainSubsystem() {
		drive = new RobotDrive(RobotMap.driveMotors[0], RobotMap.driveMotors[2], RobotMap.driveMotors[1], RobotMap.driveMotors[3]);
		RobotMap.driveMotors[1].setInverted(true);
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

	public void resetDistance() {
		for(int i = 0; i < 4; i++) {
			RobotMap.encoders[i].reset();
		}
	}

	public double getEncoder(Encoder encoder) {
		return encoder.getDistance();
	}
}