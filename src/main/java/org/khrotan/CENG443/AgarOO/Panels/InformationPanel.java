package org.khrotan.CENG443.AgarOO.Panels;

import org.khrotan.CENG443.AgarOO.Constants;
import org.khrotan.CENG443.AgarOO.Entities.Cell;
import org.khrotan.CENG443.AgarOO.Environment;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;


public class InformationPanel extends JPanel
{
    private final Environment env;

    public InformationPanel( Environment env )
    {
        //TODO: choose appropriate value
        this.setSize( Constants.LEFT_PANEL_WIDTH, Constants.WINDOWS_HEIGHT / 2 );
        this.setBackground( Color.LIGHT_GRAY );

        this.env = env;
    }

    public Dimension getPreferredSize()
    {
        return null;
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint( g );

        Graphics2D g2d = (Graphics2D) g;

        // StepCount:
        g2d.setPaint( Color.RED );
        g2d.drawString( "Step: " + env.getNumberOfSteps(), 4, 12 );

        // Cells:
        g2d.setPaint( Color.BLACK );
        g2d.drawString( "Cells: " + env.getCellEntities().size(), Constants.LEFT_PANEL_WIDTH - 50, 12 );

        // Leaderboard
        g2d.setPaint( Color.MAGENTA );
        g2d.drawString( "LEADERBOARD", Constants.LEFT_PANEL_WIDTH / 3, Constants.WINDOWS_HEIGHT * ( 0.05f ) );

        // Properties
        g2d.setPaint( Color.BLUE );

        g2d.drawString( "Name", Constants.LEFT_PANEL_WIDTH * ( 0.01f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT );
        g2d.drawString( "Mass", Constants.LEFT_PANEL_WIDTH * ( 0.25f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT );
        g2d.drawString( "HMass", Constants.LEFT_PANEL_WIDTH * ( 0.42f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT );
        g2d.drawString( "Spd", Constants.LEFT_PANEL_WIDTH * ( 0.62f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT );
        g2d.drawString( "Fd", Constants.LEFT_PANEL_WIDTH * ( 0.73f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT );
        g2d.drawString( "C", Constants.LEFT_PANEL_WIDTH * ( 0.83f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT );
        g2d.drawString( "St", Constants.LEFT_PANEL_WIDTH * ( 0.92f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT );


        g2d.setFont( new Font( "TimesRoman", Font.PLAIN, 9 ) );

        for ( int i = 0; i < env.getCellEntities().size(); i++ )
        {
            Cell cell = env.getCellEntities().get( i );

            g2d.drawString( cell.getName(), Constants.LEFT_PANEL_WIDTH * ( 0.01f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT + ( i + 1 ) * 20 );
            g2d.drawString( new DecimalFormat( "#0.00" ).format( cell.getMass() ), Constants.LEFT_PANEL_WIDTH * ( 0.25f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT + ( i + 1 ) * 20 );
            g2d.drawString( new DecimalFormat( "#0.00" ).format( cell.getHighestMass() ), Constants.LEFT_PANEL_WIDTH * ( 0.42f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT + ( i + 1 ) * 20 );
            g2d.drawString( new DecimalFormat( "#0.00" ).format( cell.getSpeed() ), Constants.LEFT_PANEL_WIDTH * ( 0.62f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT + ( i + 1 ) * 20 );
            g2d.drawString( Integer.toString( cell.getFoodEaten() ), Constants.LEFT_PANEL_WIDTH * ( 0.73f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT + ( i + 1 ) * 20 );
            g2d.drawString( Integer.toString( cell.getCellsSwallowed() ), Constants.LEFT_PANEL_WIDTH * ( 0.83f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT + ( i + 1 ) * 20 );
            g2d.drawString( cell.getStrategy().getName(), Constants.LEFT_PANEL_WIDTH * ( 0.92f ), Constants.LEADERBOARD_PROPERTIES_HEIGHT + ( i + 1 ) * 20 );
        }
    }
}
