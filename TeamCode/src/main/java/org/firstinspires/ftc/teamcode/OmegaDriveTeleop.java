package org.firstinspires.ftc.teamcode;


import java.util.*;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="OmegaDriveTeleop", group="Testers")
//@Disabled

public class OmegaDriveTeleop extends OpMode
{

    DcMotor leftDrive;        //before using a variable you have to declare it
    DcMotor rightDrive;

    public float leftY;        //float is a data type for decimals
    public float rightY;

    @Override
    public void init()
    {
        leftDrive = hardwareMap.dcMotor.get("left_drive");        //called left_drive in the config file
        leftDrive.setDirection(DcMotor.Direction.REVERSE);        //variables should be initialized in init()
        rightDrive = hardwareMap.dcMotor.get("right_drive");
    }

    @Override
    public void loop()
    {
        leftY = gamepad1.left_stick_y;            //joystick values range from -1 to 1
        rightY = gamepad1.right_stick_y;

        leftDrive.setPower(leftY);
        rightDrive.setPower(rightY);
    }
}
class CommandDependencies
{
    //Command type allows the Command class to determine what action it does
    enum commandType
    {
        MOVE,
        STOP
    }
}
//The command class defines possible robot movements
class Command
{

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
    RobotDependencies.state currstate;
    //x and y correspond to positions on the tile array.
    int x;
    int y;
}
class Tile
{
    //A tile will not alter its own state
    TileDependencies.state currstate;
  //Values contained within a 1x1 square unit area
}
//Progmatic representation of actual map
class Map
{
    ArrayList<ArrayList<Tile>> tileVals = new ArrayList<ArrayList<Tile>> ();
}