package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by tvt on 9/29/17.
 */

public class OmegaBot {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor arm = null;
    public Servo rightServo = null;
    public ColorSensor colorSensor = null;
    public Servo colorServo = null;

    private DcMotor.RunMode initialMode = null;

    HardwareMap map = null;


    public OmegaBot(DcMotor.RunMode enteredMode) {
        initialMode = enteredMode;
    }

    public void init(HardwareMap aMap) {

        map = aMap;

        leftDrive = map.dcMotor.get("left_drive");
        rightDrive = map.dcMotor.get("right_drive");

        arm = map.dcMotor.get("arm");
        rightServo = map.servo.get("right_servo");
        colorServo = map.servo.get("color_servo");

        colorSensor = map.colorSensor.get("color_sensor");

        colorSensor.enableLed(true);

        leftDrive.setMode(initialMode);
        rightDrive.setMode(initialMode);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void stopRobot() {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}
