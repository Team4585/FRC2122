package frc.robot.biblioteca;

public class HuskyVector2D {

    private double m_x;
    private double m_y;
    private double m_equalTreshold = 0.0;

    public HuskyVector2D(double InitX, double InitY)
    {
        m_x = InitX;
        m_y = InitY;
    }

    public HuskyVector2D()
    {
        this(0.0, 0.0);
    }

    public HuskyVector2D(HuskyVector2D Orig)
    {
        m_x = Orig.getX();
        m_y = Orig.getY();
    }


    public double getX() { return m_x; }
    public void setX(double NewX) { m_x = NewX; }
    public double getY() { return m_y; }
    public void setY(double NewY) { m_y = NewY; }
    public double GetEqualThreshold() { return m_equalTreshold; }
    public void SetEqualThreshold(double NewThresh) { m_equalTreshold = NewThresh; }

    public void SetVals(double NewX, double NewY)
    {
        setX(NewX);
        setY(NewY);
    }

    public void SetVals(HuskyVector2D OtherVec)
    {
        setX(OtherVec.getX());
        setY(OtherVec.getY());
    }

    public double GetMagnitude()
    {
        return Math.sqrt((m_x * m_x) + (m_y * m_y));
    }

    public void AddVec(HuskyVector2D OtherVec)
    {
        setX(getX() + OtherVec.getX());
        setY(getY() + OtherVec.getY());
    }

    public void SubVec(HuskyVector2D OtherVec)
    {
        setX(getX() - OtherVec.getX());
        setY(getY() - OtherVec.getY());
    }

    public double DistanceTo(HuskyVector2D OtherVec)
    {
        double DeltaX = OtherVec.getX() - getX();
        double DeltaY = OtherVec.getY() - getY();
        double RawDist = Math.sqrt((DeltaX * DeltaX) + (DeltaY * DeltaY));
        return (RawDist <= m_equalTreshold) ? 0.0 : RawDist;
    }

    public HuskyVector2D VectorTo(HuskyVector2D OtherVec)
    {
        HuskyVector2D WorkVec = new HuskyVector2D(OtherVec);
        WorkVec.SubVec(this);
        return WorkVec;
    }


    // return the angle from the head of the vector to the head of the other vector
    public double AngleTo(HuskyVector2D OtherVec)
    {
        HuskyVector2D WorkVec = VectorTo(OtherVec);
        return Math.toDegrees(Math.atan2(WorkVec.getX(), WorkVec.getY()));
    }

    public String toString() {
        return "("+getX()+", "+getY()+")";
    }


}
