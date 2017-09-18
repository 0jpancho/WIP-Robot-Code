package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Joseph on 9/12/2017.
 */
@Autonomous(name = "OtherTest", group = "Test")
public class OtherTest extends LinearOpMode {

    DcMotor frontLeft;
    DcMotor backLeft;

    DcMotor frontRight;
    DcMotor backRight;

    final double wheelCircumference = Math.PI * 4;
    final double gearRatio = 40 /1;
    final double ppr = 280;

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");


        waitForStart();

        driveDistance(20);
    }

    public void driveDistance(double inches)
    {
        double numRevolutions = inches / wheelCircumference;
        numRevolutions /= gearRatio;

        double encoderCounts = numRevolutions * ppr;

        telemetry.addData("Encoder Counts", encoderCounts);

        frontLeft.setTargetPosition((int)encoderCounts);
        backLeft.setTargetPosition((int)encoderCounts);

        frontRight.setTargetPosition((int)-encoderCounts);
        backRight.setTargetPosition((int)-encoderCounts);
    }
}