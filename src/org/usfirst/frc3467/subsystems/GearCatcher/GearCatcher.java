package org.usfirst.frc3467.subsystems.GearCatcher;

import org.usfirst.frc3467.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearCatcher extends Subsystem {

	public DoubleSolenoid wrist = new DoubleSolenoid(RobotMap.claw_extend,RobotMap.claw_retract);
	public DoubleSolenoid grabber = new DoubleSolenoid(RobotMap.claw_grab,RobotMap.claw_release);
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void wristRetract() {
    	wrist.set(DoubleSolenoid.Value.kReverse);
    }
    public void wristExtend() {
    	wrist.set(DoubleSolenoid.Value.kForward);
    }
    public void grabberGrab() {
    	grabber.set(DoubleSolenoid.Value.kForward);
    }
    public void grabberRelease() {
    	grabber.set(DoubleSolenoid.Value.kReverse);
    }
    public void grabberHold() {
    	grabber.set(DoubleSolenoid.Value.kOff);
    }
}

