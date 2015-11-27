package org.khrotan.CENG443.AgarOO;

public class MoveLinear extends StepStrategy
{
    public MoveLinear( Entity e )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );

        e.setDirection( new Vector( RandomFactory.generateRandomDirection() ) );
        e.getDirection().normalize();

        if ( Math.random() * 2 > 1 )
        {
            e.getDirection().setX( -e.getDirection().getX() );
            e.getDirection().setY( -e.getDirection().getY() );
        }
    }

    @Override
    public String getName()
    {
        return "org.khrotan.CENG443.AgarOO.MoveLinear";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );

        e.getDrawLocation().setX( e.getDrawLocation().getX() + e.getDirection().getX() * e.getSpeed() );
        e.getDrawLocation().setY( e.getDrawLocation().getY() + e.getDirection().getY() * e.getSpeed() );
    }
}
