package utils;

/**
 * Generic utilities class to hold miscellaneous methods
 *
 * @author Justin Roderman
 * @since October 10, 2018
 */

public class Utils
{
	/**
	 * Checks to see if a value is in a given array
	 * @param arr The array to check
	 * @param val The value to check for
	 * @return Whether or not the array contains the value
	 */
	public static <T> boolean arrContains(T[] arr, T val)
	{
		for(T t : arr)
		{
			if(t.equals(val))
				return true;
		}
		return false;
	}
}
