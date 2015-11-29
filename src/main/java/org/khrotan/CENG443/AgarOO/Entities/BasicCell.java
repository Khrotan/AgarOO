package org.khrotan.CENG443.AgarOO.Entities;

import org.khrotan.CENG443.AgarOO.Constants;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.text.DecimalFormat;

public class BasicCell extends Cell
{
    public BasicCell( String name )
    {
        setName( name );

        //TODO: choose an appropriate speed value
        setSpeed( Constants.BASIC_CELL_INITIAL_SPEED );
        setColor( RandomFactory.generateTransparentColor() );

        setMass( Constants.BASIC_CELL_INITIAL_MASS );

        //TODO: radius

        calculateRadius();
    }

    @Override
    public void draw( Graphics2D g2d )
    {
        g2d.setPaint( this.getColor() );

        // TODO: choose an appropriate algorithm for radius
        g2d.fill( new Ellipse2D.Double( getDrawLocation().getX(), getDrawLocation().getY(), getMass(), getMass() ) );

        // Line
        g2d.setPaint( this.getColor().darker() );
        g2d.setStroke( new BasicStroke( 3 ) );
        g2d.drawLine( (int) this.getCenterLocation().getX(), (int) this.getCenterLocation().getY(), (int) ( this.getCenterLocation().getX() + ( getMass() / 2 ) * getDirection().getX() ), (int) ( this.getCenterLocation().getY() + ( getMass() / 2 ) * getDirection().getY() ) );

        // Food Eaten - Cells Swallowed
        g2d.setPaint( Color.BLACK );
        g2d.drawString( Integer.toString( this.getFoodEaten() ) + " - " + Integer.toString( this.getCellsSwallowed() ), (float) this.getCenterLocation().getX() - 10, (float) this.getCenterLocation().getY() - 20 );

        // Mass
        g2d.setPaint( Color.BLUE );
        g2d.drawString( new DecimalFormat( "#0.00" ).format( this.getMass() ), (float) this.getCenterLocation().getX() - 10, (float) this.getCenterLocation().getY() - 10 );

        // Name
        g2d.setPaint( Color.BLACK );
        g2d.drawString( this.getName(), (float) this.getCenterLocation().getX() - 20, (float) this.getCenterLocation().getY() );

        // Strategy
        g2d.setPaint( Color.RED );
        g2d.drawString( this.getStrategy().getName(), (float) this.getCenterLocation().getX() - 10, (float) this.getCenterLocation().getY() + 10 );

        // Strategy turn number
        g2d.setPaint( Color.BLACK );
        g2d.drawString( Integer.toString( this.getStrategy().getNumberOfTurns() ), (float) this.getCenterLocation().getX() - 10, (float) this.getCenterLocation().getY() + 20 );
    }
}
