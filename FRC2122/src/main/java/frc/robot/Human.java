/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Human
{
    WestCoastChassis westCoastChassis = null;
    NewJoystick m_targJoystick = null;
    double m_forwardSpeed = 0.0;

    public Human(WestCoastChassis tempChassis, NewJoystick tempJoystick)
    {
        this.m_targChassis = tempChassis;
        this.m_targJoystick = tempJoystick;
    }

    public void makeCalculations(double joystickValue)
    {
        m_forwardSpeed = Math.pow(joystickValue, 2.0);

        //m_theChassis.setVals(m_theJoystick.getForwardAxis(), m_theJoystick.getTwistAxis(), m_theJoystick.getStrafeAxis());
        if (joystickValue > 0)
        {
            m_targChassis.setCommand(Chassis.chassisCommands.MOVEFORWARD, m_forwardSpeed);
        }
        else if (joystickValue < 0)
        {
            m_targChassis.setCommand(Chassis.chassisCommands.MOVEBACKWARD, m_forwardSpeed);
        }
        else
        {
            m_targChassis.setCommand(Chassis.chassisCommands.DONOTHING, 0.0);
        }
    }
}
