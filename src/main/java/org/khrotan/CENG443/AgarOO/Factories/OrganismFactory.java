package org.khrotan.CENG443.AgarOO.Factories;

import org.khrotan.CENG443.AgarOO.Constants;
import org.khrotan.CENG443.AgarOO.Entities.Organism;
import org.khrotan.CENG443.AgarOO.Entities.Vector;
import org.khrotan.CENG443.AgarOO.Environment;
import org.khrotan.CENG443.AgarOO.StepStrategies.StepStrategy;

public class OrganismFactory extends FoodFactory
{
    @Override
    public void createFood( Environment env )
    {
        int radius = env.getRandomFactory().generateNumberBetween( Constants.ORGANISM_RADIUS_LOW, Constants.ORGANISM_RADIUS_HIGH );

        Organism organismToBeCreated = new Organism( radius );

        organismToBeCreated.setMass( radius / 2 );
        organismToBeCreated.setColor( RandomFactory.generateColor() );
        organismToBeCreated.setSpeed( Constants.ORGANISM_INITIAL_SPEED );

        organismToBeCreated.setDrawLocation( new Vector( env.getRandomFactory().generateDimension() ) );
        organismToBeCreated.setDirection( new Vector( RandomFactory.generateRandomDirection() ) );
        organismToBeCreated.setCenterLocation( new Vector( organismToBeCreated.getDrawLocation().getX() + radius / 2, organismToBeCreated.getDrawLocation().getY() + radius / 2 ) );

        StepStrategy stepStrategy = env.generateOrganismStepStrategy( organismToBeCreated );
        organismToBeCreated.setStrategy( stepStrategy );

        env.getFoodEntities().add( organismToBeCreated );
    }
}