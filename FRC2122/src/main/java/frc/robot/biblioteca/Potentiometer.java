package frc.robot.biblioteca;
import edu.wpi.first.wpilibj.AnalogInput;

public class Potentiometer extends AnalogIn {
    private int m_port;
    private AnalogInput m_p;
    private double m_minVoltage;
    private double m_maxVoltage;
    private double m_minAngle;
    private double m_maxAngle;
    public Potentiometer(int port, double minVoltage, double maxVoltage, double minAngle, double maxAngle) {
        super(minAngle, maxAngle);
        m_port = port;
        m_p = new AnalogInput(port);
        m_minVoltage = minVoltage;
        m_maxVoltage = maxVoltage;
        m_minAngle = minAngle;
        m_maxAngle = maxAngle;
    }
    public Potentiometer(int port) {
        super(0, 3600);
        m_port = port;
        m_p = new AnalogInput(port);
        m_minVoltage = 4.75;
        m_maxVoltage = 4.86;
        m_minAngle = 3600;
        m_maxAngle = 3600;
    }
    @Override
    public void gatherInfo() {
        double voltage = m_p.getAverageVoltage();
        voltage = Math.min(Math.max(voltage, m_minVoltage), m_maxVoltage);
        voltage = voltage + (m_minAngle - m_minVoltage);
        voltage = (voltage/(m_maxVoltage-m_minVoltage))*m_maxAngle;
        setValue(voltage);//I could've done this in only one line, but I decided to make it more readable;
    }
    public int getPort(){
        return m_port;
    }
}
