package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entity;
import org.khrotan.CENG443.AgarOO.RandomFactory;

public class StandStill extends StepStrategy
{
    public StandStill( Entity entity )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
    }

    @Override
    public String getName()
    {
        return "org.khrotan.CENG443.AgarOO.StepStrategy.StandStill";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );
    }
}
