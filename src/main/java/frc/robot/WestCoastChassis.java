package frc.robot;

import frc.robot.biblioteca.*;
import frc.robot.biblioteca.basesubsystem.WestCoastDrive;

/**
 * A class that executes the calculations made in Human.
 */
public class WestCoastChassis
{
    // since this class is in its own package, the access specifier has to be public so other classes can see it.

    /**
     * An enum with three different commands for the forward/backward direction.
     */
    public enum chassisCommands
    {
        MOVEFORWARD,
        MOVEBACKWARD,
        DONOTHING
    }

    /**
     * An enum with three different commands for the twisting direction.
     */
    public enum rotateCommands {
        TURNRIGHT,
        TURNLEFT,
        NOROTATE
    }

    private WestCoastDrive m_westCoastDrive;
    
    private HuskyTalon m_leftMaster = null;
    private HuskyVictor m_leftSlave = null;
    private HuskyTalon m_rightMaster = null;
    private HuskyVictor m_rightSlave = null;

    double forwardVal = 0.0;
    double twistVal = 0.0;
    chassisCommands m_currentCommand = chassisCommands.DONOTHING;
    rotateCommands m_rotateCommand = rotateCommands.NOROTATE;
    double m_commandParameter = 0.0;
    double m_rotateParameter = 0.0;

    /**
     * Constructor for WestCoastChassis.
     */
    public WestCoastChassis() 
    {

    }

    /**
     * A method that initializes the values of the four motor controllers used as well as the WestCoastDrive.
     */
    public void westCoastChassisInit() 
    {
        m_leftMaster = new HuskyTalon(3);
        m_leftSlave = new HuskyVictor(1);
        m_rightMaster = new HuskyTalon(4);
        m_rightSlave = new HuskyVictor(2); 

        m_westCoastDrive = new WestCoastDrive(m_leftMaster, m_leftSlave, m_rightMaster, m_rightSlave);
    }

    /**
     * A method that executes ("does the actions") the forward/backward commands based on
     * the calculations made by the Human, using the chassisCommands enum in this class.
     */
    public void chassisDoActions()
    {
        switch (m_currentCommand)
        {
            case MOVEFORWARD:
                // m_westCoastDrive.invertForward(true);
                //m_westCoastDrive.setInvertRight(true);
                m_westCoastDrive.setForward(m_commandParameter);
                break;

            case MOVEBACKWARD:
                // m_westCoastDrive.invertForward(true);
                m_westCoastDrive.setForward(-m_commandParameter);
                break;

            default:
            case DONOTHING:
                m_westCoastDrive.setForward(0.0);
                break;
        }

    }

    /**
     * A method that executes the rotating commands based on calculations done by the Human,
     * using commands from the rotateCommands enum in this class.
     */
    public void chassisRotateActions() {
        switch (m_rotateCommand) {
            case TURNRIGHT:
                m_westCoastDrive.setTwist(-m_rotateParameter);
                m_westCoastDrive.setInvertRight(false);
                m_westCoastDrive.setInvertLeft(false);
                break;
            case TURNLEFT:
                m_westCoastDrive.setTwist(-m_rotateParameter);
                m_westCoastDrive.setInvertRight(true);
                m_westCoastDrive.setInvertLeft(true);
                break;
            default:
            case NOROTATE:
                m_westCoastDrive.setTwist(0.0);
                m_westCoastDrive.setInvertRight(false);
                m_westCoastDrive.setInvertLeft(false);
                break;        
        }
    }

    // private void setVals(double forward, double twist)
    // {
    //     forwardVal = forward;
    //     twistVal = twist;
    // }

    /**
     * Initializes m_currentCommand and m_commandParameter, to set direction and speed of forward/backward motion.
     * @param targetCommand The direction of the forward/backward motion.
     * @param commandParam The value of the speed that the robot should travel.
     */
    public void setCommand(chassisCommands targetCommand, double commandParam)
    {
        this.m_currentCommand = targetCommand;
        this.m_commandParameter = commandParam;
    }

    /**
     * Initializes m_rotateCommand and m_rotateParameter, to set direction and speed of twisting motion.
     * @param targetCommand The direction of the twisting motion (left/right)
     * @param commandParam The value of the speed that the robot should travel.
     */
    public void setRotateCommand(rotateCommands targetCommand, double commandParam) {
        this.m_rotateCommand = targetCommand;
        this.m_rotateParameter = commandParam;
    }
}