package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ManipulatorCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ManipulatorSubsystem extends Subsystem {

	private boolean open = false;
	
    public void initDefaultCommand() {
        setDefaultCommand(new ManipulatorCommand());
    }

    public void open() {
    	if(open = false) {
    		RobotMap.gearSolenoid.set(DoubleSolenoid.Value.kForward);
    		open = true;
    	}
    }

    public void close() {
    	if(open = true) {
    		RobotMap.gearSolenoid.set(DoubleSolenoid.Value.kReverse);
    		open = false;
    	}
    }
    
    public boolean getOpen() {
    	return open;
    }
}

