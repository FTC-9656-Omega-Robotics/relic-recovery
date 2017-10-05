package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="DriveTeleop", group="Testers")
//@Disabled

public class DriveTeleop extends OpMode {

    OmegaBot robot = new OmegaBot(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    public float leftY;        //float is a data type for decimals
    public float rightY;

    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Initialization", "Complete");

        robot.leftServo.setPosition(0);
        robot.rightServo.setPosition(0);

    }

    @Override
    public void loop() {
        leftY = gamepad1.left_stick_y;            //joystick values range from -1 to 1
        rightY = gamepad1.right_stick_y;

        leftServo.setPosition(leftY);            //makes left motor move through gamepad joystick value
        rightServo.setPosition(rightY);

        if (gamepad2.left_stick_y < 0) {
            robot.leftServo.setPosition(180);
        } else {
            robot.leftServo.setPosition(0);
        }

        if (gamepad2.right_stick_y < 0) {
            robot.rightServo.setPosition(180);
        } else {
            robot.rightServo.setPosition(0);
        }

        robot.leftDrive.setPower(leftY);        //set power of driving motors equal to the joystick values
        robot.rightDrive.setPower(rightY);
    }
}