package frc.robot.biblioteca;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
public class HuskyVictor extends MotorController {
    VictorSPX victor;
    public HuskyVictor(int port) {
        super();
        victor = new VictorSPX(port);
    }
    @Override
    public void setNeutralMode(int mode) {
        if (mode == 0) {
            victor.setNeutralMode(NeutralMode.Brake);
        } else {
            victor.setNeutralMode(NeutralMode.Coast);
        }
    }
    @Override
    public void doActions() {
        victor.set(ControlMode.PercentOutput, this.getTargetSpeed());
        //super.doActions();
    }
}
