package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotMap {

	// PORTS
	public static final int motorFL = 0;
	public static final int motorFR = 1;
	public static final int motorBL = 2;
	public static final int motorBR = 3;
	public static final int winchMotor = 4;

	public static final int sonicFL = 0;
	public static final int sonicFR = 1;
	public static final int sonicBL = 2;
	public static final int sonicBR = 3;

	public static final int[] encoderFL = { 0, 1 };
	public static final int[] encoderFR = { 2, 3 };
	public static final int[] encoderBL = { 4, 5 };
	public static final int[] encoderBR = { 6, 7 };

	public static final int gearSolenoidPort = 0;
	public static final int clampSolenoidPort = 1;

	// SENSORS
	public static final AnalogInput[] ultrasonicSensors = {
			new AnalogInput(sonicFL),	// front left ultrasonic
			new AnalogInput(sonicFR),	// front right ultrasonic
			new AnalogInput(sonicBL),	// rear left ultrasonic
			new AnalogInput(sonicBR) 	// rear right ultrasonic
	};
	public static final Encoder[] encoders = {
			new Encoder(encoderFL[0], encoderFL[1]),	// front left encoder
			new Encoder(encoderFR[0], encoderFR[1]),	// front right encoder
			new Encoder(encoderBL[0], encoderBL[1]),	// rear left encoder
			new Encoder(encoderBR[0], encoderBR[1])		// rear right encoder
	};

	// DRIVETRAIN SUBSYSTEM
	public static final SpeedController[] driveMotors = {
			new TalonSRX(motorFL),	// front left motor
			new TalonSRX(motorFR),	// front right motor
			new TalonSRX(motorBL),	// rear left motor
			new TalonSRX(motorBR)	// rear right motor
	};

	// GEAR MANIPULATOR SUBSYSTEM
	public static final Solenoid gearSolenoid = new Solenoid(gearSolenoidPort);

	// LIFT SUBSYSTEM
	public static final Spark liftMotor = new Spark(winchMotor);
	public static final Solenoid clampSolenoid = new Solenoid(clampSolenoidPort);
}