package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveCommand extends Command {
	
	private int distance, angle;
	private double speed;

    public AutoDriveCommand(int distance, int angle, double speed) {
        requires(Robot.drivetrainSubsystem);
        this.distance = distance;
        this.angle = angle;
        this.speed = speed;
    }

    protected void initialize() {
    	Robot.drivetrainSubsystem.resetDistance();
    }

    protected void execute() {
    	while(Robot.drivetrainSubsystem.getAverageDistance() <= distance) {
    		Robot.drivetrainSubsystem.driveMecanum(speed, 0, 0);
    	}
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
