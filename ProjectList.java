/***
 * This class deals with creating and editing an ArrayList
 * of all the projects which the user has generated.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProjectList {

	// Creating an object of the ProjectInfo class
	ProjectInfo project;

	// Creating a private ArrayList.
	private ArrayList<ProjectInfo> prList;

	// Creating a private onlyInstance variable.
	private static ProjectList onlyInstance = null;

	/***
	 * This is the constructor of the class
	 */
	// Constructor
	private ProjectList() {
		this.prList = new ArrayList<ProjectInfo>();
	}

	/***
	 *
	 * @param projectNumber Project number
	 * @return project number
	 */
	// Creating a getProject() method to find the index of each project.
	public ProjectInfo getProject(int projectNumber) {
		return prList.get(projectNumber);
	}

	// Adding the lineSeparator variable
	String lineSeparator = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

	/***
	 *
	 * @return the list
	 */
	// Creating a getOnlyInstance() class to retrieve the ArrayList.
	public static ProjectList getOnlyInstance() {
		if(onlyInstance == null) {
			onlyInstance = new ProjectList();
		}
		return onlyInstance;
	}

	/***
	 *
	 * @param project adds a project to the list
	 */
	// Creating an addProject() method to add a project to the ArrayList.
	public void addProject(ProjectInfo project) {
		prList.add(project);
	}

	/***
	 *
	 * @param projectNumber deletes a project from the list
	 */
	// Creating a deleteProject() method to remove a project from the ArrayList.
	public void deleteProject(int projectNumber) {

		/* Checking that the project number is within the size of the Array
		* and using the .remove() method to remove the corresponding project.*/
		if(projectNumber < prList.size()) {
			prList.remove(projectNumber);
			System.out.println("Project " + projectNumber + " has been deleted.");
		}
	}

	/***
	 *
	 * @return adds each project on a new line in the file
	 */
	// Creating a toFile method to print the ArrayList to the file.
	public String toFile() {
		StringBuilder output = new StringBuilder();

		// Adding each project to a new line.
		for(ProjectInfo project : prList) {
			output.append(project.toFile()).append("\n");
		}
		return output.toString();
	}

	/***
	 * This method allows a user to view all the projects in the list
	 */
	// Creating a function for the user to view all the projects in the list
	public void ViewAll(){
		for(ProjectInfo project : prList){
				System.out.println(lineSeparator + project);
			}
	}

	/***
	 * This method allows a user to view the incomplete projects in the list.
	 */
	// Creating a ViewIncomplete() method to allow a user to view all incomplete projects
	public void ViewIncomplete(){
		for(ProjectInfo project : prList) {
			if(!project.isProjectCompletion()){
				System.out.println(lineSeparator + project);
			}
		}
	}

	/***
	 * This method allows a user to view overdue projects by comparing dates.
	 * It uses a try-catch block to handle errors.
	 */
	// Creating an Overdue() method to allow a user to see overdue projects
	public void Overdue() {

		try{
			Date today = new Date();

			for(ProjectInfo project : prList){
				Date projectDeadline = new SimpleDateFormat("dd-MM-yyyy").parse(project.getProjectDeadline());
				if(projectDeadline.compareTo(today) < 0){
					System.out.println(lineSeparator + project);
				}
			}
		}

		catch(ParseException pe){
			System.out.println("Parse Exception");
		}
	}

	/***
	 * This method finds the index of the project number entered by the user
	 * @param projNumb project number
	 * @return index of the project based on the project number
	 */
	// Creating a getProjectNumber() method to get the project based on the project number in the file.
	public int getProjectNumber(int projNumb){
		int pn = -1;

		for(int i = 0; i < prList.size(); i++){
			if(prList.get(i).getProjectNumber() == projNumb) {
				pn = i;
				break;
			}

		}
		// Printing out an error message for the user if the project number entered is not found in the file.
		if (pn == -1){
			System.out.print("Project not found. Please enter a valid project number.");
		}
		return pn;
	}
}
