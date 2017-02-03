package org.usfirst.frc.team2549.robot;

public class RobotMap {

	public static final int[] motorPorts = {
			0,	// front left motor
			1,	// front right motor
			2,	// rear left motor
			3,	// rear right motor
			4	// winch motor
	};
	public static final int[] solenoidPorts = {
			0,	// gear manipulator solenoid 1
			1,	// gear manipulator solenoid 2
			2	// clamp solenoid
	};
	public static final int[] ultrasonicPorts = {
			0,
			1,
			2,
			3
	};
	public static final int[][] encoderPorts = {
			{ 0, 1 }, 	// front left encoder
			{ 2, 3 }, 	// front right encoder
			{ 4, 5 }, 	// rear left encoder
			{ 6, 7 } 	// rear right encoder
	};
}