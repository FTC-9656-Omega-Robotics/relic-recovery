package org.firstinspires.ftc.teamcode;

/**
 * Created by tvt on 9/21/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "OmegaMotorAuto", group = "Testers")
@Disabled

public class OmegaMotorAuto extends LinearOpMode {

    private DcMotor leftDrive;

    private int initialPos, finalPos;

    private ElapsedTime     runtime = new ElapsedTime();


    public void runOpMode() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        initialPos = leftDrive.getCurrentPosition();

        waitForStart();

        telemetry.addData("Initial position", initialPos);
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < 1) {
            leftDrive.setPower(1);
        }

        leftDrive.setPower(0);

        finalPos = leftDrive.getCurrentPosition();
        telemetry.addData("Final position", finalPos);

        telemetry.addData("Change in position", finalPos - initialPos);


    }
}
