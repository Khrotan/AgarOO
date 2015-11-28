package org.khrotan.CENG443.AgarOO.Factories;

import org.khrotan.CENG443.AgarOO.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class RandomFactory
{
    private final ArrayList<String> metuCengNames;
    private final Random random = new Random();

    public RandomFactory()
    {
        this.metuCengNames = new ArrayList<>();
        this.metuCengNames.add( "Ahmet Oguz Akyuz" );
        this.metuCengNames.add( "Ferda Nur Alpaslan" );
        this.metuCengNames.add( "Ismail Sengor Altingovde" );
        this.metuCengNames.add( "Volkan Atalay" );
        this.metuCengNames.add( "Aysenur Birturk" );
        this.metuCengNames.add( "Tolga Can" );
        this.metuCengNames.add( "Ruken Cakici" );
        this.metuCengNames.add( "Nihan Cicekli" );
        this.metuCengNames.add( "Ali Hikmet Dogru" );
        this.metuCengNames.add( "Seyda Ertekin" );
        this.metuCengNames.add( "Veysi Isler" );
        this.metuCengNames.add( "Sinan Kalkan" );
        this.metuCengNames.add( "Pinar Karagoz" );
        this.metuCengNames.add( "Murat Manguoglu" );
        this.metuCengNames.add( "Halit Oguztuzun" );
        this.metuCengNames.add( "Ertan Onur" );
        this.metuCengNames.add( "Atilla Ozgit" );
        this.metuCengNames.add( "Faruk Polat" );
        this.metuCengNames.add( "Yusuf Sahillioglu" );
        this.metuCengNames.add( "Uluc Saranli" );
        this.metuCengNames.add( "Erol Sahin" );
        this.metuCengNames.add( "Onur Tolga Sehitoglu" );
        this.metuCengNames.add( "Cevat Sener" );
        this.metuCengNames.add( "Sibel Tari" );
        this.metuCengNames.add( "Selim Temizer" );
        this.metuCengNames.add( "Ismail Hakki Toroslu" );
        this.metuCengNames.add( "Gokturk Ucoluk" );
        this.metuCengNames.add( "Fatos Yarman Vural" );
        this.metuCengNames.add( "Adnan TheBoss Yazici" );
        this.metuCengNames.add( "Asuman Dogac" );

    }

    public static Color generateColor()
    {
        return new Color( (int) ( Math.random() * 256 ), (int) ( Math.random() * 256 ), (int) ( Math.random() * 256 ) );
    }

    public static Color generateTransparentColor()
    {
        return new Color( (float) ( Math.random() ), (float) ( Math.random() ), (float) ( Math.random() ), Constants.TRANSPARENCY );
    }

    public static Dimension generateRandomDirection()
    {
        return new Dimension( (int) ( Math.random() * ( Constants.WINDOWS_WIDTH - Constants.LEFT_PANEL_WIDTH ) ), (int) ( Math.random() * ( Constants.WINDOWS_HEIGHT ) ) );
    }

    public static int generateStepTurnNumber()
    {
        return (int) ( 10 + Math.random() * Constants.STEP_NUMBER_MAX );
    }

    public String generateName()
    {
        return metuCengNames.get( (int) ( Math.random() * 29 ) );
    }

    public int generateNumberBetween( int a, int b )
    {
        return random.nextInt( b - a + 1 ) + a;
    }

    public Dimension generateDimension()
    {
        return new Dimension( generateNumberBetween( 50, Constants.WINDOWS_WIDTH - Constants.LEFT_PANEL_WIDTH - 50 ), generateNumberBetween( 50, Constants.WINDOWS_HEIGHT - 50 ) );
    }
}
