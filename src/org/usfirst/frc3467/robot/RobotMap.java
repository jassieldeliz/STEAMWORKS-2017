package org.usfirst.frc3467.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// Pneumatics
	public static final int pneumatics_sensor_port = 1;

	// Drivebase
	
	//CANTalon Ports (best to not start with 1, because that is the number assigned to a CANTalon by default)
	public static final int drivebase_LeftTalon = 2;
	public static final int drivebase_RightTalon = 5;
	public static final int drivebase_CenterTalon = 9;
	
	// Slave CANTalons
	public static final int drivebase_LeftTalon2 = 3;
	public static final int drivebase_LeftTalon3 = 4;
	public static final int drivebase_RightTalon2 = 6;
	public static final int drivebase_RightTalon3 = 7;
	public static final int drivebase_CenterTalon2 = 10;
	
	
}
