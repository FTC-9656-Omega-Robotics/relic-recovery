package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by tvt on 9/29/17.
 *
 * OmegaBot is mostly mapping / static values.
 * The other files are used to execute the robot (they reference this file).
 */

public class OmegaBot {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor arm = null;

    public Servo leftServo = null;
    public Servo rightServo = null;
    public ColorSensor colorSensor = null;
    public Servo colorServo = null;

    public double rightServoClosePos = 0.5;
    public double rightServoOpenPos = 0.7;
    public double colorServoClosePos = 0.95;
    public double colorServoOpenPos = 0;

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
        leftServo = map.servo.get("left_servo");
        rightServo = map.servo.get("right_servo");
        colorServo = map.servo.get("color_servo");

        colorSensor = map.colorSensor.get("color_sensor");

        colorSensor.enableLed(true);

        leftDrive.setMode(initialMode);
        rightDrive.setMode(initialMode);
        arm.setMode(initialMode);

        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setDirection(DcMotorSimple.Direction.FORWARD);
        colorServo.setDirection(Servo.Direction.REVERSE);
        leftServo.setDirection(Servo.Direction.REVERSE);

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void stopRobot() {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void grab() {                    //button y
        leftServo.setPosition(0.3);
        rightServo.setPosition(0.3);
    }

    public void release() {                 // button x
        leftServo.setPosition(0.45);         //0.5 for left and right definitely work
        rightServo.setPosition(0.5);
    }

    /**
     * Assume 270 deg per -1, 1 power per second
     * @param angle
     * @param direction left or right
     */
    public void turn(double angle, String direction) {
        ElapsedTime myTimer = new ElapsedTime();
        while(myTimer.seconds() * 270 <= angle) {
            if (direction.equals("left")) {
                leftDrive.setPower(-1);
                rightDrive.setPower(1);
            } else if (direction.equals("right")) {
                leftDrive.setPower(1);
                rightDrive.setPower(-1);
            }

        }
        stopRobot();
    }

    /**
     * Assume 47 inches per unit power of 1 per second
     * @param inches amount of inches you want to move
     */
    public void moveForward(double inches) {
        ElapsedTime myTimer = new ElapsedTime();
        while(myTimer.seconds() * 47 <= inches) {
            leftDrive.setPower(1);
            rightDrive.setPower(1);
        }
        stopRobot();
    }
    /**
     * Assume 47 inches per unit power of 1 per second
     * @param inches amount of inches you want to move
     */
    public void moveBackward(double inches) {
        ElapsedTime myTimer = new ElapsedTime();
        while(myTimer.seconds() * 47 <= inches) {
            leftDrive.setPower(-1);
            rightDrive.setPower(-1);
        }
        stopRobot();
    }


/**
 *
 * 0.3, 0.5 works for release definitely
 */


}
