package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entities.Entity;
import org.khrotan.CENG443.AgarOO.Entities.Food;
import org.khrotan.CENG443.AgarOO.Entities.Vector;
import org.khrotan.CENG443.AgarOO.Environment;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;

public class GrabFood extends StepStrategy
{
    private final Environment environment;
    private Food nearestFood = null;

    public GrabFood( Environment env )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
        this.environment = env;
    }


    private void forwardCellDirectionToNearestFood( Entity cell, Environment environment )
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
        return "GF";
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
