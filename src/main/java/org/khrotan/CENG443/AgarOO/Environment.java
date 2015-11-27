package org.khrotan.CENG443.AgarOO;

import org.khrotan.CENG443.AgarOO.CellDecorators.Evader;
import org.khrotan.CENG443.AgarOO.CellDecorators.Roamer;
import org.khrotan.CENG443.AgarOO.StepStrategies.*;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("ALL")
public class Environment
{
    private int windowWidth;
    private int windowHeight;
    private ArrayList<Food> foodEntities;
    private ArrayList<Cell> cellEntities;
    private RandomFactory randomFactory;
    private int numberOfSteps;

    public Environment( int windowWidth, int windowHeight )
    {
        setWindowWidth( windowWidth );
        setWindowHeight( windowHeight );

        setFoodEntities( new ArrayList<>() );
        setCellEntities( new ArrayList<>() );

        setRandomFactory( new RandomFactory( windowWidth, windowHeight ) );
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

    private StepStrategy generateCellStepStrategy( Cell cell )
    {
        StepStrategy candidateStrategy = null;

        double randomNum = Math.random();

        if ( cell instanceof BasicCell )
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
        else if ( cell instanceof Roamer )
        {
            if ( randomNum * 4 > 1 )
            {
                candidateStrategy = new StandStill( cell );
            }
            else if ( randomNum * 4 > 2 )
            {
                candidateStrategy = new GrabFood( this );
            }
            else if ( randomNum * 4 > 3 )
            {
                candidateStrategy = new MoveRandom();
            }
            else
            {
                candidateStrategy = new MoveLinear( cell );
            }
        }
        else if ( cell instanceof Evader )
        {
            if ( randomNum * 6 > 1 )
            {
                candidateStrategy = new StandStill( cell );
            }
            else if ( randomNum * 6 > 2 )
            {
                candidateStrategy = new GrabFood( this );
            }
            else if ( randomNum * 6 > 3 )
            {
                candidateStrategy = new MoveRandom();
            }
            else if ( randomNum * 6 > 4 )
            {
                candidateStrategy = new MoveLinear( cell );
            }
            else if ( randomNum * 6 > 5 )
            {
                candidateStrategy = new AvoidLarger();
            }
            else
            {
                candidateStrategy = new LoseMass( cell );
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
        basicCellToBeCreated.setDirection( new Vector( getRandomFactory().generateDimension() ) );
        basicCellToBeCreated.setCenterLocation( new Vector( basicCellToBeCreated.getDrawLocation().getX() + basicCellToBeCreated.getMass() / 2, basicCellToBeCreated.getDrawLocation().getY() + basicCellToBeCreated.getMass() / 2 ) );

        StepStrategy stepStrategy = this.generateCellStepStrategy( basicCellToBeCreated );
        basicCellToBeCreated.setStrategy( stepStrategy );

        getCellEntities().add( basicCellToBeCreated );
    }


    public void stepAll()
    {
        this.setNumberOfSteps( this.getNumberOfSteps() + 1 );

        this.changeStrategies();

        this.removeEatenFoods();
        this.removeEatenCells();
        this.getFoodEntities().forEach( Entity::step );
        this.getCellEntities().forEach( Entity::step );
    }

    private void changeStrategies()
    {
        for ( Cell cell : getCellEntities() )
        {
            if ( cell.getStrategy().isFinished() )
            {
                this.generateCellStepStrategy( cell );
            }
        }
    }

    public void initializeEnvironment( SugarFactory sugarFactory, OrganismFactory organismFactory )
    {
        for ( int i = 0; i < 20; i++ )
        {
            this.createFood( sugarFactory );
        }

        for ( int i = 0; i < 20; i++ )
        {
            this.createFood( organismFactory );
        }

        for ( int i = 0; i < 5; i++ )
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
            Cell cell1 = (Cell) getCellEntities().get( i );
            for ( int j = i + 1; j < getCellEntities().size(); j++ )
            {
                Cell cell2 = (Cell) getCellEntities().get( j );

                double distance = cell1.getCenterLocation().distanceTo( cell2.getCenterLocation() );
                //TODO: arrange according to mass/radius
                if ( distance < cell1.getMass() / 2 || distance < cell2.getMass() / 2 )
                {
                    System.out.println( "its close" );
                    System.out.printf( "%s mass: %d %s mass: %d\n", cell1.getName(), (int) cell1.getMass(), cell2.getName(), (int) cell2.getMass() );
                    if ( cell2.getMass() * 3 / 2 < cell1.getMass() )
                    {
                        cell1.addMass( cell2.getMass() );
                        cell1.setCellsSwallowed( cell1.getCellsSwallowed() + 1 );
                        toBeDeletedCells.add( cell2 );
                    }
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
        for ( Iterator<Cell> cellIterator = getCellEntities().iterator(); cellIterator.hasNext(); )
        {
            Cell cell = (Cell) cellIterator.next();
            for ( Iterator<Food> foodIterator = getFoodEntities().iterator(); foodIterator.hasNext(); )
            {
                Entity food = foodIterator.next();

                double distance = cell.getCenterLocation().distanceTo( food.getCenterLocation() );
                //TODO: arrange according to mass/radius
                if ( distance < cell.getMass() / 2 )
                {
                    // Remove the current element from the iterator and the list.
                    cell.addMass( food.getMass() );
                    cell.setFoodEaten( cell.getFoodEaten() + 1 );
                    foodIterator.remove();
                }
            }
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

    private int getNumberOfSteps()
    {
        return numberOfSteps;
    }

    private void setNumberOfSteps( int numberOfSteps )
    {
        this.numberOfSteps = numberOfSteps;
    }
}

