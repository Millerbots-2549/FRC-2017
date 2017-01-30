package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {

	private RobotDrive drive;

	public SpeedController motorLF;
	public SpeedController motorLB;
	public SpeedController motorRF;
	public SpeedController motorRB;

	public DrivetrainSubsystem() {
		drive = new RobotDrive(RobotMap.portMotorLF, RobotMap.portMotorLB, RobotMap.portMotorRF, RobotMap.portMotorRB);

		motorLF = RobotMap.motorLF.getController();
		motorLB = RobotMap.motorLB.getController();
		motorRF = RobotMap.motorRF.getController();
		motorRB = RobotMap.motorRB.getController();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}

	public void driveMecanum(double x, double y, double rotation) {
		drive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}

	public void driveMecanum(double x, double y, double rotation, double gyroAngle) {
		drive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}

	public void setMotor(SpeedController motor, int value) {
		motor.set(value);
	}
}
