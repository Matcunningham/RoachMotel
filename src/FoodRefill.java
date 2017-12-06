//A concrete decorator for Room
public class FoodRefill extends HotelAmenity
{
	//protected Room room = null;
        private Room room;
	private static final double COST = 5;

	public FoodRefill (Room room)
	{
		this.room = room;
	}

	public double getCost ()
	{
		return room.getCost() + COST;
	}

	public boolean isVacant ()
	{
		return room.isVacant();
	}

	public String toString ()
	{
		return room.toString() + ", with FoodBar auto refill";
	}
}
