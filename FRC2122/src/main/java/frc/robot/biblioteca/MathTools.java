package frc.robot.biblioteca;

public final class MathTools {
    public static double normalizeAngleDegrees(double angle) {
        double newAngle = angle;
        while (newAngle <= -180) newAngle += 360;
        while (newAngle > 180) newAngle -= 360;
        return newAngle;
    }
}