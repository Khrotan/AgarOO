package org.khrotan.CENG443.AgarOO;

import org.khrotan.CENG443.AgarOO.CellDecorators.Evader;
import org.khrotan.CENG443.AgarOO.CellDecorators.Hunter;
import org.khrotan.CENG443.AgarOO.CellDecorators.Roamer;
import org.khrotan.CENG443.AgarOO.Entities.*;
import org.khrotan.CENG443.AgarOO.Factories.FoodFactory;
import org.khrotan.CENG443.AgarOO.Factories.OrganismFactory;
import org.khrotan.CENG443.AgarOO.Factories.RandomFactory;
import org.khrotan.CENG443.AgarOO.Factories.SugarFactory;
import org.khrotan.CENG443.AgarOO.StepStrategies.*;

import java.util.ArrayList;

public class Environment
{
    SugarFactory sugarFactory;
    OrganismFactory organismFactory;
    private int windowWidth;
    private int windowHeight;
    private volatile ArrayList<Food> foodEntities;
    private volatile ArrayList<Cell> cellEntities;
    private RandomFactory randomFactory;
    private int numberOfSteps;

    public Environment( int windowWidth, int windowHeight )
    {
        setWindowWidth( windowWidth );
        setWindowHeight( windowHeight );

        setFoodEntities( new ArrayList<>() );
        setCellEntities( new ArrayList<>() );

        setRandomFactory( new RandomFactory() );

        setSugarFactory( new SugarFactory() );
        setOrganismFactory( new OrganismFactory() );
    }

    public StepStrategy generateSugarStepStrategy( Entity sugar )
    {
        return new StandStill( sugar );
    }

    public StepStrategy generateOrganismStepStrategy( Entity organism )
    {
        StepStrategy candidateStrategy;
        if ( Math.random() * 2 > 1 )
        {
            candidateStrategy = new MoveRandom();
        }
        else
        {
            candidateStrategy = new StandStill( organism );
        }
        return candidateStrategy;
    }

    public Cell findClosestSmallerCell( Entity cell )
    {
        double closestDistance = Double.MAX_VALUE;
        Cell resultCell = null;
        for ( int i = 0; i < this.getCellEntities().size(); i++ )
        {
            Cell candidateCell = getCellEntities().get( i );
            if ( cell.equals( candidateCell ) || ( cell.getMass() < candidateCell.getMass() ) )
            {
                continue;
            }
            if ( closestDistance > cell.getCenterLocation().distanceTo( candidateCell.getCenterLocation() ) )
            {
                resultCell = candidateCell;
                closestDistance = cell.getCenterLocation().distanceTo( candidateCell.getCenterLocation() );
            }
        }
        return resultCell;
    }

    public Cell findClosestLargerCell( Entity cell )
    {
        double closestDistance = Double.MAX_VALUE;
        Cell resultCell = null;
        for ( int i = 0; i < getCellEntities().size(); i++ )
        {
            Cell candidateCell = getCellEntities().get( i );
            if ( ( cell.equals( candidateCell ) ) || ( cell.getMass() > candidateCell.getMass() ) )
            {
                continue;
            }

            if ( closestDistance > candidateCell.getCenterLocation().distanceTo( cell.getCenterLocation() ) )
            {
                closestDistance = candidateCell.getCenterLocation().distanceTo( cell.getCenterLocation() );
                resultCell = candidateCell;
            }
        }
        return resultCell;
    }

    public StepStrategy generateCellStepStrategy( Cell cell )
    {
        StepStrategy candidateStrategy = null;

        double randomNum = Math.random();

        if ( cell instanceof Hunter )
        {
            if ( randomNum * 7 > 6 )
            {
                candidateStrategy = new ChaseSmaller( this );
            }
            else if ( randomNum * 7 > 5 )
            {
                candidateStrategy = new MoveRandom();
            }
            else if ( randomNum * 7 > 4 )
            {
                candidateStrategy = new MoveLinear( cell );
            }
            else if ( randomNum * 7 > 3 )
            {
                candidateStrategy = new AvoidLarger( this );
            }
            else if ( randomNum * 7 > 2 )
            {
                candidateStrategy = new GrabFood( this );
            }
            else if ( randomNum * 7 > 1 )
            {
                candidateStrategy = new MoveRandom();
            }
            else
            {
                candidateStrategy = new LoseMass();
            }
        }
        else if ( cell instanceof Evader )
        {
            if ( randomNum * 6 > 5 )
            {
                candidateStrategy = new StandStill( cell );
            }
            else if ( randomNum * 6 > 4 )
            {
                candidateStrategy = new GrabFood( this );
            }
            else if ( randomNum * 6 > 3 )
            {
                candidateStrategy = new MoveRandom();
            }
            else if ( randomNum * 6 > 2 )
            {
                candidateStrategy = new MoveLinear( cell );
            }
            else if ( randomNum * 6 > 1 )
            {
                candidateStrategy = new AvoidLarger( this );
            }
            else
            {
                candidateStrategy = new LoseMass();
            }
        }
        else if ( cell instanceof Roamer )
        {
            if ( randomNum * 4 > 3 )
            {
                candidateStrategy = new StandStill( cell );
            }
            else if ( randomNum * 4 > 2 )
            {
                candidateStrategy = new GrabFood( this );
            }
            else if ( randomNum * 4 > 1 )
            {
                candidateStrategy = new MoveRandom();
            }
            else
            {
                candidateStrategy = new MoveLinear( cell );
            }
        }
        else if ( cell instanceof BasicCell )
        {
            if ( randomNum * 2 > 1 )
            {
                candidateStrategy = new StandStill( cell );
            }
            else
            {
                candidateStrategy = new GrabFood( this );
            }
        }


        cell.setStrategy( candidateStrategy );
        return candidateStrategy;
    }

    private void createFood( FoodFactory factory )
    {
        factory.createFood( this );
    }

    private void createCell()
    {
        BasicCell basicCellToBeCreated = new BasicCell( getRandomFactory().generateName() );

        basicCellToBeCreated.setDrawLocation( new Vector( getRandomFactory().generateDimension() ) );
        basicCellToBeCreated.setDirection( new Vector( RandomFactory.generateRandomDirection() ) );
        //TODO: radius
        basicCellToBeCreated.setCenterLocation( new Vector( basicCellToBeCreated.getDrawLocation().getX() + basicCellToBeCreated.getMass() / 2, basicCellToBeCreated.getDrawLocation().getY() + basicCellToBeCreated.getMass() / 2 ) );

        StepStrategy stepStrategy = this.generateCellStepStrategy( basicCellToBeCreated );
        basicCellToBeCreated.setStrategy( stepStrategy );

        getCellEntities().add( basicCellToBeCreated );
    }


    public void stepAll()
    {
        this.setNumberOfSteps( this.getNumberOfSteps() + 1 );

        this.removeEatenFoods();
        this.removeEatenCells();

        this.compensateFoods();

        this.evolveCells();

        this.changeStrategies();

        for ( int i = 0; i < getFoodEntities().size(); i++ )
        {
            getFoodEntities().get( i ).step();
        }

        for ( int i = 0; i < getCellEntities().size(); i++ )
        {
            getCellEntities().get( i ).step();
            getCellEntities().get( i ).setSpeed( ( 2.0D + 100 / getCellEntities().get( i ).getMass() ) );
        }
    }

    private void compensateFoods()
    {
        if ( getFoodEntities().size() < Constants.FOOD_ON_SCREEN )
        {
            for ( int i = 0; i < Constants.FOOD_ON_SCREEN - getFoodEntities().size(); i++ )
            {
                if ( Math.random() * 2 > 1 )
                {
                    this.createFood( getSugarFactory() );
                }
                else
                {
                    this.createFood( getOrganismFactory() );
                }
            }
        }
    }

    private void changeStrategies()
    {
        for ( int i = 0; i < getCellEntities().size(); i++ )
        {
            Cell cell = getCellEntities().get( i );
            if ( getCellEntities().get( i ).getStrategy().isFinished() )
            {
                this.generateCellStepStrategy( cell );
            }
        }
    }

    private void evolveCells()
    {
        for ( int i = 0; i < getCellEntities().size(); i++ )
        {
            Cell candidateCell = getCellEntities().get( i );

            if ( candidateCell instanceof Evader && candidateCell.getMass() > Constants.EVADER_TO_HUNTER_MASS )
            {
                getCellEntities().set( i, new Hunter( candidateCell ) );
            }
            else if ( candidateCell instanceof Roamer && candidateCell.getMass() > Constants.ROAMER_TO_EVADER_MASS )
            {
                getCellEntities().set( i, new Evader( candidateCell ) );
            }
            else if ( candidateCell instanceof BasicCell && candidateCell.getMass() > Constants.BASICCELL_TO_ROAMER_MASS )
            {
                getCellEntities().set( i, new Roamer( candidateCell ) );
            }
        }
    }

    public void initializeEnvironment()
    {
        for ( int i = 0; i < Constants.SUGARS_ON_SCREEN; i++ )
        {
            this.createFood( this.getSugarFactory() );
        }

        for ( int i = 0; i < Constants.ORGANISMS_ON_SCREEN; i++ )
        {
            this.createFood( this.getOrganismFactory() );
        }

        for ( int i = 0; i < Constants.INITIAL_CELLS_ON_SCREEN; i++ )
        {
            this.createCell();
        }
    }

    public Food getNearestFood( Entity cell )
    {
        double minDist = Double.MAX_VALUE;
        Entity nearestFood = null;

        for ( Entity food : getFoodEntities() )
        {
            if ( cell.getCenterLocation().distanceTo( food.getCenterLocation() ) < minDist )
            {
                minDist = cell.getCenterLocation().distanceTo( food.getCenterLocation() );
                nearestFood = food;
            }
        }
        return (Food) nearestFood;
    }

    private void removeEatenCells()
    {
        ArrayList<Cell> toBeDeletedCells = new ArrayList<>();

        for ( int i = 0; i < getCellEntities().size(); i++ )
        {
            Cell cell1 = getCellEntities().get( i );
            for ( int j = i + 1; j < getCellEntities().size(); j++ )
            {
                Cell cell2 = getCellEntities().get( j );

                double distance = cell1.getCenterLocation().distanceTo( cell2.getCenterLocation() );
                //TODO: arrange according to mass/radius
                if ( distance < cell1.getMass() / 2 || distance < cell2.getMass() / 2 )
                {
                    //TODO: arrange according to mass/radius
                    if ( cell2.getMass() * 3 / 2 < cell1.getMass() )
                    {
                        cell1.addMass( cell2.getMass() );
                        cell1.setCellsSwallowed( cell1.getCellsSwallowed() + 1 );
                        toBeDeletedCells.add( cell2 );
                    }
                    //TODO: arrange according to mass/radius
                    else if ( cell1.getMass() * 3 / 2 < cell2.getMass() / 2 )
                    {
                        cell2.addMass( cell1.getMass() );
                        cell2.setCellsSwallowed( cell2.getCellsSwallowed() + 1 );
                        toBeDeletedCells.add( cell1 );
                    }
                }
            }
        }

        for ( Cell cell : toBeDeletedCells )
        {
            getCellEntities().remove( cell );
        }
    }

    private void removeEatenFoods()
    {
        ArrayList<Food> toBeDeletedFood = new ArrayList<>();

        for ( int i = 0; i < getCellEntities().size(); i++ )
        {
            Cell cell = getCellEntities().get( i );
            for ( int j = 0; j < getFoodEntities().size(); j++ )
            {
                Food food = getFoodEntities().get( j );
                double distance = cell.getCenterLocation().distanceTo( food.getCenterLocation() );
                //TODO: arrange according to mass/radius
                if ( distance < cell.getMass() / 2 )
                {
                    cell.addMass( food.getMass() );
                    cell.setFoodEaten( cell.getFoodEaten() + 1 );
                    toBeDeletedFood.add( food );
                }
            }
        }

        for ( Food food : toBeDeletedFood )
        {
            getFoodEntities().remove( food );
        }
    }

    public int getWindowWidth()
    {
        return windowWidth;
    }

    private void setWindowWidth( int windowWidth )
    {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight()
    {
        return windowHeight;
    }

    private void setWindowHeight( int windowHeight )
    {
        this.windowHeight = windowHeight;
    }

    public ArrayList<Food> getFoodEntities()
    {
        return foodEntities;
    }

    private void setFoodEntities( ArrayList<Food> foodEntities )
    {
        this.foodEntities = foodEntities;
    }

    public RandomFactory getRandomFactory()
    {
        return randomFactory;
    }

    private void setRandomFactory( RandomFactory randomFactory )
    {
        this.randomFactory = randomFactory;
    }

    public ArrayList<Cell> getCellEntities()
    {
        return cellEntities;
    }

    private void setCellEntities( ArrayList<Cell> cellEntities )
    {
        this.cellEntities = cellEntities;
    }

    public int getNumberOfSteps()
    {
        return numberOfSteps;
    }

    private void setNumberOfSteps( int numberOfSteps )
    {
        this.numberOfSteps = numberOfSteps;
    }

    public SugarFactory getSugarFactory()
    {
        return sugarFactory;
    }

    public void setSugarFactory( SugarFactory sugarFactory )
    {
        this.sugarFactory = sugarFactory;
    }

    public OrganismFactory getOrganismFactory()
    {
        return organismFactory;
    }

    public void setOrganismFactory( OrganismFactory organismFactory )
    {
        this.organismFactory = organismFactory;
    }
}

