package org.khrotan.CENG443.AgarOO.Entities;

import java.awt.*;

public class Vector
{
    private double x;
    private double y;

    public Vector( double x, double y )
    {
        this.x = x;
        this.y = y;
    }

    public Vector( Dimension d )
    {
        this.x = d.getWidth();
        this.y = d.getHeight();
    }

    public void normalize()
    {
        double length = Math.sqrt( Math.pow( this.x, 2 ) + Math.pow( this.y, 2 ) );
        this.x = x / length;
        this.y = y / length;
    }

    public double distanceTo( Vector other )
    {
        return Math.sqrt( Math.pow( other.getX() - this.getX(), 2 ) + Math.pow( other.getY() - this.getY(), 2 ) );
    }

    public double getX()
    {
        return x;
    }

    public void setX( double x )
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY( double y )
    {
        this.y = y;
    }
}