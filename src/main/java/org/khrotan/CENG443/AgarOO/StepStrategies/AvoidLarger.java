package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entities.Cell;
import org.khrotan.CENG443.AgarOO.Entities.Entity;
import org.khrotan.CENG443.AgarOO.Entities.Vector;
import org.khrotan.CENG443.AgarOO.Environment;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;

public class AvoidLarger extends StepStrategy
{

    Environment env;

    public AvoidLarger( Environment env )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
        this.env = env;
    }

    @Override
    public String getName()
    {
        return "AL";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );

        Cell closestLargestCell = env.findClosestLargerCell( e );

        if ( closestLargestCell == null )
        {
            this.setNumberOfTurns( 1 );
            e.setStrategy( env.generateCellStepStrategy( (Cell) e ) );
            return;
        }

        Vector antiDirection = new Vector( -1 * ( closestLargestCell.getCenterLocation().getX() - e.getCenterLocation().getX() ), -1 * ( closestLargestCell.getCenterLocation().getY() - e.getCenterLocation().getY() ) );
        antiDirection.normalize();
        e.setDirection( antiDirection );

        e.getDrawLocation().setX( e.getDrawLocation().getX() + e.getSpeed() * e.getDirection().getX() );
        e.getDrawLocation().setY( e.getDrawLocation().getY() + e.getSpeed() * e.getDirection().getY() );
    }
}
