package org.usfirst.frc3467.subsystems.Hopper;

import org.usfirst.frc3467.robot.CommandBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class hopperActuate extends CommandBase{
	
	private Value INandOut;
	
	public hopperActuate(Value actuate){
		requires(hopper);
		INandOut = actuate;
		setTimeout(1.0);
	}
	public hopperActuate(){
		requires(hopper);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
	hopper.setHopper(INandOut);	
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		hopper.setHopper(Value.kOff);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	
}
