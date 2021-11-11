package frc.robot.biblioteca;
import java.util.ArrayList;
public class RoboBaseClass {
    private static ArrayList<RoboBaseClass> m_allParts = new ArrayList<RoboBaseClass>();
    public RoboBaseClass() {
        RoboBaseClass.addPart(this);
    }
    public void gatherInfo() {}
    public void doActions() {}
    public static void addPart(RoboBaseClass e) {
        RoboBaseClass.m_allParts.add(e);
    }
    public static ArrayList<RoboBaseClass> getParts() {
        return (m_allParts);
    }
    public static void gatherInfoAll() {
        for ( RoboBaseClass r : RoboBaseClass.getParts() ) {
            r.gatherInfo();
        }
    }
    public static void doActionsAll() {
        for ( RoboBaseClass r : RoboBaseClass.getParts() ) {
            r.doActions();
        }
    }
}
