package org.firstinspires.ftc.teamcode;

/**
 * Created by tvt on 10/24/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "DriveAutoTest", group = "Testers")
//@Disabled

public class DriveAutoTest extends LinearOpMode {

    OmegaBot robot = new OmegaBot(DcMotor.RunMode.RUN_USING_ENCODER);

    private int initialPos, finalPos;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {


        robot.init(hardwareMap);
        robot.leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        robot.rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        telemetry.addData("Initialization", "Complete");


        waitForStart();
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() <= 1) {
            robot.leftDrive.setPower(1);
            robot.rightDrive.setPower(1);
        }
    }

}
