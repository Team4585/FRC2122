package frc.robot.code2122;

import frc.robot.biblioteca.MotorController;
import frc.robot.biblioteca.Vector3DIn;

public class WestCoastDrive extends Drive 
{
    private MotorController m_leftMaster;
    private MotorController m_leftSlave;
    private MotorController m_rightMaster;
    private MotorController m_rightSlave;

    private double forwardVal = 0.0;
    private double twistVal = 0.0;

    public WestCoastDrive(MotorController leftMaster, MotorController leftSlave, MotorController rightMaster, MotorController rightSlave)
    {
        super();

        m_leftMaster = leftMaster;
        m_leftSlave = leftSlave;
        m_rightMaster = rightMaster;
        m_rightSlave = rightSlave;

        m_rightSlave.follow(m_rightMaster);
        m_leftSlave.follow(m_leftMaster);

    }


}