package org.khrotan.CENG443.AgarOO.Entities;

import org.khrotan.CENG443.AgarOO.Constants;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BasicCell extends Cell
{
    public BasicCell( String name )
    {
        setName( name );

        //TODO: choose an appropriate speed value
        setSpeed( Constants.BASIC_CELL_INITIAL_SPEED );
        setColor( RandomFactory.generateTransparentColor() );

        //TODO: choose an appropriate mass value
        setMass( Constants.BASIC_CELL_INITIAL_MASS );

        calculateRadius();
    }

    @Override
    public void draw( Graphics2D g2d )
    {
        g2d.setPaint( this.getColor() );
        // TODO: choose an appropriate algorithm for radius
        g2d.fill( new Ellipse2D.Double( getDrawLocation().getX(), getDrawLocation().getY(), getMass(), getMass() ) );

        g2d.setPaint( Color.BLACK );
        g2d.drawString( this.getName(), (float) this.getCenterLocation().getX() - 20, (float) this.getCenterLocation().getY() );

        g2d.setPaint( Color.RED );
        g2d.drawString( this.getStrategy().getName(), (float) this.getCenterLocation().getX() - 10, (float) this.getCenterLocation().getY() + 10 );

        g2d.setPaint( Color.BLACK );
        g2d.drawString( Integer.toString( this.getStrategy().getNumberOfTurns() ), (float) this.getCenterLocation().getX() - 10, (float) this.getCenterLocation().getY() + 20 );
    }
}
