package org.khrotan.CENG443.AgarOO.CellDecorators;

import org.khrotan.CENG443.AgarOO.Entities.Cell;

import java.awt.*;

public class Evader extends CellDecorator
{
    private final Cell decoratedCell;

    public Evader( Cell cell )
    {
        super( cell );
        decoratedCell = cell;
    }

    public void draw( Graphics2D g2d )
    {
        decoratedCell.draw( g2d );
        g2d.setPaint( Color.BLUE );
        g2d.drawOval( (int) ( this.getCenterLocation().getX() - ( this.getMass() / 4 ) ), (int) ( this.getCenterLocation().getY() - ( this.getMass() / 4 ) ), (int) this.getMass() / 2, (int) this.getMass() / 2 );
    }
}
