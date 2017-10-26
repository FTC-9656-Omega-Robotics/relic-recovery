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
    public Servo leftServo = null;
    public Servo rightServo = null;
    public ColorSensor colorSensor;

    private DcMotor.RunMode initialMode = null;

    HardwareMap map = null;


    public OmegaBot(DcMotor.RunMode enteredMode) {
        initialMode = enteredMode;
    }

    public void init(HardwareMap aMap) {

        map = aMap;

        leftDrive = map.dcMotor.get("left_drive");
        rightDrive = map.dcMotor.get("right_drive");
        leftServo = map.servo.get("left_servo");
        rightServo = map.servo.get("right_servo");
        colorSensor = map.colorSensor.get("color_sensor");

        leftDrive.setMode(initialMode);
        rightDrive.setMode(initialMode);

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        stopRobot();
    }

    public void stopRobot() {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}
