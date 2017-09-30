package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

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
    }

    @Override
    public void loop() {
        leftY = gamepad1.left_stick_y;            //joystick values range from -1 to 1
        rightY = gamepad1.right_stick_y;

        robot.leftDrive.setPower(leftY);
        robot.rightDrive.setPower(rightY);
    }
}
