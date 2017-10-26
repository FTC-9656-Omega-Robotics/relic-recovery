package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DriveTeleop", group = "Testers")
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
        //robot.rightServo.setDirection(Servo.Direction.REVERSE);

    }

    @Override
    public void loop() {
        leftY = gamepad1.left_stick_y;            //joystick values range from -1 to 1
        rightY = gamepad1.right_stick_y;


        if (gamepad2.left_bumper) {
            robot.leftServo.setPosition(1);
        } else if (gamepad2.left_trigger > 0) {
            robot.leftServo.setPosition(0);
        }

        if (gamepad2.right_bumper) {
            robot.rightServo.setPosition(1);
        } else if (gamepad2.right_trigger > 0) {
            robot.rightServo.setPosition(0);
        }

        robot.leftDrive.setPower(leftY);        //set power of driving motors equal to the joystick values
        robot.rightDrive.setPower(rightY);

    }
}
