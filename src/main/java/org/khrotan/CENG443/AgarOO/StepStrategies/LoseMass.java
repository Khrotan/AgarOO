package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entities.Entity;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;

public class LoseMass extends StepStrategy
{
    private double losePercentage = Math.random() * 0.01;

    public LoseMass()
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
    }

    @Override
    public String getName()
    {
        return "LM";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );
        e.setMass( e.getMass() * ( 1 - getLosePercentage() ) );
    }

    private double getLosePercentage()
    {
        return losePercentage;
    }

    public void setLosePercentage( double losePercentage )
    {
        this.losePercentage = losePercentage;
    }
}
