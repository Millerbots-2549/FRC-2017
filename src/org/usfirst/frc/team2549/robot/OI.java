package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI
{
	public int axisX = 0;
	public int axisY = 1;
	public int axisR = 2;
	
	public int portMain = 0;
	public int portManipulator = 1;
	
	public Joystick ctrlMain = new Joystick(portMain);
}