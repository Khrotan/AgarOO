import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class LogoPanel extends JPanel
{
    private final BufferedImage logo;

    public LogoPanel( Environment env, BufferedImage logo )
    {
        this.logo = logo;
        //TODO: choose appropriate value
        this.setSize( 256, 384 );
        this.setBackground( Color.black );
        this.setBounds( 0, 384, 256, 384 );
    }

    @Override
    public void paintComponent( Graphics g )
    {
        g.drawImage( logo, 0, 0, null );
    }
}
