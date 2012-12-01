import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;



public class EmployeeManager
{
	private static EmployeeManager app;
//	private JPanel fieldInformationPanel;     
//   	private JPanel inputPanel;
//   	private JPanel bannerPanel;  
//   	private JPanel buttonPanel;
//   	private JPanel centerPanel;
//   	private JPanel bannerInformationPanel;
//   	private JPanel employeeTypeBoxPanel;
//   	private JPanel mainButtonPanel;
//   	private JPanel[] fieldPanel = new JPanel[8];
//   	private JPanel[] inputFieldPanel = new JPanel[8];
//    private JLabel[] field = new JLabel[8];
//   	private JLabel bannerInformation;
//   	private JButton addButton;
//   	private JButton doneButton;
//   	private JButton newButton;
//   	private JButton loadButton;
//   	private JButton mainNewFileButton;
//   	private JButton mainAddButton;
//   	private JButton mainDeleteButton;
//   	private JButton mainEditButton;
//	private JButton mainSaveButton;
//	private JButton mainExitButton;
	private JMenuBar mainMenu;
//   	private JFrame fileChooserWindow;
   	private JFrame mainWindow;
//   	private JFrame adderWindow; 	
//   	private JComboBox<String> employeeTypeBox;
//   	private JTextField fileLocationInputField;
//   	private JTextField[] inputField = new JTextField[8];
//   	private String fileLocation;
//   	private String[] columnNames = {"Employee's Name", "Job Class", "Personel #",
//			"Hire Date", "Pay", "Shift", "Bonus", "Training"};
//   	private MyModel model = new MyModel(columnNames, 1);
//   	private ObjectInputStream objectInputFile;
//   	private ObjectOutputStream objectOutputFile;
 	private JTable table;
//	private ArrayList<Employee> employeeArray = new ArrayList<Employee>();
//   	private DecimalFormat money = new DecimalFormat("$#,##0.00");
   	private boolean unsavedChangesMade = false;
//   	private int selectionValue;
//   	private int currentNumberOfFields = 0;
//   	private int newNumberOfFields = 0;
   	private int currentSelectedRow = -1;
//   	private int currentEmptyRow = 0;
   	private final int WINDOW_WIDTH = 440;   // Window width
   	private final int WINDOW_HEIGHT = 145;  // Window height
//    private final String[] employeeTypes = {"Select a job class...", "Production Worker",
//    										"Shift Supervisor", "Team Leader"};
   	private int[] columnWidths = {130, 120, 65, 65, 80, 50, 80, 80};
   	TableColumn column = null;
   	private JMenuItem exitItem;
	private JMenuItem helpItem;
	private AbstractButton addItem;
	private JMenuItem openItem;
	private JMenuItem closeItem;
	private JMenuItem saveItem;
	private AbstractButton saveAsItem;
	private AbstractButton editItem;
	private JMenuItem deleteItem;
	private JMenuItem newItem;
   	
   	// Constructor
   	
   	public EmployeeManager()
   	{	
   		//buildArrays();
   		//fileChooser();
   		mainManager();
   		//adderScreen();
   		//fileBrowser();
   	}				
   	
//   	public void fileBrowser(int dialogType) {
   		
//   	}
//   	public void fileChooser()
//   	{
//   		fileChooserWindow = new JFrame("Employee Manager - Choose a File");
//   		fileChooserWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//   		fileChooserWindow.setSize(440, 150);
//   		fileChooserWindow.setLocationRelativeTo(null);
//   		
//   		JPanel fileChooserPanel = new JPanel();
//   		fileChooserWindow.add(fileChooserPanel);
//   		fileChooserPanel.setLayout(new GridLayout(2,1));
//   		fileChooserPanel.setBackground(Color.gray);
//   		
//   		
//   		JPanel userInfoTextPanel = new JPanel();
//   		userInfoTextPanel.setBackground(Color.gray);
//   		JLabel userInfoText = new JLabel("<HTML> <P>Welcome! Please enter the location of an " +
//   									    "existing .dat file, or <P>where you would like a new " +
//   									    "file to be saved.</HTML>");
//   		userInfoTextPanel.add(userInfoText);
//   		fileChooserPanel.add(userInfoTextPanel);
//   		
//   		
//   		JPanel fileLocationInputPanel = new JPanel();
//   		fileLocationInputPanel.setBackground(Color.gray);
//   		fileLocationInputField = new JTextField(35);
//   		fileLocationInputPanel.add(fileLocationInputField);
//   		//fileChooserPanel.add(fileLocationInputPanel);
//   		
//   		// Create a panel for the buttons.
//        //buttonPanel = new JPanel();
//        //buttonPanel.setBackground(Color.gray);
//
//        // Create the buttons.
//        newButton= new JButton("Create New!");
//        loadButton = new JButton("Load");
//        
//        // Register the action listeners.
//        newButton.addActionListener(new FileButtonListener());
//        loadButton.addActionListener(new FileButtonListener());
//        
//        ButtonGroup fileChooserButtonGroup = new ButtonGroup();
//        fileChooserButtonGroup.add(newButton);
//        fileChooserButtonGroup.add(loadButton);
//        
//        // Add the buttons to the button panel.
//        fileLocationInputPanel.add(newButton);
//        fileLocationInputPanel.add(loadButton);
//       
//   		fileChooserPanel.add(fileLocationInputPanel);
//   		
//   		fileChooserWindow.getRootPane().setDefaultButton(loadButton);
//   		
//   		fileChooserWindow.setResizable(false);
//   		fileChooserWindow.setVisible(true);
//   	}
   	public void mainManager()
   	{
		mainWindow = new JFrame("Employee Manager - Choose a File");
   		// Display a title
		mainWindow.setSize(WINDOW_WIDTH + 300, WINDOW_HEIGHT + 200);
		mainWindow.setLocationRelativeTo(null);
		// Specify an action for the close button.
		mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Create a BorderLayout manager.
		mainWindow.setLayout(new BoxLayout(mainWindow.getContentPane(), BoxLayout.Y_AXIS));
		mainWindow.addWindowListener(new WindowsListener());
		
		buildDisplayPanel();
		
		mainWindow.setResizable(false);
		mainWindow.setVisible(true);
	}
   	
//   	public void adderScreen()
//   	{
//   		adderWindow = new JFrame("Employee Manager - Add a New Employee");
//   		adderWindow.setSize(WINDOW_WIDTH, (WINDOW_HEIGHT + (15 * newNumberOfFields)));
//		adderWindow.setLocationRelativeTo(null);
//		// Specify an action for the close button.
//		adderWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		// Create a BorderLayout manager.
//		adderWindow.setLayout(new BoxLayout(adderWindow.getContentPane(), BoxLayout.Y_AXIS));
//		adderWindow.addWindowListener(new WindowsListener());
//		
//		buildBannerPanel();
//		buildCenterPanel();
//		buildButtonPanel();
//		
//		adderWindow.setResizable(false);
//		adderWindow.setVisible(false);
   	
   	
//   	}
   	public void buildDisplayPanel()
   	{
   		//DefaultTableModel model = new DefaultTableModel();
   		//table = new JTable(model);
   		//JPanel tablePanel = new JPanel();
   		//tablePanel.setSize(WINDOW_WIDTH + 500, WINDOW_HEIGHT - 20);
   		mainMenu = new JMenuBar();
   		JMenu file = new JMenu("File");
   		JMenu employee = new JMenu("Employee");
		JMenu help = new JMenu("Help");
		
		openItem = new JMenuItem("Open");
		openItem.setMnemonic(KeyEvent.VK_O);
		openItem.addActionListener(new mainMenuListener());
		
		newItem = new JMenuItem("New");
		newItem.setMnemonic(KeyEvent.VK_N);
		newItem.addActionListener(new mainMenuListener());
		
		closeItem = new JMenuItem("Close");
		closeItem.setMnemonic(KeyEvent.VK_C);
		closeItem.addActionListener(new mainMenuListener());
		
		saveItem = new JMenuItem("Save");
		saveItem.setMnemonic(KeyEvent.VK_S);
		saveItem.setEnabled(false);
		saveItem.addActionListener(new mainMenuListener());
		
		saveAsItem = new JMenuItem("Save As");
		saveAsItem.setMnemonic(KeyEvent.VK_A);
		saveAsItem.setEnabled(false);
		saveAsItem.addActionListener(new mainMenuListener());
		
		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new mainMenuListener());
		
		addItem = new JMenuItem("Add");
		addItem.setMnemonic(KeyEvent.VK_A);
		addItem.setEnabled(false);
		addItem.addActionListener(new mainMenuListener());
		
		editItem = new JMenuItem("Edit");
		editItem.setMnemonic(KeyEvent.VK_E);
		editItem.setEnabled(false);
		editItem.addActionListener(new mainMenuListener());
		
		deleteItem = new JMenuItem("Delete");
		deleteItem.setMnemonic(KeyEvent.VK_D);
		deleteItem.setEnabled(false);
		deleteItem.addActionListener(new mainMenuListener());
		
		helpItem = new JMenuItem("Help");
		helpItem.setMnemonic(KeyEvent.VK_H);
		helpItem.addActionListener(new mainMenuListener());
		
		file.add(openItem);
		file.add(newItem);
		file.add(saveItem);
		file.add(saveAsItem);
		file.add(closeItem);
		file.add(exitItem);
		
		employee.add(addItem);
		employee.add(editItem);
		employee.add(deleteItem);
		
		help.add(helpItem);
		
		mainMenu.add(file);
		mainMenu.add(employee);
		mainMenu.add(help);
		
   		table = TableManagement.getTable();
		JScrollPane scrollPane = new JScrollPane(table);
   		table.setFillsViewportHeight(true);
   		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
   		table.getTableHeader().setReorderingAllowed(false);
   		table.getTableHeader().setResizingAllowed(false);
   		table.getSelectionModel().addListSelectionListener(new RowListener());
   		for (int i = 0; i < 8; i++) {
   			column = table.getColumnModel().getColumn(i);
   			column.setPreferredWidth(columnWidths[i]);
   		}
   		
   		mainWindow.setJMenuBar(mainMenu);
   		mainWindow.add(scrollPane);
   		
//   		mainButtonPanel = new JPanel();
//   		
//   		mainNewFileButton = new JButton("New File");
//   		mainAddButton = new JButton("Add");
//   		mainDeleteButton = new JButton("Delete");
//   		mainEditButton = new JButton("Edit");
//   		mainSaveButton = new JButton("Save");
//   		mainExitButton = new JButton("Exit");
//   		
//   		mainNewFileButton.addActionListener(new mainButtonListener());
//   		mainAddButton.addActionListener(new mainButtonListener());
//   		mainDeleteButton.addActionListener(new mainButtonListener());
//   		mainEditButton.addActionListener(new mainButtonListener());
//   		mainSaveButton.addActionListener(new mainButtonListener());
//   		mainExitButton.addActionListener(new mainButtonListener());
//   		
//   		mainButtonPanel.add(mainNewFileButton);
//   		mainButtonPanel.add(mainAddButton);
//   		mainButtonPanel.add(mainDeleteButton);
//   		mainButtonPanel.add(mainEditButton);
//   		mainButtonPanel.add(mainSaveButton);
//   		mainButtonPanel.add(mainExitButton);
//   		
//   		mainDeleteButton.setEnabled(false);
//   		mainEditButton.setEnabled(false);
//   		mainSaveButton.setEnabled(false);
//   		
//   		mainWindow.add(mainButtonPanel);
   		
   	}
   	
   	public void setVisible() {
   		mainWindow.setVisible(true);
   	}
//   	public void buildBannerPanel()
//    {
//   		// Create the panel.
//   		bannerPanel = new JPanel();    
//   		bannerInformationPanel = new JPanel();
//   		employeeTypeBoxPanel = new JPanel();
//   		
//   		bannerPanel.setBackground(Color.gray);
//   		bannerInformationPanel.setBackground(Color.gray);
//   		employeeTypeBoxPanel.setBackground(Color.gray);
//   		
//   		bannerPanel.setLayout(new BoxLayout(bannerPanel, BoxLayout.Y_AXIS));
//   		bannerInformationPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//   		employeeTypeBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//   		
//   		// Create the label.
//        bannerInformation = new JLabel("<HTML>Please select the type of employee " + 
//								       "you would like to add. Data is <P>required" +
//								       " for all fields.</HTML>");
//        employeeTypeBox = new JComboBox<String>(employeeTypes);
//        
//        employeeTypeBox.addActionListener(new ComboBoxListener());
//        
//        bannerInformationPanel.add(bannerInformation);
//        employeeTypeBoxPanel.add(employeeTypeBox);
//        
//        // Add the label to this panel.
//        bannerPanel.add(bannerInformationPanel);
//        bannerPanel.add(employeeTypeBoxPanel);
//        
//        adderWindow.add(bannerPanel);
//    }
//   	 
//   	
    // method to create the question panel.
//	private void buildArrays()
//	{
//		int[] columnWidths = {130, 120, 65, 65, 80, 50, 80, 80};
//		TableColumn column = null;
//			
//		//model.addRow(new Object[8]);
//		for (int i = 0; i < 8; i++)
//		{
//			inputFieldPanel[i] = new JPanel();
//			inputFieldPanel[i].setLayout(new FlowLayout(FlowLayout.RIGHT));
//			inputField[i] = new JTextField(10);
//			inputFieldPanel[i].add(inputField[i]);
//			
//			fieldPanel[i] = new JPanel();
//			fieldPanel[i].setLayout(new FlowLayout(FlowLayout.LEFT));
//			field[i] = new JLabel("");
//			fieldPanel[i].add(field[i]);
//			
//			column = table.getColumnModel().getColumn(i);
//			column.setPreferredWidth(columnWidths[i]);
//			
//			
//			//table.saddColumn(new TableColumn(i, 75));
//			//table.setValueAt(columnNames[i], 0, i + 1 );
//			
//		}
//		field[0].setText("Employee Name:");
//		field[1].setText("Employee ID (where # is a digit and L is a letter A-M):");
//		field[2].setText("Hire Date:");
//		inputField[1].setText("###-L");
//		inputField[2].setText("MM/DD/YYYY");
//		inputField[1].addFocusListener(new TextFieldListener());
//		inputField[2].addFocusListener(new TextFieldListener());
//		
//		
//	}
   	
//   	private void buildButtonPanel()
//    {
//       // Create a panel for the buttons.
//       buttonPanel = new JPanel();
//       buttonPanel.setBackground(Color.gray);
//
//       // Create the buttons.
//       addButton= new JButton("Add");
//       doneButton = new JButton("Done!");
//       
//       // Register the action listeners.
//       addButton.addActionListener(new addButtonListener());
//       doneButton.addActionListener(new doneButtonListener());
//       
//       // Add the buttons to the button panel.
//       buttonPanel.add(addButton);
//       buttonPanel.add(doneButton);
//       
//       adderWindow.add(buttonPanel);
//    }


   	
			
	
//   	public void saveData()
//   	{
//   		try
//		{
//			objectOutputFile = new ObjectOutputStream(new FileOutputStream(fileLocation));
//			for (int i = 0; i < employeeArray.size(); i++)
//			{
//				if (employeeArray.get(i).getEmployeeType().equals("Production Worker"))
//					objectOutputFile.writeInt(0);
//				if (employeeArray.get(i).getEmployeeType().equals("Shift Supervisor"))
//					objectOutputFile.writeInt(1);
//				if (employeeArray.get(i).getEmployeeType().equals("Team Leader"))
//					objectOutputFile.writeInt(2);
//				objectOutputFile.writeObject(employeeArray.get(i));
//			}
//			objectOutputFile.writeInt(-1);
//			mainSaveButton.setEnabled(false);
//			unsavedChangesMade = false;
//		}
//		catch (IOException ex)
//		{
//			JOptionPane.showMessageDialog(null, "Unable to save file. Please make sure it is not " +
//												"already in use.");
//		}
//   	}
   	
//   	public void setEditorFields()
//   	{
//   		Employee employee = new Employee();
//   		if(employeeArray.get(currentSelectedRow).getEmployeeType().equals("Production Worker"))
//   		{
//   			employeeTypeBox.setSelectedIndex(1);
//   			ProductionWorker proWor = (ProductionWorker) employeeArray.get(currentSelectedRow);
//   			Integer shift = proWor.getShift();
//   			Double hourlyPayRate = proWor.getHourlyPayRate();
//   			inputField[3].setText(shift.toString());
//   			inputField[4].setText(hourlyPayRate.toString());
//   			employee = proWor;
//   		}
//   		if(employeeArray.get(currentSelectedRow).getEmployeeType().equals("Shift Supervisor"))
//   		{
//   			employeeTypeBox.setSelectedIndex(2);
//   			ShiftSupervisor shiSup = (ShiftSupervisor) employeeArray.get(currentSelectedRow);
//   			Double annualSalary = shiSup.getAnnualSalary();
//   			Double annualBonus = shiSup.getAnnualBonus();
//   			inputField[3].setText(annualSalary.toString());
//   			inputField[4].setText(annualBonus.toString());
//   			employee = shiSup;
//   		}
//   		if(employeeArray.get(currentSelectedRow).getEmployeeType().equals("Team Leader"))
//   		{
//   			employeeTypeBox.setSelectedIndex(3);
//   			TeamLeader teaLea = (TeamLeader) employeeArray.get(currentSelectedRow);
//   			Integer shift = teaLea.getShift();
//   			Double hourlyPayRate = teaLea.getHourlyPayRate();
//   			Double monthlyBonus = teaLea.getMonthlyBonus();
//   			Double attendedTrainingHours = teaLea.getAttendedTrainingHours();
//   			Double requiredTrainingHours = teaLea.getRequiredTrainingHours();
//   			inputField[3].setText(shift.toString());
//   			inputField[4].setText(hourlyPayRate.toString());
//   			inputField[5].setText(monthlyBonus.toString());
//   			inputField[6].setText(attendedTrainingHours.toString());
//   			inputField[7].setText(requiredTrainingHours.toString());
//   			employee = teaLea;
//   		}
//   		inputField[0].setText(employee.getEmployeeName());
//   		inputField[1].setText(employee.getEmployeeNumber());
//   		inputField[2].setText(employee.getHireDate());
//   	}
   	
   	private class WindowsListener implements WindowListener
   	{
		@Override
		public void windowActivated(WindowEvent e)
		{	
		}
		@Override
		public void windowClosed(WindowEvent e)
		{
			if (unsavedChangesMade)
			{
				int selection = 0;
				selection = JOptionPane.showConfirmDialog(null, "<HTML>Changes were made to this "
						+ "document that have not<P> been saved. Would you like to save them now?"
						+ "</HTML>", "Save Changes?", JOptionPane.YES_NO_CANCEL_OPTION);
				if (selection == JOptionPane.YES_OPTION)
				{
					FileManagement.saveData();
					System.exit(0);
				}
				if (selection == JOptionPane.NO_OPTION)
				{
					System.exit(0);
				}
			}
			else
				System.exit(0);
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
		@Override
		public void windowClosing(WindowEvent e) {
			if (unsavedChangesMade)
			{
				int selection = 0;
				selection = JOptionPane.showConfirmDialog(null, "<HTML>Changes were made to this "
						+ "document that have not<P> been saved. Would you like to save them now?"
						+ "</HTML>", "Save Changes?", JOptionPane.YES_NO_CANCEL_OPTION);
				if (selection == JOptionPane.YES_OPTION)
				{
					FileManagement.saveData();
					System.exit(0);
				}
				if (selection == JOptionPane.NO_OPTION)
				{
					System.exit(0);
				}
			}
			else
				System.exit(0);
			
		}
   		
   	}
   	
//   	private class ComboBoxListener implements ActionListener
//	{
//		@Override
//		public void actionPerformed(ActionEvent e)
//	    {
//			if (currentNumberOfFields == 0)
//				buttonPanel.add(doneButton);
//			if (employeeTypeBox.getSelectedItem().equals("Production Worker"))
//			{
//				rebuildCenterPanel(5);
//				field[3].setText("Shift (enter 1 for day, 2 for night):");
//				field[4].setText("Hourly Pay Rate:");
//			}
//			if (employeeTypeBox.getSelectedItem().equals("Shift Supervisor"))
//			{
//				rebuildCenterPanel(5);
//				field[3].setText("Annual Salary");
//				field[4].setText("Annual Production Bonus");
//			}
//			if (employeeTypeBox.getSelectedItem().equals("Team Leader"))
//			{
//				rebuildCenterPanel(8);
//				field[3].setText("Shift (enter 1 for day, 2 for night):");
//				field[4].setText("Hourly Pay Rate:");
//				field[5].setText("Monthly Bonus:");
//				field[6].setText("Hours of Required Training:");
//				field[7].setText("Hours of Training Attended:");
//			}
//			currentNumberOfFields = newNumberOfFields;
//	    }
//	}
   	
//   	private class TextFieldListener implements FocusListener
//	{
//		@Override
//		public void focusGained(FocusEvent f)		
//		{
//			if (f.getSource() == inputField[1])
//				if ((inputField[1].getText()).equals("###-L"))
//					inputField[1].setText("");
//				else if ((inputField[1].getText()).equals(""))
//					inputField[1].setText("###-L");
//			if (f.getSource() == inputField[2])
//				if ((inputField[2].getText()).equals("MM/DD/YYYY"))	
//					inputField[2].setText("");
//				else if ((inputField[2].getText()).equals(""))	
//					inputField[2].setText("MM/DD/YYYY");
//		}
//		@Override
//		public void focusLost(FocusEvent f)		
//		{
//			if (f.getSource() == inputField[1])
//				if ((inputField[1].getText()).equals(""))
//					inputField[1].setText("###-L");
//			if (f.getSource() == inputField[2])
//				if ((inputField[2].getText()).equals(""))	
//					inputField[2].setText("MM/DD/YYYY");
//		}
//	}
   	
   	private class RowListener implements ListSelectionListener
   	{
		@Override
		public void valueChanged(ListSelectionEvent e)
		{
			if (table.getSelectedColumn() >= 0 && table.getSelectedRow() >= 0 && table.getSelectedRow() != currentSelectedRow)
			{
				if (table.getValueAt(table.getSelectedRow(), 0) != null)
				{
					editItem.setEnabled(true);
					deleteItem.setEnabled(true);
				}
				else
				{
					editItem.setEnabled(false);
					deleteItem.setEnabled(false);
				}
				currentSelectedRow = table.getSelectedRow();
			}
			
		}
   		
   	}
   	
//   	private class FileButtonListener implements ActionListener
//   	{
//   		
//   		Boolean readyForMain = false;
//   		@Override
//		public void actionPerformed(ActionEvent e)
//   		{
//   			fileLocation = fileLocationInputField.getText();
//   			if (fileLocation.isEmpty() || fileLocation == null || containsInvalidCharacters() || 
//   					!fileLocation.substring(fileLocation.length() - 4).equalsIgnoreCase(".dat"))
//   				JOptionPane.showMessageDialog(null, "Please enter a valid filename. Filename's must end with " +
//   													"\".dat\" and cannot contain the following: / ? < > \\ : * | \" ");
//   			else
//   			{	
//   				File userInputLocation = new File(fileLocation);
//   			
//   				if (e.getSource() == newButton)
//   				{
//   					if (userInputLocation.exists())
//   					{
//   						selectionValue = JOptionPane.showConfirmDialog(null, "This file already exists. Would you like " +
//   																			 "to load the file instead? If \"NO\" is " +
//   																			 "selected the file will be overwriten and" +
//   																			 " all data in it will be lost!", "Oops!", 
//   																			 JOptionPane.YES_NO_CANCEL_OPTION);
//   						if (selectionValue == JOptionPane.YES_OPTION)
//   						{
//   							loadFileInfo();
//   						}
//   						if (selectionValue == JOptionPane.NO_OPTION)
//   						{
//   							readyForMain = true;
//   						}
//   					}
//   					else
//   					{
//   						readyForMain = true;
//   					}
//   				}
//   				if (e.getSource() == loadButton)
//   				{
//   					loadFileInfo();
//   				}
//   				if (readyForMain)
//   				{
//   					fileChooserWindow.setVisible(false);
//   					mainWindow.setTitle("Employee Manager - " + fileLocation);
//   					mainWindow.setVisible(true);
//   				}
//   			}	
//   		}
//   		private boolean containsInvalidCharacters()
//   		{
//   			return false;
//   		}
//   		private void loadFileInfo()
//   		{
//   			try
//			{
//				
//   				objectInputFile = new ObjectInputStream(new FileInputStream(fileLocation));				
//   				int objectType;
//   				while ((objectType = objectInputFile.readInt()) != -1)
//				{
//					if (objectType == 0)
//					{
//						ProductionWorker employee = (ProductionWorker) objectInputFile.readObject();
//						addTableRow(employee, currentEmptyRow);
//						employeeArray.add(employee);
//					}
//					if (objectType == 1)
//					{
//						ShiftSupervisor employee = (ShiftSupervisor) objectInputFile.readObject();
//						addTableRow(employee, currentEmptyRow);
//						employeeArray.add(employee);
//					}
//					if (objectType == 2)
//					{
//						TeamLeader employee = (TeamLeader) objectInputFile.readObject();
//						addTableRow(employee, currentEmptyRow);
//						employeeArray.add(employee);
//					}
//				}
//				
//			}
//			catch (FileNotFoundException ex)
//			{
//				JOptionPane.showMessageDialog(null, "The file was not found. Please make sure it has not " +
//											     	"been moved.");
//			}
//			catch (EOFException ex)
//			{
//				readyForMain = true;
//				try
//				{
//					objectInputFile.close();
//				} 
//				catch (IOException e)
//				{
//					JOptionPane.showMessageDialog(null, "The file did not close currectly.");
//				}
//			}
//   			catch (IOException ex)
//			{
//				JOptionPane.showMessageDialog(null, "Unable to open file. Please make sure it is not " +
//														"already in use.");
//				ex.printStackTrace();
//			}
//   			catch (ClassNotFoundException ex)
//			{
//				JOptionPane.showMessageDialog(null, "File does no contain the correct type of data. Please " +
//													"select another.");
//			}
//   		}
//   		
//   		
//   	}   	
//   	
	private class mainMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == openItem){
				mainWindow.setVisible(false);
				FileManagement.openWindow();
				if (FileManagement.isLoaded()) {
					addItem.isEnabled();
					mainWindow.setTitle("Employee Manager - " + FileManagement.getFileLocation());
				}
				mainWindow.setVisible(true);
			}
			if (e.getSource() == newItem) {
				mainWindow.setVisible(false);
				FileManagement.saveAsWindow();
				mainWindow.setVisible(true);
				addItem.setEnabled(true);
			}
			if (e.getSource() == saveAsItem){
				mainWindow.setVisible(false);
				FileManagement.saveAsWindow();
				mainWindow.setVisible(true);
			}
			if (e.getSource() == closeItem){
				if (unsavedChangesMade)
				{
					int selection = 0;
					selection = JOptionPane.showConfirmDialog(null, "<HTML>Changes were made to this "
							+ "document that have not<P> been saved. Would you like to save them now?"
							+ "</HTML>", "Save Changes?", JOptionPane.YES_NO_CANCEL_OPTION);
					if (selection == JOptionPane.YES_OPTION)
					{
						FileManagement.saveData();
						app = new EmployeeManager();
					}
					if (selection == JOptionPane.NO_OPTION)
						app = new EmployeeManager();
				}
				else
					app = new EmployeeManager();
			}
			if (e.getSource() == saveItem)
				FileManagement.saveData();
			if (e.getSource() == exitItem)
				System.exit(0);
			if (e.getSource() == addItem)
			{
				mainWindow.setVisible(false);
				ModifyWindow.showAddWindow();
				mainWindow.setVisible(true);
			}
			if (e.getSource() == editItem)
			{
				mainWindow.setVisible(false);
				ModifyWindow.showEditWindow(currentSelectedRow);
				mainWindow.setVisible(true);
			}
			
			if (e.getSource() == helpItem)
				JOptionPane.showMessageDialog(null, "Select an animal from the list, then select" +
													" a choice from the combo box to see an image");
			
			
		}
		
	}
//   	
//   	
//   	private class mainButtonListener implements ActionListener
//   	{
//		@Override
//		public void actionPerformed(ActionEvent e)
//		{
//			if (e.getSource() == mainAddButton)
//			{
//				mainWindow.setVisible(false);
//				buttonPanel.remove(doneButton);
//				buttonPanel.add(doneButton);
//				addButton.setText("Add");
//				doneButton.setText("Done");
//				adderWindow.setTitle("Employee Manager - Add a New Employee");
//				adderWindow.setVisible(true);
//			}
//			if (e.getSource() == mainDeleteButton)
//			{
//				int selection = 0;
//				selection = JOptionPane.showConfirmDialog(null, "Delete employee " 
//						+ table.getValueAt(currentSelectedRow, 0) + "?", "Confirm Delete?", 
//						JOptionPane.YES_NO_OPTION);
//				if (selection == JOptionPane.YES_OPTION)
//				{
//					model.removeRow(currentSelectedRow);
//					mainSaveButton.setEnabled(true);
//					unsavedChangesMade = true;
//					currentEmptyRow--;
//					employeeArray.remove(currentSelectedRow);
//				}
//			}
//			if (e.getSource() == mainEditButton)
//			{
//				mainWindow.setVisible(false);
//				buttonPanel.remove(addButton);
//				buttonPanel.add(addButton);
//				addButton.setText("Finished");
//				doneButton.setText(" Cancel ");
//				setEditorFields();					
//				adderWindow.setTitle("Employee Manager - Edit a Current Employee");
//				adderWindow.setVisible(true);
//			}
//			if (e.getSource() == mainSaveButton || e.getSource() == mainExitButton ||
//				e.getSource() == mainNewFileButton)
//			{
//				if (unsavedChangesMade)
//				{
//					int source = 0;
//					String messageText[] = {"", "You are about to exit. ", "You are about to open a new file."};
//					
//					int selection = 0;
//					selection = JOptionPane.showConfirmDialog(null, messageText[source] + "Would you like to save the changes made to " + fileLocation + "?", "Confirm Save?", 
//																	JOptionPane.YES_NO_OPTION);
//					if (selection == JOptionPane.YES_OPTION)
//						saveData();
//				}
//				if (e.getSource() == mainExitButton)
//					System.exit(0);
//				if (e.getSource() == mainNewFileButton)
//				{
//					mainWindow.setVisible(false);
//					app = null;
//					app = new EmployeeManager();
//				}
//			}
//		}
//   	}
   	
//   	private class addButtonListener implements ActionListener
//   	{
//		@Override
//		public void actionPerformed(ActionEvent e) 
//		{			
//			String[]  input = new String[currentNumberOfFields];
//				
//			for (int i = 0; i < currentNumberOfFields; i++)
//				input[i] = inputField[i].getText();
//			
//			if (!employeeTypeBox.getSelectedItem().equals("Select a job class..."))
//			{	
//				try
//				{
//					if (employeeTypeBox.getSelectedItem().equals("Production Worker"))
//					{
//						ProductionWorker employee = new ProductionWorker(input[0], input[1], input[2], input[3], input[4]);
//						if (addButton.getText() == "Add")
//						{
//							addTableRow(employee,currentEmptyRow);
//							employeeArray.add(employee);
//						}
//						else
//						{
//							addTableRow(employee,currentSelectedRow);
//							employeeArray.set(currentSelectedRow, employee);
//
//						}
//					}
//					else if (employeeTypeBox.getSelectedItem().equals("Shift Supervisor"))
//					{
//						ShiftSupervisor employee = new ShiftSupervisor(input[0], input[1], input[2], input[3], input[4]);
//						if (addButton.getText() == "Add")
//						{
//							addTableRow(employee,currentEmptyRow);
//							employeeArray.add(employee);
//						}
//						else
//						{
//							addTableRow(employee,currentSelectedRow);
//							employeeArray.set(currentSelectedRow, employee);
//
//						}
//					}
//					else
//					{
//						TeamLeader employee = new TeamLeader(input[0], input[1], input[2], input[3], input[4],
//														input[5], input[6], input[7]);
//						if (addButton.getText() == "Add")
//						{
//							addTableRow(employee,currentEmptyRow);
//							employeeArray.add(employee);
//						}
//						else
//						{
//							addTableRow(employee,currentSelectedRow);
//							employeeArray.set(currentSelectedRow, employee);
//
//						}
//					}
//					
//					mainSaveButton.setEnabled(true);
//					unsavedChangesMade = true;
//					for (int i = 0; i < currentNumberOfFields; i++)
//						inputField[i].setText("");
//					inputField[1].setText("###-L");
//					inputField[2].setText("MM/DD/YYYY");
//					
//					
//					if (addButton.getText() == "Finished")
//					{
//						adderWindow.setVisible(false);
//						mainWindow.setVisible(true);
//					}
//					else
//					{
//						JOptionPane.showMessageDialog(null, "<HTML>The entry was added successfully! When you" +
//								  " are done<P> adding entries, click \"Done\" to return " +
//								  "to the main window.</HTML>");
//					}
//					employeeTypeBox.setSelectedIndex(0);
//					rebuildCenterPanel(0);
//					currentNumberOfFields = 0;
//				}
//				catch (EmployeeException ex)
//				{
//					JOptionPane.showMessageDialog(null, ex.getMessage());
//					inputField[ex.getField()].requestFocus();
//					inputField[ex.getField()].selectAll();
//				}
//				catch (ProductionWorkerException ex)
//				{
//					JOptionPane.showMessageDialog(null, ex.getMessage());
//					inputField[ex.getField()].requestFocus();
//					inputField[ex.getField()].selectAll();				
//				}
//				catch (ShiftSupervisorException ex)
//				{
//					JOptionPane.showMessageDialog(null, ex.getMessage());
//					inputField[ex.getField()].requestFocus();
//					inputField[ex.getField()].selectAll();				
//				}
//				catch (TeamLeaderException ex)
//				{
//					JOptionPane.showMessageDialog(null, ex.getMessage());
//					inputField[ex.getField()].requestFocus();
//					inputField[ex.getField()].selectAll();				
//				}
//				
//			}
//			
//		}
//   		
//   	}
//   	
//   	private class doneButtonListener implements ActionListener
//   	{
//		@Override
//		public void actionPerformed(ActionEvent e) 
//		{
//			adderWindow.setVisible(false);
//			mainWindow.setVisible(true);
//		}
//   	}
   	
   	public static void main(String[] args)
   	{
		app = new EmployeeManager();
	}
}
