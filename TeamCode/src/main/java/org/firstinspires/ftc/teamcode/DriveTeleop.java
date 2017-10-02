package org.firstinspires.ftc.teamcode;

/**
 * Created by tvt on 9/21/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/DriveTeleop.java
@TeleOp(name="DriveTeleop", group="Testers")
//@Disabled

public class DriveTeleop extends OpMode {
=======
@Autonomous(name = "MotorAuto", group = "Testers")
//@Disabled

public class MotorAuto extends LinearOpMode {

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private Servo leftServo;
    private Servo rightServo;

    private int initialPos, finalPos;

    private ElapsedTime     runtime = new ElapsedTime();

>>>>>>> bb9f4bc5413b7363f0e60ce4bfa1a519eb0aa236:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/OmegaDriveTeleop.java



    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        leftServo = hardwareMap.servo.get("left_servo");
        rightServo = hardwareMap.servo.get("right_servo");

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        initialPos = leftDrive.getCurrentPosition();


        waitForStart();

        telemetry.addData("Initial position", initialPos);
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < 10) {
            leftDrive.setPower(1);
            rightDrive.setPower(1);
            leftServo.setPosition(1);
            rightServo.setPosition(1);
        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftServo.setPosition(0);
        rightServo.setPosition(0);

        finalPos = leftDrive.getCurrentPosition();
        telemetry.addData("Final position", finalPos);

        telemetry.addData("Change in position", finalPos - initialPos);


    }
}
