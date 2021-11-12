package frc.robot.biblioteca;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class HuskyVictor extends MotorController {
    VictorSPX victor;
    public HuskyVictor(int port) {
        super();
        victor = new VictorSPX(port);
    }
    @Override
    public void doActions() {
        victor.set(ControlMode.PercentOutput, this.getTargetSpeed());
        super.doActions();
    }
}
