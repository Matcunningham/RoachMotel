

public class RoachColony implements Observer
{
    private String name;
    private int population;
    private int growRate;
    private boolean isVacant;
    
    public RoachColony(String colonyName, int numOfGuest, int growthFactor)
    {
        name = colonyName;
        population = numOfGuest;
        growRate = growthFactor;
    }

    @Override
    public void update(boolean vacant) 
    {
       isVacant = vacant;
    }
}
