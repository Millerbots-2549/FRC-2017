package org.usfirst.frc.team2549.robot;

import org.usfirst.frc.team2549.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team2549.robot.subsystems.ManipulatorSubsystem;
import org.usfirst.frc.team2549.robot.subsystems.WinchSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class Robot extends IterativeRobot {

	public static final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
	public static final ManipulatorSubsystem manipulatorSubsystem = new ManipulatorSubsystem();
	public static final WinchSubsystem winchSubsystem = new WinchSubsystem();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser autoChooser;

	public void robotInit() {
		oi = new OI();
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
