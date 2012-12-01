
public class ShiftSupervisorException extends Exception
{
	private int field;
	private static String[] message = {"Please enter a dollar amount greater than 0 using numbers only" +
									   " for \"Annual Salary:\"", "Please enter a dollar amount greater" +
									   " than 0 using numbers only for \"Annual Bonus:\""};
	
	public ShiftSupervisorException(int f)
	{
		super(message[f]);
		field = (f + 3);
	}
	public int getField()
	{
		return field;
	}
}
