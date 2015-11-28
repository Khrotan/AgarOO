package org.khrotan.CENG443.AgarOO.Panels;

import org.khrotan.CENG443.AgarOO.Constants;
import org.khrotan.CENG443.AgarOO.Environment;

import javax.swing.*;
import java.awt.*;


public class InformationPanel extends JPanel
{
    public InformationPanel( Environment env )
    {
        //TODO: choose appropriate value
        this.setSize( Constants.LEFT_PANEL_WIDTH, Constants.WINDOWS_HEIGHT / 2 );
        this.setBackground( Color.LIGHT_GRAY );
    }

    public Dimension getPreferredSize()
    {
        return null;
    }

    public void refreshInformation()
    {

    }
}
