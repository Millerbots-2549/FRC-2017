package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	// PORTS
	public int axisX = 0;
	public int axisY = 1;
	public int axisR = 2;
	public int axisW = 3;

	public int clampOpen = 5;
	public int clampClose = 3;

	public int winchForward = 6;
	public int winchReverse = 4;

	public int portMain = 0;

	// OBJECTS
	public Joystick ctrlMain = new Joystick(portMain);

	public Button buttonClampOpen = new JoystickButton(ctrlMain, clampOpen);
	public Button buttonClampClose = new JoystickButton(ctrlMain, clampClose);
	public Button buttonWinchForward = new JoystickButton(ctrlMain, winchForward);
	public Button buttonWinchReverse = new JoystickButton(ctrlMain, winchReverse);
}