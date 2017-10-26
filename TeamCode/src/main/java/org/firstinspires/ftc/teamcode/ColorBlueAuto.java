package org.firstinspires.ftc.teamcode;

/**
 * Created by tvt on 10/24/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "ColorRedAuto", group = "Testers")
//@Disabled

public class ColorBlueAuto extends LinearOpMode {

    OmegaBot robot = new OmegaBot(DcMotor.RunMode.RUN_USING_ENCODER);

    private int initialPos, finalPos;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {


        robot.init(hardwareMap);
        telemetry.addData("Initialization", "Complete");


        waitForStart();

        if (robot.colorSensor.blue() > 20) {
            while (runtime.seconds() < 2) {
                robot.leftDrive.setPower(-1);
                robot.rightDrive.setPower(-1);
            }
        } else {
            while (runtime.seconds() < 2) {
                robot.leftDrive.setPower(1);
                robot.rightDrive.setPower(1);
            }
        }
    }
}
