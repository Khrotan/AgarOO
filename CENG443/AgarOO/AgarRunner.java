package CENG443.AgarOO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AgarRunner
{
    public Environment environment;
    public LogoPanel logoPanel;
    public InformationPanel informationPanel;
    public GameDisplayPanel gameDisplayPanel;
    public ApplicationWindow applicationWindow;
    private BufferedImage logo;

    {
        try
        {
            setLogo( ImageIO.read( new File( "CENG443/AgarOO/Logo.bmp" ) ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    public AgarRunner()
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
            agarRunner.applicationWindow.repaint();
            Thread.sleep( 150 );
        }
    }

    public Environment getEnvironment()
    {
        return environment;
    }

    public void setEnvironment( Environment environment )
    {
        this.environment = environment;
    }

    public BufferedImage getLogo()
    {
        return logo;
    }

    public void setLogo( BufferedImage logo )
    {
        this.logo = logo;
    }

    public LogoPanel getLogoPanel()
    {
        return logoPanel;
    }

    public void setLogoPanel( LogoPanel logoPanel )
    {
        this.logoPanel = logoPanel;
    }

    public InformationPanel getInformationPanel()
    {
        return informationPanel;
    }

    public void setInformationPanel( InformationPanel informationPanel )
    {
        this.informationPanel = informationPanel;
    }

    public GameDisplayPanel getGameDisplayPanel()
    {
        return gameDisplayPanel;
    }

    public void setGameDisplayPanel( GameDisplayPanel gameDisplayPanel )
    {
        this.gameDisplayPanel = gameDisplayPanel;
    }

    public ApplicationWindow getApplicationWindow()
    {
        return applicationWindow;
    }

    public void setApplicationWindow( ApplicationWindow applicationWindow )
    {
        this.applicationWindow = applicationWindow;
    }
}
