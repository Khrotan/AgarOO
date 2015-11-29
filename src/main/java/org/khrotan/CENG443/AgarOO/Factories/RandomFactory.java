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
        this.metuCengNames.add( "AhmetOguz" );
        this.metuCengNames.add( "FerdaNur" );
        this.metuCengNames.add( "IsmailSengor" );
        this.metuCengNames.add( "VolkanAtalay" );
        this.metuCengNames.add( "Aysenur" );
        this.metuCengNames.add( "TolgaCan" );
        this.metuCengNames.add( "RukenCakici" );
        this.metuCengNames.add( "NihanCicekli" );
        this.metuCengNames.add( "HikmetDogru" );
        this.metuCengNames.add( "SeydaErtekin" );
        this.metuCengNames.add( "VeysiIsler" );
        this.metuCengNames.add( "SinanKalkan" );
        this.metuCengNames.add( "PinarKaragoz" );
        this.metuCengNames.add( "Murat" );
        this.metuCengNames.add( "Halit" );
        this.metuCengNames.add( "ErtanOnur" );
        this.metuCengNames.add( "AtillaOzgit" );
        this.metuCengNames.add( "FarukPolat" );
        this.metuCengNames.add( "Yusuf" );
        this.metuCengNames.add( "UlucSaranli" );
        this.metuCengNames.add( "ErolSahin" );
        this.metuCengNames.add( "OnurTolga" );
        this.metuCengNames.add( "CevatSener" );
        this.metuCengNames.add( "SibelTari" );
        this.metuCengNames.add( "SelimTemizer" );
        this.metuCengNames.add( "Ismail" );
        this.metuCengNames.add( "Gokturk" );
        this.metuCengNames.add( "FatosVural" );
        this.metuCengNames.add( "AdnanYazici" );
        this.metuCengNames.add( "AsumanDogac" );

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
