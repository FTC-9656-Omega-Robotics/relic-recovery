package org.firstinspires.ftc.teamcode;

/**
 * Created by tvt on 10/24/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "ColorBlueAuto", group = "Testers")
//@Disabled

public class ColorBlueAuto extends LinearOpMode {

    OmegaBot robot = new OmegaBot(DcMotor.RunMode.RUN_USING_ENCODER);

    private boolean ourBallIsBackward;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {


        robot.init(hardwareMap);
        robot.leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);      //autonomous has different directions than teleop; teleop defaults
        robot.rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);     //to the directions passed in OmegaBot
        telemetry.addData("Initialization", "Complete");


        waitForStart();             //Note that code in this file is sequential, unless put in a while loop containing OpModeIsActive()
        runtime.reset();

        robot.colorServo.setPosition(robot.colorServoOpenPos);
        sleep(3000);
        ourBallIsBackward = robot.colorSensor.blue() > robot.colorSensor.red();
        sleep(1000);                                                //wait 1 second before continuing with code

        telemetry.addData("Team color is behind me", ourBallIsBackward);

        /**
         * Drives robot either backward or forward 6 inches
         */
        if (ourBallIsBackward) {
            robot.leftDrive.setPower(1);                                        //Robot moves 60 inches per power unit of 1 per second
            robot.rightDrive.setPower(1);
        } else {
            robot.leftDrive.setPower(-1);
            robot.rightDrive.setPower(-1);
        }
        sleep(100);
        robot.colorServo.setPosition(robot.colorServoClosePos);
        robot.stopRobot();
        sleep(100);

        /**
         * Estimated path to reach parking in safe zone, adjusted on whether robot first moved backward or forward
         * Assume safe zone is left of robot.
         * Robot is supposed to drive 36in forward from its starting pos, turn 90deg left, drive 3in forward.
         * Write reflection or generic classes when distancePerPowerPerTimeUnit is found and if necessary.
         * distancePerPowerPerTimeUnit was last measured to be 60in per power unit of 1 per second, but that wasn't measured
         * for final robot mech design.
         * Rotation speed based on time is still unknown.
         */
        if(ourBallIsBackward) {
            robot.leftDrive.setPower(1);
            robot.rightDrive.setPower(1);
            sleep(700);
        } else {                            //i.e., if the robot initially moved forward
            robot.leftDrive.setPower(1);
            robot.rightDrive.setPower(1);
            sleep(500);
        }
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(1);
        sleep(10);            //assuming it takes 1 second to turn 90 deg
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(1);
        sleep(50);
        robot.stopRobot();

        /**
         * This is just for debugging purposes
         */
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
