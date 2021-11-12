package frc.robot.biblioteca.basesubsystem;

import frc.robot.biblioteca.MotorController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveWheelSpeeds;
import java.lang.Math;
import com.ctre.phoenix.sensors.PigeonIMU;

public class MecanumDrive extends Drive {
    private MotorController m_frontLeft;
    private MotorController m_frontRight;
    private MotorController m_backLeft;
    private MotorController m_backRight;
    private double m_distanceX;
    private double m_distanceY;
    private double m_rotDistance;
    Translation2d m_frontLeftLocationx;
    Translation2d m_frontRightLocation;
    Translation2d m_backLeftLocation;
    Translation2d m_backRightLocation;
    MecanumDriveKinematics m_kinematics;
    MecanumDriveOdometry m_odometry;
    PigeonIMU m_gyro;
    Pose2d m_robotPose;
    boolean positional;
    public MecanumDrive(MotorController frontLeft, MotorController frontRight, MotorController backLeft, MotorController backRight, double wheelDistX, double wheelDistY, double rotDist, int pigeonPort){
        super();
        positional = true;
        m_gyro = new PigeonIMU(pigeonPort);
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
        MecanumDriveKinematics m_kinematics = new MecanumDriveKinematics(
        m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation
        );
        //m_odometry = new MecanumDriveOdometry(m_kinematics, new Rotation2d(Math.toRadians(m_gyro.getFusedHeading())));
        m_backLeft.setInverted(true);
        m_backRight.setInverted(true);
    }
    public MecanumDrive(MotorController frontLeft, MotorController frontRight, MotorController backLeft, MotorController backRight){
        super();
        positional = false;
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
        m_frontLeft.set(this.getSpeed(false, true));
        m_frontRight.set(this.getSpeed(false, false));
        m_backLeft.set(this.getSpeed(true, false) );
        m_backRight.set(this.getSpeed(true, true));
        
        //System.out.println(m_gyro.getFusedHeading());
        //System.out.println("F: " + m_forward + "T: " + m_twist + "S: " + m_strafe);
        //System.out.println(m_frontLeft.getTargetSpeed());
        /*Pose2d m_RobotPose = m_odometry.update(
            new Rotation2d(Math.toRadians(m_gyro.getFusedHeading())), 
            new MecanumDriveWheelSpeeds(
            (m_frontLeft.getRealSpeed() * m_rotDistance) / 4096, 
            (m_frontRight.getRealSpeed() * m_rotDistance) / 4096,
            (m_backLeft.getRealSpeed() * m_rotDistance) / 4096,
            (m_backRight.getRealSpeed() * m_rotDistance) / 4096));*/
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
    public void gatherInfo(){}
}