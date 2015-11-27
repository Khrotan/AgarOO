import javax.swing.*;
import java.awt.*;


class ApplicationWindow extends JFrame
{
    private LogoPanel logoPanel;
    private InformationPanel informationPanel;
    private GameDisplayPanel gameDisplayPanel;

    public ApplicationWindow( LogoPanel logoPanel, InformationPanel informationPanel, GameDisplayPanel gameDisplayPanel ) throws HeadlessException
    {
        super();

        this.setLogoPanel( logoPanel );
        this.setInformationPanel( informationPanel );
        this.setGameDisplayPanel( gameDisplayPanel );

        this.setTitle( "Agar.OO" );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        this.setLayout( null );
        this.add( logoPanel );
        this.add( informationPanel );
        this.add( gameDisplayPanel );
        this.setSize( new Dimension( 1024, 768 ) );
        this.setResizable( false );
    }

    @Override
    public void paintComponents( Graphics g )
    {
        super.paintComponents( g );
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
    }

    public LogoPanel getLogoPanel()
    {
        return logoPanel;
    }

    private void setLogoPanel( LogoPanel logoPanel )
    {
        this.logoPanel = logoPanel;
    }

    public InformationPanel getInformationPanel()
    {
        return informationPanel;
    }

    private void setInformationPanel( InformationPanel informationPanel )
    {
        this.informationPanel = informationPanel;
    }

    public GameDisplayPanel getGameDisplayPanel()
    {
        return gameDisplayPanel;
    }

    private void setGameDisplayPanel( GameDisplayPanel gameDisplayPanel )
    {
        this.gameDisplayPanel = gameDisplayPanel;
    }
}
