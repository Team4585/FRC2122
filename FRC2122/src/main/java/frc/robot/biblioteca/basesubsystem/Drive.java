package frc.robot.biblioteca.basesubsystem;
import frc.robot.biblioteca.HuskyVector2D;
import frc.robot.biblioteca.RoboBaseClass;
import frc.robot.biblioteca.MathTools;

public abstract class Drive extends RoboBaseClass {
    protected double m_forward;
    protected double m_twist;
    protected double m_strafe;
    protected double m_throttle;
    private HuskyVector2D m_vel;
    protected double m_heading;
    protected HuskyVector2D m_loc;
    private double m_rotVel;
    private boolean m_invertForward;
    private boolean m_invertStrafe;
    private boolean m_invertTwist;
    private boolean m_invertThrottle;
    protected boolean m_positional;
    public Drive() {
        super();
    }
    @Override
    abstract public void doActions();
    @Override
    abstract public void gatherInfo();
    public void setForward(double forward) {
        if(m_invertForward){
            m_forward = -forward;
        }else{
            m_forward = forward;
        }
    }
    public void setTwist(double twist) {
        if(m_invertTwist){
            m_twist = -twist;
        }else{
            m_twist = twist;
        }
    }
    public void setStrafe(double strafe){
        if(m_invertStrafe){
            m_strafe = -strafe;
        }else{
            m_strafe = strafe;
        }
    }
    public void setThrottle(double throttle){
        if(m_invertThrottle){
            m_throttle = -throttle;
        }else{
            m_throttle = throttle;
        }
    }
    public HuskyVector2D getLoc(){
        return m_loc;
    }
    public HuskyVector2D getVel(){
        return m_vel;
    }
    public double getHeading(){
        return m_heading;   
    }
    public double getHeadingNormalized() {
        return MathTools.normalizeAngleDegrees(m_heading);
    }
    public double getRotVel(){
        return m_rotVel;   
    }
    public void invertTwist(boolean twist){
        m_invertTwist = twist;
    }
    public void invertStrafe(boolean strafe){
        m_invertStrafe = strafe;
    }
    public void invertForward(boolean forward){
        m_invertForward = forward;
    }
    public void invertThrottle(boolean throttle){
        m_invertThrottle = throttle;
    }
}
