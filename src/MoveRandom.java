public class MoveRandom extends StepStrategy
{
    public MoveRandom( Entity entity )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
    }

    @Override
    public String getName()
    {
        return "MoveRandom";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );

        e.setDirection( new Vector( RandomFactory.generateRandomDirection() ) );
        e.getDirection().normalize();


        if ( Math.random() * 2 > 1 )
        {
            e.getLocation().setX( e.getLocation().getX() + e.getDirection().getX() * e.getSpeed() );
            e.getLocation().setY( e.getLocation().getY() + e.getDirection().getY() * e.getSpeed() );
        }
        else
        {
            e.getLocation().setX( e.getLocation().getX() - e.getDirection().getX() * e.getSpeed() );
            e.getLocation().setY( e.getLocation().getY() - e.getDirection().getY() * e.getSpeed() );
        }
    }
}
