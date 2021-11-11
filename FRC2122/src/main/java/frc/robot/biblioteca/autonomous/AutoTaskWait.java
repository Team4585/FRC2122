package frc.robot.biblioteca.autonomous;

public class AutoTaskWait extends AutoTask{
    protected boolean m_isComplete;
    Long m_waitTime;
    Long m_startTime;
    public AutoTaskWait(Long waitTime){
        m_waitTime = waitTime * 1000000000;
    }
    public void Init() {
        m_startTime = System.nanoTime();
        m_waitTime += m_startTime;
        System.out.println("Waiting");
    }
    public void Run() {
        if(System.nanoTime() > m_waitTime) {
            m_isComplete = true;
        }
    }
    public void OnComplete() {
        System.out.println("Done Waiting");
    }
}