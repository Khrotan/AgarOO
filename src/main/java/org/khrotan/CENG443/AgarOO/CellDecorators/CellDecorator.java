package org.khrotan.CENG443.AgarOO.CellDecorators;

import org.khrotan.CENG443.AgarOO.Entities.Cell;
import org.khrotan.CENG443.AgarOO.Entities.Vector;
import org.khrotan.CENG443.AgarOO.StepStrategies.StepStrategy;

import java.awt.*;

public abstract class CellDecorator extends Cell
{
    private final Cell decoratedCell;

    CellDecorator( Cell cell )
    {
        this.decoratedCell = cell;
        this.setName( cell.getName() );
        this.setFoodEaten( cell.getFoodEaten() );
        this.setCellsSwallowed( cell.getCellsSwallowed() );
        this.setStrategy( cell.getStrategy() );
        this.setColor( cell.getColor() );
        this.setMass( cell.getMass() );
        this.setSpeed( cell.getSpeed() );
        this.setDirection( cell.getDirection() );
        this.setDrawLocation( cell.getDrawLocation() );
        this.setCenterLocation( cell.getCenterLocation() );
    }

    public abstract void draw( Graphics2D g2d );

    private Cell getDecoratedCell()
    {
        return decoratedCell;
    }

    @Override
    public void addMass( double additionalMass )
    {
        super.addMass( additionalMass );
        decoratedCell.addMass( additionalMass );
    }

    @Override
    public void removeMass( double toBeDeletedMass )
    {
        super.removeMass( toBeDeletedMass );
        decoratedCell.removeMass( toBeDeletedMass );
    }

    @Override
    public void setStrategy( StepStrategy strategy )
    {
        super.setStrategy( strategy );
        decoratedCell.setStrategy( strategy );
    }

    @Override
    public void setSpeed( double speed )
    {
        super.setSpeed( speed );
        decoratedCell.setSpeed( speed );
    }

    @Override
    public void setMass( double mass )
    {
        super.setMass( mass );
        decoratedCell.setMass( mass );
    }

    @Override
    public void setColor( Color color )
    {
        super.setColor( color );
        decoratedCell.setColor( color );
    }

    @Override
    public void setCellsSwallowed( int cellsSwallowed )
    {
        super.setCellsSwallowed( cellsSwallowed );
        decoratedCell.setCellsSwallowed( cellsSwallowed );
    }

    @Override
    public void setFoodEaten( int foodEaten )
    {
        super.setFoodEaten( foodEaten );
        decoratedCell.setFoodEaten( foodEaten );
    }

    @Override
    public void setDirection( Vector direction )
    {
        super.setDirection( direction );
        decoratedCell.setDirection( direction );
    }

    @Override
    public void setDrawLocation( Vector drawLocation )
    {
        super.setDrawLocation( drawLocation );
        decoratedCell.setDrawLocation( drawLocation );
    }

    @Override
    public void setCenterLocation( Vector centerLocation )
    {
        super.setCenterLocation( centerLocation );
        decoratedCell.setCenterLocation( centerLocation );
    }
}
