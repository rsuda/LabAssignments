// COURSE: CSCI1620
// TERM: Fall 2018
//
// NAME: Robin Suda
// RESOURCES: The lab documentation powerpoint.

/**
 * Class for a simple, randomized guessing game. Five integer values between 1 and MAX_VALUE (inclusive) will be
 * generated. Only the first and last will be shown to the player. The player must then guess if the sum
 * of all of the numbers is greater than the possible average or not.
 *
 */
public class RandGuessGame
{

	/**
	 * Number of randomly generated numbers.
	 */
	private static final int ARR_SIZE = 5;
	
	/**
	 * Maximum value of randomly generated values.
	 */
	private static final int MAX_VALUE = 100;
	
	/**
	 * Stores sum of random values.
	 */
	private int arraySum;
	
	/**
	 * Stores player's guess.
	 */
	private char guess;
	
	/**
	 * Number the player must guess against, calculated with MAX_VALUE and ARR_SIZE.
	 */
	private int guessTarget;
	
	/**
	 * Determines if the String returned by toString hides the middle values.
	 */
	private boolean hideMiddleVals;
	
	/**
	 * Stores randomly generated numbers for game.
	 */
	private int[] numbers;
	
	/**
	 * Random number generator to use for the game.
	 */
	private java.util.Random rand;
	
	//Declare data members
	
	//Create Constructor
	/**
	 * Constructor for the RandGuessGame. Creates "numbers" array of size 
	 * ARR_SIZE to store random values,sets arraySum to zero, and calculates 
	 * value of "guessTarget" by multiplying the amount of numbers byhalf 
	 * of "MAX_VALUE". The passed Random object is assigned to the class' 
	 * Random member. hideMiddleValsis defaulted to "true".
	 * @param randIn The random number generator to be used for this instance of the game.
	 */
	public RandGuessGame(java.util.Random randIn)
	{
		rand = randIn;
		hideMiddleVals = true;
		numbers = new int[ARR_SIZE];
		arraySum = 0;
		guessTarget = ARR_SIZE * (MAX_VALUE / 2);
	}
	
	/**
	 * Populates the "numbers" array with random numbers between 1 and "MAX_VALUE".
	 */
	public void populateArray()
	{
		for (int i = 0; i < ARR_SIZE; i++)
		{
			numbers[i] = rand.nextInt(MAX_VALUE) + 1;
			arraySum = arraySum + numbers[i];
		}
	}
	
	/**
	 * Toggles the value of hideMiddleVals. If it is currently true, sets it to false, 
	 * and vice-versa.
	 */
	public void toggleHidden()
	{
		if (hideMiddleVals)
		{
			hideMiddleVals = false;
		}
		else
		{
			hideMiddleVals = true;
		}
	}
	
	/**
	 * Returns a String containing the values in the "numbers" array on a single line, separated 
	 * by spaceswith the middle values hidden or all visible based on value of "hideMiddleValue" 
	 * data member. There isa trailing space on the end, so an example String returned may be: 
	 * "5 X X X 67 ". NOTE: This does notoutput to System.out, it generates and returns a String.
	 * @return toString the formated correctly.
	 */
	public java.lang.String toString()
	{
		if (hideMiddleVals)
		{
			return String.format("%d X X X %d ", numbers[0], numbers[ARR_SIZE - 1]);
		}
		else
		{
			String last = "";
			for (int i = 0; i < ARR_SIZE; i++)
			{
				last = last + numbers[i] + " ";
			}
			return last;
		}
	}
	
	/**
	 * Accepts a user's guess for the game. Validates that it is either the character 'Y' or 'N'. 
	 * If itis a valid guess, sets the guess data member to the passed value and returns "true". 
	 * If it is notvalid it does not change the value of guess and returns false.
	 * @param guessIn The player's guess.
	 * @return True if the passed guess is valid, false if it is not.
	 */
	public boolean validatePlayerGuess(char guessIn)
	{
		if (guessIn == 'Y' || guessIn == 'N')
		{
			guess = guessIn;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if player's guess was correct, and constructs and returns a String that reports 
	 * if theyare correct or incorrect, and appends the correct sum of the array.
	 * @return A String reporting the results of the game.
	 */
	public java.lang.String getResult()
	{
		String result = "";
		if (guess == 'Y' && arraySum > guessTarget) 
		{
			result = String.format("You guessed correctly! The sum was %d!", arraySum);
		}
		else if (guess == 'Y' && arraySum <= guessTarget) 
		{
			result = String.format("You guessed wrong! The sum was %d!", arraySum);
		}
		else if (guess == 'N' && arraySum > guessTarget) 
		{
			result = String.format("You guessed wrong! The sum was %d!", arraySum);
		}
		else 
		{
			result = String.format("You guess correctly! The sum was %d!", arraySum);
		}
		return result;
	}
	//Write member methods
	
	/**
	 * Retrieves the numbers array. Used for testing, do not change.
	 * @return The numbers array.
	 */
	public int[] getNumbers()
	{
		return numbers;
	}
	
	/**
	 * Retrieves the sum of the numbers in the array. Used for testing, do not change.
	 * @return The value of arraySum.
	 */
	public int getArraySum()
	{
		return arraySum;
	}
}
