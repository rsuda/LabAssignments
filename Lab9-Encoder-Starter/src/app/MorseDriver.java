// COURSE: CSCI1620
// TERM: Fall 2018
// 
// NAME: Robin Suda
// RESOURCES: Use of the javaDoc and powerpoint slides from previous lectures.
package app;

import java.io.FileNotFoundException;
import java.util.Scanner;

import morsecode.InvalidCharacterException;
import morsecode.MorseEncoder;

/**
 * Handles top-level user I/O for interaction with MorseEncoder. 
 * 
 * @author Robin Suda
 *
 */
public class MorseDriver
{
	/**
	 * Entry point for the program.  Basic user input to encode
	 * a file using the MorseEncoder functionality.
	 * 
	 * @param args Command line arguments, not used.
	 * @throws FileNotFoundException if the file is not found.
	 */
	public static void main(String[] args) 
	{
		// For testing, System.in Scanner needs to be created only once, and should
		// not be placed inside a loop or try-statement.
		Scanner console = new Scanner(System.in);  
		
		////////////////////////////////////////////////////////////////
		// 
		//
		// Add exception handling code below that gracefully deals with
		// FileNotFoundException and InvalidCharacterException.  
		//
		// If a FileNotFoundException occurs you should allow the user
		// to try again by re-entering new data for ALL prompts. 
		//
		// If an InvalidCharacterException occurs, you should notify 
		// the user of which character caused the problem in the input
		// file and then the program should halt.
		//
		// See the sampleOutput.txt for format of the expected prompts.
		///////////////////////////////////////////////////////////////
		
		boolean valid = true;
		do
		{
			try
			{
				System.out.print("What is the Morse code mapping file named? ");
				String mapFile = console.nextLine();
				System.out.print("Which file to encode? ");
				String toEncode = console.nextLine();
				System.out.print("Where to write the output? ");
				String output = console.nextLine();
				MorseEncoder m = new MorseEncoder(mapFile);
				m.encodeFile(toEncode, output);
				System.out.println("<<SUCCESS>> Refresh the Eclipse project folder and view the file!");
				valid = true;
			}
			catch (FileNotFoundException e)
			{
				System.out.print("<<ERROR>> That file doesn't exist. Let's try again.");
				System.out.println();
				System.out.println();
				//console.close();
				//console = new Scanner(System.in);
				valid = false;
			}
			catch (InvalidCharacterException e)
			{
				System.out.print("<<ERROR>> The input file contains a character that could not be "
						+ "encoded.\r\n");
				System.out.println("<<BAD CHAR = " + e.getCharacter() + ">>");
			}
		} while (!valid);
		console.close();
	}

}
