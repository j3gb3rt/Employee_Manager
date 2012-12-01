import java.io.Serializable;


public class TeamLeader extends ProductionWorker implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double monthlyBonus;
    private double requiredTrainingHours;
    private double attendedTrainingHours;
    
    TeamLeader(String eNa, String eNu, String hD, String s, String hPR, String mB, String rTH, String aTH) throws EmployeeException, 
    																											  ProductionWorkerException,
    																											  TeamLeaderException
    {
    	super(eNa, eNu, hD, s, hPR);
    	setEmployeeType("Team Leader");
    	try
    	{
    		monthlyBonus = Double.parseDouble(mB);
    	}
    	catch (NumberFormatException e)
    	{
    		throw new TeamLeaderException(0);
    	}
    	checkMonthlyBonus();
    	try
    	{
    		requiredTrainingHours = Double.parseDouble(rTH);
    	}
    	catch (NumberFormatException e)
    	{
    		throw new TeamLeaderException(1);
    	}
    	checkRequiredTrainingHours();
    	try
    	{
    		attendedTrainingHours = Double.parseDouble(aTH);
    	}
    	catch (NumberFormatException e)
    	{
    		throw new TeamLeaderException(2);
    	}
    	checkAttendedTrainingHours();
    }
    TeamLeader()
    {
    	super();
    	monthlyBonus = 0.0;
    	requiredTrainingHours = 0.0;
    	attendedTrainingHours = 0.0;
    }
    public double getMonthlyBonus()
    {
    	return monthlyBonus;
    }
    public double getRequiredTrainingHours()
    {
    	return requiredTrainingHours;
    }
    public double getAttendedTrainingHours()
    {
    	return attendedTrainingHours;
    }
    public void setMonthlyBonus(double mB)
    {
    	monthlyBonus = mB;
    }
    public void setRequiredTrainingHours(double rTH)
    {
    	requiredTrainingHours = rTH;
    }
    public void setAttendedTrainingHours(double aTH)
    {
    	attendedTrainingHours = aTH;
    }
    public void checkMonthlyBonus() throws TeamLeaderException
    {
    	if (monthlyBonus < 0)
    		throw new TeamLeaderException(0);
    }
    public void checkRequiredTrainingHours() throws TeamLeaderException
    {
    	if (requiredTrainingHours < 0)
    		throw new TeamLeaderException(1);

    }
    public void checkAttendedTrainingHours() throws TeamLeaderException
    {
    	if (attendedTrainingHours < 0 || attendedTrainingHours > requiredTrainingHours)
    		throw new TeamLeaderException(2);

    } 
}
