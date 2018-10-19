package main.user;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import main.user.items.Equipment;
import utils.Tuple;

/**
 * Class to hold Player information
 *
 * @author Justin Roderman
 * @since October 5, 2018
 */

public class Player
{
	private String name; // Name of the player
	private SimpleIntegerProperty credits; // How many credits the player has
	private ArrayList<Equipment> equipment = new ArrayList<Equipment>(); // The inventory of the player

	/**
	 * Creates a new player character
	 * @param n Name of the player
	 */
	public Player(String n)
	{
		name = n;
		credits = new SimpleIntegerProperty(0);
	}

	/**
	 * Gets the name of the player
	 * @return Name of player
	 */
	public String getName() { return name; }

	/**
	 *
	 * @return
	 */
	public void addCredits(int c)
	{
		int creds = credits.get();
		creds += c;
		if(creds < 0)
			credits.set(0);
		else
			credits.set(creds);
	}

	/**
	 * Gets the amount of credits player has
	 * @return Wealth of player
	 */
	public int getCredits() { return credits.get(); }

	/**
	 * Gets the amount of credits player has as a SimpleIntegerProperty
	 * @return Wealth of player as SimpleIntegerProperty
	 */
	public SimpleIntegerProperty getCreditsProp() { return credits; }

	/**
	 * Gets how much the player is carrying
	 * @return The total weight of the player's inventory
	 */
	public int getBulk() { return getCurrBulk(); }

	/**
	 * Calculates the current weight of the player's inventory
	 * @return The weight of the player's inventory
	 */
	private int getCurrBulk()
	{
		int bulk = 0; // Actual weight
		int bulkL = 0; // Additional weight due to remainder from light items
		for(Equipment e : equipment)
		{
			Tuple<Integer, Integer> b = e.getBulkWRemainder();
			bulk += b.getFirst();
			bulkL += b.getSecond();
		}
		return (bulk + (bulkL / 10));
	}

	/**
	 * Adds a new item to the inventory of the player
	 * @param newE The new equipment to add
	 */
	public void addItem(Equipment newE)
	{
		for(Equipment e : equipment)
		{
			// Check to make sure equipment isn't already in inventory
			if(e.equals(newE))
			{
				// If it is, increment the count
				e.incrementCount(newE.getCount());
				return;
			}
		}
		// If it isn't in inventory, simply add it
		equipment.add(newE);
	}
}
