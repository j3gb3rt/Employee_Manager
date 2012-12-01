
public class EmployeeException extends Exception
{
	private int field;
	private int check;
	private static String[] message = {"Employee Name is not valid. Employee name's must only contain" +
			  					" letters only.", "Employee Number must be of the format \"###-L\"," +
			  					" where #" + " is a number and L is a letter A - M.", "Hire Date " +
			  					"must be of the format \"MM/DD/YYYY\" and a valid date after 01/01/0000."};
	
	public EmployeeException(int f, int c)
	{
		super(message[f]);
		field = f;
		check = c;
	}
	public EmployeeException(int f)
	{
		super(message[f]);
		field = f;
	}
	public EmployeeException()
	{
		super("Please enter a value into all fields.");
	}
	public int getField()
	{
		return field;
	}
	public int getCheck()
	{
		return check;
	}
}
