package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="MotorTester", group="Testers")
//@Disabled

public class MotorTester extends OpMode {

    OmegaBot robot = new OmegaBot(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    public float leftY;        //float is a data type for decimals

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Initialization", "Complete");
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        leftY = gamepad1.left_stick_y;            //joystick values range from -1 to 1 //changed to boolean dpad to see what'll happen
        robot.leftDrive.setPower(leftY);
    }
}
