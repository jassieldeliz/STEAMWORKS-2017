
package org.usfirst.frc3467.subsystems.Gyro;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyro extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getAngle() {
    	return 0;
    }
    
    public void reportGyroValues() {
    	return;
    }
    
    public void gyroReset() {
    	
    }
    
    public double getGyroYaw() {
    	return 0;
    }
}

