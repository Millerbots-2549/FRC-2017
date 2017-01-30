package org.usfirst.frc.team2549.robot.util;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.SpeedController;

public class MotorController {

	public static enum Type {
		Talon, TalonSRX
	}

	public Type type;
	public int port;
	private boolean allocated = false;

	public MotorController(MotorController x) {
		this.type = x.type;
		this.port = x.port;
	}

	public MotorController(Type type, int port) {
		this.type = type;
		this.port = port;
	}

	public SpeedController getController() {
		if (allocated) return null;
		allocated = true;

		switch (type) {
		case Talon:
			return new Talon(port);
		case TalonSRX:
			return new TalonSRX(port);
		default:
			return null;
		}
	}
}
