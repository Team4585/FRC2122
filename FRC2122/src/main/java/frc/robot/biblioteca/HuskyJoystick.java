package frc.robot.biblioteca;
import edu.wpi.first.wpilibj.Joystick;
public class HuskyJoystick {
    private Joystick m_joystick;
    private double m_deadZone = 0.1;
    public HuskyJoystick(int port) {
        super();
        m_joystick = new Joystick(port);
    }
    public void setDeadZone(double zone) {
        m_deadZone = zone;
    }
    public boolean getButton(int channel) {
        return(m_joystick.getRawButton(channel));
    }
    public boolean getButtonPressed(int channel) {
        return(m_joystick.getRawButtonPressed(channel));
    }
    public double getAxis(int channel) {
        double val = 0;
        if (Math.abs(m_joystick.getRawAxis(channel)) > m_deadZone) {
            val = m_joystick.getRawAxis(channel);
        }
        return(val);
    }
}