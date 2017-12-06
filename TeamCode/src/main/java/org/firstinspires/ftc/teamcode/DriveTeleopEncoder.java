package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DriveTeleopEncoder", group = "Testers")
//@Disabled

public class DriveTeleopEncoder extends OpMode {

    OmegaBot robot = new OmegaBot(DcMotor.RunMode.RUN_USING_ENCODER);

    public float leftY;        //float is a data type for decimals
    public float rightY;
    public int position;

    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Initialization", "Complete");

        robot.rightServo.setPosition(0);
        robot.colorServo.setPosition(1);
        //robot.rightServo.setDirection(Servo.Direction.REVERSE);
        robot.leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        position = robot.arm.getCurrentPosition();

    }

    @Override
    public void loop() {
        robot.leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftY = gamepad1.left_stick_y;            //joystick values range from -1 to 1
        rightY = gamepad1.right_stick_y;


        if (gamepad2.right_bumper) {
            robot.rightServo.setPosition(1);
        } else if (gamepad2.left_bumper) {
            robot.rightServo.setPosition(0);
        }

        robot.leftDrive.setPower(.95*leftY);        //set power of driving motors equal to the joystick values
        robot.rightDrive.setPower(rightY);

        telemetry.addData("Encoder Position", position);

        if (gamepad2.a) {
            position = position+1; //1120 ticks = 360 deg IRL
            robot.arm.setTargetPosition(position);
            robot.arm.setPower(.5);
        } else  if (gamepad2.b) {
            position = position-1;
            robot.arm.setTargetPosition(position);
            robot.arm.setPower(-0.5);
        } else {
            robot.arm.setTargetPosition(position);
        }

        if (gamepad2.right_bumper) {
            robot.rightServo.setPosition(1);
        } else if (gamepad2.left_bumper){
            robot.rightServo.setPosition(0);
        }

        if (gamepad2.y) {
            robot.colorServo.setPosition(0.7);
        }
        else if (gamepad2.x){
            robot.colorServo.setPosition(0);
        }

    }
}
