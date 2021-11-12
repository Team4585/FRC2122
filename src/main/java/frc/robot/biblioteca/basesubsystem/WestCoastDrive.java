package frc.robot.biblioteca.basesubsystem;

import frc.robot.biblioteca.HuskyTalon;
import frc.robot.biblioteca.HuskyVictor;

/**
 * A class that has the motor controllers along with methods to set the motion.
 */
public class WestCoastDrive extends Drive 
{
    private HuskyTalon m_leftMaster;
    private HuskyVictor m_leftSlave;
    private HuskyTalon m_rightMaster;
    private HuskyVictor m_rightSlave;

    int invertLeft = 1;
    int invertRight = 1;

    /**
     * Parameterized constructor for WestCoastDrive
     * @param leftMaster The HuskyTalon motor controller on the left side.
     * @param leftSlave The HuskyVictor motor controller on the left side.
     * @param rightMaster The HuskyTalon motor controller on the right side.
     * @param rightSlave The HuskyVictor motor controller on the right side.
     */
    public WestCoastDrive(HuskyTalon leftMaster, HuskyVictor leftSlave, HuskyTalon rightMaster, HuskyVictor rightSlave)
    {
        super();

        m_leftMaster = leftMaster;
        m_leftSlave = leftSlave;
        m_rightMaster = rightMaster;
        m_rightSlave = rightSlave;

        m_rightSlave.follow(m_rightMaster);
        m_leftSlave.follow(m_leftMaster);

    }

    /**
     * A method that combines forward (Y) axis and twist (Z) axis into one value to pass to the right/left masters.
     */
    @Override
    public void doActions() 
    {   
        // m_rightMaster.set(m_forward + m_twist * invertRight);
        // m_leftMaster.set(m_forward + m_twist * invertLeft);

         m_rightMaster.set(-m_forward - (m_twist * invertRight));
         m_leftMaster.set(m_forward - (m_twist * invertLeft));
        
        // m_rightMaster.set(-m_forward);
        // m_leftMaster.set(m_forward);

        // m_rightMaster.set(m_twist * invertRight);
        // m_leftMaster.set(m_twist * invertLeft);

    
    }

    /**
     * Inverts the direction of the left motor controller (from 1 to -1, or vice versa)
     * @param invTwist A boolean argument that changes the direction of the left motor controller.
     */
    public void setInvertLeft(boolean invTwist) {
        if(invTwist) {
            invertLeft = -1;
        } else {
            invertLeft = 1;
        }
    }

    /**
     * Inverts the direction of the right motor controller (from 1 to -1, or vice versa)
     * @param invTwist A boolean argument that changes the direction of the right motor controller.
     */
    public void setInvertRight(boolean invTwist) {
        if(invTwist) {
            invertRight = -1;
        } else {
            invertRight = 1;
        }
    }


    /**
     * A blank overridden method that gathers information
     */
    @Override
    public void gatherInfo() 
    {

    }


}