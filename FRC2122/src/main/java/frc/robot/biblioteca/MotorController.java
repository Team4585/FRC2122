package frc.robot.biblioteca;
public class MotorController extends AnalogOutput {
    private boolean m_ifFollowing;
    private MotorController m_following;
    private double m_speed;
    private double m_realSpeed;
    int invert;
    public MotorController() {
        super(-1, 1);
        m_ifFollowing = false;
        invert = 1;
    }
    public void set(double value) {
        m_speed = value * invert;
    }
    public void follow(MotorController motorFollow) {
        m_ifFollowing = true;
        m_following = motorFollow;

    }
    public double getTargetSpeed(){
        return m_speed;
    }
    public double getRealSpeed(){
        return m_realSpeed;
    }
    @Override
    public void gatherInfo(){
        // if(m_ifFollowing == true){
        //     m_speed = m_following.getTargetSpeed();
        // }
    }
    public void setInverted(boolean inve){
        if(inve){
            invert = -1;
        }else{
            invert = 1;
        }
    }
    protected void setRealSpeed(double speed) {
        m_realSpeed = speed;
    }
    public void setNeutralMode(int mode) {}
    @Override
    public void doActions(){
        // if(m_following != null) {
        //     this.m_following.set(m_speed * -1);
        // }
    }
}
