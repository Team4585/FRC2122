package frc.robot.code2122;

public class WestCoastChassis
{
    enum chassisCommands
    {
        MOVEFORWARD,
        MOVEBACKWARD,
        DONOTHING
    }

    private WestCoastDrive m_westCoastDrive;
    
    private MotorController m_leftMaster;
    private MotorController m_leftSlave;
    private MotorController m_rightMaster;
    private MotorController m_rightSlave;

    private chassisCommands m_currentCommand = chassisCommands.DONOTHING;
    private double m_commandParameter = 0.0;

    public WestCoastChassis() 
    {

    }

    public void westCoastChassisInit() 
    {
        m_westCoastDrive = new WestCoastDrive(m_leftMaster, m_leftSlave, m_rightMaster, m_rightSlave);
    }

    public void chassisDoActions()
    {
        switch (m_currentCommand)
        {
            //For some reason, setStrafe is what we would consider setForward to be.
            //If there are issues with setForward, change it back to setStrafe
            case MOVEFORWARD:
                m_westCoastDrive.setForward(m_commandParameter);
                break;

            case MOVEBACKWARD:
                m_westCoastDrive.setForward(-m_commandParameter);
                break;

            default:
            case DONOTHING:
                m_westCoastDrive.setForward(0.0);
                m_westCoastDrive.setTwist(0.0);
                // m_westCoastDrive.setStrafe(0.0);
                break;
        }
    }

    private void setVals(double forward, double twist)
    {
        forwardVal = forward;
        twistVal = twist;
    }

    public void setCommand(chassisCommands targetCommand, double commandParam)
    {
        this.m_currentCommand = targetCommand;
        this.m_commandParameter = commandParam;
    }
}