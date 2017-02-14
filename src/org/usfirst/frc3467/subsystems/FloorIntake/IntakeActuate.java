package org.usfirst.frc3467.subsystems.FloorIntake;

import org.usfirst.frc3467.robot.CommandBase;

public class IntakeActuate extends CommandBase{
	
	private boolean extend;
	
	public IntakeActuate(boolean Extend){
		requires(flr_intake);
		extend = Extend;
		setTimeout(0.5);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(extend){
			flr_intake.extend();
		}
		else{
			flr_intake.retract();
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
