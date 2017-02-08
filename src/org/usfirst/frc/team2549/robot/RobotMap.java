package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotMap {

	// PWM
	public static final int frontLeftMotorPort = 0;
	public static final int rearLeftMotorPort = 1;
	public static final int frontRightMotorPort = 2;
	public static final int rearRightMotorPort = 3;
	public static final int winchMotorPort = 4;

	// DIO
	public static final int[] frontLeftEncoderPort = { 0, 1 };
	public static final int[] rearLeftEncoderPort = { 2, 3 };
	public static final int[] frontRightEncoderPort = { 4, 5 };
	public static final int[] rearRightEncoderPort = { 6, 7 };

	// Analog
	public static final int frontLeftUSPort = 0;
	public static final int rearLeftUSPort = 1;
	public static final int frontRightUSPort = 2;
	public static final int rearRightUSPort = 3;

	// PCM
	public static final int gearSolenoidPort = 0;
	public static final int winchSolenoidPort = 1;

	// Motors
	public static final TalonSRX frontLeftMotor = new TalonSRX(frontLeftMotorPort);
	public static final TalonSRX rearLeftMotor = new TalonSRX(rearLeftMotorPort);
	public static final TalonSRX frontRightMotor = new TalonSRX(frontRightMotorPort);
	public static final TalonSRX rearRightMotor = new TalonSRX(rearRightMotorPort);
	public static final Spark winchMotor = new Spark(winchMotorPort);

	// Encoders
	public static final Encoder frontLeftEncoder = new Encoder(frontLeftEncoderPort[0], frontLeftEncoderPort[1]);
	public static final Encoder rearLeftEncoder = new Encoder(rearLeftEncoderPort[0], rearLeftEncoderPort[1]);
	public static final Encoder frontRightEncoder = new Encoder(frontRightEncoderPort[0], frontRightEncoderPort[1]);
	public static final Encoder rearRightEncoder = new Encoder(rearRightEncoderPort[0], rearRightEncoderPort[1]);

	// Ultrasonics
	public static final AnalogInput frontLeftUS = new AnalogInput(frontLeftUSPort);
	public static final AnalogInput rearLeftUS = new AnalogInput(rearLeftUSPort);
	public static final AnalogInput frontRightUS = new AnalogInput(frontRightUSPort);
	public static final AnalogInput rearRightUS = new AnalogInput(rearRightUSPort);

	// Solenoids
	public static final Solenoid gearSolenoid = new Solenoid(gearSolenoidPort);
	public static final Solenoid winchSolenoid = new Solenoid(winchSolenoidPort);
}