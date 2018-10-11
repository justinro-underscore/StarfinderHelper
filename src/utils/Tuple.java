package utils;

/**
 * Generic tuple class
 *
 * @author Justin Roderman
 * @since October 9, 2018
 */

public class Tuple<T, S>
{
	private T first; // The first element of the tuple
	private S second; // The second element of the tuple

	/**
	 * Creates a tuple object
	 * @param first The first element of the tuple
	 * @param second The second element of the tuple
	 */
	public Tuple(T first, S second)
	{
		this.first = first;
		this.second = second;
	}

	/**
	 * Returns the first element of the tuple
	 * @return The first element of the tuple
	 */
	public T getFirst()
	{
		return first;
	}

	/**
	 * Returns the second element of the tuple
	 * @return The second element of the tuple
	 */
	public S getSecond()
	{
		return second;
	}

	@Override
	public String toString()
	{
		return "(" + first.toString() + ", " + second.toString() + ")";
	}
}
