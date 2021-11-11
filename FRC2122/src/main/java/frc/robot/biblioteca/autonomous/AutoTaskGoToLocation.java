package frc.robot.biblioteca.autonomous;

import frc.robot.RobotConstants;
import frc.robot.biblioteca.MathTools;
import frc.robot.biblioteca.BasicPID;
import frc.robot.biblioteca.HuskyVector2D;
import frc.robot.biblioteca.basesubsystem.Drive;

public class AutoTaskGoToLocation extends AutoTask {
    private Drive m_drive;
    private HuskyVector2D m_currentPosition;
    private HuskyVector2D m_targetPosition;
    private double m_currentHeading;
    private double m_targetHeading;
    private BasicPID m_rotatePID;
    private BasicPID m_drivePID;
    private boolean m_startDriving = false;
    public AutoTaskGoToLocation(Drive drive, HuskyVector2D targetPosition) {
        m_drive = drive;
        m_targetPosition = targetPosition;
        m_rotatePID = new BasicPID();
        m_rotatePID.setP(RobotConstants.rotateP);
        m_rotatePID.setI(RobotConstants.rotateI);
        m_rotatePID.setD(RobotConstants.rotateD);
        m_rotatePID.setMinOutput(-0.5);
        m_rotatePID.setMaxOutput(0.5);
        m_drivePID = new BasicPID();
        m_drivePID.setP(RobotConstants.driveP);
        m_drivePID.setI(RobotConstants.driveI);
        m_drivePID.setD(RobotConstants.driveD);
        m_drivePID.setMinOutput(-0.5);
        m_drivePID.setMaxOutput(0.5);
    }
    @Override
    public void Init() {
        m_isComplete = false;
        m_startDriving = false;
        System.out.println("Going to new Location");
    }
    @Override
    public void Run() {
        m_currentPosition = m_drive.getLoc();
        m_currentHeading = m_drive.getHeadingNormalized();
        boolean isBackwardsFaster = false;
        double angleToTarget = MathTools.normalizeAngleDegrees(Math.toDegrees(Math.atan2(m_targetPosition.getX()-m_currentPosition.getY(), m_targetPosition.getY()+m_currentPosition.getX())));
        //double angleToTarget = Math.toDegrees(Math.atan2(m_targetPosition.getX()-m_currentPosition.getX(), m_targetPosition.getY()-m_currentPosition.getY()));
        if (angleToTarget > 90 || angleToTarget < -90) {
            isBackwardsFaster = true;
        }
        if (isBackwardsFaster) {
            m_targetHeading = MathTools.normalizeAngleDegrees(angleToTarget - 180);
        } else {
            m_targetHeading = angleToTarget;
        }

        m_rotatePID.setPosition(m_currentHeading);
        m_rotatePID.setTarget(m_targetHeading);
        m_drivePID.setPosition(0);
        m_drivePID.setTarget(Math.sqrt(
            Math.pow(Math.abs(m_targetPosition.getX()-m_currentPosition.getX()),2)+
            Math.pow(Math.abs(m_targetPosition.getY()-m_currentPosition.getY()),2)));
        //m_drivePID.setPosition(-m_currentPosition.getX());
        //m_drivePID.setTarget(m_targetPosition.getY());
        System.out.println(m_drivePID.getError());
        System.out.println("Target Information: "+m_currentPosition.getX()+", "+m_currentPosition.getY()+", "+m_drivePID.getTarget());
        System.out.println("Heading Information: "+m_currentHeading+", "+m_targetHeading+", "+m_rotatePID.calculateError());
        if(Math.abs(m_rotatePID.getError()) < RobotConstants.rotateTolerance) {
            m_startDriving = true;
        } else {
            m_startDriving = false;
        }
        if (m_startDriving) {
            m_drive.setTwist(0);
            m_drive.setForward(Math.abs(m_drivePID.calculateError()) * (isBackwardsFaster ? -1 : 1));
        } else {
            m_drive.setForward(0);
            m_drive.setTwist(m_rotatePID.calculateError()*-1);
        }
        if(Math.abs(m_drivePID.getTarget()) < RobotConstants.driveTolerance) {
            m_isComplete = true;
        }
    }
    @Override
    public void OnComplete() {
        m_drive.setForward(0);
        m_drive.setTwist(0);
        System.out.println("Arrived at Location");
    }
}
