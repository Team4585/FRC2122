package frc.robot.biblioteca.basesubsystem;

import frc.robot.RobotConstants;
import frc.robot.biblioteca.HuskyPigeon;
import frc.robot.biblioteca.HuskyVector2D;
import frc.robot.biblioteca.MotorController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveWheelSpeeds;
import java.lang.Math;

public class MecanumDrive extends Drive {
    private MotorController m_frontLeft;
    private MotorController m_frontRight;
    private MotorController m_backLeft;
    private MotorController m_backRight;
    private double m_distanceX;
    private double m_distanceY;
    private double m_rotDistance;
    private MecanumDriveKinematics m_kinematics;
    protected MecanumDriveOdometry m_odometry;
    public MecanumDrive(MotorController frontLeft, MotorController frontRight, MotorController backLeft, MotorController backRight, double wheelDistX, double wheelDistY, double rotDist){
        super();
        m_positional = true;
        m_frontLeft = frontLeft; 
        m_frontRight = frontRight;
        m_backLeft = backLeft;
        m_backRight = backRight;
        m_distanceX = wheelDistX; //How far are the wheels from the center? (The center meaning the average location of all 4 wheels.)
        m_distanceY = wheelDistY;
        m_rotDistance = rotDist; //How far does the wheel travel in one pulse? Meters
        Translation2d m_frontLeftLocation = new Translation2d(m_distanceX, m_distanceY);
        Translation2d m_frontRightLocation = new Translation2d(m_distanceX, -m_distanceY);
        Translation2d m_backLeftLocation = new Translation2d(-m_distanceX, m_distanceY);
        Translation2d m_backRightLocation = new Translation2d(-m_distanceX, -m_distanceY);
        m_kinematics = new MecanumDriveKinematics(m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation);
        m_heading = 0;
        m_odometry = new MecanumDriveOdometry(m_kinematics, new Rotation2d(0.25*Math.PI + Math.toRadians(m_heading)));
        m_backLeft.setInverted(true);
        m_backRight.setInverted(true);
    }
    public MecanumDrive(MotorController frontLeft, MotorController frontRight, MotorController backLeft, MotorController backRight){
        super();
        m_positional = false;
        m_frontLeft = frontLeft;
        m_frontRight = frontRight;
        m_backLeft = backLeft;
        m_backRight = backRight;
        m_backLeft.setInverted(true);
        m_backRight.setInverted(true);
    }
    /*public double getX(){
        return m_robotPose.getTranslation().getX();
    }
    public double getY(){
        return m_robotPose.getTranslation().getY();
    }*/
    public void doActions(){
        HuskyVector2D input = new HuskyVector2D(m_forward, m_strafe);
        input.rotate(0);//-m_gyro.getHeadingBasic());
        m_frontLeft.set(Math.min(Math.max(input.getX() + input.getY() + m_twist, -1), 1));// * m_throttle);
        m_frontRight.set(Math.min(Math.max(-input.getX() + input.getY() + m_twist, -1), 1));// * m_throttle);
        m_backLeft.set(Math.min(Math.max(-input.getX() + input.getY() - m_twist, -1), 1));// * m_throttle);
        m_backRight.set(Math.min(Math.max(input.getX() + input.getY() - m_twist, -1), 1));// * m_throttle);
    }
    private double getSpeed(boolean isLeft, boolean isLeftGrain){
        double totalSpeed = m_forward;
        if(isLeft){
            totalSpeed -= m_twist;
        }else{
            totalSpeed += m_twist;
        }
        if(isLeftGrain){
            totalSpeed -= m_strafe;
        }else{
            totalSpeed += m_strafe;
        }
        return totalSpeed;
    }
    public void gatherInfo() {
        Pose2d m_RobotPose = m_odometry.update(
            new Rotation2d(Math.toRadians(m_heading)), 
            new MecanumDriveWheelSpeeds(
            (m_frontLeft.getRealSpeed() * m_rotDistance),// / 4096, 
            (m_frontRight.getRealSpeed() * m_rotDistance),// / 4096,
            (m_backLeft.getRealSpeed() * m_rotDistance),// / 4096,
            (m_backRight.getRealSpeed() * m_rotDistance)));// / 4096));
        m_loc = new HuskyVector2D(m_RobotPose.getTranslation().getY()/15.0, -m_RobotPose.getTranslation().getX()/15.0);
    }
}