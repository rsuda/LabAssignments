// COURSE: CSCI1620
// TERM: Fall 2018
//
// NAME: Robin Suda
// RESOURCES: The lab documentation powerpoint.
/**
 * Emulates a simple account with basic information and the ability to be locked and unlocked. An unlocked account shows
 * all information while a locked account will hide many of the details. This demonstrates how encapsulation can be used
 * to implement information hiding; as class designers we have full control over what information can be accessed, how
 * it is accessed, and how it is altered.
 */
public class LockableAccount
{

	/**
	 * The minimum value an account number can be.
	 */
	private static final int ACCOUNT_NUM_MIN = 1000;
	
	/**
	 * The maximum value an account number can be.
	 */
	private static final int ACCOUNT_NUM_MAX = 9999;
	
	/**
	 * The user name for the account.
	 */
	private java.lang.String userName;
	
	/**
	 * The user's email address.
	 */
	private java.lang.String emailAddress;
	
	/**
	 * The account number for the account.
	 */
	private int accountNumber;
	
	/**
	 * The user's password.
	 */
	private java.lang.String password;
	
	/**
	 * Any notification the user may have; if this value is null then there is no notification.
	 */
	private java.lang.String notification;
	
	/**
	 * Whether the account is locked or not. True is locked, false is unlocked.
	 */
	private boolean locked;
	
	//Class data members go here
	
	//Constructor goes here
	
	/**
	 * Constructor used to create a new LockableAccount. Any String is valid for 
	 * userName, emailAddress, andpassword. The accountNumber is a controlled value 
	 * and should be set using the same rules as thesetAccount method. A newly 
	 * created account will be locked.
	 * @param userNameIn Account user name
	 * @param accountNumberIn Requested account number for the account
	 * @param emailAddressIn Account email address
	 * @param passwordIn Account password
	 */
	public LockableAccount(java.lang.String userNameIn, int accountNumberIn, 
			java.lang.String emailAddressIn, java.lang.String passwordIn)
	{
		userName = userNameIn;
		setAccountNumber(accountNumberIn);
		emailAddress = emailAddressIn;
		password = passwordIn;
		lock();
		notification = "";
	}
	//Class methods go here
	
	/**
	 * Attempts to set the account number to the requested value. If the passed value is 
	 * between the account minimumand maximum inclusive, accountNumber will be set to the 
	 * passed value. If the account number is not within thevalid range, accountNumber 
	 * will be set to -1 to denote an invalid account number.
	 * @param accountNumberIn The account number requested.
	 */
	public void setAccountNumber(int accountNumberIn)
	{
		if (accountNumberIn >= ACCOUNT_NUM_MIN && accountNumberIn <= ACCOUNT_NUM_MAX)
		{
			accountNumber = accountNumberIn;
		}
		else
		{
			accountNumber = -1;
		}
	}
	
	/**
	 * Locks the account.
	 */
	public void lock()
	{
		locked = true;
	}
	
	/**
	 * Attempts to unlock the account with the passed password String. Only if the 
	 * passed password matches theaccount's password the account will be unlocked by 
	 * setting locked to false. Returns true if successfullyunlocked, false otherwise. 
	 * If the password passed is null it is treated the same as an incorrectpassword.
	 * @param passwordIn Password to attempt to unlock the account
	 * @return Whether or not the account is unlocked
	 */
	public boolean unlock(java.lang.String passwordIn)
	{
		boolean value = true;
		if (passwordIn == null)
		{
			value = false;
		}
		else if (passwordIn.equals(password))
		{
			locked = false;
			value = true;
		} 
		else
		{
			value = false;
		}
		return value;
	}
	
	/**
	 * Sets the notification of the account.
	 * @param notificationIn The notification String.
	 */
	public void addNotification(java.lang.String notificationIn)
	{
		notification = notificationIn;
	}
	
	/**
	 * Returns the account's email address; the String returned depends on the 
	 * locked state of the account.If the account is not locked it will return 
	 * the emailAddress as it is stored. If the account islocked the String will 
	 * be the first character of the emailAddress with the remainder of the 
	 * charactersin the emailAdress as asterisks *.
	 * @return The full or partially hidden email address of the account
	 */
	public java.lang.String getEmailAddress()
	{
		String theEmail = "";
		if (!locked)
		{
			theEmail = emailAddress;
		}
		else
		{
			for (int i = 0; i < emailAddress.length(); i++)
			{
				if (i == 0)
				{
					theEmail += emailAddress.substring(0, 1);
				}
				else
				{
					theEmail += "*";
				}
			}
		}
		return theEmail;
	}
	
	/**
	 * Returns the account number; the String returned depends on the locked state 
	 * of the account and if theaccount number is valid. If the account number is 
	 * invalid returns the String "Invalid account number,please contact customer 
	 * support" whether or not the account is unlocked. If the account number is 
	 * validand the account is unlocked it will return the account number as a 
	 * String; if the account is locked itwill return asterisks in place of the 
	 * digits.
	 * @return The full or partially hidden account number
	 */
	public java.lang.String getAccountNumberString()
	{
		String accountNumberSend = "";
		if (accountNumber == -1)
		{
			return "Invalid account number, please contact customer support";
		}
		else if (locked)
		{
			String accountNumberTemp = String.format("%d", accountNumber);
			for (int i = 0; i < accountNumberTemp.length(); i++)
			{
				accountNumberSend += "*";
			}
		}
		else
		{
			accountNumberSend = String.format("%d", accountNumber);
		}
		return accountNumberSend;
	}
	
	/**
	 * Returns the notification; the String returned depends on the locked state 
	 * of the account and if there is a notification. If there is no notification 
	 * returns the String "No notification".If there is a notification and the 
	 * account is unlocked it will return the notification. If there is 
	 * anotification and the account is locked it will return the String "You 
	 * have a notification".
	 * @return The notification String
	 */
	public java.lang.String getNotification()
	{
		String theNote = "";
		if (locked && !"".equals(notification))
		{
			theNote = "You have a notification";
		}
		else if ("".equals(notification))
		{
			theNote = "No notification";
		}
		else if (!locked && !"".equals(notification)) 
		{
			theNote = notification;
			addNotification("");
		}
		return theNote;
	}
	//Do not change toString	
	/**
	 * Returns the information of the account; the String returned depends on the locked state of the account.
	 * If the account is unlocked it will clear the notification by setting it to null. Uses the getter methods
	 * for account number, email address, and notification to ensure the appropriate values are displayed
	 * depending on the locked state of the account.
	 * @return A String representing this account
	 */
	public String toString()
	{
		String out;
		
		if (locked)
		{
			out = "***LOCKED ACCOUNT***";
		}
		else
		{
			out = "***UNLOCKED ACCOUNT***";
		}
		out += String.format("\nUser Name: %s\nAccount Number: %s\nEmail Address: %s\n%s",
				userName, getAccountNumberString(), getEmailAddress(), getNotification());
		
		if (!locked)
		{
			notification = "";
		}
		
		return out;
	}
	
}
