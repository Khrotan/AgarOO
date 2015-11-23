import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BasicCell extends Cell
{
    public BasicCell( String name )
    {
        setCellsSwallowed( 0 );
        //TODO: choose an appropriate speed value
        setSpeed( 5 );
        setColor( RandomFactory.generateTransparentColor() );
        //TODO: choose an appropriate mass value
        setMass( 60 );
        setFoodEaten( 0 );
        setCellsSwallowed( 0 );
        setName( name );
    }

    @Override
    public void draw( Graphics2D g2d )
    {
        g2d.setPaint( this.getColor() );
        g2d.fill( new Ellipse2D.Double( getLocation().getX(), getLocation().getY(), getMass(), getMass() ) );
        g2d.setPaint( new Color( this.getColor().getRGB() ) );
        g2d.drawString( this.getName(), (int) getLocation().getX(), (int) getLocation().getY() );
    }
}
