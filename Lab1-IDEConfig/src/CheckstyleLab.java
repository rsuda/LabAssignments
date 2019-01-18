// COURSE: CSCI1620
// TERM: Fall 2018
//
// NAME: Robin Suda
// RESOURCES: The lab documentation powerpoint.
/**
 * Lab to practice Checkstyle formatting.
 * @author Robin Suda
 */
public class CheckstyleLab
{
	/**
	 * The size of the array.
	 */
	private static final int ARR_SIZE = 10;
	
	/**
	 * Main method which calculates the sum of the squares of the integers 1 to 10 inclusive.
	 * @param args Command line arguments (Unused)
	 */
	public static void main(String[] args)
	{
		
		int[] squares = new int[ARR_SIZE];
		
		for (int i = 1; i - 1 < ARR_SIZE; i++) 
		{
			squares[i - 1] = (int) Math.pow(i, 2);
			System.out.printf("Square of %d is %d\n", i, squares[i - 1]);
		}
		
		System.out.printf("The sum of the squares is %d!", sumArray(squares));

	}
	
	/**
	 * This method returns the sum of the values in the arr parameter or zero when arr is null.
	 * @param arr the array.
	 * @return sum of the array.
	 */
	public static int sumArray(int[] arr)
	{
		int sum = 0;
		if (arr == null)
		{
			return 0;
		}
		else
		{
			for (int i = 0; i < arr.length; i++)
			{
				if (arr[i] >= 0)
				{
					sum += Math.abs(arr[i]);
				}
				else
				{
					sum -= Math.abs(arr[i]);
				}
			}
		}
		return sum;
	}

}
