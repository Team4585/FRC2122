package frc.robot;

import frc.robot.biblioteca.HuskyJoystick;

public class NewJoystick
{
    HuskyJoystick m_driveControl;
    double m_forwardAxis = 0.0;
    double m_twistAxis = 0.0;
    boolean m_button1 = false;
    boolean m_button2 = false;

    public NewJoystick()
    {
       
    }

    public void newJoystickInit()
    {
        m_driveControl = new HuskyJoystick(0);
    }

    public double gatherInformation()
    {
        m_forwardAxis = m_driveControl.getAxis(RobotConstants.forwardAxis);
        m_twistAxis = m_driveControl.getAxis(RobotConstants.twistAxis); 
        m_button1 = m_driveControl.getButton(1);
        m_button2 = m_driveControl.getButton(2);

        return m_forwardAxis;
    }

    //public void newJoystickDoActions()
    //{
    //} 

    public double getForwardAxis()
    {
        return m_forwardAxis;
    }

    public double getTwistAxis()
    {
        return m_twistAxis;
    }

    public double getStrafeAxis()
    {
        return m_strafeAxis;
    }

    public boolean getButton1()
    {
        return m_button1;
    }

    public boolean getButton2()
    {
        return m_button2;
    }
}