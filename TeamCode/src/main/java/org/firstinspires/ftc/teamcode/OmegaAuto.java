// package com.qualcomm.ftcrobotcontroller.opmodes; //ignore the red yo
package org.firstinspires.ftc.teamcode; //revert to top if needed

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "OmegaAuto", group = "Edwardian Relic Recovery")
//@Disable
public class OmegaAuto extends LinearOpMode {


    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor pickUp;
    private DcMotor roll;
    private DcMotor fling;

    public int loadPos;
    public boolean isShooting = false;

    private ElapsedTime     runtime = new ElapsedTime();



    @Override
    public void runOpMode() {

        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        pickUp = hardwareMap.dcMotor.get("pickUp");
        roll = hardwareMap.dcMotor.get("roll");

        fling = hardwareMap.dcMotor.get("catapult");
        fling.setDirection(DcMotor.Direction.FORWARD);
        fling.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        loadPos = fling.getCurrentPosition();
        telemetry.addData("Load Position", loadPos);


        waitForStart();

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.5)) {
            leftDrive.setPower(1);
            rightDrive.setPower(1);
            roll.setPower(-1);
            pickUp.setPower(1);
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);

        runtime.reset();
        if (opModeIsActive() && (runtime.seconds() < 2) && (!isShooting)) {
            fling.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fling.setTargetPosition(loadPos + 1440);
            fling.setPower(0.05);
            isShooting = true;
        }
        if (isShooting) {
            fling.setPower(0);
        }

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) { //5-8 seconds
            leftDrive.setPower(1);
            rightDrive.setPower(1);
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}


package org.firstinspires.ftc.teamcode;


import java.util.*;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
public class OmegaAuto extends OpMode
{
    Robot currrob;
    AutomatedCommandRunner autocom;
    @Override
    public void init()
    {
        currrob = new Robot(0, 0);
        autocom = new AutomatedCommandRunner();
        autocom.addCommand(new MoveForwardCommand(1));
    }
    @Override
    public void loop()
    {

    }
}

/**
 *
 *
 */
class CommandDependencies
{
    //Command type allows the Command class to determine what action it does
    public static enum commandType
    {
        MOVE,
        STOP
    }
}
//This class manages command running
class AutomatedCommandRunner
{
    ArrayList<org.firstinspires.ftc.teamcode.Command> commands;
    public void addCommand(Command comm)
    {
        commands.add(comm);
    }
    public void clearCommands()
    {
        commands.clear();
    }
    public void runCommandGroup(Robot rob)
    {
        for (Command tempCom : commands)
        {
            tempCom.operate(rob);
        }
    }
}
//The command class defines possible robot movements
abstract class Command
{
    public abstract void operate(Robot rob);
}
class MoveForwardCommand extends Command
{
    int powerOfMove;
    public MoveForwardCommand(int powerOfMoveC)
    {
        powerOfMove = powerOfMoveC;
    }
    public void operate(Robot rob)
    {
        rob.rightDrive.setPower(powerOfMove);
        rob.leftDrive.setPower(powerOfMove);
    }
}
class RobotDependencies
{
    ArrayList<Command> instructions;
    static enum state
    {
        IDLE,
        MOVING,
    }
}
class TileDependencies
{
    public static enum state
    {
        PASSABLE,
    }
}
class Robot
{
    //A Robot's state is determined by external sensors.
    org.firstinspires.ftc.teamcode.RobotDependencies.state currstate;
    //x and y correspond to positions on the tile array.
    int x;
    int y;
    DcMotor leftDrive;
    DcMotor rightDrive;
    public Robot(int xC, int yC)
    {
        this.x = xC;
        this.y = yC;
        leftDrive = hardwareMap.dcMotor.get("left_drive");        //called left_drive in the config file
        leftDrive.setDirection(DcMotor.Direction.REVERSE);        //variables should be initialized in init()
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
    }
}
class Tile
{
    //A tile will not alter its own state
    org.firstinspires.ftc.teamcode.TileDependencies.state currstate;
    //Values contained within a 1x1 square unit area
}
//Progmatic representation of actual map
class Map
{
    ArrayList<ArrayList<Tile>> tileVals = new ArrayList<ArrayList<Tile>> ();
}