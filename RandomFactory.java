import java.awt.*;
import java.util.ArrayList;


public class RandomFactory
{
    public ArrayList<String> metuCengNames;
    int windowWidth;
    int windowHeight;

    public RandomFactory( int windowWidth, int windowHeight )
    {
        this.metuCengNames = new ArrayList<>();
        this.metuCengNames.add( "AhmetOguz" );
        this.metuCengNames.add( "FerdaNur" );
        this.metuCengNames.add( "IsmailSengor" );
        this.metuCengNames.add( "Volkan" );
        this.metuCengNames.add( "Aysenur" );
        this.metuCengNames.add( "Tolga" );
        this.metuCengNames.add( "Ruken" );
        this.metuCengNames.add( "Nihan" );
        this.metuCengNames.add( "AliHikmet" );
        this.metuCengNames.add( "Seyda" );
        this.metuCengNames.add( "Veysi" );
        this.metuCengNames.add( "Sinan" );
        this.metuCengNames.add( "Pinar" );
        this.metuCengNames.add( "Murat" );
        this.metuCengNames.add( "Halit" );
        this.metuCengNames.add( "Ertan" );
        this.metuCengNames.add( "Atilla" );
        this.metuCengNames.add( "Faruk" );
        this.metuCengNames.add( "Yusuf" );
        this.metuCengNames.add( "Uluc" );
        this.metuCengNames.add( "Erol" );
        this.metuCengNames.add( "OnurTolga" );
        this.metuCengNames.add( "Cevat" );
        this.metuCengNames.add( "Sibel" );
        this.metuCengNames.add( "Selim" );
        this.metuCengNames.add( "IsmailHakki" );
        this.metuCengNames.add( "Gokturk" );
        this.metuCengNames.add( "Fatos" );
        this.metuCengNames.add( "AdnanTheBoss" );
        this.metuCengNames.add( "Asuman" );

        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }

    public String generateName()
    {
        return this.metuCengNames.get( (int) ( Math.random() * 29 ) );
    }

    public static Color generateColor()
    {
        return new Color( (int) ( Math.random() % 256 ), (int) ( Math.random() % 256 ), (int) ( Math.random() % 256 ) );
    }

    public Dimension generateDimension()
    {
        return new Dimension( (int) ( Math.random() * this.windowWidth ), (int) ( Math.random() * this.windowHeight ) );
    }
}
