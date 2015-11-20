import javax.swing.*;
import java.awt.*;


public class ApplicationWindow extends JFrame
{
    // TODO: make an appropriate layout, place panels in that layout

    public LogoPanel logoPanel;
    public InformationPanel informationPanel;
    public GameDisplayPanel gameDisplayPanel;

    public ApplicationWindow( LogoPanel logoPanel, InformationPanel informationPanel, GameDisplayPanel gameDisplayPanel ) throws HeadlessException
    {
        super();

        this.logoPanel = logoPanel;
        this.informationPanel = informationPanel;
        this.gameDisplayPanel = gameDisplayPanel;

        this.setTitle( "Agar.OO" );
    }
}
