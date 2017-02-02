package org.usfirst.frc3467.subsystems.PixyCam;

import org.usfirst.frc3467.robot.CommandBase;

public class TargetGoal extends CommandBase {

	private static final boolean debugging = false;
	
	public TargetGoal() {
		requires(pixyCam);
		System.out.println("Targeting Goal");
	}
	
	protected void initialize() {	
	}

	protected void execute() {
		pixyCam.convert();
		pixyCam.publishValues();
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
