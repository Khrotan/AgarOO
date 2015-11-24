import java.awt.*;

public abstract class Entity
{
    public StepStrategy strategy;
    private Color color;
    private double mass;
    private double speed;
    private Vector direction;
    private Vector drawLocation;
    private Vector centerLocation;

    public abstract void draw( Graphics2D g2d );

    public abstract void calculateAndSetCenterVector();

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

    public void step()
    {
        this.getStrategy().step( this );
        this.calculateAndSetCenterVector();
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
