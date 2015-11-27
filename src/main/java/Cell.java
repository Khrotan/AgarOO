import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Cell extends Entity
{
    private String name;
    private int foodEaten;
    private int cellsSwallowed;

    public void addMass( double additionalMass )
    {
        super.setMass( super.getMass() + additionalMass );
    }

    public void removeMass( double toBeDeletedMass )
    {
        super.setMass( super.getMass() - toBeDeletedMass );
    }

    public String getName()
    {
        return name;
    }

    void setName( String name )
    {
        this.name = name;
    }

    public int getFoodEaten()
    {
        return foodEaten;
    }

    public void setFoodEaten( int foodEaten )
    {
        this.foodEaten = foodEaten;
    }

    public int getCellsSwallowed()
    {
        return cellsSwallowed;
    }

    void setCellsSwallowed( int cellsSwallowed )
    {
        this.cellsSwallowed = cellsSwallowed;
    }

    public void draw( Graphics2D g2d )
    {
        g2d.setPaint( this.getColor() );
        g2d.draw( new Ellipse2D.Double( this.getDrawLocation().getX(), this.getDrawLocation().getY(), getMass(), getMass() ) );
    }

    @Override
    public void calculateAndSetCenterVector()
    {
        this.getCenterLocation().setX( this.getDrawLocation().getX() + getMass() / 2 );
        this.getCenterLocation().setY( this.getDrawLocation().getY() + getMass() / 2 );
    }
}