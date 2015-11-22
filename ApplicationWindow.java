import javax.swing.*;
import java.awt.*;


public class ApplicationWindow extends JFrame
{
    // TODO: make an appropriate layout, place panels in that layout

    public LogoPanel logoPanel;
    public InformationPanel informationPanel;
    public GameDisplayPanel gameDisplayPanel;

    private GridLayout gridLayout;

    public ApplicationWindow( LogoPanel logoPanel, InformationPanel informationPanel, GameDisplayPanel gameDisplayPanel ) throws HeadlessException
    {
        super();

        this.logoPanel = logoPanel;
        this.informationPanel = informationPanel;
        this.gameDisplayPanel = gameDisplayPanel;

        this.setTitle( "Agar.OO" );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        this.setLayout( null );
        this.add( logoPanel );
        this.add( informationPanel );
        this.add( gameDisplayPanel );
        this.setSize( new Dimension( 1024, 768 ) );
        this.setResizable( false );
    }

    public void repaintWindow()
    {
        logoPanel.repaint();
        informationPanel.repaint();
        gameDisplayPanel.repaint();
    }
}
