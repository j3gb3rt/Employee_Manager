import java.io.Serializable;


public class ShiftSupervisor extends Employee implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double annualSalary;
    private double annualBonus;
    
    ShiftSupervisor(String eNa, String eNu, String hD, String aS, String aB) throws EmployeeException, 
    																				ShiftSupervisorException
    {
    	super(eNa, eNu, hD);
    	setEmployeeType("Shift Supervisor");
    	try
    	{
    		annualSalary = Double.parseDouble(aS);
    	}
    	catch (NumberFormatException e)
    	{
    		throw new ShiftSupervisorException(1);
    	}
    	checkAnnualSalary();
    	try
    	{
    		annualBonus = Double.parseDouble(aB);
    	}
    	catch (NumberFormatException e)
    	{
    		throw new ShiftSupervisorException(2);
    	}
    	checkAnnualBonus();
    }
    ShiftSupervisor()
    {
    	super();
    	annualSalary = 0.0;
    	annualBonus = 0.0;
    }
    public double getAnnualSalary()
    {
    	return annualSalary;
    }
    public double getAnnualBonus()
    {
    	return annualBonus;
    }
    public void setAnnualSalary(int aS)
    {
    	annualSalary = aS;
    }
    public void setAnnualBonus(double aB)
    {
    	annualBonus = aB;
    }
    public void checkAnnualSalary() throws ShiftSupervisorException
    {
    	if ( annualSalary < 0)
    		throw new ShiftSupervisorException(1);
    }
    public void checkAnnualBonus() throws ShiftSupervisorException
    {
    	if ( annualBonus < 0)
    		throw new ShiftSupervisorException(2);
	
    }
}
