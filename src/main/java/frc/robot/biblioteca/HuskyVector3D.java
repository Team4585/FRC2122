package frc.robot.biblioteca;

public class HuskyVector3D {

    private double m_x;
    private double m_y;
    private double m_z;
    private double m_equalTreshold = 0.0;

    public HuskyVector3D(double InitX, double InitY, double InitZ)
    {
        m_x = InitX;
        m_y = InitY;
        m_z = InitZ;
    }

    public HuskyVector3D()
    {
        this(0.0, 0.0, 0.0);
    }

    public HuskyVector3D(HuskyVector3D Orig)
    {
        m_x = Orig.getX();
        m_y = Orig.getY();
        m_z = Orig.getZ();
    }


    public double getX() { return m_x; }
    public void setX(double NewX) { m_x = NewX; }
    public double getY() { return m_y; }
    public void setY(double NewY) { m_y = NewY; }
    public double getZ() { return m_z; }
    public void setZ(double NewZ) { m_z = NewZ; }
    public double GetEqualThreshold() { return m_equalTreshold; }
    public void SetEqualThreshold(double NewThresh) { m_equalTreshold = NewThresh; }

    public void SetVals(double NewX, double NewY, double NewZ)
    {
        setX(NewX);
        setY(NewY);
        setZ(NewY);
    }

    public void SetVals(HuskyVector3D OtherVec)
    {
        setX(OtherVec.getX());
        setY(OtherVec.getY());
        setZ(OtherVec.getZ());
    }

    public double GetMagnitude()
    {
        return Math.sqrt((m_x * m_x) + (m_y * m_y) + (m_z * m_z));
    }

    public void AddVec(HuskyVector3D OtherVec)
    {
        setX(getX() + OtherVec.getX());
        setY(getY() + OtherVec.getY());
        setZ(getZ() + OtherVec.getZ());
    }

    public void SubVec(HuskyVector3D OtherVec)
    {
        setX(getX() - OtherVec.getX());
        setY(getY() - OtherVec.getY());
        setZ(getZ() - OtherVec.getZ());
    }

    public double DistanceTo(HuskyVector3D OtherVec)
    {
        double DeltaX = OtherVec.getX() - getX();
        double DeltaY = OtherVec.getY() - getY();
        double DeltaZ = OtherVec.getZ() - getZ();
        double RawDist = Math.sqrt((DeltaX * DeltaX) + (DeltaY * DeltaY) + (DeltaZ * DeltaZ));
        return (RawDist <= m_equalTreshold) ? 0.0 : RawDist;
    }

    public HuskyVector3D VectorTo(HuskyVector3D OtherVec)
    {
        HuskyVector3D WorkVec = new HuskyVector3D(OtherVec);
        WorkVec.SubVec(this);
        return WorkVec;
    }


    // return the angle from the head of the vector to the head of the other vector
    public double AngleToXY(HuskyVector3D OtherVec)
    {
        HuskyVector3D WorkVec = VectorTo(OtherVec);
        return Math.toDegrees(Math.atan2(WorkVec.getX(), WorkVec.getY()));
    }
    public double AngleToXZ(HuskyVector3D OtherVec)
    {
        HuskyVector3D WorkVec = VectorTo(OtherVec);
        return Math.toDegrees(Math.atan2(WorkVec.getX(), WorkVec.getZ()));
    }
    public double AngleToYZ(HuskyVector3D OtherVec)
    {
        HuskyVector3D WorkVec = VectorTo(OtherVec);
        return Math.toDegrees(Math.atan2(WorkVec.getY(), WorkVec.getZ()));
    }
    @Override
    public String toString() {
        String result = "("+m_x+", "+m_y+", "+m_z+")";
        return result;
    }

}
