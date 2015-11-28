package org.khrotan.CENG443.AgarOO.Entities;

public abstract class Cell extends Entity
{
    protected String name;
    private int foodEaten;
    private int cellsSwallowed;
    private double radius;

    public void addMass( double additionalMass )
    {
        super.setMass( super.getMass() + additionalMass );
    }

    public void removeMass( double toBeDeletedMass )
    {
        super.setMass( super.getMass() - toBeDeletedMass );
    }

    public void calculateRadius()
    {
        radius = Math.sqrt( 100 * getMass() / Math.PI );
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius( double radius )
    {
        this.radius = radius;
    }

    public String getName()
    {
        return name;
    }

    protected void setName( String name )
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

    public void setCellsSwallowed( int cellsSwallowed )
    {
        this.cellsSwallowed = cellsSwallowed;
    }

    @Override
    public void calculateAndSetCenterVector()
    {
        this.getCenterLocation().setX( this.getDrawLocation().getX() + getMass() / 2 );
        this.getCenterLocation().setY( this.getDrawLocation().getY() + getMass() / 2 );
    }
}