package main.user.items;

import utils.Tuple;

/**
 * Class to used create equipment for the player
 *
 * @author Justin Roderman
 * @since October 5, 2018
 */

public class Equipment
{
	protected String name; // Name of the equipment
	protected int level; // Required level of the equipment
	protected int count; // How many of this equipment does the player have
	protected Bulk bulk; // Bulk (weight) of the equipment

	/**
	 * Creates an equipment object
	 * @param name Name of the equipment
	 * @param level Required level
	 * @param bulk Bulk
	 */
	public Equipment(String name, int level, int bulk) { this(name, level, "" + bulk); }

	/**
	 * Creates an equipment object
	 * @param name Name of the equipment
	 * @param level Required level
	 * @param bulk Bulk
	 */
	public Equipment(String name, int level, String bulk) { this(name, level, bulk, 1); }

	/**
	 * Creates an equipment object
	 * @param name Name of the equipment
	 * @param level Required level
	 * @param bulk Bulk
	 * @param count How many of the equipment user has
	 */
	public Equipment(String name, int level, int bulk, int count) { this(name, level, "" + bulk, count); }

	/**
	 * Creates an equipment object
	 * @param name Name of the equipment
	 * @param level Required level
	 * @param bulk Bulk
	 * @param count How many of the equipment user has
	 */
	public Equipment(String name, int level, String bulk, int count)
	{
		this.name = name;
		if(level < 1)
			throw new IllegalArgumentException("Level cannot be less than 1");
		this.level = level;
		if(count < 1)
			throw new IllegalArgumentException("Level cannot be less than 1");
		this.count = count;
		this.bulk = new Bulk(bulk);
	}

	/**
	 * Get the name of the equipment
	 * @return The name of the equipment
	 */
	public String getName() { return name; }

	/**
	 * Get the required level of the equipment
	 * @return Required level
	 */
	public int getLevel() { return level; }

	/**
	 * Increments the amount of this equipment that the user has by specified amount
	 * @param c Amount to increment by, CAN BE NEGATIVE
	 */
	public void incrementCount(int c)
	{
		count += c;
		if(count <= 0)
			throw new RuntimeException("Count is 0");
	}

	/**
	 * Increments the amount of this equipment that the user has by 1
	 */
	public void incrementCount() { count++; }

	/**
	 *	Decrements the amount of this equipment that the user has by 1
	 */
	public void decrementCount()
	{
		count--;
		if(count == 0)
			throw new RuntimeException("Count is 0");
	}

	/**
	 * Returns the amount of this equipment that the user has
	 * @return The amount of this equipment that the user has
	 */
	public int getCount() { return count; }

	/**
	 * Gets how heavy a single instance of this equipment weighs
	 * @return The bulk of the equipment
	 */
	public String getSingleBulk()
	{
		if(bulk.isLight())
			return "L";
		return "" + bulk.getBulk();
	}

	/**
	 * Get how heavy all of the equipment weighs
	 * Factors in how many of this equipment that the user has
	 * @return How heavy this equipment weighs
	 */
	public int getBulk()
	{
		if(bulk.isLight())
			return (count / 10);
		return (bulk.getBulk() * count);
	}

	/**
	 * Gets how heavy all of the equipment weighs WITH a remainder (if the bulk is light)
	 * @return A tuple, first element is how heavy the equipment weighs, second element is what is leftover
	 */
	public Tuple<Integer, Integer> getBulkWRemainder()
	{
		if(bulk.isLight())
			return new Tuple<Integer, Integer>(count / 10, count % 10);
		return new Tuple<Integer, Integer>(bulk.getBulk() * count, 0);
	}

	/**
	 * Returns if the bulk is light
	 * @return If bulk is light
	 */
	public boolean isBulkLight() { return bulk.isLight(); }

	/**
	 * Checks if equipment is equal to each other (checks name & level)
	 * @param rhs The equipment to check against
	 * @return Whether or not the equipment is equal
	 */
	public boolean equals(Equipment rhs) { return (name.equals(rhs.getName()) && (level == rhs.getLevel())); }


	/**
	 * Class to used to hold bulk information of the equipment
	 *
	 * @author Justin Roderman
	 * @since October 5, 2018
	 */
	private class Bulk
	{
		private int weight; // Weight of the equipment
		private boolean isLight; // Whether or not the equipment is light ("L")

		/**
		 * Create a bulk object
		 * @param w The weight of the equipment (could be L)
		 */
		public Bulk(String w)
		{
			isLight = false;
			// Check if light first
			if(w.equals("L"))
			{
				weight = 0;
				isLight = true;
			}
			else // If not light, try parsing to an integer
			{
				try {
					weight = Integer.parseInt(w);
					if(weight < 0)
						throw new IllegalArgumentException();
				}
				catch(IllegalArgumentException e2)
				{
					throw new IllegalArgumentException("Bulk must be \"L\" or a positive integer");
				}
			}
		}

		/**
		 * Gets the bulk (weight) of the equipment
		 * Note: Does not tell if it is light or not, meaning 0 could be weightless OR light
		 * @return The weight of the equipment
		 */
		public int getBulk() { return weight; }

		/**
		 * Get if equipment is light
		 * @return Whether or not the equipment is light
		 */
		public boolean isLight() { return isLight; }
	}
}
