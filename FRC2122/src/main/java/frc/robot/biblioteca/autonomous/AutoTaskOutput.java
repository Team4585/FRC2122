package frc.robot.biblioteca.autonomous;

public class AutoTaskOutput extends AutoTask {
    private String m_output;
    public AutoTaskOutput(String output) {
        m_output = output;
    }
    public void Init() {
        m_isComplete = false;
        System.out.println("Init!");
    }
    public void Run() {
        System.out.println("Run!");
        System.out.println(m_output);
        m_isComplete = true;
    }
    public void OnComplete() {
        System.out.println("Complete!");
    }
}
