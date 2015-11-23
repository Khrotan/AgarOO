package CENG443.AgarOO;

public abstract class StepStrategy
{
    protected int numberOfTurns;

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

    public void setNumberOfTurns( int numberOfTurns )
    {
        this.numberOfTurns = numberOfTurns;
    }
}
