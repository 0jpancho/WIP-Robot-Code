package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import java.util.Locale;
import java.util.Timer;

/**
 * Created by Joseph Pancho on 10/18/2017.
 */

public class Robot {

    public DcMotor frontLeft, frontRight, backLeft, backRight, lift;
    public Servo liftLeft, liftRight;

    public BNO055IMU imu;
    public Orientation angles;

    double currentHeading;

    final double wheelCircumference = Math.PI * 4;
    final double gearRatio = 40/1;
    final double ppr = 280;

    public final int FORWARD = 1;
    public final int BACKWARD = 2;
    public final int LEFT = 3;
    public final int RIGHT = 4;

    public void initialize(LinearOpMode lInput, HardwareMap hardwareMap, Telemetry telemetry) {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        lift = hardwareMap.dcMotor.get("lift");
        liftLeft = hardwareMap.servo.get("liftLeft");
        liftRight = hardwareMap.servo.get("liftRight");

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);


}
    public void resetDriveEncoders() {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public double getAngle(int whichAngle) {
        switch(whichAngle){
            case 1:
                return AngleUnit.DEGREES.normalize(angles.firstAngle);

            case 2:
                return AngleUnit.DEGREES.normalize(angles.secondAngle);

            case 3:
                return AngleUnit.DEGREES.normalize(angles.thirdAngle);

            default:
                return getAngle(1);
        }
    }
    public double getHeading(){
        return getAngle(1);
    }

    public void resetGyro(){
        currentHeading = getAngle(1);
    }

    public void drive(double inches, int direction) {


        double numRevolutions = inches / wheelCircumference;
        numRevolutions /= gearRatio;

        double encoderCounts = numRevolutions * ppr;

        switch(direction){
            case FORWARD:
                frontLeft.setTargetPosition((int)encoderCounts);
                backLeft.setTargetPosition((int)encoderCounts);

                frontRight.setTargetPosition((int)-encoderCounts);
                backRight.setTargetPosition((int)-encoderCounts);

            case BACKWARD:
                frontLeft.setTargetPosition((int)-encoderCounts);
                backLeft.setTargetPosition((int)-encoderCounts);

                frontRight.setTargetPosition((int)encoderCounts);
                backRight.setTargetPosition((int)encoderCounts);

            case LEFT:
                frontLeft.setTargetPosition((int)-encoderCounts);
                backLeft.setTargetPosition((int)encoderCounts);

                frontRight.setTargetPosition((int)-encoderCounts);
                backRight.setTargetPosition((int)encoderCounts);

            case RIGHT:
                frontLeft.setTargetPosition((int)encoderCounts);
                backLeft.setTargetPosition((int)-encoderCounts);

                frontRight.setTargetPosition((int)encoderCounts);
                backRight.setTargetPosition((int)-encoderCounts);
        }
    }
    public void turnAngle(double angle, double power){

        while(getHeading() < angle){
            frontLeft.setPower(-1);
            frontRight.setPower(-1);

            backLeft.setPower(-1);
            backRight.setPower(-1);
        }

        while(getHeading() > angle) {
            frontLeft.setPower(1);
            frontRight.setPower(1);

            backLeft.setPower(1);
            backRight.setPower(1);
        }
    }
}

