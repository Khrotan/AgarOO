import java.awt.*;

public abstract class Entity
{
    public StepStrategy strategy;
    private Color color;
    private double mass;
    private double speed;
    private Vector direction;
    private Vector location;

    public abstract void draw( Graphics2D g2d );

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

    public Vector getLocation()
    {
        return location;
    }

    public void setLocation( Vector location )
    {
        this.location = location;
    }

    public void step()
    {
        this.getStrategy().step( this );
    }
}
