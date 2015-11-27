public class OrganismFactory extends FoodFactory
{
    @Override
    public void createFood( Environment env )
    {
        int radius = env.getRandomFactory().generateNumberBetween( 8, 12 );

        Organism organismToBeCreated = new Organism( radius );

        organismToBeCreated.setMass( radius / 2 );
        organismToBeCreated.setColor( RandomFactory.generateColor() );
        organismToBeCreated.setSpeed( 1 );

        organismToBeCreated.setDrawLocation( new Vector( env.getRandomFactory().generateDimension() ) );
        organismToBeCreated.setDirection( new Vector( env.getRandomFactory().generateDimension() ) );
        organismToBeCreated.setCenterLocation( new Vector( organismToBeCreated.getDrawLocation().getX() + radius / 2, organismToBeCreated.getDrawLocation().getY() + radius / 2 ) );

        StepStrategy stepStrategy = env.generateOrganismStepStrategy( organismToBeCreated );
        organismToBeCreated.setStrategy( stepStrategy );

        env.getFoodEntities().add( organismToBeCreated );
    }
}