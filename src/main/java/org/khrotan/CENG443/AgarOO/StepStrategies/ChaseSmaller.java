package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entity;
import org.khrotan.CENG443.AgarOO.RandomFactory;

public class ChaseSmaller extends StepStrategy
{
    public ChaseSmaller()
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
