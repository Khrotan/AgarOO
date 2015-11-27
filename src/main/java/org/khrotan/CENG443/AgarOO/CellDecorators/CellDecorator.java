package org.khrotan.CENG443.AgarOO.CellDecorators;

import org.khrotan.CENG443.AgarOO.Cell;

import java.awt.*;

public abstract class CellDecorator extends Cell
{
    private final Cell decoratedCell;

    CellDecorator( Cell cell )
    {
        decoratedCell = cell;
    }

    public void draw( Graphics2D g2d )
    {

    }
}
