package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entities.Cell;
import org.khrotan.CENG443.AgarOO.Entities.Entity;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;

public class AvoidLarger extends StepStrategy
{
    //TODO: en buyukse ne olacak ?
    public AvoidLarger( Cell largerCell )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
        if ( largerCell == null )
        {
            return;
        }
        /*int antiX = largerCell.getCenterLocation().getX() -
        Vector antiDirection =  */
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
    }
}
