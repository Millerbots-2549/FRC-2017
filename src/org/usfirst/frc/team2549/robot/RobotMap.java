package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RobotMap {

	// PORTS
	public static final int[] motorPorts = { 0, 1, 2, 3, 4 };
	public static final int[] solenoidPorts = { 0, 1, 2 };
	public static final int[] ultrasonicPorts = { 0, 1, 2, 3 };
	public static final int[][] encoderPorts = {
			{ 0, 1 }, 	// front left encoder
			{ 2, 3 }, 	// front right encoder
			{ 4, 5 }, 	// rear left encoder
			{ 6, 7 } 	// rear right encoder
	};

	// SENSORS
	public static final AnalogInput[] ultrasonicSensors = {
			new AnalogInput(ultrasonicPorts[0]),
			new AnalogInput(ultrasonicPorts[1]),
			new AnalogInput(ultrasonicPorts[2]),
			new AnalogInput(ultrasonicPorts[3])
	};
	public static final Encoder[] encoders = {
			new Encoder(encoderPorts[0][0], encoderPorts[0][1]),	// front left encoder
			new Encoder(encoderPorts[1][0], encoderPorts[1][1]),	// front right encoder
			new Encoder(encoderPorts[2][0], encoderPorts[2][1]),	// rear left encoder
			new Encoder(encoderPorts[3][0], encoderPorts[3][1])		// rear right encoder
	};

	// DRIVETRAIN SUBSYSTEM
	public static final SpeedController[] driveMotors = {
			new TalonSRX(motorPorts[0]), 	// front left motor
			new TalonSRX(motorPorts[1]), 	// front right motor
			new TalonSRX(motorPorts[2]), 	// rear left motor
			new TalonSRX(motorPorts[3]) 	// rear right motor
	};

	// GEAR MANIPULATOR SUBSYSTEM
	public static final DoubleSolenoid gearSolenoid = new DoubleSolenoid(solenoidPorts[0], solenoidPorts[1]);

	// LIFT SUBSYSTEM
	public static final SpeedController liftMotor = new Spark(motorPorts[4]);
	public static final Solenoid clampSolenoid = new Solenoid(solenoidPorts[2]);
}