package frc.robot.biblioteca.autonomous;

public class AutoTask {
    protected boolean m_isComplete;
    public void Init() {}
    public void Run() {}
    public void OnComplete() {}
    public boolean IsComplete() {
        return m_isComplete;
    }
}
