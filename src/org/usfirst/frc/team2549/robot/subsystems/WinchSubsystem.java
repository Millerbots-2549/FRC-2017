package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.WinchCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchSubsystem extends Subsystem {

	public boolean forward = true;
	
    public void initDefaultCommand() {
        setDefaultCommand(new WinchCommand());
    }
    
    public void setMotor(double value) {
    	if(forward = true)
    		RobotMap.liftMotor.set(value);
    	else if(forward = false)
    		RobotMap.liftMotor.set(-value);
    }
    
    public void openClamp() {
    	RobotMap.clampSolenoid.set(true);
    }
    
    public void closeClamp() {
    	RobotMap.clampSolenoid.set(false);
    }
}
