//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : SugarFactory.java
//  @ Date : 18.11.2015
//  @ Author : 
//
//


import java.awt.*;

public class SugarFactory extends FoodFactory
{

    @Override
    public Food createFood( Environment env )
    {
        Sugar sugarToBeCreated = new Sugar();

        sugarToBeCreated.mass = Math.random();
        sugarToBeCreated.color = new Color( (int) ( Math.random() % 256 ), (int) ( Math.random() % 256 ), (int) ( Math.random() % 256 ) );
        sugarToBeCreated.speed = 0;
        sugarToBeCreated.step( (double) 0 );
        //TODO: Decide a appropriate length
        sugarToBeCreated.sideHalfLength = (int) ( Math.random() % 80 );

        env.entities.add( sugarToBeCreated );
        return sugarToBeCreated;
    }
}