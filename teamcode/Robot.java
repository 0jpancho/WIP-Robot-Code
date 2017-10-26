package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Joseph Pancho on 10/18/2017.
 */

public class Robot {

    public DcMotor frontLeft, frontRight, backLeft, backRight, lift;
    public Servo liftLeft, liftRight;

    public void initialize(LinearOpMode lInput, HardwareMap hardwareMap, Telemetry telemetry)
    {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        lift = hardwareMap.dcMotor.get("lift");
        liftLeft = hardwareMap.servo.get("liftLeft");
        liftRight = hardwareMap.servo.get("liftRight");
    }
    public void resetDriveEncoders()
    {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    
}
