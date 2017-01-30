package org.usfirst.frc.team2549.robot;

import org.usfirst.frc.team2549.robot.util.MotorController;

public class RobotMap {

	public static final int portMotorLF = 0;
	public static final int portMotorLB = 1;
	public static final int portMotorRF = 2;
	public static final int portMotorRB = 3;
	public static final MotorController motorLF = new MotorController(MotorController.Type.Talon, portMotorLF);
	public static final MotorController motorLB = new MotorController(MotorController.Type.Talon, portMotorLB);
	public static final MotorController motorRF = new MotorController(MotorController.Type.Talon, portMotorRF);
	public static final MotorController motorRB = new MotorController(MotorController.Type.Talon, portMotorRB);

	public static final int portMotorLift = 4;
	public static final MotorController motorLift = new MotorController(MotorController.Type.Talon, portMotorLift);

	public static final int[] portEncLF = { 0, 1 };
	public static final int[] portEncLB = { 2, 3 };
	public static final int[] portEncRF = { 4, 5 };
	public static final int[] portEncRB = { 6, 7 };
}