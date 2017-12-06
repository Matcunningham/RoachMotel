//A concrete decorator for Room
public class Shower extends HotelAmenity
{
	//protected Room room = null;
        private Room room;
	private static final double COST = 25;

	public Shower (Room room)
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
		return room.toString() + ", with spray resistant shower";
	}
}

