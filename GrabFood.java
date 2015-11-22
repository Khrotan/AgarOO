public class GrabFood extends StepStrategy
{
    Food nearestFood;

    public GrabFood( Cell cell, Environment environment )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
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

        e.getLocation().setX( e.getLocation().getX() + e.getDirection().getX() * e.getSpeed() );
        e.getLocation().setY( e.getLocation().getY() + e.getDirection().getY() * e.getSpeed() );
    }
}
