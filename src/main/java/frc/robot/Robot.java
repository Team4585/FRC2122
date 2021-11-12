/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.biblioteca.RoboBaseClass;

/**
 * A class to initialize Joystick, Human, and Chassis objects, run commands periodically, and use the main method to communicate with the driver station.
 */
public class Robot extends TimedRobot 
{
  WestCoastChassis m_theChassis;
  NewJoystick m_theJoystick;
  Human m_theHuman;


  //This is where we initialize our main objects
  /**
   * A method to initialize the main objects - Joystick, Human, and the Chassis.
   */
  @Override
  public void robotInit() 
  {
//    SmartDashboard.putNumber("Forward Axis", 1);
//    SmartDashboard.putNumber("TwistAxis", 2)
//    SmartDashboard.putNumber("StrafeAxis", 0);
//    SmartDashboard.putNumber("AimAxis", 2);
//    SmartDashboard.putNumber("Aim Override Button", 1);
//    SmartDashboard.putNumber("Shoot Button", 1);
//    SmartDashboard.putNumber("Intake Button", 2);
//    SmartDashboard.putNumber("Helix Button", 3);
//    SmartDashboard.putNumber("Joystick Deadzones", 0.25);

    m_theChassis = new WestCoastChassis();
    m_theJoystick = new NewJoystick();
    m_theHuman = new Human(m_theChassis, m_theJoystick);
  }

  //This is calling the more specific "constructors" of objects with init methods
  /**
   * A method to call the more specific initializer methods of the objects.
   */
  public void initSubsystems()
  {
    m_theJoystick.newJoystickInit();
    m_theChassis.westCoastChassisInit();
  }

  /**
   * An overriden method from TimedRobot.
   */
  @Override
  public void robotPeriodic() 
  {

  }

  /**
   * Initializes values for the autonomous period.
   */
  @Override
  public void autonomousInit() 
  {
    //m_autoController.Init(m_driveTrain, m_limeLight);
    //m_autoController.setActive(true);
  }


  /**
   * A method to run the autonomousInit() method, along with the associated actions (when autonomous is selected on the driver station).
   */
  @Override
  public void autonomousPeriodic() 
  {
    //Cry
    RoboBaseClass.gatherInfoAll();
    RoboBaseClass.doActionsAll();
  }

  /**
   * Initializes the values for the teleoperated period (selected from the driver station).
   */
  @Override
  public void teleopInit() 
  {
 //   RobotConstants.forwardAxis = (int) SmartDashboard.getNumber("Forward Axis", 1);
 //   RobotConstants.twistAxis = (int) SmartDashboard.getNumber("Twist Axis", 2);
 //   RobotConstants.strafeAxis = (int) SmartDashboard.getNumber("Strafe Axis", 0);
 //   RobotConstants.aimAxis = (int) SmartDashboard.getNumber("Aim Axis", 1);
 //   RobotConstants.aimOverrideButton = (int) SmartDashboard.getNumber("Aim Override Button", 1);
 //   RobotConstants.shootButton = (int) SmartDashboard.getNumber("Shoot Button", 1);
 //   RobotConstants.intakeButton = (int) SmartDashboard.getNumber("Intake Button", 2);
 //   RobotConstants.helixButton = (int) SmartDashboard.getNumber("Helix Button", 3);
 //   RobotConstants.joystickDeadZone = (int) SmartDashboard.getNumber("Joystick Deadzones", 0.25);

    initSubsystems();
  }

  //This runs the actions for TeleOp
  /**
   * Runs the actions for the teleoperated period.
   */
  @Override
  public void teleopPeriodic() 
  {
    RoboBaseClass.gatherInfoAll();
    
      m_theJoystick.gatherInformation();  //basically assigns joystick values
      m_theHuman.makeCalculations();
      m_theChassis.chassisDoActions();
      m_theChassis.chassisRotateActions();

    RoboBaseClass.doActionsAll();
  }

  //This is for the "Test" setting on drive station
  /**
   * An overriden method that controls the "test" setting on the drive station
   */
  @Override
  public void testPeriodic() 
  {

  }
}
// woo code

