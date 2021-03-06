import java.util.ArrayList;

public class RoomFactory
{
	public Room createRoom(ArrayList<String> amenities)
	{
		Room r = new HotelRoom();
		if (amenities.contains("spa"))
			r = new Spa(r);
		if (amenities.contains("bar"))
			r = new FoodBar(r);
		if (amenities.contains("refill"))
			r = new FoodRefill(r);
		if (amenities.contains("shower"))
			r = new Shower(r);
		return r;
	}
	
}
