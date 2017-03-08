package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotMap {

	// PWM
	public static final int motorFL = 7;
	public static final int motorFR = 6;
	public static final int motorBL = 8;
	public static final int motorBR = 9;
	public static final int winchMotor = 5;
	public static final int servoL = 3;
	public static final int servoR = 4;

	// DIO
	public static final int[] encoderFL = { 0, 1 };
	public static final int[] encoderFR = { 2, 3 };
	public static final int[] encoderBL = { 4, 5 };
	public static final int[] encoderBR = { 6, 7 };

	// ANALOG
	public static final int sonicL = 0;
	public static final int sonicR = 1;
	public static final int gyroPort = 2;

	// PCM
	public static final int gearSolenoidPort = 1;
	public static final int clampSolenoidPort = 1;

	// SENSORS
	public static final Encoder[] encoders = {
			new Encoder(encoderFL[0], encoderFL[1]),	// front left encoder
			new Encoder(encoderFR[0], encoderFR[1]),	// front right encoder
			new Encoder(encoderBL[0], encoderBL[1]),	// rear left encoder
			new Encoder(encoderBR[0], encoderBR[1])		// rear right encoder
	};
	public static final AnalogInput[] ultrasonicSensors = {
			new AnalogInput(sonicL),	// left ultrasonic
			new AnalogInput(sonicR),	// right ultrasonic
	};
	public static final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static final BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();

	// DRIVETRAIN SUBSYSTEM
	public static final SpeedController[] driveMotors = {
			new TalonSRX(motorFL),	// front left motor
			new TalonSRX(motorFR),	// front right motor
			new TalonSRX(motorBL),	// rear left motor
			new TalonSRX(motorBR)	// rear right motor
	};

	// LIFT SUBSYSTEM
	public static final Spark liftMotor = new Spark(winchMotor);
	public static final Solenoid clampSolenoid = new Solenoid(clampSolenoidPort);

	// FLAGS
	public static final Servo[] flagServos = {
			new Servo(servoL),
			new Servo(servoR)
	};
}