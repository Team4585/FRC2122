/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.biblioteca.RoboBaseClass;
import java.util.*;
import java.io.*;

public class Robot extends TimedRobot 
{
  WestCoastChassis m_theChassis;
  NewJoystick m_theJoystick;
  Human m_theHuman;


  //This is where we initialize our main objects
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
  public void initSubsystems()
  {
    m_theJoystick.newJoystickInit();
    m_theChassis.westCoastChassisInit();
  }

  @Override
  public void robotPeriodic() 
  {

  }

  //This initializes the values for autonomous
  @Override
  public void autonomousInit() 
  {
    //m_autoController.Init(m_driveTrain, m_limeLight);
    //m_autoController.setActive(true);
  }

  /* When "Autonomous" is selected on the driver station, the autonomousInit() will be run
    and then this runs the associated actions
  */
  @Override
  public void autonomousPeriodic() 
  {
    //Cry
    RoboBaseClass.gatherInfoAll();
    RoboBaseClass.doActionsAll();
  }

  //This initializes the values for "TeleOperated" as seen on the driver station
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
  @Override
  public void teleopPeriodic() 
  {
     double joystickValue = m_theJoystick.gatherInformation();  //basically assigns joystick values
      m_theHuman.makeCalculations(joystickValue);
      m_theChassis.chassisDoActions();

    RoboBaseClass.doActionsAll();
  }

  //This is for the "Test" setting on drive station
  @Override
  public void testPeriodic() 
  {

  }
}
// woo code

