/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystem.*;

/**
 * A class for the Human, responsible for making all of the calculations after receiving values from the Joystick.
 */
public class Human
{
    WestCoastChassis m_targChassis;
    NewJoystick m_targJoystick;
    WeaponsJoystick m_weaponsJoystick;
    AmesWall m_wall;
    double m_forwardSpeed = 0.0;
    double m_twistSpeed = 0.0;
    double m_deadZone = 0.2;

    /**
     * A parameterized constructor for the Human.
     * @param tempChassis The chassis to move the robot.
     * @param tempJoystick The joystick to read values and gather information.
     * @param tempWeaponsJoystick The joystick that gets information for the subsystems.
     * @param tempWall The wall that can move in four directions.
     */
    public Human(WestCoastChassis tempChassis, NewJoystick tempJoystick, WeaponsJoystick tempWeaponsJoystick, AmesWall tempWall)
    {
        this.m_targChassis = tempChassis;
        this.m_targJoystick = tempJoystick;
        this.m_weaponsJoystick = tempWeaponsJoystick;
        this.m_wall = tempWall;
    }

    /**
     * A method to calculate direction and speed of the robot, based on the values of m_forwardSpeed and forwardJoystickValue.
     */
    public void makeCalculations()
    {
        double forwardJoystickValue = m_targJoystick.m_forwardAxis;
        m_forwardSpeed = Math.pow(forwardJoystickValue, 2.0);

        //m_theChassis.setVals(m_theJoystick.getForwardAxis(), m_theJoystick.getTwistAxis(), m_theJoystick.getStrafeAxis());
        if (forwardJoystickValue > m_deadZone)
        {
            m_targChassis.setCommand(WestCoastChassis.chassisCommands.MOVEFORWARD, m_forwardSpeed);
        }
        else if (forwardJoystickValue < -m_deadZone)
        {
            m_targChassis.setCommand(WestCoastChassis.chassisCommands.MOVEBACKWARD, m_forwardSpeed);
        }
        else
        {
            m_targChassis.setCommand(WestCoastChassis.chassisCommands.DONOTHING, 0.0);
        }
        
        double twistJoystickValue = m_targJoystick.m_twistAxis;
        m_twistSpeed = Math.pow(twistJoystickValue, 2.0);

        if (twistJoystickValue > m_deadZone)
        {
            m_targChassis.setRotateCommand(WestCoastChassis.rotateCommands.TURNRIGHT, m_twistSpeed);
        }
        else if (twistJoystickValue < -m_deadZone)
        {
            m_targChassis.setRotateCommand(WestCoastChassis.rotateCommands.TURNLEFT, m_twistSpeed);
        }
        else
        {
            m_targChassis.setRotateCommand(WestCoastChassis.rotateCommands.NOROTATE, 0.0);
        }

        boolean m_button3 = m_weaponsJoystick.getButton3();
        boolean m_button4 = m_weaponsJoystick.getButton4();
        boolean m_button5 = m_weaponsJoystick.getButton5();
        boolean m_button6 = m_weaponsJoystick.getButton6();

        if (m_button3) {
            m_wall.moveUp();
        }

        if (m_button4) {
            m_wall.moveDown();
        }

        if (m_button5) {
            m_wall.moveLeft();
        }

        if (m_button6) {
            m_wall.moveRight();
        }
    }

    public void setDeadZone(double deadZone) {
        m_deadZone = deadZone;
    }
}
