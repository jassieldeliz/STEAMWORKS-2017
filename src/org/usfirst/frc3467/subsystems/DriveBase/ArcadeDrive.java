package org.usfirst.frc3467.subsystems.DriveBase;

import org.usfirst.frc3467.robot.CommandBase;

public class ArcadeDrive extends CommandBase {
	
	public ArcadeDrive() {
		requires(driveBase);
		this.setInterruptible(true);
	}
	
	protected void initialize() {
	}

	protected void execute() {
		//Applies the driveTank method to the driveBase object
		driveBase.driveArcade(oi.getPrimeY(), oi.getPrimeTwist(), true);
		System.out.println("ArcadeDrive Executing");
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
