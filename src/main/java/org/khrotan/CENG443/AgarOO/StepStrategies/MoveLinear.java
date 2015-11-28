package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Constants;
import org.khrotan.CENG443.AgarOO.Entities.Entity;
import org.khrotan.CENG443.AgarOO.Entities.Vector;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;

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
        return "ML";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );

        e.getDrawLocation().setX( e.getDrawLocation().getX() + e.getDirection().getX() * e.getSpeed() );
        e.getDrawLocation().setY( e.getDrawLocation().getY() + e.getDirection().getY() * e.getSpeed() );

        //TODO: arrange according to radius
        if ( e.getDrawLocation().getX() < Constants.WINDOWS_WIDTH && e.getDrawLocation().getX() < 0 )
        {
            e.getDirection().setX( -1 * e.getDirection().getX() );
        }
        if ( e.getDrawLocation().getX() + e.getMass() > 800 && e.getDirection().getX() > 0 )
        {
            e.getDirection().setX( -1 * e.getDirection().getX() );
        }
        if ( e.getDrawLocation().getY() < 0 && e.getDirection().getY() < 0 )
        {
            e.getDirection().setY( -1 * e.getDirection().getY() );
        }
        if ( e.getDrawLocation().getY() + e.getMass() > Constants.WINDOWS_HEIGHT && e.getDirection().getY() > 0 )
        {
            e.getDirection().setY( -1 * e.getDirection().getY() );
        }
    }
}
