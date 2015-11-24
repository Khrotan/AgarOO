public class GrabFood extends StepStrategy
{
    Food nearestFood = null;
    Environment environment;

    public GrabFood( Environment env )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
        this.environment = env;
    }


    public void forwardCellDirectionToNearestFood( Entity cell, Environment environment )
    {
        if ( nearestFood == null )
        {
            nearestFood = environment.getNearestFood( cell );

            Vector newDirectionVector = new Vector( nearestFood.getCenterLocation().getX() - cell.getCenterLocation().getX(), nearestFood.getCenterLocation().getY() - cell.getCenterLocation().getY() );
            newDirectionVector.normalize();

            cell.setDirection( newDirectionVector );
        }

        Food candidateNearestFood = environment.getNearestFood( cell );

        if ( nearestFood.hashCode() != candidateNearestFood.hashCode() )
        {
            nearestFood = environment.getNearestFood( cell );

            Vector newDirectionVector = new Vector( nearestFood.getCenterLocation().getX() - cell.getCenterLocation().getX(), nearestFood.getCenterLocation().getY() - cell.getCenterLocation().getY() );
            newDirectionVector.normalize();

            cell.setDirection( newDirectionVector );
        }
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

        forwardCellDirectionToNearestFood( e, environment );

        e.getDrawLocation().setX( e.getDrawLocation().getX() + e.getDirection().getX() * e.getSpeed() );
        e.getDrawLocation().setY( e.getDrawLocation().getY() + e.getDirection().getY() * e.getSpeed() );
    }
}
