package org.khrotan.CENG443.AgarOO;

public class SugarFactory extends FoodFactory
{
    @Override
    public void createFood( Environment env )
    {
        Sugar sugarToBeCreated = new Sugar();

        //TODO: choose a mass value
        sugarToBeCreated.setMass( env.getRandomFactory().generateNumberBetween( 4, 6 ) );
        sugarToBeCreated.setColor( RandomFactory.generateColor() );
        sugarToBeCreated.setSpeed( 0 );
        sugarToBeCreated.setSideHalfLength( (int) ( sugarToBeCreated.getMass() * 2 ) );

        sugarToBeCreated.setDrawLocation( new Vector( env.getRandomFactory().generateDimension() ) );
        sugarToBeCreated.setDirection( new Vector( env.getRandomFactory().generateDimension() ) );
        sugarToBeCreated.setCenterLocation( new Vector( sugarToBeCreated.getDrawLocation().getX() + sugarToBeCreated.getSideHalfLength() / 2, sugarToBeCreated.getDrawLocation().getY() + sugarToBeCreated.getSideHalfLength() / 2 ) );

        StepStrategy stepStrategy = env.generateSugarStepStrategy( sugarToBeCreated );
        sugarToBeCreated.setStrategy( stepStrategy );

        env.getFoodEntities().add( sugarToBeCreated );
    }
}