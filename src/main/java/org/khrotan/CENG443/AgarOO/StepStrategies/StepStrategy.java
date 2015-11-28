package org.khrotan.CENG443.AgarOO.StepStrategies;

import org.khrotan.CENG443.AgarOO.Entities.Entity;

public abstract class StepStrategy
{
    private int numberOfTurns;

    public boolean isFinished()
    {
        return ( this.numberOfTurns == 0 );
    }

    public abstract String getName();

    public abstract void step( Entity e );

    public int getNumberOfTurns()
    {
        return numberOfTurns;
    }

    void setNumberOfTurns( int numberOfTurns )
    {
        this.numberOfTurns = numberOfTurns;
    }
}
