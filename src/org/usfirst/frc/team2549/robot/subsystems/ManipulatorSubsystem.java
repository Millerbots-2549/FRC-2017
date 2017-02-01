package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ManipulatorCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorSubsystem extends Subsystem {

    public void initDefaultCommand() {
        setDefaultCommand(new ManipulatorCommand());
    }

    public void setOpen() {
    	//RobotMap.gearSolenoid.set
    }

    public void setClosed() {
    	
    }
}

