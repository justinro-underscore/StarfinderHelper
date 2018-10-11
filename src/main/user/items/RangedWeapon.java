package main.user.items;

/**
 * Class that holds information for a ranged weapon
 *
 * @author Justin Roderman
 * @since October 9, 2018
 */

public class RangedWeapon extends Weapon
{
	private int range; // Range (in ft.) that the weapon is useful in
	private int usage; // How much of ammo is used per shot
	private int capacity; // Max capacity of the weapon
	private String ammoType; // Ammo type of the weapon

	/**
	 * Creates a new Ranged Weapon object
	 * @param name Name of the weapon
	 * @param level Required level
	 * @param bulk Bulk
	 * @param damage Damage
	 * @param critical Critical ability
	 * @param special Special ability
	 * @param range Range (in feet) that weapon is useful in
	 * @param usage How much ammo is used per shot
	 * @param capacity Max capacity
	 * @param ammoType Ammo type
	 */
	public RangedWeapon(String name, int level, int bulk, String damage, String critical, String special, int range, int usage, int capacity, String ammoType)
	{
		super(name, level, "" + bulk, damage, critical, special);
		this.range = range;
		this.usage = usage;
		this.capacity = capacity;
		this.ammoType = ammoType;
	}

	/**
	 * Gets the range of the weapon (in feet)
	 * @return The range of the weapon (in feet)
	 */
	public int getRange() { return range; }

	/**
	 * Gets the amount of ammo used per shot
	 * @return The amount of ammo used per shot
	 */
	public int getUsage() { return usage; }

	/**
	 * Gets the maximum capacity of the weapon
	 * @return Max capacity of the weapon
	 */
	public int getCapacity() { return capacity; }

	/**
	 * Gets the ammo type of the weapon
	 * @return The ammo type
	 */
	public String getAmmoType() { return ammoType; }
}
