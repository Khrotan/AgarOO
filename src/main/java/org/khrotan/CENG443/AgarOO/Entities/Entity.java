package org.khrotan.CENG443.AgarOO.Entities;

import org.khrotan.CENG443.AgarOO.Constants;
import org.khrotan.CENG443.AgarOO.StepStrategies.StepStrategy;

import java.awt.*;

public abstract class Entity
{
    private StepStrategy strategy;
    private Color color;
    private double mass;
    private double speed;
    private Vector direction;
    private Vector drawLocation;
    private Vector centerLocation;

    public abstract void draw( Graphics2D g2d );

    protected abstract void calculateAndSetCenterVector();

    public void step()
    {
        this.getStrategy().step( this );
        this.calculateAndSetCenterVector();
        this.edgeControl();
    }

    private void edgeControl()
    {
        if ( this.getCenterLocation().getX() < 0 )
        {
            //TODO: radius
            this.getDrawLocation().setX( -this.getMass() / 2 );
        }

        //TODO: radius
        if ( this.getCenterLocation().getX() > ( Constants.WINDOWS_WIDTH ) )
        {
            //TODO: radius
            this.getDrawLocation().setX( Constants.WINDOWS_WIDTH - this.getMass() / 2 );
        }

        if ( this.getCenterLocation().getY() < 0 )
        {
            //TODO: radius
            this.getDrawLocation().setY( -this.getMass() / 2 );
        }

        if ( this.getCenterLocation().getY() > ( Constants.WINDOWS_HEIGHT ) )
        {
            //TODO: radius
            this.getDrawLocation().setY( Constants.WINDOWS_HEIGHT - this.getMass() / 2 );
        }
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor( Color color )
    {
        this.color = color;
    }

    public double getMass()
    {
        return mass;
    }

    public void setMass( double mass )
    {
        this.mass = mass;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed( double speed )
    {
        this.speed = speed;
    }

    public StepStrategy getStrategy()
    {
        return strategy;
    }

    public void setStrategy( StepStrategy strategy )
    {
        this.strategy = strategy;
    }

    public Vector getDirection()
    {
        return direction;
    }

    public void setDirection( Vector direction )
    {
        this.direction = direction;
    }

    public Vector getDrawLocation()
    {
        return drawLocation;
    }

    public void setDrawLocation( Vector drawLocation )
    {
        this.drawLocation = drawLocation;
    }

    public Vector getCenterLocation()
    {
        return centerLocation;
    }

    public void setCenterLocation( Vector centerLocation )
    {
        this.centerLocation = centerLocation;
    }
}
