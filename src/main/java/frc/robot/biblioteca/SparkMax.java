package frc.robot.biblioteca;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class SparkMax extends MotorController {
    CANSparkMax m_spark;
    public SparkMax(int port, boolean brushless) {
        super();
        m_spark = new CANSparkMax(port, brushless? MotorType.kBrushed : MotorType.kBrushless);
    }
    @Override
    public void doActions() {
        m_spark.set(getValue());
        super.doActions();
    }
}
