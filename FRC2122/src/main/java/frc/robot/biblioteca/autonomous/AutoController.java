package frc.robot.biblioteca.autonomous;
import java.util.ArrayList;
import frc.robot.biblioteca.RoboBaseClass;
public class AutoController extends RoboBaseClass {
    private ArrayList<AutoTask> m_taskList;
    private AutoTask m_currentTask;
    private boolean m_active;
    private int m_taskNumber;
    public AutoController() {
        super();
    }
    public void Init(ArrayList<AutoTask> tasks) {
        System.out.println("Init!");
        m_taskNumber = 0;
        m_taskList = tasks;
        m_taskList.add(new AutoTaskOutput("Autonomous Over!"));
        m_currentTask = m_taskList.get(0);
        m_currentTask.Init();
    }
    public void gatherInfo() {
        if(m_active) {
            if(m_currentTask.IsComplete()) {
                m_currentTask.OnComplete();
                m_taskNumber ++;
                if(m_taskNumber < m_taskList.size()) {
                    m_currentTask = m_taskList.get(m_taskNumber);
                    m_currentTask.Init();
                } else {
                    m_active = false;
                }
            }
        }
    }
    public void doActions() {
        if(m_active) {
            m_currentTask.Run();
        }
    }
    public void setActive(boolean active) {
        m_active = active;
    }
}