package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Joseph Pancho on 10/18/2017.
 */
@TeleOp(name = "Thingy", group = "Sctuff")
public class TeleopMain extends OpMode {

    DcMotor frontLeft, frontRight, backLeft, backRight, lift;
    Servo liftLeft, liftRight;

    double x;
    double y;

    public void init() {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        lift = hardwareMap.dcMotor.get("lift");
        liftLeft = hardwareMap.servo.get("liftLeft");
        liftRight = hardwareMap.servo.get("liftRight");
    }

    public void loop() {
        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;

        telemetry.addData("right", frontRight.getPower());
        telemetry.addData("left", frontLeft.getPower());
        telemetry.addData("Are we actually running", "Yes");

        /*forward*/
        if (gamepad1.left_stick_y < -0.25) {
            frontLeft.setPower(-y);
            frontRight.setPower(y);
            backLeft.setPower(-y);
            backRight.setPower(y);
            telemetry.addData("Thing", 1);
        }

        /*backward*/
        else if (gamepad1.left_stick_y > 0.25) {
            frontLeft.setPower(-y);
            frontRight.setPower(y);
            backLeft.setPower(-y);
            backRight.setPower(y);
            telemetry.addData("Thing", 2);
        }

        /*right*/
        else if (gamepad1.left_stick_x > 0.25) {
            frontLeft.setPower(x);
            frontRight.setPower(x);
            backLeft.setPower(-x);
            backRight.setPower(-x);
            telemetry.addData("Thing", 3);
        }

        /*left*/
        else if (gamepad1.left_stick_x < -0.25) {
            frontLeft.setPower(2*x);
            frontRight.setPower(2*x);
            backLeft.setPower(2*-x);
            backRight.setPower(2*-x);
            telemetry.addData("Thing", 4);
        }

        else if (gamepad1.b) {
            frontLeft.setPower(1);
            frontRight.setPower(1);
            backLeft.setPower(1);
            backRight.setPower(1);
            telemetry.addData("Thing", 200);
        }

        else if (gamepad1.x)
        {
            frontLeft.setPower(-1);
            frontRight.setPower(-1);
            backLeft.setPower(-1);
            backRight.setPower(-1);
            telemetry.addData("Thing", 100);
        }

        else if (gamepad1.left_stick_y < 0.25 && gamepad1.left_stick_y > -0.25 &&
                gamepad1.left_stick_x < 0.25 && gamepad1.left_stick_x > -0.25) {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
            telemetry.addData("Thing", 10);
    }

    lift.setPower(gamepad2.right_stick_y);
}}
