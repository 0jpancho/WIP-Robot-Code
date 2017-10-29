package org.firstinspires.ftc.teamcode.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Joseph on 10/27/2017.
 */
@Autonomous(name = "Thingy", group = "Sctuff")
public class BlueTest extends LinearOpMode {

    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.initialize(BlueTest.this, hardwareMap, telemetry);

        waitForStart();

        robot.drive(12, robot.FORWARD);

    }
}
