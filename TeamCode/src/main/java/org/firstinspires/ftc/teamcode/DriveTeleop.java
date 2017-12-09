package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DriveTeleop", group = "Testers")
//@Disabled

public class DriveTeleop extends OpMode {

    OmegaBot robot = new OmegaBot(DcMotor.RunMode.RUN_USING_ENCODER);

    public float leftY;        //float is a data type for decimals
    public float rightY;
    public int position;

    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Initialization", "Complete");
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

        robot.leftDrive.setPower(leftY);
        robot.rightDrive.setPower(rightY);


        if (gamepad2.a) {
            robot.arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.arm.setPower(0.25);
            position = robot.arm.getCurrentPosition();
        } else if (gamepad2.b) {
            robot.arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.arm.setPower(-0.25);
            position = robot.arm.getCurrentPosition();
        } else {
            robot.arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.arm.setTargetPosition(position);
            robot.arm.setPower(0.5);
        }
        telemetry.addData("Encoder Position", position);

        if (gamepad2.x) {
            robot.rightServo.setPosition(robot.rightServoOpenPos);
        } else if (gamepad2.y) {
            robot.rightServo.setPosition(robot.rightServoClosePos);
        }

        if (gamepad2.left_bumper) {                //works do not change
            robot.colorServo.setPosition(robot.colorServoClosePos);
        } else if (gamepad2.right_bumper) {
            robot.colorServo.setPosition(robot.colorServoOpenPos);
        }

    }
}