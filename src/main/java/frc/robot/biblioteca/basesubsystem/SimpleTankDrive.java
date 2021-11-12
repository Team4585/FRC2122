package frc.robot.biblioteca.basesubsystem;

import frc.robot.biblioteca.MotorController;
import frc.robot.biblioteca.Vector3DIn;

public class SimpleTankDrive extends Drive{
  private MotorController m_leftMaster;
  private MotorController m_leftSlave;
  private MotorController m_rightMaster;
  private MotorController m_rightSlave;
  private double twistInv;
  private double driveInv;
  private double invertRight;
  private double invertLeft;
  private double heading;
  public SimpleTankDrive(MotorController leftMaster, MotorController leftSlave, MotorController rightMaster, MotorController rightSlave){
    super();
    m_leftMaster = leftMaster;
    m_leftSlave = leftSlave;
    m_rightMaster = rightMaster;
    m_rightSlave = rightSlave;
    m_rightSlave.follow(m_rightMaster);
    m_leftSlave.follow(m_leftMaster);
    driveInv = 1;
    twistInv = 1;
    invertLeft = 1;
    invertRight = 1;
  }
  public void invertLeft(boolean inv){
    if(inv){
      invertLeft = -1;
    }else{
      invertLeft = 1;
    }
  }
  public void invertRight(boolean inv){
    if(inv){
      invertRight = -1;
    }else{
      invertRight = 1;
    }
  }
  public void fightingLeft(boolean boo){
    m_leftSlave.setInverted(boo);
  }
  public void fightingRight(boolean boo){
    m_rightSlave.setInverted(boo);
  }
  public void gatherInfo(){
  }
  @Override
  public void doActions(){
    m_leftMaster.set(((m_forward * driveInv) - (m_twist * twistInv)) * invertLeft);
    m_rightMaster.set(((m_forward * driveInv) + (m_twist * twistInv)) * invertRight);
  }
}
