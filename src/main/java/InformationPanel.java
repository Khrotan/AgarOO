import javax.swing.*;
import java.awt.*;


public class InformationPanel extends JPanel
{
    public InformationPanel( Environment env )
    {
        //TODO: choose appropriate value
        this.setSize( 256, 384 );
        this.setBackground( Color.LIGHT_GRAY );
    }

    public Dimension getPreferredSize()
    {
        return null;
    }

    public void RefreshInformation()
    {

    }
}
