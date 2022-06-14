/**
 * This class writes the list to the file
 */

import java.util.*;
import java.io.*;

public class ProjectFile {

	// Creating an object of the ProjectList class
	ProjectList projectList;

	/***
	 * This method creates a list from the ProjectList class.
	 */
	// Creating a method for the getOnlyInstance class
	 ProjectFile() {
		projectList = ProjectList.getOnlyInstance();
	}

	/***
	 * This method updates the project list and writes it to the file.
	 */
	// Creating a method to write the project list to the file
	public void updateProjectList() {

		 // Using a try-catch block to write to the file
		try {
			Formatter projectsTxt = new Formatter("projects.txt");
			
			projectsTxt.format(projectList.toFile());
			projectsTxt.close();
			System.out.println("Projects file updated.");
		}

		// If the file isn't found then an appropriate message is presented.
		catch(FileNotFoundException e) {
			System.out.println("Projects file not updated.");
		}
	}
}