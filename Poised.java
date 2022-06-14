/**
 * POISED
 * Final Capstone submission for HyperionDev's Software Engineering Bootcamp Level 2
 *
 * @author Samir Gelb
 * @version 3.0 10 June 2022
 */

public class Poised {
	/***
	 * Main method implements all other methods.
	 * @param args arguments
	 */
	public static void main(String[] args){

		// Creating an object of the Reader Class
		ProjectReader reader = new ProjectReader();

		// Calling the FileData() method of the ProjectReader Class
		reader.FileData();

		// Creating an object of the ProjectList Class
		ProjectList projectList = ProjectList.getOnlyInstance();

		// Creating an object of the ProjectFile class
		ProjectFile file = new ProjectFile();

		// Creating an object of the EditProjects class
		EditProjects editProjects = new EditProjects();

		// Creating an object of the ProjectMethods class
		ProjectMethods method = new ProjectMethods();

		// Adding the lineSeparator variable
		String lineSeparator = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

		// Using a while loop to enter the menu
		while(true){

			// Presenting the user with a menu
			System.out.println("""
					Please select one of the following options:\s
					1 - View All Projects
					2 - Add a new Project.
					3 - Edit Projects.
					4 - View Incomplete Projects
					5 - View Overdue Projects
					6 - Quit.""");

			// gathering the user's choice using the getNum() method from the ProjectMethods Class
			int menuOption = method.getNum(" ");

			/* If the user chooses to exit the program an exit message is printed and the program exits
			* This is outside the switch-case statement to ensure the program quits*/
			if(menuOption == 6){
				System.out.println("Arrivederci!");
				System.out.println(lineSeparator);
				break;
			}

			// Using a switch-case statement for each user choice

			switch (menuOption) {
				case 1 -> {
					System.out.println("You have chosen to view all projects.");
					projectList.ViewAll();
					System.out.println(lineSeparator);
				}

				// Allowing the user to add a new project
				case 2 -> {
					System.out.println("You have chosen to add a new project.");

					// Calling the createProject() method from the Reader Class
					reader.createProject();
					System.out.println("New Project added.");

					// Adding the project to the file
					file.updateProjectList();
					System.out.println(lineSeparator);
				}

				/* If the user chooses to edit a project
				 * they are presented with a second menu.
				 * This menu is called from the EditProjects Class */
				case 3 -> {
					editProjects.Menu();
					System.out.println(lineSeparator);
				}

				/* If the user asks to view all incomplete projects
				 * I call the ViewIncomplete method from the EditProjects Class */
				case 4 -> {
					System.out.println("You have chosen to view all incomplete projects.");
					projectList.ViewIncomplete();
					System.out.println(lineSeparator);
				}

				/* If the user asks to view all incomplete projects
				 * I call the Overdue method from the EditProjects Class */
				case 5 -> {
					System.out.println("You have chosen to view all overdue projects.");
					projectList.Overdue();
					System.out.println(lineSeparator);
				}

				/* If the user does not enter a valid option,
				 * an appropriate message is printed.*/
				default -> System.out.println("Please enter a valid option.");
			}
		}
	}
}