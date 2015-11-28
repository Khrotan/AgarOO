package org.khrotan.CENG443.AgarOO.Panels;

import org.khrotan.CENG443.AgarOO.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class LogoPanel extends JPanel
{
    private final BufferedImage logo;

    public LogoPanel( BufferedImage logo )
    {
        this.logo = logo;
        //TODO: choose appropriate value
        this.setSize( Constants.LEFT_PANEL_WIDTH, Constants.WINDOWS_HEIGHT / 2 );
        this.setBackground( Color.black );
        this.setBounds( 0, Constants.WINDOWS_HEIGHT / 2, Constants.LEFT_PANEL_WIDTH, Constants.WINDOWS_HEIGHT / 2 );
    }

    @Override
    public void paintComponent( Graphics g )
    {
        g.drawImage( logo, 0, 0, null );
    }
}
