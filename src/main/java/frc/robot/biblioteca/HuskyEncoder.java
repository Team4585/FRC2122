package frc.robot.biblioteca;
import edu.wpi.first.wpilibj.Encoder;

public class HuskyEncoder extends AnalogIn{
    private int m_port1;
    private int m_port2;
    private Encoder m_encoder;
    public HuskyEncoder(int port1, int port2, double distancePerPulse) {
        super(-1, 1);
        m_port1 = port1;
        m_port2 = port2;
        m_encoder = new Encoder(port1, port2);
        m_encoder.setDistancePerPulse(distancePerPulse);
    }
    public void reset() {
        m_encoder.reset();
    }
    /*public int getCount() {
        return (m_encoder.getCount());
    }*/
    public boolean getDirection() {
        return (m_encoder.getDirection());
    }
    public double getDistance(){
        return (m_encoder.getDistance());
    }
    public double getDistancePerPulse(){
        return (m_encoder.getDistancePerPulse());
    }
    public int getEncodingScale(){
        return (m_encoder.getEncodingScale());
    }
    public int getFPGAIndex(){
        return (m_encoder.getFPGAIndex());
    }
    public double getRate(){
        return (m_encoder.getRate());
    }
    public int getRaw(){
        return (m_encoder.getRaw());
    }
    public int getSamplesToAverage(){
        return (m_encoder.getSamplesToAverage());
    }
    public boolean getStopped(){
        return (m_encoder.getStopped());
    } 

    @Override
    public void gatherInfo() {
        setValue(m_encoder.get());
    }
}
