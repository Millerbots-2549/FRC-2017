package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.Talon;

public class RobotMap {
	public static int motorLF = 0;
	public static int motorLB = 1;
	public static int motorRF = 2;
	public static int motorRB = 3;

	public static final Talon talonLF = new Talon(motorLF);
	public static final Talon talonLB = new Talon(motorLB);
	public static final Talon talonRF = new Talon(motorRF);
	public static final Talon talonRB = new Talon(motorRB);
}
