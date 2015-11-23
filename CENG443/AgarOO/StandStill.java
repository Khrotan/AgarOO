package CENG443.AgarOO;

public class StandStill extends StepStrategy
{
    public StandStill( Entity entity )
    {
        super.setNumberOfTurns( RandomFactory.generateStepTurnNumber() );
        entity.setSpeed( 0 );
        entity.setStrategy( this );
    }

    @Override
    public String getName()
    {
        return "StandStill";
    }

    @Override
    public void step( Entity e )
    {
        super.setNumberOfTurns( super.getNumberOfTurns() - 1 );
    }
}
