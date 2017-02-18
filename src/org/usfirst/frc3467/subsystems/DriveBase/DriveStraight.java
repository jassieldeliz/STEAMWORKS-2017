package org.usfirst.frc3467.subsystems.DriveBase;

import org.usfirst.frc3467.robot.CommandBase;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Drive the given distance straight (negative values go backwards).
 * Uses a local PID controller to run a simple PID loop that is only
 * enabled while this command is running. The input is the averaged
 * values of the left and right encoders.
 */
public class DriveStraight extends CommandBase {

	private static final double TOLERANCE = 50;
	
	private PIDController m_pid;
	private double m_maxSpeed = 0.6;
	private double m_distance = 0.0;
	private boolean m_manualCurve = false;
	private double m_curveValue = 0.0;
	private double m_pastDistance = 0.0;
	private int m_count = 0;
	
	private double KP = 2.0;
	private double KI = 0.0;
	private double KD = 1.0;
	
    public DriveStraight(double distance, double maxSpeed, double kp, double ki, double kd) {
        
    	requires(driveBase);
    	KP = kp; KI = ki; KD = kd;
    	m_maxSpeed = maxSpeed;
    	m_distance = distance;
    	buildController();
    }

    public DriveStraight(double distance, double maxSpeed) {
    
    	requires(driveBase);
    	m_maxSpeed = maxSpeed;
    	m_distance = distance;
    	buildController();
    	;
    }
	
	public DriveStraight(double distance) {
    	requires(driveBase);
    	m_distance = distance;
    	buildController();
	}
	
	public DriveStraight(double distance, boolean curve, double curveValue) {
		requires(driveBase);
		
		m_distance = distance;
		m_manualCurve = curve;
		m_curveValue = curveValue;
		
		buildController();
	}
	
	public DriveStraight(double distance, double maxSpeed, double timeOut) {
		requires(driveBase);
		m_distance = distance;
		m_maxSpeed = maxSpeed;
		
		setTimeout(timeOut);
	}
	
	private void buildController() {
		
		m_pid = new PIDController(KP, KI, KD,
                new PIDSource() {
                    PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

                    public double pidGet() {
                        return driveBase.getDistance();
                    }

                    public void setPIDSourceType(PIDSourceType pidSource) {
                      m_sourceType = pidSource;
                    }

                    public PIDSourceType getPIDSourceType() {
                        return m_sourceType;
                    }
                },
                new PIDOutput() {
                	
                	public void pidWrite(double d) {
                		// Drive with the magnitude returned by the PID calculation, 
                		// and curve the opposite way from the current yaw reading
                		// (Divide yaw by 180 so as to normalize to -1.0 / + 1.0)
                		//driveBase.drive(-d, -(ahrs.getGyroYaw()/240.));
                		setCurve(-d);
                }});
		
        m_pid.setAbsoluteTolerance(TOLERANCE);
        m_pid.setOutputRange((m_maxSpeed * -1.0), m_maxSpeed);
        m_pid.setSetpoint(m_distance);
    }

	//If the robot has hit a wall, SAY SOMETHING!
	public boolean hasStalled() {
		if (driveBase.getDistance() - m_pastDistance <= 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setCurve(double d) {
		if (m_manualCurve) {
			driveBase.drive(d, m_curveValue);
		}
			else  {
				driveBase.drive(d, -(gyro.getAngle()/240.));
				}
		}
	
	
    // Called just before this Command runs the first time
    protected void initialize() {
    	// Get everything in a safe starting state.
        driveBase.resetEncoders();
       // gyro.gyroReset();
    	m_pid.reset();
        m_pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveBase.reportEncoders();
    	
    	if (hasStalled()) {
    		m_count++;
    	}
    	
    	m_pastDistance = driveBase.getDistance();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double error = m_pid.getError();
    	
    	if (m_count >= 50) {
    		return true;
    	}
    	else {
    		return (error >= 0 && error <= TOLERANCE);
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop PID and the wheels
    	m_pid.disable();
        driveBase.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}

