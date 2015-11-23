package CENG443.AgarOO;

public class OrganismFactory extends FoodFactory
{
    @Override
    public Food createFood( Environment env )
    {
        int radius = env.getRandomFactory().generateNumberBetween( 8, 12 );

        Organism organismToBeCreated = new Organism( radius );

        organismToBeCreated.setMass( Math.random() );
        organismToBeCreated.setColor( RandomFactory.generateColor() );
        // TODO: make organism speed a small value
        organismToBeCreated.setSpeed( 1 );

        organismToBeCreated.setLocation( new Vector( env.getRandomFactory().generateDimension() ) );
        organismToBeCreated.setDirection( new Vector( env.getRandomFactory().generateDimension() ) );

        StepStrategy stepStrategy = env.generateOrganismStepStrategy( organismToBeCreated );
        organismToBeCreated.setStrategy( stepStrategy );

        env.getFoodEntities().add( organismToBeCreated );
        return organismToBeCreated;
    }
}