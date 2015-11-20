import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class LogoPanel extends JPanel
{
    public BufferedImage logo;

    public LogoPanel( Environment env, BufferedImage logo )
    {
        this.logo = logo;
    }

    public Dimension getPreferredSize()
    {
        return null;
    }
}
