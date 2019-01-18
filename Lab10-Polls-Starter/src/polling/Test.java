package polling;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class Test {

	@org.junit.Test
	public void testValidPoll() 
	{
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		arraylist.add(10);
		arraylist.add(20);
		arraylist.add(30);
		PollingPlace test = new PollingPlace(123, 60, arraylist);
		PollResult result = new PollResult("vote1.ser");
		assertEquals(true, result.validPollingPlace(test));
	}

}
