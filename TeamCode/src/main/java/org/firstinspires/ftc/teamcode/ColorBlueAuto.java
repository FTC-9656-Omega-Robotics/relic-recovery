package org.firstinspires.ftc.teamcode;

/**
 * Created by tvt on 10/24/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "ColorBlueAuto", group = "Testers")
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
        while (opModeIsActive()) {
            if (robot.colorSensor.blue() > robot.colorSensor.red()) {
                while (runtime.seconds() < 2) {
                    robot.leftDrive.setPower(-1);
                    robot.rightDrive.setPower(-1);
                }
            }

            if (robot.colorSensor.blue() > robot.colorSensor.red()) {
                telemetry.addLine("I see blue.");
            } else {
                telemetry.addLine("I don't see blue.");
            }
            telemetry.addData("Blueness", robot.colorSensor.blue());
            telemetry.addData("Redness", robot.colorSensor.red());
            telemetry.update();
        }
    }
}
