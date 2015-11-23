public class SugarFactory extends FoodFactory
{

    @Override
    public Food createFood( Environment env )
    {
        Sugar sugarToBeCreated = new Sugar();

        //TODO: choose a mass value
        sugarToBeCreated.setMass( Math.random() * 60 );
        sugarToBeCreated.setColor( RandomFactory.generateColor() );
        sugarToBeCreated.setSpeed( 0 );
        sugarToBeCreated.setSideHalfLength( env.getRandomFactory().generateNumberBetween( 8, 12 ) );

        sugarToBeCreated.setLocation( new Vector( env.getRandomFactory().generateDimension() ) );
        sugarToBeCreated.setDirection( new Vector( env.getRandomFactory().generateDimension() ) );

        StepStrategy stepStrategy = env.generateSugarStepStrategy( sugarToBeCreated );
        sugarToBeCreated.setStrategy( stepStrategy );

        env.getFoodEntities().add( sugarToBeCreated );
        return sugarToBeCreated;
    }
}