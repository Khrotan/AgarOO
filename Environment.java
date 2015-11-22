import java.util.ArrayList;

public class Environment
{
    public int windowWidth;
    public int windowHeight;
    private ArrayList<Entity> foodEntities;
    private ArrayList<Entity> cellEntities;
    private RandomFactory randomFactory;

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
            candidateStrategy = new MoveRandom( organism );
        }
        else
        {
            candidateStrategy = new StandStill( organism );
        }
        return candidateStrategy;
    }

    public StepStrategy generateCellStepStrategy( Cell cell )
    {
        StepStrategy candidateStrategy;
        if ( ( Math.random() * 2 ) > 1 )
        {
            candidateStrategy = new StandStill( cell );
        }
        else
        {
            candidateStrategy = new GrabFood( this );
        }
        return candidateStrategy;
    }

    public Food createFood( FoodFactory factory )
    {
        return factory.createFood( this );
    }

    public Cell createCell()
    {
        BasicCell basicCellToBeCreated = new BasicCell( getRandomFactory().generateName() );

        basicCellToBeCreated.setLocation( new Vector( getRandomFactory().generateDimension() ) );
        basicCellToBeCreated.setDirection( new Vector( getRandomFactory().generateDimension() ) );

        StepStrategy stepStrategy = this.generateCellStepStrategy( basicCellToBeCreated );
        basicCellToBeCreated.setStrategy( stepStrategy );

        getCellEntities().add( basicCellToBeCreated );
        return basicCellToBeCreated;
    }

    public void stepAll()
    {
        this.getFoodEntities().forEach( Entity::step );
        for ( Entity e : getCellEntities() )
        {
            e.step();
        }
    }

    public void initializeEnvironment( SugarFactory sugarFactory, OrganismFactory organismFactory )
    {
        for ( int i = 0; i < 50; i++ )
        {
            this.createFood( sugarFactory );
        }

        for ( int i = 0; i < 50; i++ )
        {
            this.createFood( organismFactory );
        }

        for ( int i = 0; i < 5; i++ )
        {
            Cell cell = this.createCell();
        }
    }

    public Food getNearestFood( Entity cell )
    {
        double minDist = Double.MAX_VALUE;
        Entity nearestFood = null;

        for ( Entity food : getFoodEntities() )
        {
            if ( cell.getLocation().distanceTo( food.getLocation() ) < minDist )
            {
                minDist = cell.getLocation().distanceTo( food.getLocation() );
                nearestFood = food;
            }
        }
        return (Food) nearestFood;
    }

    public int getWindowWidth()
    {
        return windowWidth;
    }

    public void setWindowWidth( int windowWidth )
    {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight()
    {
        return windowHeight;
    }

    public void setWindowHeight( int windowHeight )
    {
        this.windowHeight = windowHeight;
    }

    public ArrayList<Entity> getFoodEntities()
    {
        return foodEntities;
    }

    public void setFoodEntities( ArrayList<Entity> foodEntities )
    {
        this.foodEntities = foodEntities;
    }

    public RandomFactory getRandomFactory()
    {
        return randomFactory;
    }

    public void setRandomFactory( RandomFactory randomFactory )
    {
        this.randomFactory = randomFactory;
    }

    public ArrayList<Entity> getCellEntities()
    {
        return cellEntities;
    }

    public void setCellEntities( ArrayList<Entity> cellEntities )
    {
        this.cellEntities = cellEntities;
    }
}

