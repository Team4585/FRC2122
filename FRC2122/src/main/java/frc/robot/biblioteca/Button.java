package frc.robot.biblioteca;
import frc.robot.biblioteca.HuskyDigIn;
import edu.wpi.first.wpilibj.DigitalInput;

public class Button extends HuskyDigIn {
    private final int m_port;
    private final DigitalInput m_b;

    public Button(final int port) {
        super(false);
        m_port = port;
        m_b = new DigitalInput(port);
    }
    @Override
    public void gatherInfo() {
        setValue(m_b.get());
    }
    public int getPort(){
        return m_port;
    }
}
