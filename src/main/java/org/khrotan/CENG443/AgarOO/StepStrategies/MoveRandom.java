package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entities.Entity;
import org.khrotan.CENG443.AgarOO.Entities.Vector;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;

public class MoveRandom extends StepStrategy
{
    public MoveRandom()
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
    }

    @Override
    public String getName()
    {
        return "MR";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );

        e.setDirection( new Vector( RandomFactory.generateRandomDirection() ) );
        e.getDirection().normalize();


        if ( Math.random() * 2 > 1 )
        {
            e.getDrawLocation().setX( e.getDrawLocation().getX() + e.getDirection().getX() * e.getSpeed() );
            e.getDrawLocation().setY( e.getDrawLocation().getY() + e.getDirection().getY() * e.getSpeed() );
        }
        else
        {
            e.getDrawLocation().setX( e.getDrawLocation().getX() - e.getDirection().getX() * e.getSpeed() );
            e.getDrawLocation().setY( e.getDrawLocation().getY() - e.getDirection().getY() * e.getSpeed() );
        }
    }
}
