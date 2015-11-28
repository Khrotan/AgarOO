package org.khrotan.CENG443.AgarOO.CellDecorators;

import org.khrotan.CENG443.AgarOO.Entities.Cell;

import java.awt.*;

public class Hunter extends CellDecorator
{
    private final Cell decoratedCell;

    public Hunter( Cell cell )
    {
        super( cell );
        decoratedCell = cell;
    }

    public void draw( Graphics2D g2d )
    {
        decoratedCell.draw( g2d );
        g2d.setPaint( Color.RED );
        g2d.drawOval( (int) ( this.getCenterLocation().getX() - ( this.getMass() * ( 0.375 ) ) ), (int) ( this.getCenterLocation().getY() - ( this.getMass() * ( 0.375 ) ) ), (int) ( this.getMass() * ( 0.75 ) ), (int) ( this.getMass() * ( 0.75 ) ) );
    }
}
