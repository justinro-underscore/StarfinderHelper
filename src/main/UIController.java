package main;

import main.user.Player;
import main.user.items.Equipment;
import main.user.items.RangedWeapon;

/**
 * Controls the user interaction for StarFinderHelper
 *
 * @author Justin Roderman
 * @since October 5, 2018
 */

public class UIController
{
	/**
	 * For now, being used to test
	 * @param args
	 */
	public static void main(String[] args)
	{
		Player p = new Player("Justin");

		Equipment test1 = new Equipment("Test2", 1, "L", 22);
		p.addItem(test1);
		System.out.println(p.getBulk());

		Equipment test10 = new Equipment("Test1", 1, 10);
		Equipment test2 = new Equipment("Test2", 1, 2);
		p.addItem(test10);
		p.addItem(test2);
		Equipment test3 = new Equipment("Test2", 1, 2, 6);
		p.addItem(test3);
		System.out.println(p.getBulk());
		Equipment test4 = new Equipment("Test4", 1, "L", 15);
		p.addItem(test4);
		System.out.println(p.getBulk());
		Equipment test5 = new Equipment("Test5", 1, "L", 17);
		p.addItem(test5);
		RangedWeapon sr = new RangedWeapon("Thunderstrike Street Sweeper", 7, 2, "1d10 So", "Knockdown", "Boost 1d6", 50, 5, 40, "charges");
		p.addItem(sr);
		System.out.println(p.getBulk());
	}
}
