package org.khrotan.CENG443.AgarOO.Entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Sugar extends Food
{
    private int sideHalfLength;

    public void draw( Graphics2D g2d )
    {
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setPaint( getColor() );
        g2d.draw( new Rectangle2D.Double( (int) this.getDrawLocation().getX(), (int) this.getDrawLocation().getY(), this.getSideHalfLength(), this.getSideHalfLength() ) );
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
