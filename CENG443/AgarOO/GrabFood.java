package CENG443.AgarOO;

public class GrabFood extends StepStrategy
{
    Food nearestFood;
    Environment environment;

    public GrabFood( Environment env )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
        this.environment = env;
    }


    public void arrangeCellDirection( Entity cell, Environment environment )
    {
        nearestFood = environment.getNearestFood( cell );

        Vector newDirectionVector = new Vector( nearestFood.getLocation().getX() - cell.getLocation().getX(), nearestFood.getLocation().getY() - cell.getLocation().getY() );
        newDirectionVector.normalize();

        cell.setDirection( newDirectionVector );
    }

    @Override
    public String getName()
    {
        return "GrabFood";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );

        arrangeCellDirection( e, environment );

        e.getLocation().setX( e.getLocation().getX() + e.getDirection().getX() * e.getSpeed() );
        e.getLocation().setY( e.getLocation().getY() + e.getDirection().getY() * e.getSpeed() );
    }
}
