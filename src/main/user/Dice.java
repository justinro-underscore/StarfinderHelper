package main.user;

import java.util.Random;

import utils.Utils;

/**
 * Class to use for dice functionality
 *
 * @author Justin Roderman
 * @since October 5, 2018
 */

public class Dice
{
	private Integer[] diceTypes = {4, 6, 8, 10, 12, 20}; // Possible dice types in the game

	private int count; // How many dice should be rolled
	private int dieType; // Type of die

	/**
	 * Creates a new Dice object
	 * @param count Amount of dice to be rolled
	 * @param dieType Type of dice to be rolled
	 */
	public Dice(int count, int dieType) { this("" + count + "d" + dieType); }


	/**
	 * Creates a new Dice object
	 * @param die The die in string form \"\d+d\d+"\
	 */
	public Dice(String die)
	{
		int c, d;
		// Make sure the string is in the correct form
		die = die.trim();
		if(!die.matches("\\d+d\\d+"))
			throw new IllegalArgumentException("Die input invalid, valid input: \"{COUNT}d{DICE_TYPE}\"");
		// Parse the string - get count and die type
		c = Integer.parseInt(die.substring(0, die.indexOf('d')));
		d = Integer.parseInt(die.substring(die.indexOf('d') + 1));
		// Bounds check
		if(c < 1)
			throw new IllegalArgumentException("Count cannot be less than 1");
		count = c;
		if(!Utils.<Integer>arrContains(diceTypes, d))
			throw new IllegalArgumentException("Dice type \"" + d + "\" invalid. Possible types are 4, 6, 8, 10, 12, or 20");
		dieType = d;
	}

	/**
	 * Rolls the Dice object
	 * @return A random value recieved from rolling the Dice
	 */
	public int roll()
	{
		int rollCount = 0;
		Random rand = new Random();
		for(int i = 0; i < count; i++)
		{
			rollCount += (rand.nextInt(dieType) + 1);
		}
		return rollCount;
	}

	@Override
	public String toString() { return "" + count + "d" + dieType; }
}
