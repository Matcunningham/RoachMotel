//Singleton Hotel

import java.lang.reflect.Constructor;
import java.util.*;

public class Hotel implements Subject
{
	private static final int SIZE = 2;
	private static Hotel hotel = null;
        private boolean vacant = true;
	private Room[] room = new Room[SIZE];
        private RoomFactory factory = new RoomFactory();
        private ArrayList<Observer> observers;

	private Hotel (){}

	public static Hotel getInstance ()
	{
		if (hotel == null)
			hotel = new Hotel();
		return hotel;
	}
        
        public void checkIn(RoachColony colony)
        {
            if(this.isVacant())
            {
                int roomFinder = 0;
                while(room[roomFinder] != null)
                {
                    roomFinder++;
                }
                ArrayList<String> amenities = new ArrayList<>();
                Scanner in = new Scanner(System.in);
                System.out.println("Would you like to add a spa package for $20? (yes/no) :");
                if(in.next().equalsIgnoreCase("yes"))
                {
                    amenities.add("spa");
                }
                System.out.println("Would you like to add a food bar for $10? (yes/no) :");
                if(in.next().equalsIgnoreCase("yes"))
                {
                    amenities.add("bar");
                }
                System.out.println("Would you like to add food bar auto refill for $5? (yes/no) :");
                if(in.next().equalsIgnoreCase("yes"))
                {
                    amenities.add("refill");
                }
                System.out.println("Would you like to add an antispray shower for $25? (yes/no) :");
                if(in.next().equalsIgnoreCase("yes"))
                {
                    amenities.add("shower");
                }
                room[roomFinder] = factory.createRoom(amenities);
            }
            else
            {
                // this.registerObserver(colony);
                System.out.println("No Vacany, you have been added to the waitinglist");
            }
        }
        
        public void checkOut()
        {
            if(!this.isVacant())
            {
                
            }
                
        }
        
	// If any of the rooms are vacant, return true otherwise false
	public boolean isVacant ()
	{
		for (int i = 0; i < SIZE; i++)
		{
			if (room[i] == null) // changed from if (room[i].isVacant())
				return true;
		}
		return false;
	}

	public Room get (int i)
	{
		return room[i];
	}
//Replaces a room in index i with a room decorated with class anyRoom
	public void set (int i, Class<? extends Room> anyRoom)
	{
		// This file should not know any of the Decorator names but be able
		// to invoke their constructors and decorate the Rooms in the array
		Constructor<? extends Room> ctor = null;
		try
		{
			ctor = anyRoom.getConstructor(Room.class);
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		// Once the constructor is determined in runtime, it should
		// try to override the Room in index i with a decorated one
		try
		{
			room[i] = ctor.newInstance(room[i]);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

    @Override
    public void registerObserver(Observer o) 
    {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) 
    {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() 
    {
        
    }
}