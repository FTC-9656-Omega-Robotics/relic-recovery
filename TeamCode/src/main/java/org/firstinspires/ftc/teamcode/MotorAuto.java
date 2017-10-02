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

@Autonomous(name = "MotorAuto", group = "Testers")
//@Disabled

public class MotorAuto extends LinearOpMode {

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private Servo leftDriveS;
    private Servo rightDriveS;
    private int initialPos, finalPos;

    private ElapsedTime     runtime = new ElapsedTime();




    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        leftDriveS = hardwareMap.servo.get("left_driveS");
        rightDriveS = hardwareMap.servo.get("left_driveS");
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
            leftDriveS.setPosition(1);
            rightDriveS.setPosition(1);
        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftDriveS.setPosition(0);
        rightDriveS.setPosition(0);
        
        finalPos = leftDrive.getCurrentPosition();
        telemetry.addData("Final position", finalPos);

        telemetry.addData("Change in position", finalPos - initialPos);


    }
}
