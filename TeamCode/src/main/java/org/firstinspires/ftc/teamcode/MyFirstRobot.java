package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Basic Driver", group="Linear OpMode")
public class MyFirstRobot extends LinearOpMode {

    private DcMotor trainerMotor = null;
    private Servo trainerServo = null;
    static final double SERVO_HOME_POSITION = 0.0;
    static final double SERVO_MID_POSITION = 0.5;
    static final double SERVO_END_POSITION = 1.0;
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "initialization");
        telemetry.update();

        //this is the trainer motor we used.
       trainerMotor = hardwareMap.get(DcMotor.class, "test");
       trainerMotor.setDirection(DcMotorSimple.Direction.FORWARD);

       trainerServo = hardwareMap.get(Servo.class, "tservo");
       

        waitForStart();
        int test = 0;

        while(opModeIsActive()) {
            test = test + 1;
            telemetry.addData("Status", "Executing");
            telemetry.addData("test value: ", test);
            telemetry.update();

            //this is a comment

            trainerMotor.setPower(.5);
            sleep(500);
            trainerMotor.setPower(0);
            sleep(500);

            telemetry.addData("Servo", "Moving to Mid");
            telemetry.update();

            trainerServo.setPosition(SERVO_MID_POSITION);
            sleep(2000);

            telemetry.addData("Servo", "Moving to End");
            telemetry.update();
            trainerServo.setPosition(SERVO_END_POSITION);
            sleep(2000);

            telemetry.addData("Servo", "Moving to Home");
            telemetry.update();
            trainerServo.setPosition(SERVO_HOME_POSITION);
            sleep(2000);
        }

        telemetry.addData("status", "Program Complete");
        telemetry.update();
    }
}
