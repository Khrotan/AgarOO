public class LoseMass extends StepStrategy
{
    private double losePercentage;

    public LoseMass( Object o )
    {

    }

    @Override
    public String getName()
    {
        return null;
    }

    @Override
    public void step( Entity e )
    {

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
