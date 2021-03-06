package org.usfirst.frc.team101.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

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
	
	public static Joystick driveOne = new Joystick(0);
	public static Joystick driveTwo = new Joystick(1);
	public static Joystick operator = new Joystick(2);
	
	public static Talon motorLeft = new Talon(0);
	public static Talon motorRight = new Talon(1);
	
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	public static Compressor compressor;
	public static DoubleSolenoid gearThingy;
	public static boolean gearTogglePressed = false;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
