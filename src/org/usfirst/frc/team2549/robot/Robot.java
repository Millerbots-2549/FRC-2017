package org.usfirst.frc.team2549.robot;

import org.usfirst.frc.team2549.robot.commands.AutoCommand;
import org.usfirst.frc.team2549.robot.commands.AutoTestCommand;
import org.usfirst.frc.team2549.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team2549.robot.subsystems.ManipulatorSubsystem;
import org.usfirst.frc.team2549.robot.subsystems.WinchSubsystem;
import org.usfirst.frc.team2549.robot.subsystems.SensorSubsystem;
import org.usfirst.frc.team2549.robot.subsystems.CameraSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
	public static final ManipulatorSubsystem manipulator = new ManipulatorSubsystem();
	public static final WinchSubsystem winch = new WinchSubsystem();
	public static final SensorSubsystem sensors = new SensorSubsystem();
	public static final CameraSubsystem cameras = new CameraSubsystem();
	public static OI oi;

	Command autoCommand;
	SendableChooser autoChooser;

	public void robotInit() {
		oi = new OI();
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default Auto", new AutoCommand());
		autoChooser.addObject("Drive into wall", new AutoTestCommand());
		SmartDashboard.putData("Auto Mode", autoChooser);
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {

		String autoSelected = SmartDashboard.getString("Auto Mode", "Default Auto");

		switch(autoSelected) {
		case "Drive into Wall":
			autoCommand = new AutoTestCommand();
		case "Default Auto":
			autoCommand = new AutoCommand();
			break;
		default:
			autoCommand = new AutoCommand();
			break;
		}

		if (autoCommand != null) autoCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autoCommand != null) autoCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
