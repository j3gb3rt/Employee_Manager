import java.io.Serializable;
import java.util.StringTokenizer;


public class Employee implements Serializable
{
    private String employeeType;
	private String employeeName;
    private String employeeNumber;
    private String hireDate;
    
    public Employee(String eNa, String eNu, String hD) throws EmployeeException
    {
    	employeeName = eNa;
    	employeeNumber = eNu;
    	hireDate = hD;
    	checkEmployeeName();
		checkEmployeeNumber();
		checkHireDate();
    }
    public Employee()
    {
    	employeeName = "First Last";
    	employeeNumber = "XXX-L";
    	hireDate = "MM/DD/YYYY";
    }
    public String getEmployeeName()
    {
    	return employeeName;
    }
    public String getEmployeeNumber()
    {
    	return employeeNumber;
    }
    public String getHireDate()
    {
    	return hireDate;
    }
    public String getEmployeeType()
    {
    	return employeeType;
    }
    public void setEmployeeName(String eNa)
    {
    	employeeName = eNa;
    }
    public void setEmployeeNumber(String eNu)
    {
    	employeeNumber = eNu;
    }
    public void setHireDate(String hD)
    {
    	hireDate = hD;
    }
    public void setEmployeeType(String eT)
    {
    	employeeType = eT;
    }
    public void checkEmployeeName() throws EmployeeException
    {
    	for (int i = 0; i < employeeName.length(); i++)
    	{
    		if (!Character.isLetter(employeeName.charAt(i)) && !Character.isWhitespace(employeeName.charAt(i))
    			&& (employeeName.charAt(i) != '-'))
    			throw new EmployeeException(0);
    	}
    	if (employeeName == null || employeeName == "" || employeeName.isEmpty())
    		throw new EmployeeException(0);
    }
    public void checkEmployeeNumber() throws EmployeeException
    {	
    	if (employeeNumber.length() != 5)
    		throw new EmployeeException(1);
    	for (int i = 0; i < 3; i++)
    	{
    		if (!Character.isDigit(employeeNumber.charAt(i)))
    			throw new EmployeeException(1);
    	}
    	if (employeeNumber.charAt(3) != '-')
    		throw new EmployeeException(1);
    	if (!Character.isLetter(employeeNumber.charAt(4)) || Character.isLowerCase(employeeNumber.charAt(4)) 
    		|| (employeeNumber.charAt(4) > 'M'))
    		throw new EmployeeException(1);
    }
    public void checkHireDate() throws EmployeeException
    {
    	int month;
    	int day;
    	final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	int februaryMax = 29;
    	int year;
	
    	if (hireDate.length() != 10)
    		throw new EmployeeException(2,1);
    	for (int i = 0; i < 10; i++)
    	{
    		if (!Character.isDigit(hireDate.charAt(i)) && (hireDate.charAt(i) != '/'))
    			throw new EmployeeException(2,(10 + i));
    	}
    	StringTokenizer dateTokenizer = new StringTokenizer(hireDate, "/");
    	month = Integer.parseInt(dateTokenizer.nextToken());
    	day = Integer.parseInt(dateTokenizer.nextToken());
    	year = Integer.parseInt(dateTokenizer.nextToken());
	
    	if (dateTokenizer.countTokens() != 0)
    		throw new EmployeeException(2,2);
    	if (month <= 0 || month > 12)
    		throw new EmployeeException(2,3);
    	if (month == 2)
    	{
    		if ((year % 4 != 0) || (year % 100 == 0 && year % 400 != 0 ))
    			februaryMax = 28;
    		if	(day < 0 || day > februaryMax)
    			throw new EmployeeException(2,4);
    	}
    	else if	(day < 0 || day > daysOfMonth[month-1])
    		throw new EmployeeException(2,5);
    	if (year < 0)
    		throw new EmployeeException(2,6);
    }
}
