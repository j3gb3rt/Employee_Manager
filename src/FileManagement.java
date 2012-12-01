import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileManagement {
	private static ArrayList<Employee> employeeArray = new ArrayList<Employee>();
   	private static ObjectInputStream objectInputFile;
   	private static ObjectOutputStream objectOutputFile;
	private static String locationOfFile;
	private static boolean unsavedChangesMade;
	private static boolean fileLoadedSuccessfully = false;
	
	public static void addEmployee(Employee emp) {
		employeeArray.add(emp);
		unsavedChangesMade = true;
	}
	
	public static ArrayList<Employee> getEmployeeList() {
		return employeeArray;
	}
	
	public static Employee getEmployee(int index) {
		return employeeArray.get(index);
	}
	
	public static String getFileLocation() {
		return locationOfFile;
	}
	
	
	
	public static boolean isLoaded() {
		return fileLoadedSuccessfully ;
	}
	
	public static boolean isUnsaved() {
		return unsavedChangesMade;
	}
	
	public static void saveData() {
		try
		{
			objectOutputFile = new ObjectOutputStream(new FileOutputStream(locationOfFile));
			for (int i = 0; i < employeeArray.size(); i++)
			{
				if (employeeArray.get(i).getEmployeeType().equals("Production Worker"))
					objectOutputFile.writeInt(0);
				if (employeeArray.get(i).getEmployeeType().equals("Shift Supervisor"))
					objectOutputFile.writeInt(1);
				if (employeeArray.get(i).getEmployeeType().equals("Team Leader"))
					objectOutputFile.writeInt(2);
				objectOutputFile.writeObject(employeeArray.get(i));
			}
			objectOutputFile.writeInt(-1);
			unsavedChangesMade = false;
		}
		catch (IOException ex)
		{
			JOptionPane.showMessageDialog(null, "Unable to save file. Please make sure it is not " +
												"already in use.");
		}
	}
	
	public static void saveData(String fileLocation) {
		locationOfFile = fileLocation;
		saveData();
	}
	public static void loadData() {
		try
		{
			objectInputFile = new ObjectInputStream(new FileInputStream(locationOfFile));				
			int objectType;
			while ((objectType = objectInputFile.readInt()) != -1)
			{
				if (objectType == 0)
				{
					ProductionWorker employee = (ProductionWorker) objectInputFile.readObject();
					TableManagement.addTableRow(employee);
					employeeArray.add(employee);
				}
				if (objectType == 1)
				{
					ShiftSupervisor employee = (ShiftSupervisor) objectInputFile.readObject();
					TableManagement.addTableRow(employee);
					employeeArray.add(employee);
				}
				if (objectType == 2)
				{
					TeamLeader employee = (TeamLeader) objectInputFile.readObject();
					TableManagement.addTableRow(employee);
					employeeArray.add(employee);
				}
			}
			fileLoadedSuccessfully = true;
		}
		catch (FileNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null, "The file was not found. Please make sure it has not " +
					"been moved.");
			fileLoadedSuccessfully = false;
		}
		catch (EOFException ex)
		{
			try
			{
				objectInputFile.close();
			} 
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "The file did not close currectly.");
				fileLoadedSuccessfully = false;
			}
			fileLoadedSuccessfully = false;
		}
		catch (IOException ex)
		{
			JOptionPane.showMessageDialog(null, "Unable to open file. Please make sure it is not " +
					"already in use.");
			ex.printStackTrace();
			fileLoadedSuccessfully = false;
		}
		catch (ClassNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null, "File does no contain the correct type of data. Please " +
					"select another.");
			fileLoadedSuccessfully = false;
		}
	}
	
	public static void openWindow() {
		JFileChooser fileBrowserWindow = new JFileChooser();
   		FileNameExtensionFilter filter = new FileNameExtensionFilter(
   		        "Employee Management Files", "emf");
   		fileBrowserWindow.setFileFilter(filter);	
   		int returnVal = fileBrowserWindow.showOpenDialog(fileBrowserWindow);
   		if(returnVal == JFileChooser.APPROVE_OPTION) {
   			locationOfFile = fileBrowserWindow.getSelectedFile().getAbsolutePath();
   			loadData();
   		}
   		
	}
	
	public static void saveAsWindow() {
		JFileChooser fileBrowserWindow = new JFileChooser();
   		FileNameExtensionFilter filter = new FileNameExtensionFilter(
   		        "Employee Management Files", "emf");
   		fileBrowserWindow.setFileFilter(filter);	
   		int returnVal = fileBrowserWindow.showSaveDialog(fileBrowserWindow);
   		if(returnVal == JFileChooser.APPROVE_OPTION) {
   			locationOfFile = fileBrowserWindow.getSelectedFile().getAbsolutePath();
   			saveData();
   		}
   		
	}
}
