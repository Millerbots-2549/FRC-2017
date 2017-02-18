package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public int axisX = 0;
	public int axisY = 1;
	public int axisR = 2;
	public int axisW = 3;
	
	public int buttonCameraGear = 6;
	public int buttonCameraWinch = 4;
	
	public int buttonClampOpen = 5;
	public int buttonClampClose = 3;

	public int buttonWinchStop = 10;
	public int buttonWinchForward = 8;
	public int buttonWinchReverse = 12;

	public int portMain = 0;

	public Joystick ctrlMain = new Joystick(portMain);
}