// COURSE: CSCI1620
// TERM: Fall 2018
// 
// NAME: Robin Suda
// RESOURCES: JavaDoc and powerpoint for this section were used to make this class.

////////////////////////////////////////////////////////////////
// ATTENTION: WebCAT will not deduct style points for your JUnit 
// test files.  Use of magic numbers is permitted in tests, and 
// javadoc for each method is optional.  However, it's good to 
// add comments that describe the purpose of each test if you 
// have time before the lab is due.
////////////////////////////////////////////////////////////////

import static org.junit.Assert.*;   // A Checkstyle error on this line is okay.

import org.junit.Test;

/**
 * This class provides a series of JUnit test cases corresponding
 * to the SavingsAccount.java functionality.
 * 
 * @author 
 */
public class SavingsAccountTest
{
	///////////////////////////////////////////////////////////////
	// ATTENTION: Some sample tests are provided here to help you
	// get started.  Feel free to refer back to them as examples.
	// but we do not recommend editing them.
	///////////////////////////////////////////////////////////////
	
	/**
	 * The tolerance to use on all floating-point comparisons in the test
	 * cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	/**
	 * This test verifies the behavior of the default constructor when 
	 * provided valid parameter values.  Getters are also exercised to
	 * verify that the object has been set up correctly.
	 */
	@Test
	public void testConstructorBasic()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		assertEquals("Durango", a.getFirstName());
		assertEquals("Maverick", a.getLastName());
		assertEquals(9721, a.getAccountNumber());
		
		// When comparing double or float values, assertEquals takes a 
		// third parameter that specifies how close the two values need to
		// be to be considered equal.
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This test verifies that calling setFirstName with a valid string will
	 * cause the SavingsAccount to take on the new name.
	 */
	@Test
	public void testSetFirstNameValid()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		a.setFirstName("Herbie");
		assertEquals("Herbie", a.getFirstName());
	}
	
	/**
	 * This test verifies that calling setFirstName with invalid values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetFirstNameInValid()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		a.setFirstName(null);
		assertEquals("Durango", a.getFirstName());
		a.setFirstName("");
		assertEquals("Durango", a.getFirstName());
	}
	
	////////////////////////////////////////////////////////////////////////////
	// YOUR TESTS GO BELOW!  Try to write additional tests that exercise all of 
	// the code in SavingsAccount.java
	////////////////////////////////////////////////////////////////////////////

	@Test
	public void testDeposit()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		a.deposit(0);
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);
		a.deposit(1.48);
		assertEquals(12.00, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testWithdraw()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		a.withdraw(0);
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);
		a.withdraw(1.52);
		assertEquals(9.00, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testToString()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		assertEquals("9721: $10.52", a.toString());
	}
	
	@Test
	public void testSetLastNameValid()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		a.setLastName("Herbie");
		assertEquals("Herbie", a.getLastName());
	}
	
	/**
	 * This test verifies that calling setFirstName with invalid values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetLastNameInValid()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		a.setLastName(null);
		assertEquals("Maverick", a.getLastName());
		a.setLastName("");
		assertEquals("Maverick", a.getLastName());
	}
	
	@Test
	public void testInterest()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		a.applyMonthlyInterest();
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testSetInterestRate()
	{
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		a.setInterestRate(2.50);
		a.applyMonthlyInterest();
		assertEquals("9721: $10.54", a.toString());
	}
	
}
