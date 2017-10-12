package org.usfirst.frc.team101.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team101.robot.RobotMap;
import org.usfirst.frc.team101.robot.triggers.*;

public class Drive extends PIDSubsystem{
	Talon motorLeft = RobotMap.motorLeft;
	Talon motorRight = RobotMap.motorRight;
	
	private static Drive drive = new Drive(0, 0, 0);
	
	ADXRS450_Gyro gyro = RobotMap.gyro;

	private Drive(double p, double i, double d) {
		super("Turn Angle", p, i, d);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous();
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double returnPIDInput() {
		return gyro.getAngle();
		// TODO Auto-generated method stub         
	
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public static void drive()
	{	
		RobotMap.motorLeft.set(RobotMap.driveOne.getY());
		RobotMap.motorRight.set(RobotMap.driveTwo.getY());
	}
	
	public static Drive getInstance()
	{
		return drive;
	}
	

}
