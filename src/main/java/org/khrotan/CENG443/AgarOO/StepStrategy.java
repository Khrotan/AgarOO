package org.khrotan.CENG443.AgarOO;

public abstract class StepStrategy
{
    private int numberOfTurns;

    public boolean isFinished()
    {
        return ( this.numberOfTurns == 0 );
    }

    public abstract String getName();

    public abstract void step( Entity e );

    int getNumberOfTurns()
    {
        return numberOfTurns;
    }

    void setNumberOfTurns( int numberOfTurns )
    {
        this.numberOfTurns = numberOfTurns;
    }
}
