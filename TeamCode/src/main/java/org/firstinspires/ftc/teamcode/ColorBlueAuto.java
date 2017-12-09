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
    private boolean ourBallIsBackward;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {


        robot.init(hardwareMap);
        telemetry.addData("Initialization", "Complete");


        waitForStart();
        runtime.reset();

        robot.colorServo.setPosition(robot.colorServoOpenPos);
        sleep(3000);
        ourBallIsBackward = robot.colorSensor.blue() > robot.colorSensor.red();
        sleep(1000);                                                //wait 1 second before continuing with code

        telemetry.addData("Team color is behind me", ourBallIsBackward);

        if (ourBallIsBackward) {
            robot.leftDrive.setPower(1);
            robot.rightDrive.setPower(1);
        } else {
            robot.leftDrive.setPower(-1);
            robot.rightDrive.setPower(-1);
        }
        sleep(1000);

        robot.colorServo.setPosition(robot.colorServoClosePos);
        while (opModeIsActive()) {

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
