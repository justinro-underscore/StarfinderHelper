package main.user.items;

/**
 * Class that holds information for a melee weapon
 *
 * @author Justin Roderman
 * @since October 9, 2018
 */

public class MeleeWeapon extends Weapon
{
	/**
	 * Creates a new Melee Weapon object
	 * @param name Name of the weapon
	 * @param level Required level
	 * @param bulk Bulk
	 * @param damage Damage
	 * @param critical Critical ability
	 * @param special Special ability
	 */
	public MeleeWeapon(String name, int level, int bulk, String damage, String critical, String special) { super(name, level, "" + bulk, damage, critical, special); }

	/**
	 * Creates a new Melee Weapon object
	 * @param name Name of the weapon
	 * @param level Required level
	 * @param bulk Bulk
	 * @param damage Damage
	 * @param critical Critical ability
	 * @param special Special ability
	 */
	public MeleeWeapon(String name, int level, String bulk, String damage, String critical, String special) { super(name, level, bulk, damage, critical, special); }
}
