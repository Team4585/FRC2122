package frc.robot.biblioteca;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
public class LimeLightCamera extends RoboBaseClass {
     private NetworkTable table;
     private NetworkTableEntry m_tx;//Horizontal Offset From Crosshair To Target (-29.8 to 29.8 degrees)
     private NetworkTableEntry m_ty;//Vertical Offset From Crosshair To Target (-24.85 to 24.85 degrees)
     private NetworkTableEntry m_ta;//Target Area (0% of image to 100% of image)
     private double m_xDistance;
     private double m_yDistance;
     private double m_area;
     private LimeLightCameraMode m_cameraMode;
     public LimeLightCamera() {
          table = NetworkTableInstance.getDefault().getTable("limelight");
          m_tx = table.getEntry("tx");
          m_ty = table.getEntry("ty");
          m_ta = table.getEntry("ta");
     }
     @Override
     public void gatherInfo() {
          m_xDistance = m_tx.getDouble(0.0);
          m_yDistance = m_ty.getDouble(0.0);
          m_area = m_ta.getDouble(0.0);
     }
     
     public double getXDistance() {
          return m_xDistance;
     }
     public double getYDistance() {
          return m_yDistance;
     }
     public double getArea() {
          return m_area;
     }
     
     public void setLimeLightCameraMode(LimeLightCameraMode mode) {
          m_cameraMode = mode;
          if(mode == LimeLightCameraMode.ROBOTVISION) {
               table.getEntry("camMode").setNumber(0);
          } else {
               table.getEntry("camMode").setNumber(1);
          }
     }
     public void setLimeLightCameraMode(int mode) {
          table.getEntry("camMode").setNumber(mode);
     }
     public LimeLightCameraMode getLimeLightCameraMode() {
          return m_cameraMode;
     }
}
