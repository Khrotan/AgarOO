package CENG443.AgarOO;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Sugar extends Food
{
    private int sideHalfLength;

    public void draw( Graphics2D g2d )
    {
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setPaint( getColor() );
        g2d.draw( new Rectangle2D.Double( (int) this.getLocation().getX(), (int) this.getLocation().getY(), this.getSideHalfLength(), this.getSideHalfLength() ) );
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
