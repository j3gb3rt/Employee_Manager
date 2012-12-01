import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyWindow {
	private static JPanel inputPanel;
	private static JPanel centerPanel;
	private static JPanel fieldInformationPanel;
	private static int currentNumberOfFields;
	private static int newNumberOfFields;
	private static JPanel[] inputFieldPanel;
	private static JPanel[] fieldPanel;
	private static JLabel[] field;
	private static JFrame modifierWindow;
   	private static final int WINDOW_WIDTH = 440;   // Window width
   	private static final int WINDOW_HEIGHT = 145;  // Window height
	private static JPanel bannerPanel;
	private static JPanel bannerInformationPanel;
	private static JPanel employeeTypeBoxPanel;
	private static JLabel bannerInformation;
	private static JComboBox<String> employeeTypeBox;
	private static JTextField[] inputField;
	private static final String[] employeeTypes = {"Select a job class...", "Production Worker",
				"Shift Supervisor", "Team Leader"};
	private static JPanel buttonPanel;
	private static JButton approveButton;
	private static JButton cancelButton;
	private static int currentSelectedRow;

	private static void buildArrays()
	{
//		int[] columnWidths = {130, 120, 65, 65, 80, 50, 80, 80};
//		TableColumn column = null;
			
		//model.addRow(new Object[8]);
		inputFieldPanel = new JPanel[8];
		inputField = new JTextField[8];
		fieldPanel = new JPanel[8];
		field = new JLabel[8];
		
		for (int i = 0; i < 8; i++)
		{
			inputFieldPanel[i] = new JPanel();
			inputFieldPanel[i].setLayout(new FlowLayout(FlowLayout.RIGHT));
			inputField[i] = new JTextField(10);
			inputFieldPanel[i].add(inputField[i]);
			
			fieldPanel[i] = new JPanel();
			fieldPanel[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			field[i] = new JLabel("");
			fieldPanel[i].add(field[i]);
			
			
			//table.saddColumn(new TableColumn(i, 75));
			//table.setValueAt(columnNames[i], 0, i + 1 );
			
		}
		field[0].setText("Employee Name:");
		field[1].setText("Employee ID (where # is a digit and L is a letter A-M):");
		field[2].setText("Hire Date:");
		inputField[1].setText("###-L");
		inputField[2].setText("MM/DD/YYYY");
		inputField[1].addFocusListener(new TextFieldListener());
		inputField[2].addFocusListener(new TextFieldListener());
		
		
	}

	
   	public static void buildBannerPanel()
    {
   		// Create the panel.
   		bannerPanel = new JPanel();    
   		bannerInformationPanel = new JPanel();
   		employeeTypeBoxPanel = new JPanel();
   		
   		bannerPanel.setBackground(Color.gray);
   		bannerInformationPanel.setBackground(Color.gray);
   		employeeTypeBoxPanel.setBackground(Color.gray);
   		
   		bannerPanel.setLayout(new BoxLayout(bannerPanel, BoxLayout.Y_AXIS));
   		bannerInformationPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
   		employeeTypeBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
   		
   		// Create the label.
        bannerInformation = new JLabel("<HTML>Please select the type of employee " + 
								       "you would like to add. Data is <P>required" +
								       " for all fields.</HTML>");
        employeeTypeBox = new JComboBox<String>(employeeTypes);
        
        employeeTypeBox.addActionListener(new ComboBoxListener());
        
        bannerInformationPanel.add(bannerInformation);
        employeeTypeBoxPanel.add(employeeTypeBox);
        
        // Add the label to this panel.
        bannerPanel.add(bannerInformationPanel);
        bannerPanel.add(employeeTypeBoxPanel);
        
        modifierWindow.add(bannerPanel);
    }
   	private static void buildButtonPanel(boolean isAddingNewEmployee)
   	{
   		// Create a panel for the buttons.
   		buttonPanel = new JPanel();
   		buttonPanel.setBackground(Color.gray);

   		// Create the buttons.
   		
   		approveButton= new JButton("");
   		cancelButton = new JButton("");
   		

   		// Register the action listeners.
   		approveButton.addActionListener(new approveButtonListener());
   		cancelButton.addActionListener(new cancelButtonListener());

   		// Add the buttons to the button panel.
   		if (isAddingNewEmployee){
   			approveButton.setText("Add");
   		}
   		else {
   			approveButton.setText("Finished");
   			
   		}
   		cancelButton.setText("Cancel");
   		buttonPanel.add(cancelButton);
   		buttonPanel.add(approveButton);
   		modifierWindow.add(buttonPanel);
   	}

	public static void buildCenterPanel()
   	{
   		inputPanel = new JPanel();
   		fieldInformationPanel = new JPanel();
   		centerPanel = new JPanel();
   		
   		inputPanel.setBackground(Color.gray);
   		fieldInformationPanel.setBackground(Color.gray);
   		centerPanel.setBackground(Color.gray);
   		
   		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
   		centerPanel.add(fieldInformationPanel);
   		centerPanel.add(inputPanel);
   		
   		modifierWindow.add(centerPanel);
   	}
	
	private static void rebuildCenterPanel(int nNOF)
	{
   		newNumberOfFields = nNOF;
	
   		if ((newNumberOfFields - currentNumberOfFields) > 0)
   		{
   			inputPanel.setLayout(new GridLayout(newNumberOfFields, 1));
   			fieldInformationPanel.setLayout(new GridLayout(newNumberOfFields, 1));
   			
   			for (int i = currentNumberOfFields; i < newNumberOfFields; i++)
   			{
   				inputPanel.add(inputFieldPanel[i]);
   				fieldInformationPanel.add(fieldPanel[i]);
   			}
   		}
   		if ((newNumberOfFields - currentNumberOfFields) < 0)
   		{	
   			for (int i = (currentNumberOfFields - 1); i >= newNumberOfFields; i--)
   			{
   				inputPanel.remove(inputFieldPanel[i]);
   				fieldInformationPanel.remove(fieldPanel[i]);
   			}
   			
   			inputPanel.setLayout(new GridLayout(newNumberOfFields, 1));
   			fieldInformationPanel.setLayout(new GridLayout(newNumberOfFields, 1));
   			
   		}
   		modifierWindow.setSize(WINDOW_WIDTH, (WINDOW_HEIGHT + (30 * newNumberOfFields)));
		
	}
	protected void setEditorFields(Employee emp)
   	{
   		Employee employee = new Employee();
   		if(emp.getEmployeeType().equals("Production Worker"))
   		{
   			employeeTypeBox.setSelectedIndex(1);
   			ProductionWorker proWor = (ProductionWorker) emp;
   			Integer shift = proWor.getShift();
   			Double hourlyPayRate = proWor.getHourlyPayRate();
   			inputField[3].setText(shift.toString());
   			inputField[4].setText(hourlyPayRate.toString());
   			employee = proWor;
   		}
   		if(emp.getEmployeeType().equals("Shift Supervisor"))
   		{
   			employeeTypeBox.setSelectedIndex(2);
   			ShiftSupervisor shiSup = (ShiftSupervisor) emp;
   			Double annualSalary = shiSup.getAnnualSalary();
   			Double annualBonus = shiSup.getAnnualBonus();
   			inputField[3].setText(annualSalary.toString());
   			inputField[4].setText(annualBonus.toString());
   			employee = shiSup;
   		}
   		if(emp.getEmployeeType().equals("Team Leader"))
   		{
   			employeeTypeBox.setSelectedIndex(3);
   			TeamLeader teaLea = (TeamLeader) emp;
   			Integer shift = teaLea.getShift();
   			Double hourlyPayRate = teaLea.getHourlyPayRate();
   			Double monthlyBonus = teaLea.getMonthlyBonus();
   			Double attendedTrainingHours = teaLea.getAttendedTrainingHours();
   			Double requiredTrainingHours = teaLea.getRequiredTrainingHours();
   			inputField[3].setText(shift.toString());
   			inputField[4].setText(hourlyPayRate.toString());
   			inputField[5].setText(monthlyBonus.toString());
   			inputField[6].setText(attendedTrainingHours.toString());
   			inputField[7].setText(requiredTrainingHours.toString());
   			employee = teaLea;
   		}
   		inputField[0].setText(employee.getEmployeeName());
   		inputField[1].setText(employee.getEmployeeNumber());
   		inputField[2].setText(employee.getHireDate());
   	}
   
	private static void setup(boolean isAddingNewEmployee) {
		modifierWindow = new JFrame("Employee Manager - Add a New Employee");
   		modifierWindow.setSize(WINDOW_WIDTH, (WINDOW_HEIGHT + (15 * newNumberOfFields)));
		modifierWindow.setLocationRelativeTo(null);
		// Specify an action for the close button.
		modifierWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Create a BorderLayout manager.
		modifierWindow.setLayout(new BoxLayout(modifierWindow.getContentPane(), BoxLayout.Y_AXIS));
		modifierWindow.addWindowListener(new WindowsListener());
		
		buildArrays();
		buildBannerPanel();
		buildCenterPanel();
		buildButtonPanel(isAddingNewEmployee);
		
		modifierWindow.setResizable(false);
		modifierWindow.setVisible(true);
	}
	
	public static boolean showAddWindow() {
		setup(true);
		while (modifierWindow.isVisible())
			;
		return true;
		
	}
	
	public static boolean showEditWindow(int index) {
		currentSelectedRow = index;
		setup(false);
		return true;
	}
	
	private static class approveButtonListener implements ActionListener
   	{
		

		@Override
		public void actionPerformed(ActionEvent e) 
		{			
			String[]  input = new String[currentNumberOfFields];
				
			for (int i = 0; i < currentNumberOfFields; i++)
				input[i] = inputField[i].getText();
			
			if (!employeeTypeBox.getSelectedItem().equals("Select a job class..."))
			{	
				try
				{
					if (employeeTypeBox.getSelectedItem().equals("Production Worker"))
					{
						ProductionWorker employee = new ProductionWorker(input[0], input[1], input[2], input[3], input[4]);
						if (approveButton.getText() == "Add")
						{
							TableManagement.addTableRow(employee);
						}
						else
						{
							TableManagement.addTableRow(employee,currentSelectedRow);

						}
					}
					else if (employeeTypeBox.getSelectedItem().equals("Shift Supervisor"))
					{
						ShiftSupervisor employee = new ShiftSupervisor(input[0], input[1], input[2], input[3], input[4]);
						if (approveButton.getText() == "Add")
						{
							TableManagement.addTableRow(employee);
						}
						else
						{
							TableManagement.addTableRow(employee,currentSelectedRow);
						}
					}
					else
					{
						TeamLeader employee = new TeamLeader(input[0], input[1], input[2], input[3], input[4],
														input[5], input[6], input[7]);
						if (approveButton.getText() == "Add")
						{
							TableManagement.addTableRow(employee);
						}
						else
						{
							TableManagement.addTableRow(employee,currentSelectedRow);

						}
					}
					for (int i = 0; i < currentNumberOfFields; i++)
						inputField[i].setText("");
					inputField[1].setText("###-L");
					inputField[2].setText("MM/DD/YYYY");
					
					
					if (approveButton.getText() == "Finished")
					{
						modifierWindow.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "<HTML>The entry was added successfully! When you" +
								  " are done<P> adding entries, click \"Done\" to return " +
								  "to the main window.</HTML>");
					}
					employeeTypeBox.setSelectedIndex(0);
					rebuildCenterPanel(0);
					currentNumberOfFields = 0;
				}
				catch (EmployeeException ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
					inputField[ex.getField()].requestFocus();
					inputField[ex.getField()].selectAll();
				}
				catch (ProductionWorkerException ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
					inputField[ex.getField()].requestFocus();
					inputField[ex.getField()].selectAll();				
				}
				catch (ShiftSupervisorException ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
					inputField[ex.getField()].requestFocus();
					inputField[ex.getField()].selectAll();				
				}
				catch (TeamLeaderException ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
					inputField[ex.getField()].requestFocus();
					inputField[ex.getField()].selectAll();				
				}
				
			}
			
		}
   		
   	}
   	
   	private static class cancelButtonListener implements ActionListener
   	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			modifierWindow.setVisible(false);
		}
   	}
	
	
	private static class ComboBoxListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
	    {
			if (currentNumberOfFields == 0)
				buttonPanel.add(cancelButton);
			if (employeeTypeBox.getSelectedItem().equals("Production Worker"))
			{
				rebuildCenterPanel(5);
				field[3].setText("Shift (enter 1 for day, 2 for night):");
				field[4].setText("Hourly Pay Rate:");
			}
			if (employeeTypeBox.getSelectedItem().equals("Shift Supervisor"))
			{
				rebuildCenterPanel(5);
				field[3].setText("Annual Salary");
				field[4].setText("Annual Production Bonus");
			}
			if (employeeTypeBox.getSelectedItem().equals("Team Leader"))
			{
				rebuildCenterPanel(8);
				field[3].setText("Shift (enter 1 for day, 2 for night):");
				field[4].setText("Hourly Pay Rate:");
				field[5].setText("Monthly Bonus:");
				field[6].setText("Hours of Required Training:");
				field[7].setText("Hours of Training Attended:");
			}
			currentNumberOfFields = newNumberOfFields;
	    }
	}
   	private static class TextFieldListener implements FocusListener
	{
		@Override
		public void focusGained(FocusEvent f)		
		{
			if (f.getSource() == inputField[1])
				if ((inputField[1].getText()).equals("###-L"))
					inputField[1].setText("");
				else if ((inputField[1].getText()).equals(""))
					inputField[1].setText("###-L");
			if (f.getSource() == inputField[2])
				if ((inputField[2].getText()).equals("MM/DD/YYYY"))	
					inputField[2].setText("");
				else if ((inputField[2].getText()).equals(""))	
					inputField[2].setText("MM/DD/YYYY");
		}
		@Override
		public void focusLost(FocusEvent f)		
		{
			if (f.getSource() == inputField[1])
				if ((inputField[1].getText()).equals(""))
					inputField[1].setText("###-L");
			if (f.getSource() == inputField[2])
				if ((inputField[2].getText()).equals(""))	
					inputField[2].setText("MM/DD/YYYY");
		}
	}
	
	private static class WindowsListener implements WindowListener
   	{

		@Override
		public void windowActivated(WindowEvent e)
		{	
		}
		@Override
		public void windowClosed(WindowEvent e)
		{
			cancelButton.dispatchEvent(new ActionEvent(cancelButton, ActionEvent.ACTION_PERFORMED,
										 "button pressed"));
		}
		@Override
		public void windowClosing(WindowEvent e)
		{
			cancelButton.dispatchEvent(new ActionEvent(cancelButton, ActionEvent.ACTION_PERFORMED,
										 "button pressed"));
		}
		@Override
		public void windowDeactivated(WindowEvent e)
		{	
		}
		@Override
		public void windowDeiconified(WindowEvent e)
		{	
		}
		@Override
		public void windowIconified(WindowEvent e)
		{	
		}

		@Override
		public void windowOpened(WindowEvent e)
		{	
		}
   		
   	}
   	
}
