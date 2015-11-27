package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entity;
import org.khrotan.CENG443.AgarOO.RandomFactory;

public class LoseMass extends StepStrategy
{
    private double losePercentage;

    public LoseMass( Object o )
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

    public double getLosePercentage()
    {
        return losePercentage;
    }

    public void setLosePercentage( double losePercentage )
    {
        this.losePercentage = losePercentage;
    }
}
