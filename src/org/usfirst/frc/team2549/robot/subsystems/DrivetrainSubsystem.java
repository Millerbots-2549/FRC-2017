package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.DriveCommand;
import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

public class DrivetrainSubsystem extends Subsystem {

	private RobotDrive drive;

	public DrivetrainSubsystem() {
		drive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.rearLeftMotor, RobotMap.frontRightMotor, RobotMap.rearRightMotor);
		RobotMap.frontRightMotor.setInverted(true);
		RobotMap.rearRightMotor.setInverted(true);
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
		RobotMap.frontLeftEncoder.reset();
		RobotMap.frontRightEncoder.reset();
		RobotMap.rearLeftEncoder.reset();
		RobotMap.rearRightEncoder.reset();
	}
	
	public int getAverageDistance() {
		return (RobotMap.frontLeftEncoder.get() +
				RobotMap.frontRightEncoder.get() +
				RobotMap.rearLeftEncoder.get() + 
				RobotMap.rearRightEncoder.get()) / 4;
	}
}