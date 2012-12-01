import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TableManagement {
	private static String[] columnNames = {"Employee's Name", "Job Class", "Personel #",
			"Hire Date", "Pay", "Shift", "Bonus", "Training"};
	private static MyModel model = new MyModel(columnNames, 1);
	private static JTable table = new JTable(model);
	private static DecimalFormat money = new DecimalFormat("$#,##0.00");
	private static int currentEmptyRow;
	
	private static void addTableCommon(Employee emp, int row)
	{
		FileManagement.addEmployee(emp);
		if (currentEmptyRow > (table.getRowCount() - 1))
		{
			model.addRow(new Object[8]);
		}

		table.setValueAt(emp.getEmployeeName(), row, 0);
		table.setValueAt(emp.getEmployeeType(), row, 1);
		table.setValueAt(emp.getEmployeeNumber(), row, 2);
		table.setValueAt(emp.getHireDate(), row, 3);
		currentEmptyRow++;
	}
	
	public static void addTableRow(ProductionWorker emp) {
		addTableRow(emp, currentEmptyRow);
	}
	
	public static void addTableRow(ProductionWorker emp, int row)
	{
		addTableCommon(emp, row);

		String[] shiftText = {" (day)", " (night)"};

		table.setValueAt(money.format(emp.getHourlyPayRate()) + "/hr", row, 4);
		table.setValueAt(emp.getShift() + shiftText[emp.getShift() - 1], row, 5);
		table.setValueAt("N/A", row, 6);
		table.setValueAt("N/A", row, 7);

	}
	
	public static void addTableRow(ShiftSupervisor emp) {
		addTableRow(emp, currentEmptyRow);
	}
	
	public static void addTableRow(ShiftSupervisor emp, int row)
	{
		addTableCommon(emp, row);

		table.setValueAt(money.format(emp.getAnnualSalary()) + "/yr", row, 4);
		table.setValueAt("N/A", row, 5);
		table.setValueAt(money.format(emp.getAnnualBonus()) + "/yr", row, 6);
		table.setValueAt("N/A", row, 7);
	}
	
	public static void addTableRow(TeamLeader emp) {
		addTableRow(emp, currentEmptyRow);
	}
	
	public static void addTableRow(TeamLeader emp, int row)
	{
		addTableCommon(emp, row);

		table.setValueAt(money.format(emp.getHourlyPayRate()) + "/hr", row, 4);
		table.setValueAt("N/A", row, 5);
		table.setValueAt(money.format(emp.getMonthlyBonus()) + "/mo", row, 6);
		table.setValueAt(emp.getAttendedTrainingHours() + "/" + 
				emp.getRequiredTrainingHours() + " hr(s)", row, 7);
	}
	
	public static JTable getTable() {
		return table;
	}
	
	private static class MyModel extends DefaultTableModel
   	{
		private static final long serialVersionUID = 1L;

		public MyModel(String[] columnNames, int i)
		{
			super(columnNames,i);
		}

		@Override
		public boolean isCellEditable(int row, int column) 
   		{
			return false;
   	    }
   	}
}
