import java.io.Serializable;


public class ProductionWorker extends Employee implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shift;
    private double hourlyPayRate;
    
    ProductionWorker(String eNa, String eNu, String hD, String s, String hPR) throws EmployeeException,
    																				 ProductionWorkerException
    {
    	super(eNa, eNu, hD);
    	setEmployeeType("Production Worker");
    	try
    	{
    		shift = Integer.parseInt(s);
    	}
    	catch (NumberFormatException e)
    	{
    		throw new ProductionWorkerException(1);
    	}
    	checkShift();
    	try
    	{
    		hourlyPayRate = Double.parseDouble(hPR);
    	}
    	catch (NumberFormatException e)
    	{
    		throw new ProductionWorkerException(1);
    	}
    	checkHourlyPayRate();
    }
    ProductionWorker()
    {
    	super();
    	shift = 0;
    	hourlyPayRate = 0.0;
    }
    public int getShift()
    {
    	return shift;
    }
    public double getHourlyPayRate()
    {
    	return hourlyPayRate;
    }
    public void setShift(int s)
    {
    	shift = s;
    }
    public void setHourlyPayRate(double hPR)
    {
    	hourlyPayRate = hPR;
    }
    public void checkShift() throws ProductionWorkerException
    {
    	if (shift < 1 ||  shift > 2)
    		throw new ProductionWorkerException(0);
    }
    public void checkHourlyPayRate() throws ProductionWorkerException
    {
    	if (hourlyPayRate < 0)
    		throw new ProductionWorkerException(1);
    }
}
