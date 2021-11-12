package frc.robot.biblioteca;

import java.util.Timer;
import java.util.TimerTask;
class PIDKiller extends TimerTask {

    private PID m_connectedclass;
    private Timer m_timer;


    PIDKiller (PID pid, Timer timer)
    {
        m_timer = timer;
        this.m_connectedclass = pid;
    }

    public void run() {
        m_connectedclass.calculateError();
        if(Math.abs((m_connectedclass.getPosition()) - m_connectedclass.getTarget()) < m_connectedclass.getTolerance()){
            m_timer.cancel();
        }
    }
}
