package frc.robot.biblioteca.basesubsystem;

import frc.robot.biblioteca.BasicPID;
import frc.robot.biblioteca.RoboBaseClass;
//import PID;
//import math;

public abstract class Turret extends RoboBaseClass {
  private double m_currentAngleX = 0;
  private double m_targetAngleX = 0;
  private double m_currentAngleY = 0;
  private double m_targetAngleY = 0;
  
  private double m_xMin = -180;
  private double m_xMax = 180;
  private double m_yMin = 0;
  private double m_yMax = 0;
  protected boolean m_PIDEnable = false;
  
  private BasicPID m_PIDX;
  private BasicPID m_PIDY;

  private double m_shoot = 0;
  
  public Turret(double xMin, double xMax, double yMin, double yMax, boolean doPID) {
    super();
    m_xMin = xMin;
    m_xMax = xMax;
    m_yMin = yMin;
    m_yMax = yMax;
    m_PIDEnable = doPID;
    m_PIDX = new BasicPID();
    m_PIDY = new BasicPID();
  }
  public double getCurrentX() {
    return m_currentAngleX;
  }
  public double getCurrentY() {
    return m_currentAngleY;
  }
  // public void setTargetX(double x) {
  //   m_targetAngleX = Math.max(Math.min(x, m_xMax), m_xMin);//limit input to -360 and 360
  // }
  // public void setTargetY(double y) {
  //   m_targetAngleY = Math.max(Math.min(y, m_yMax), m_yMin);//limit input to -360 and 360
  // }
  protected void setCurrentX(double x) {
    m_currentAngleX = x;
  }
  protected void setCurrentY(double y) {
    m_currentAngleY = y;
  }
  public void setShoot(double speed) {
    m_shoot = speed;
  }
  abstract protected void shoot(double velocity);
  abstract public void rotateX(double x);
  abstract public void rotateY(double y);
  @Override
  public void doActions() {
    if(m_PIDEnable) {
      m_PIDX.setPosition(m_currentAngleX);
      m_PIDX.setTarget(m_targetAngleX);
      m_PIDY.setPosition(m_currentAngleY);
      m_PIDY.setTarget(m_targetAngleY);
      rotateX(m_PIDX.calculateError());
      rotateY(m_PIDY.calculateError());
    }
    shoot(m_shoot);
  }
}
