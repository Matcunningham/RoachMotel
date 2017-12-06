//A concrete decorator for Room
public class FoodBar extends HotelAmenity
{
	//protected Room room = null;
        private Room room;
	private static final double COST = 10;

	public FoodBar (Room room)
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
		return room.toString() + ", with FoodBar";
	}
}
