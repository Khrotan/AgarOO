import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Organism extends Food
{
    public double radius;

    public Organism( double radius )
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius( double radius )
    {
        this.radius = radius;
    }

    public void draw( Graphics2D g2d )
    {
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setPaint( this.getColor() );
        g2d.fill( new Ellipse2D.Double( this.getDrawLocation().getX(), this.getDrawLocation().getY(), getRadius(), getRadius() ) );
    }

    @Override
    public void calculateAndSetCenterVector()
    {
        this.getCenterLocation().setX( this.getDrawLocation().getX() + getRadius() / 2 );
        this.getCenterLocation().setY( this.getDrawLocation().getY() + getRadius() / 2 );
    }
}
