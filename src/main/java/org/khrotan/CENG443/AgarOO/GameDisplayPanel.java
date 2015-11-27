package org.khrotan.CENG443.AgarOO;

import javax.swing.*;
import java.awt.*;

public class GameDisplayPanel extends JPanel
{
    private final Environment environmentReference;

    public GameDisplayPanel( Environment environment )
    {
        environmentReference = environment;
        //TODO: choose appropriate value
        this.setSize( 768, 768 );
        this.setBounds( 256, 0, 768, 768 );
    }

    @Override
    public Dimension getPreferredSize()
    {
        return null;
    }

    @Override
    public void paintComponent( Graphics g )
    {
        Graphics2D g2 = (Graphics2D) g;

        for ( Entity entity : environmentReference.getFoodEntities() )
        {
            entity.draw( g2 );
        }

        for ( Entity entity : environmentReference.getCellEntities() )
        {
            entity.draw( g2 );
        }
    }
}
