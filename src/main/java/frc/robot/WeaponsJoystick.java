package frc.robot;

import frc.robot.biblioteca.HuskyJoystick;

/**
 * A class for the Joystick, which gathers information from X, Y, Z axis.
 */
public class WeaponsJoystick
{
    HuskyJoystick m_weaponsControl;
    boolean m_button1 = false;
    boolean m_button2 = false;

    /**
     * A blank constructor for the joystick.
     */
    public WeaponsJoystick()
    {
       
    }

    /**
     * Initializes the m_driveControl variable as a new HuskyJoystick.
     */
    public void weaponsJoystickInit()
    {
        m_weaponsControl = new HuskyJoystick(1);
    }

    /**
     * Initializes the values of both forward axis and twist axis, and the two buttons found on the joystick.
     */
    public void gatherInformation()
    {
        
        m_button1 = m_weaponsControl.getButton(1);
        m_button2 = m_weaponsControl.getButton(2);
    } 

    /**
     * Returns the value of button 1.
     * @return A boolean value of the pressed status of button 1.
     */
    public boolean getButton1()
    {
        return m_button1;
    }

    /**
     * Returns the value of button 2.
     * @return A boolean value of the pressed status of button 2.
     */
    public boolean getButton2()
    {
        return m_button2;
    }
}