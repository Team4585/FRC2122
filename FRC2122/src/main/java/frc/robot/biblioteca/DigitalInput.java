package frc.robot.biblioteca;
import frc.robot.biblioteca.RoboBaseClass;

class HuskyDigIn extends RoboBaseClass {
    private boolean m_currentValue;
    public HuskyDigIn(boolean initValue) {
        super();
        m_currentValue = initValue;
    }
    public boolean getValue() {
        return(m_currentValue);
    }
    protected void setValue(boolean value) {
        m_currentValue = value;
    }
}
