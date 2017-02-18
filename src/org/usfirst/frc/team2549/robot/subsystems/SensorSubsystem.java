package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class SensorSubsystem extends Subsystem {

	public void initDefaultCommand() {
	}

	public void resetEncoders() {
		for (int i = 0; i < 4; i++) {
			RobotMap.encoders[i].reset();
		}
	}

	public double getEncoder(int port) {
		if (port == 1 || port == 3)
			return -RobotMap.encoders[port].get();
		return RobotMap.encoders[port].get();
	}

	public double getEncoderAverage() {
		return (getEncoder(0) + getEncoder(1) + getEncoder(2) + getEncoder(3)) / 4;
	}

	public double getUltrasonic(int port) {
		return RobotMap.ultrasonicSensors[port].getVoltage();
	}

	public double getUltrasonicAverage() {
		return (getUltrasonic(0) + getUltrasonic(1)) / 4;
	}

	public void resetGyro() {
		RobotMap.gyro.reset();
	}

	public double getGyroAngle() {
		return RobotMap.gyro.getAngle();
	}

	public double getGyroRate() {
		return RobotMap.gyro.getRate();
	}

	public double getAccelerometer() {
		return RobotMap.accelerometer.getX();
	}
}
