package frc.robot.biblioteca;
import edu.wpi.first.wpilibj.AnalogInput;
public class UltrasonicSensor extends AnalogIn {
    private final int m_port;
    private final AnalogInput m_sensor;
	private int m_sampleBuffer;
	private final int m_millimetersPerVolt = 976;//constant set by range finder
	private double m_correctionCoeff = 1.125;
	private int m_defaultSampleBuffer = 20;

    public UltrasonicSensor(int port) {
        super(0, 550);
        m_port = port;
		m_sensor = new AnalogInput(port);
		setSampleBuffer(m_defaultSampleBuffer);
    }
    public UltrasonicSensor(int port, int sampleBuffer) {
        super(0, 550);
        m_port = port;
        m_sensor = new AnalogInput(port);
		setSampleBuffer(sampleBuffer);
    }
    @Override
    public void gatherInfo() {
        setValue(m_sensor.getAverageValue());
    }
    public int getPort(){
        return m_port;
    }
	public double getMillimeters() {
		return m_sensor.getAverageVoltage() * m_millimetersPerVolt * m_correctionCoeff;
	}
	public double getInches() {
		return getMillimeters() * 0.03937;
	}
	public double getCentimeters() {
		return getMillimeters() * 0.10;
	}
	public double getVoltage(){
		return m_sensor.getAverageVoltage();
	}
    public void setSampleBuffer(int buffer) {
		m_sampleBuffer = buffer;
		m_sensor.setAverageBits(buffer);
		m_sensor.setOversampleBits(buffer);
	}
    
}