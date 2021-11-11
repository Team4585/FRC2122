package frc.robot.biblioteca;

import java.util.TimerTask;
import java.util.Timer;
public class PID {
    private double m_P;
    private double m_I;
    private double m_D;
    private double m_errorSum;
    private double m_error;
    private double m_tolerance;
    private double m_maxError;
    private double m_maxOutput;
    private double m_minOutput;
    private double m_lastPosition;
    private double m_target;
    private TimerTask m_runnable;
    private PIDKiller m_testStop;
    private Timer m_timer;
    private boolean m_isActive;
    private double m_position;
    public PID(TimerTask command) {
        m_runnable = command;
        m_testStop = new PIDKiller(this, m_timer);
    }

    public boolean isActive(){
        return m_isActive;
    }

    public double getTarget() { return m_target; }

    public void setTarget(double target) {this.m_target = target;}

    public double getP() {
        return m_P;
    }

    public void setP(double m_P) {
        this.m_P = m_P;
    }

    public double getI() { return m_I; }

    public void setI(double m_I) {
        this.m_I = m_I;
    }

    public double getD() {
        return m_D;
    }

    public void setD(double m_D) { this.m_D = m_D; }

    public double getTolerance() { return m_tolerance; }

    public void setTolerance(double m_tolerance) { this.m_tolerance = m_tolerance; }

    public double getPosition(){return m_position;}

    public void setPosition(double position) { this.m_position = position; }

    public double calculateError() {
        double output = 0;
        m_error = m_target - m_position;
        m_errorSum += m_error;
        output += m_error * m_P;
        output += m_errorSum * m_I;
        output -= m_error - m_lastPosition * m_D;
        if(Math.abs(m_errorSum) > m_maxError)
        if(output > m_maxOutput){
            output = m_maxOutput;
        }
        if(output < m_minOutput){
            output = m_minOutput;
        }
        return output;

    }
    public void run(long delay){
        m_isActive = true;
        m_timer.schedule(m_runnable, delay);
        m_timer.schedule(m_testStop, delay);
    }
    public void stop(){
        m_isActive = false;
        m_runnable.cancel();
        m_timer.cancel();
    }
}

