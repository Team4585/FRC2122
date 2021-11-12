package frc.robot.biblioteca;
import edu.wpi.first.wpilibj.Solenoid;

public class HuskySolenoid extends DigitalOutput {
    private int m_port;
    private Solenoid m_solenoid;
    public HuskySolenoid(int port) {
        super(false);
        m_port = port;
        m_solenoid = new Solenoid(port);
    }
    @Override
    public void doActions() {
        m_solenoid.set(getValue());
    }

}
