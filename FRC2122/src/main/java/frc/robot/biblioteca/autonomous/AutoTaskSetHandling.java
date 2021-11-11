package frc.robot.biblioteca.autonomous;

import frc.robot.RobotConstants;
import frc.robot.subsystem.*;

public class AutoTaskSetHandling extends AutoTask {
    private Intake m_intake;
    private Output m_output;
    private double m_shootSpeed;
    private double m_helixSpeed;
    private double m_intakeSpeed;
    public AutoTaskSetHandling(Intake intake, Output output, double shootSpeed, double helixSpeed, double intakeSpeed) {
        m_intake = intake;
        m_output = output;
        m_shootSpeed = shootSpeed;
        m_helixSpeed = helixSpeed;
        m_intakeSpeed = intakeSpeed;
    }
    @Override
    public void Init() {
        m_isComplete = false;
    }
    @Override
    public void Run() {
        m_output.shoot(m_shootSpeed);
        m_intake.intake(m_intakeSpeed, m_helixSpeed);
        m_isComplete = true;
    }
    @Override
    public void OnComplete() {
    }
}
