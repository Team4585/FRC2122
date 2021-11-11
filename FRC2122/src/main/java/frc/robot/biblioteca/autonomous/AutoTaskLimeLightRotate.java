package frc.robot.biblioteca.autonomous;

import frc.robot.biblioteca.basesubsystem.*;
import frc.robot.RobotConstants;
import frc.robot.biblioteca.*;


public class AutoTaskLimeLightRotate extends AutoTask {
    private Drive m_drive;
    private Turret m_shooter;
    private double m_currentHeading;
    private double m_targetHeading;
    private BasicPID m_pidX;
    private BasicPID m_pidY;
    private LimeLightCamera m_limeLight;
    private int m_timeIn;
    public AutoTaskLimeLightRotate(Drive drive, Turret shooter, LimeLightCamera camera) {
        m_drive = drive;
        m_shooter = shooter;
        m_limeLight = camera;
        m_pidX = new BasicPID();
        m_pidX.setP(RobotConstants.aimXP);
        m_pidX.setI(RobotConstants.aimXI);
        m_pidX.setD(RobotConstants.aimXD);
        m_pidX.setMinOutput(-0.5);
        m_pidX.setMaxOutput(0.5);
        m_pidY = new BasicPID();
        m_pidY.setP(RobotConstants.aimYP);
        m_pidY.setI(RobotConstants.aimYI);
        m_pidY.setD(RobotConstants.aimYD);
        m_pidY.setMinOutput(-0.5);
        m_pidY.setMaxOutput(0.5);
    }
    @Override
    public void Init() {
        m_isComplete = false;
        m_timeIn = 0;
    }
    @Override
    public void Run() {
        m_pidX.setPosition(m_limeLight.getXDistance());
        m_pidY.setPosition(m_limeLight.getYDistance());

        m_pidX.setTarget(0);
        m_pidY.setTarget(RobotConstants.aimYOffset);

        m_drive.setTwist(m_pidX.calculateError());
        m_shooter.rotateY(m_pidY.calculateError());
        
        if(Math.abs(m_pidX.getError()) < RobotConstants.aimXTolerance && Math.abs(m_pidY.getError()) < RobotConstants.aimYTolerance) {
            m_timeIn ++;
        } else {
            m_timeIn = 0;
        }
        if(m_timeIn > 10) {
            m_isComplete = true;
        }
    }
    @Override
    public void OnComplete() {
    }

}
