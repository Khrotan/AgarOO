package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entity;
import org.khrotan.CENG443.AgarOO.RandomFactory;

public class AvoidLarger extends StepStrategy
{
    public AvoidLarger()
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
    }

    @Override
    public String getName()
    {
        return null;
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );
    }
}
