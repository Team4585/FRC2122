/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.biblioteca.basesubsystem.MecanumDrive;
import frc.robot.biblioteca.HuskyTalon;

/**
A class that creates a chassis with motor controllers and has methods to move around.
 */
public class Chassis
{
    /**
    An enum with three commands to move the robot.
     */
    enum chassisCommands
    {
        MOVEFORWARD,
        MOVEBACKWARD,
        DONOTHING
    }

    MecanumDrive m_driveTrain;
       
    HuskyTalon front_left;
    HuskyTalon back_left;
    HuskyTalon front_right;
    HuskyTalon back_right;

    double forwardVal = 0.0;
    double twistVal = 0.0;
    double strafeVal = 0.0;
    chassisCommands m_currentCommand = chassisCommands.DONOTHING;
    double m_commandParameter = 0.0;
    
    /**
    A blank constructor
    */
    public Chassis()
    {

    }

    /**
    A method that sets the four motor controllers to the chassis and creates a mecanum drive wtih the four controllers.
    */
    public void chassisInit()
    {
        front_left = new HuskyTalon(1);
        back_left = new HuskyTalon(3);
        front_right = new HuskyTalon(2);
        back_right = new HuskyTalon(4);

        m_driveTrain = new MecanumDrive(front_left, front_right, back_left, back_right);

    }

    /**
    A method that moves the robot, based on the command given and the speed inputted.
    */
    public void chassisDoActions()
    {
        switch (m_currentCommand)
        {
            //For some reason, setStrafe is what we would consider setForward to be
            case MOVEFORWARD:
                m_driveTrain.setStrafe(m_commandParameter);
                break;

            case MOVEBACKWARD:
                m_driveTrain.setStrafe(-m_commandParameter);
                break;

            default:
            case DONOTHING:
                m_driveTrain.setForward(0.0);
                m_driveTrain.setTwist(0.0);
                m_driveTrain.setStrafe(0.0);
                break;
        }


        // m_driveTrain.setForward(forwardVal);
        // m_driveTrain.setTwist(twistVal);
        // m_driveTrain.setStrafe(strafeVal);
    }

    /**
    A method that initializes the values of forward, twist, and strafe 
    */
    private void setVals(double forward, double twist, double strafe)
    {
        forwardVal = forward;
        twistVal = twist;
        strafeVal = strafe;
    }

    /**
    Initializes the commands for the speed and the type of movement
    */
    public void setCommand(chassisCommands targetCommand, double commandParam)
    {
        this.m_currentCommand = targetCommand;
        this.m_commandParameter = commandParam;
    }
}
