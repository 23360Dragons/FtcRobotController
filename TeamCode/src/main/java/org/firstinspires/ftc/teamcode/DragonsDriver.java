package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Basic TeleOp", group = "TeleOp")

public class DragonsDriver extends LinearOpMode {
    private DcMotor leftFront=null;
    private DcMotor rightFront=null;
    private DcMotor leftBack=null;
    private DcMotor rightBack=null;
    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class,"rightBack");


        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive())
        {
            telemetry.addData("Test wirelessly", "i updated wirelessly");
            telemetry.update();
           double drive = -gamepad1.left_stick_y;

           double strafe = gamepad1.left_stick_x;
           double turn = gamepad1.right_stick_x;
           double leftFrontPower = drive + strafe + turn;
           double rightFrontPower = drive - strafe - turn;
           double leftBackPower = drive - strafe + turn;
           double rightBackPower = drive + strafe - turn;
           leftFront.setPower(-leftFrontPower);
           rightFront.setPower(rightFrontPower);
           leftBack.setPower(leftBackPower);
           rightBack.setPower(rightBackPower);


           int timer1 = 0;
            if (gamepad1.left_stick_y > 0) {
                timer1 = 100;
                if (gamepad1.left_stick_y > 0) {
                    telemetry.addData("Test Rumble", "I should be Rumbling");
                    telemetry.update();
                    gamepad1.rumble(timer1);
                }
            }
            int timer2 = 0;
            if (gamepad1.left_stick_x > 0) {
                timer2 = 100;
                if (gamepad1.left_stick_x > 0) {
                    telemetry.addData("Test Rumble", "I should be Rumbling");
                    telemetry.update();
                    gamepad1.rumble(timer2);
                }
            }







        }






        leftBack.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }
}
