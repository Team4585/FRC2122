package frc.robot.biblioteca.autonomous;

import frc.robot.RobotConstants;
import frc.robot.biblioteca.basesubsystem.Drive;

public class AutoTaskSetDrive extends AutoTask {
    private Drive m_drive;
    private double m_forward;
    private double m_twist;
    private double m_strafe;
    public AutoTaskSetDrive(Drive drive, double forward, double twist, double strafe) {
        m_drive = drive;
        m_forward = forward;
        m_twist = twist;
        m_strafe = strafe;
    }
    @Override
    public void Init() {
        m_isComplete = false;
    }
    @Override
    public void Run() {
        m_drive.setForward(m_forward);
        m_drive.setTwist(m_twist);
        m_drive.setStrafe(m_strafe);
        m_isComplete = true;
    }
    @Override
    public void OnComplete() {
    }
}
