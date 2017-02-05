package org.usfirst.frc3467.subsystems.DriveBase;

import org.usfirst.frc3467.robot.CommandBase;

public class RobotCentricDrive extends CommandBase {
	
	public RobotCentricDrive() {
		requires(driveBase);
		this.setInterruptible(true);
	}
	
	protected void initialize() {
	}

	protected void execute() {
		driveBase.driveRobotCentric(oi.getPrimeY(), oi.getPrimeX(), oi.getPrimeTwist());
		
		gyro.reportGyroValues();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
