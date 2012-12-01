
public class TeamLeaderException extends Exception
{
	private int field;
	private static String[] message = {"Please enter a dollar amount greater than 0 using numbers only" +
									   " for \"Monthly Bonus:\"","Please enter a dollar amount greater" +
									   " than 0 using numbers only for \"Hours of Required Training:\"",
									   "Please enter a dollar amount greater than 0 using numbers only " +
									   "for \"Hours of Required Attended:\""};
	
	public TeamLeaderException(int f)
	{
		super(message[f]);
		field = (f + 5);
	}
	public int getField()
	{
		return field;
	}
}
