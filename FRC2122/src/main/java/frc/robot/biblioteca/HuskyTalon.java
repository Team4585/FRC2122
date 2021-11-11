package frc.robot.biblioteca;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class HuskyTalon extends MotorController {
    public TalonSRX talon;
    public HuskyTalon(final int port) {
        talon = new TalonSRX(port);
        talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        talon.setNeutralMode(NeutralMode.Brake);
    }
    @Override
    public void setNeutralMode(int mode) {
        if (mode == 0) {
            talon.setNeutralMode(NeutralMode.Brake);
        } else {
            talon.setNeutralMode(NeutralMode.Coast);
        }
    }
    @Override
    public void gatherInfo() {
        setRealSpeed(talon.getSelectedSensorVelocity());
        super.gatherInfo();
    }
    @Override
    public void doActions(){
        talon.set(ControlMode.PercentOutput, getTargetSpeed());
        super.doActions();
    }
}
