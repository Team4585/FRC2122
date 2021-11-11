package frc.robot.biblioteca;
import frc.robot.biblioteca.RoboBaseClass;

class DigitalOutput extends RoboBaseClass {
    private boolean m_currentValue;
    public DigitalOutput(boolean initValue) {
        super();
        m_currentValue = initValue;
    }
    public boolean getValue() {
        return(m_currentValue);
    }
    public void setValue(boolean value) {
        m_currentValue = value;
    }
}
