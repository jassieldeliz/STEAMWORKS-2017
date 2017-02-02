package org.usfirst.frc3467.subsystems.Pneumatics;

import org.usfirst.frc3467.robot.CommandBase;

public class Compressor_ReportStatus extends CommandBase {

	private int counter;
	
	public Compressor_ReportStatus() {
		requires(pneumatics);
		this.setInterruptible(true);
	}
	
	protected void initialize() {
		counter = 0;
	}

	protected void execute() {
		if (counter < 50) {
			counter++;
		}
		else {
			pneumatics.reportPressure();
			counter = 0;
		}
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
