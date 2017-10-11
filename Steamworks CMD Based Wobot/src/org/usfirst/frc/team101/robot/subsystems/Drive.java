package org.usfirst.frc.team101.robot.subsystems;

import org.usfirst.frc.team101.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub	
	}
	
	public void operatorControl()
	{
		RobotMap.motorLeft.set(RobotMap.driveOne.getY());
		RobotMap.motorRight.set(RobotMap.driveTwo.getY());
	}

}
