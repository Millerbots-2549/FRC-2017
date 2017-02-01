package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {

	private RobotDrive drive;

	public SpeedController[] motors;
	
	public DrivetrainSubsystem() {
		for(int i = 0; i < 4; i++) {
			motors[i] = RobotMap.driveMotors[i];
		}
		
		drive = new RobotDrive(motors[0], motors[1], motors[2], motors[3]);
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

	public void setMotor(SpeedController motor, int value) {
		motor.set(value);
	}
}
