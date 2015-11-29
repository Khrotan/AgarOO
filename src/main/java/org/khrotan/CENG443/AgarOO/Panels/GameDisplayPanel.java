package org.khrotan.CENG443.AgarOO.Panels;

import org.khrotan.CENG443.AgarOO.Constants;
import org.khrotan.CENG443.AgarOO.Entities.Cell;
import org.khrotan.CENG443.AgarOO.Environment;

import javax.swing.*;
import java.awt.*;

public class GameDisplayPanel extends JPanel
{
    private final Environment environmentReference;

    public GameDisplayPanel( Environment environment )
    {
        environmentReference = environment;
        this.setBounds( Constants.LEFT_PANEL_WIDTH, 0, Constants.WINDOWS_WIDTH - Constants.LEFT_PANEL_WIDTH, Constants.WINDOWS_HEIGHT );
        this.setSize( Constants.WINDOWS_WIDTH - Constants.LEFT_PANEL_WIDTH, Constants.WINDOWS_HEIGHT );
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension( Constants.WINDOWS_WIDTH - Constants.LEFT_PANEL_WIDTH, Constants.WINDOWS_HEIGHT );
    }

    @Override
    public void paintComponent( Graphics g )
    {
        Graphics2D g2d = (Graphics2D) g;

        for ( int i = 0; i < environmentReference.getFoodEntities().size(); i++ )
        {
            environmentReference.getFoodEntities().get( i ).draw( g2d );
        }

        for ( Cell cell : environmentReference.getCellEntities() )
        {
            cell.draw( g2d );
        }
    }
}
