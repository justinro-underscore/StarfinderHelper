package main.user.items;

import java.util.Hashtable;

/**
 * Abstract class that will handle basic weapon functionality
 *
 * @author Justin Roderman
 * @since October 9, 2018
 */

import main.user.Dice;

public abstract class Weapon extends Equipment
{
	/*
	 * Holds the damage types for weapons
	 * 	Key - Single character key that is input
	 * 	Value - The corresponding damage type
	 */
	private Hashtable<String, String> DAMAGE_TYPES = new Hashtable<String, String>();

	protected Dice damage; // How much damage the weapon deals
	protected String[] damageTypes = {"", ""}; // The damage types of the weapon (max 2)
	protected String critical; // The critical ability of the weapon
	protected String special; // The special ability of the weapon

	/**
	 * Fills in the DAMAGE_TYPES hashtable
	 */
	private void createDamageTypesTable()
	{
		DAMAGE_TYPES.put("A", "E Acid");
		DAMAGE_TYPES.put("C", "E Cold");
		DAMAGE_TYPES.put("E", "E Electricity");
		DAMAGE_TYPES.put("F", "E Fire");
		DAMAGE_TYPES.put("So", "E Sonic");

		DAMAGE_TYPES.put("B", "K Bludgeoning");
		DAMAGE_TYPES.put("P", "K Piercing");
		DAMAGE_TYPES.put("S", "K Slashing");
	}

	/**
	 * Creates a new weapon
	 * @param name Name of the weapon
	 * @param level Required level
	 * @param bulk Bulk
	 * @param damage Damage
	 * @param critical Critical ability
	 * @param special Special ability
	 */
	public Weapon(String name, int level, String bulk, String damage, String critical, String special)
	{
		super(name, level, bulk);
		createDamageTypesTable(); // Create the damage types table

		// Check damage input
		if(!damage.matches("\\w+ \\w+( & \\w+)?"))
			throw new IllegalArgumentException("Damage input invalid, valid input: \"{DICE} {DAMAGE_TYPE_LETTER}\" or \"{DICE} {DAMAGE_TYPE_1_LETTER} & {DAMAGE_TYPE_2_LETTER}\"");
		// Get the damage dice amount
		this.damage = new Dice(damage.substring(0, damage.indexOf(' ')));
		// Get the first damage type
		String[] split = damage.split(" ");
		if(!DAMAGE_TYPES.containsKey(split[1]))
			throw new IllegalArgumentException("Damage type \"" + split[1] + "\" not valid. Valid types: A, C, E, F, So, B, P, or S");
		damageTypes[0] = split[1];
		// Get the second damage type (if exists)
		if(split.length != 2)
		{
			if(!DAMAGE_TYPES.containsKey(split[3]))
				throw new IllegalArgumentException("Damage type \"" + split[3] + "\" not valid. Valid types: A, C, E, F, So, B, P, or S");
			if(damageTypes[0].equals(split[3]))
				throw new IllegalArgumentException("Damage type \"" + split[3] + "\" cannot be repeated");
			damageTypes[1] = split[3];
		}

		this.critical = critical;
		this.special = special;
	}

	/**
	 * Returns the damage of the weapon
	 * @return The damage
	 */
	public String getDamage() { return damage.toString() + " " + damageTypes; }

	/**
	 * Returns the critical ability of the weapon
	 * @return The critical ability
	 */
	public String getCritical() { return critical; }

	/**
	 * Returns the special ability of the weapon
	 * @return The special ability
	 */
	public String getSpecial() { return special; }
}
