package main.user.items;

/**
 * Class that holds information for a grenade weapon
 *
 * @author Justin Roderman
 * @since October 9, 2018
 */

public class Grenade extends Equipment
{
	private int range; // Range (in ft.) that the grenade is useful in
	private String capacity; // Usually "Drawn"
	private String special; // The special ability of the grenade

	/**
	 * Creates a new Grenade object
	 * @param name Name of the grenade
	 * @param level Required level
	 * @param bulk Bulk
	 * @param range Range (in feet) that weapon is useful in
	 * @param capacity I'm actually not sure what this is in relation to grenades...
	 * @param special Special ability
	 */
	public Grenade(String name, int level, String bulk, int range, String capacity, String special)
	{
		super(name, level, bulk);
		this.range = range;
		this.capacity = capacity;
		this.special = special;
	}

	/**
	 * Gets the range of the grenade (in feet)
	 * @return The range of the grenade (in feet)
	 */
	public int getRange() { return range; }

	/**
	 * Gets the capacity of the grenade
	 * @return The capacity of the grenade
	 */
	public String getCapacity() { return capacity; }

	/**
	 * Gets the special ability of the grenade
	 * @return The special ability of the grenade
	 */
	public String getSpecial() { return special; }
}
