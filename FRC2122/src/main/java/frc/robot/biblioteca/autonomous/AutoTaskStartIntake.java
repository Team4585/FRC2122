package frc.robot.biblioteca.autonomous;

import frc.robot.subsystem.Intake;

public class AutoTaskStartIntake extends AutoTask {
    private Intake m_intake;
    public void AutoTaskStartIntake(Intake intake) {
        m_intake = intake;
    }
    public void Init() {
        //m_intake.intake(1);
    }
    public void Run() {
        m_isComplete = true;
    }
    public void OnComplete() {

    }
}