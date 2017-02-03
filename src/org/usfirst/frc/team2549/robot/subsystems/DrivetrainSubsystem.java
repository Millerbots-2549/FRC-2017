package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.DriveCommand;
import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;

public class DrivetrainSubsystem extends Subsystem {

	private RobotDrive drive;
	private TalonSRX[] motors;
	private Encoder[] encoders;

	public DrivetrainSubsystem() {
		for (int i = 0; i < 4; i++) {
			motors[i] = new TalonSRX(RobotMap.motorPorts[i]);
			encoders[i] = new Encoder(RobotMap.encoderPorts[i][0], RobotMap.encoderPorts[i][1]);
		}

		drive = new RobotDrive(motors[0], motors[2], motors[1], motors[3]);
		motors[1].setInverted(true);
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
		for (int i = 0; i < 4; i++) {
			encoders[i].reset();
		}
	}

	public double getMotor(int port) {
		return motors[port].get();
	}

	public double getEncoder(int port) {
		return encoders[port].getDistance();
	}
}