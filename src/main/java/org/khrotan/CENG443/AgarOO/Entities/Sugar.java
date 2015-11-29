package org.khrotan.CENG443.AgarOO.Entities;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Sugar extends Food
{
    private int sideHalfLength;

    public void draw( Graphics2D g2d )
    {
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setPaint( getColor() );

        AffineTransform old = g2d.getTransform();

        g2d.translate( this.getDrawLocation().getX(), this.getDrawLocation().getY() );
        g2d.rotate( this.hashCode() % 360 );


        g2d.drawRect( 0, 0, sideHalfLength, sideHalfLength );
        g2d.setTransform( old );

    }

    @Override
    public void calculateAndSetCenterVector()
    {
        this.getCenterLocation().setX( this.getDrawLocation().getX() + getSideHalfLength() / 2 );
        this.getCenterLocation().setY( this.getDrawLocation().getY() + getSideHalfLength() / 2 );
    }

    public int getSideHalfLength()
    {
        return sideHalfLength;
    }

    public void setSideHalfLength( int sideHalfLength )
    {
        this.sideHalfLength = sideHalfLength;
    }
}
