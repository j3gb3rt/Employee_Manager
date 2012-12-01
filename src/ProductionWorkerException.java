
public class ProductionWorkerException extends Exception
{
	private int field;
	private static String[] message = {"Please enter '1' or '0' for \"Shift:\"", "Please enter a dollar" +
									   " amount greater than 0 using numbers only for \"Hourly Pay Rate:\""};
	
	public ProductionWorkerException(int f)
	{
		super(message[f]);
		field = (f + 3);
	}
	public int getField()
	{
		return field;
	}
}
