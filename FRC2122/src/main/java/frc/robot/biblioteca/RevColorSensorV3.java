package frc.robot.biblioteca;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;

public class RevColorSensorV3 extends ColorInput {
    ColorSensorV3 m_colorSensor;
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    
    public RevColorSensorV3() {
        super();
        m_colorSensor = new ColorSensorV3(i2cPort);
    }
    @Override
    public void gatherInfo() {
        HuskyColor color = new HuskyColor(m_colorSensor.getRed(), m_colorSensor.getGreen(), m_colorSensor.getBlue());
        setValue(color);
    }
}