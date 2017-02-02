package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public int axisX = 0;
	public int axisY = 1;
	public int axisR = 2;
	public int axisW = 3;
	public int buttonGearOpen = 4;
	public int buttonGearClose = 2;
	public int buttonClampOpen = 5;
	public int buttonClampClose = 3;
	public int buttonWinchForward = 7;
	public int buttonWinchReverse = 11;

	public int portMain = 0;

	public Joystick ctrlMain = new Joystick(portMain);
}