package frc.robot.biblioteca;
public class HuskyColor {
    private double m_red;
    private double m_green;
    private double m_blue;
    public HuskyColor(double red, double green, double blue) {
        m_red = Math.max(Math.min(red, 255), 0);
        m_green = Math.max(Math.min(green, 255), 0);
        m_blue = Math.max(Math.min(blue, 255), 0);
    }
    public double getRed() {
        return m_red;
    }
    public double getGreen() {
        return m_green;
    }
    public double getBlue() {
        return m_blue;
    }
    public String getColorAsHex() {
        return Integer.toHexString((int) Math.round(m_red))+Integer.toHexString((int) Math.round(m_green))+Integer.toHexString((int) Math.round(m_blue));
    }
    public static String colorRed = "FF0000";
    public static String colorGreen = "00FF00";
    public static String colorBlue = "0000FF";
}