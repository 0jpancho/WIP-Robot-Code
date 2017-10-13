package org.usfirst.frc.team101.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearMech extends Subsystem {
	
	DoubleSolenoid gearThingy = new DoubleSolenoid(0,1);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void closeGearMech()
	{
		gearThingy.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void openGearMech()
	{
		gearThingy.set(DoubleSolenoid.Value.kForward);
	}
}
