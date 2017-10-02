package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="DriveTeleop", group="Testers")
//@Disabled

public class DriveTeleop extends OpMode {

    DcMotor leftDrive;        //before using a variable you have to declare it
    DcMotor rightDrive;

    public float leftY;        //float is a data type for decimals
    public float rightY;

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");        //called left_drive in the config file
        leftDrive.setDirection(DcMotor.Direction.REVERSE);        //variables should be initialized in init()
        rightDrive = hardwareMap.dcMotor.get("right_drive");
    }

    @Override
    public void loop() {
        leftY = gamepad1.left_stick_y;            //joystick values range from -1 to 1
        rightY = gamepad1.right_stick_y;

        leftDrive.setPower(leftY);
        rightDrive.setPower(rightY);
    }
}
