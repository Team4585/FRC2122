package frc.robot.biblioteca;
import frc.robot.biblioteca.RoboBaseClass;
class AnalogOutput extends RoboBaseClass {
    private double m_currentValue;
    private double m_maxValue = 1;
    private double m_minValue = -1;
    public AnalogOutput(double max, double min) {
        super();
        m_maxValue = max;
        m_minValue = min;
    }
    public double getValue() {
        return(m_currentValue);
    }
    public double getMax() {
        return(m_maxValue);
    }
    public double getMin() {
        return(m_minValue);
    }
    public void setValue(double value) {
        if (value < m_minValue) {
            m_currentValue = m_minValue;
        } else if (value > m_maxValue) {
            m_currentValue = m_maxValue;
        } else {
            m_currentValue = value;
        }
    }
    public void setMax(double max) {
        m_maxValue = max;
    }
    public void setMin(double min) {
        m_minValue = min;
    }
    @Override
    public void gatherInfo(){}
    @Override
    public void doActions(){}
}
