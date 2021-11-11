package frc.robot.biblioteca;
import frc.robot.biblioteca.RoboBaseClass;

public class Vector3DIn extends RoboBaseClass {
    private HuskyVector3D m_currentValue;
    public Vector3DIn() {
        super();
    }
    public HuskyVector3D getValue() {
        return(m_currentValue);
    }
    protected void setValue(HuskyVector3D value) {
        m_currentValue = value;
    }
}