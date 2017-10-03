package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by tvt on 9/30/17.
 *
 * will probably replace this file with Concept files later
 */

@Autonomous(name = "VuforiaAuto", group = "Autonomous")
@Disabled

public class VuforiaAuto extends LinearOpMode {


    VuforiaLocalizer vuforiaLocalizer;
    VuforiaLocalizer.Parameters parameters;
    VuforiaTrackables visionTargets;
    VuforiaTrackable target;
    VuforiaTrackableDefaultListener listener;

    OpenGLMatrix lastKnownLocation;
    OpenGLMatrix phoneLocation;

    public static final String VUFORIA_KEY = "AeHamGv/////AAAAGatue6x+UUqYmC4ZizIMOwlXQu9PiPCBg2U3pp6MRrszfP50zMPbjRxk24a+ZLIjCf6zV/ar8vjlTqP6ypUex9UJbdzvrYhG2QYt6vsxuuNH3j5n5+1ZDBu4ghKZuowze1jHmQnBwSW1C4MKrBzjydRwTMoVx5V+QWqtd4IGvYi5yO1iavXEUpuD0TL+6mX98OJXQecDVW2WRKmqCSrSEuy2Oeo+gwdb+zMD9QdzrlIIuew7vdoI1Hj3gJV+28lt7zvoU6YLb7rGcE03ar8MtaJGYy5LLjlDFXEBArKV+GCwJDXP923zCRQAzxaLd+e31/Qa+pRQgS5h+qthuUakWjabaqH9WWfXB18Jc0XmQgmI";


    public void runOpMode() throws InterruptedException {

        waitForStart();

        while(opModeIsActive()) {



            telemetry.update();
            idle();
        }

    }

    public void setupVuforia() {
        parameters = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK; //We will use the back camera of the phone.
        vuforiaLocalizer = ClassFactory.createVuforiaLocalizer(parameters);

        visionTargets = vuforiaLocalizer.loadTrackablesFromAsset("FTC_2017-18");
    }
}
