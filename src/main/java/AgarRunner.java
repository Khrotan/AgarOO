import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class AgarRunner
{
    private Environment environment;
    private LogoPanel logoPanel;
    private InformationPanel informationPanel;
    private GameDisplayPanel gameDisplayPanel;
    private ApplicationWindow applicationWindow;
    private BufferedImage logo;
    {
        try
        {
            setLogo( ImageIO.read( new File( "src/main/resources/Logo.bmp" ) ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    private AgarRunner()
    {
        setEnvironment( new Environment( 1024, 768 ) );

        setLogoPanel( new LogoPanel( environment, logo ) );
        setInformationPanel( new InformationPanel( getEnvironment() ) );
        setGameDisplayPanel( new GameDisplayPanel( getEnvironment() ) );

        setApplicationWindow( new ApplicationWindow( getLogoPanel(), getInformationPanel(), getGameDisplayPanel() ) );

        getApplicationWindow().setVisible( true );

        getLogoPanel().setVisible( true );
        getInformationPanel().setVisible( true );
        getGameDisplayPanel().setVisible( true );
    }

    public static void main( String[] args ) throws InterruptedException
    {
        AgarRunner agarRunner;
        agarRunner = new AgarRunner();

        SugarFactory sugarFactory = new SugarFactory();
        OrganismFactory organismFactory = new OrganismFactory();

        agarRunner.getEnvironment().initializeEnvironment( sugarFactory, organismFactory );

        while ( true )
        {
            agarRunner.getEnvironment().stepAll();
            agarRunner.getApplicationWindow().repaint();
            Thread.sleep( 50 );
        }
    }

    private Environment getEnvironment()
    {
        return environment;
    }

    private void setEnvironment( Environment environment )
    {
        this.environment = environment;
    }

    public BufferedImage getLogo()
    {
        return logo;
    }

    private void setLogo( BufferedImage logo )
    {
        this.logo = logo;
    }

    private LogoPanel getLogoPanel()
    {
        return logoPanel;
    }

    private void setLogoPanel( LogoPanel logoPanel )
    {
        this.logoPanel = logoPanel;
    }

    private InformationPanel getInformationPanel()
    {
        return informationPanel;
    }

    private void setInformationPanel( InformationPanel informationPanel )
    {
        this.informationPanel = informationPanel;
    }

    private GameDisplayPanel getGameDisplayPanel()
    {
        return gameDisplayPanel;
    }

    private void setGameDisplayPanel( GameDisplayPanel gameDisplayPanel )
    {
        this.gameDisplayPanel = gameDisplayPanel;
    }

    private ApplicationWindow getApplicationWindow()
    {
        return applicationWindow;
    }

    private void setApplicationWindow( ApplicationWindow applicationWindow )
    {
        this.applicationWindow = applicationWindow;
    }
}
