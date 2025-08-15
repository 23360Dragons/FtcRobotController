package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Basic Driver", group="Linear OpMode")
public class MyFirstRobot extends LinearOpMode {

    private DcMotor trainerMotor = null;
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "initialization");
        telemetry.update();

       trainerMotor = hardwareMap.get(DcMotor.class, "test");
       trainerMotor.setDirection(DcMotorSimple.Direction.FORWARD);
       

        waitForStart();
        int test = 0;

        while(opModeIsActive()) {
            test = test + 1;
            telemetry.addData("Status", "Executing");
            telemetry.addData("test value: ", test);
            telemetry.update();

            trainerMotor.setPower(.5);
            sleep(1000);
            trainerMotor.setPower(0);
            sleep(1000);

        }

        telemetry.addData("status", "Program Complete");
        telemetry.update();
    }
}
