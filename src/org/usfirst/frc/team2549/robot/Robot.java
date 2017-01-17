package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;
import org.usfirst.frc.team2549.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot
{
	public static final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;

    public void robotInit()
    {
		oi = new OI();
        /*chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);*/
    }
	
    public void disabledInit() {}
	public void disabledPeriodic() { Scheduler.getInstance().run(); }

    public void autonomousInit()
    {
        /*autonomousCommand = (Command) chooser.getSelected();
        
		String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} //*/
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();//*/
    }

    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();   
    }

    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
