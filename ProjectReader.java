/***
 * This class contains methods to read from the file and create a new project
 */

import java.util.*;
import java.io.*;

class ProjectReader {
	// Creating an object of the ProjectList class
	ProjectList projectList;

	/***
	 * Constructor of the class.
	 */
	// Calling the getOnlyInstance() method from the projectList class
	ProjectReader(){
		projectList = ProjectList.getOnlyInstance();
	}

	// Creating an object of the ProjectMethods class
	ProjectMethods method = new ProjectMethods();

	/***
	 * This method reads the data in the file and adds it to the ArrayList
	 */
	/* Creating a method to read the data in the file
	* and add the file data to the ArrayList of projects */
	public void FileData() {

		// using a try-catch block to read from the file
		try{

			// Creating a file object and a scanner object
			File projectFile = new File("projects.txt");
			Scanner sc = new Scanner(projectFile);

			// Using a while loop to read the data in the file
			while(sc.hasNext()){

				// Separating each line in the file into a new array
				String line = sc.nextLine();
				String[] pList = line.split("; ");

				// initialising variables for each index in the second array
				String pName = pList[0], bAdd = pList[1], bType = pList[2], pDue = pList[4], pCompDate = pList[10];

				int pCost = Integer.parseInt(pList[5]), pPaid = Integer.parseInt(pList[6]),
						pERF = Integer.parseInt(pList[7]), pNum = Integer.parseInt(pList[8]);

				boolean pDone = Boolean.parseBoolean(pList[9]);

				// Creating objects of each data group in the array
				PersonalInformation cont = new PersonalInformation(pList[11], pList[12],
						pList[13], pList[14], pList[15], pList[16]);

				PersonalInformation arch = new PersonalInformation(pList[17],
						pList[18], pList[19], pList[20], pList[21], pList[22]);

				PersonalInformation cus = new PersonalInformation(pList[23],
						pList[24], pList[25], pList[26], pList[27], pList[28]);

				ProjectInfo projectInfo = new ProjectInfo(pName, bAdd, bType, pDue, pDone, pCompDate, cus, arch, cont,
						pCost, pPaid, pERF, pNum);

				// Adding the project object to the ArrayList
				projectList.addProject(projectInfo);
			}
		}

		// Using a catch block in case the file can't be found
		catch(FileNotFoundException e) {
			System.out.println("Projects file not found. Please try again.");
		}
	}

	/***
	 * This method creates a project using user input.
	 */
	// Creating a method to create a new project from user input
	public void createProject() {
		
		// Declaring variables for each person's details	
		String personType = null;

		String architectName = null;
		String architectSurname = null;
		String architectPhoneNumber = null;
		String architectEmail = null;
		String architectAddress = null;
		
		String contractorName;
		String contractorSurname;
		String contractorPhoneNumber;
		String contractorEmail;
		String contractorAddress;
								
		String customerName = null;
		String customerSurname;
		String customerPhoneNumber = null;
		String customerEmail = null;
		String customerAddress = null;
									
		// Declaring variables for project information
		String projectName;
		String buildingAddress;
		String buildingType;
		String projectDeadline;
		
		boolean projectCompletion = false;
		String completionDate;
		int customerFee;
		int amountPaidToDate;
		int erf;
		int projectNumber;
		String lineSeparator = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

				
		//Gathering the project information using the getNum() and getStr() methods for input
		System.out.println("\nPlease enter the name of the project: ");
		projectName = method.getStr(" ");

		System.out.println("\nPlease enter the address of this building: ");
		buildingAddress = method.getStr(" ");
				
		System.out.println("\nPlease enter the type of building for this project: ");
		buildingType = method.getStr(" ");

		System.out.println("\nPlease enter the surname of the customer for whom this project is being built: ");
		customerSurname = method.getStr(" ");

		System.out.println("\nPlease enter the project's due date in dd-mm-yyyy format: ");
		projectDeadline = method.dateCreator();

		System.out.println("\nPlease enter the cost of this project: R");
		customerFee = method.getNum(" ");
				
		System.out.println("\nPlease enter the amount paid by the customer to date: R");
		amountPaidToDate = method.getNum(" ");
				
		System.out.println("\nPlease enter the project's ERF number: ");
		erf = method.getNum(" ");
				
		System.out.println("\nPlease enter the project number: ");
		projectNumber = method.getNum(" ");
				
		/* by default a new project is incomplete 
		 * so this block of code is for if a user wishes to add a previously completed project */
		if(!projectCompletion) {
			System.out.println("\nPlease enter the date of completion in dd-mm-yyyy format: ");
			completionDate = method.dateCreator();
		}
					
		else {
			completionDate = "None";
		}
				
		
		// Gathering the customer's information using the getStr() methods for input.
		System.out.println("\nPlease enter the customer's details");
				
		// Creating a customer object of the personalInformation class.
		PersonalInformation customer = new PersonalInformation(personType, customerName, customerSurname,
				customerPhoneNumber, customerEmail, customerAddress);
		personType = "Customer";
		customer.setPerson(personType);
					
		// Asking the user for the customer's information using the getStr() methods for input.
		System.out.println("\nCustomer's first name: ");
		customerName = method.getStr(" ");
		customer.setName(customerName);
					
		System.out.println("\nCustomer's surname: ");
		customerSurname = method.getStr(" ");
		customer.setSurname(customerSurname);
						
		System.out.println("\nCustomer's phone number: ");
		customerPhoneNumber = method.getStr(" ");
		customer.setPhoneNumber(customerPhoneNumber);
						
		System.out.println("\nCustomer's email address: ");
		customerEmail = method.getStr(" ");
		customer.setEmail(customerEmail);
						
		System.out.println("\nCustomer's Address: ");
		customerAddress = method.getStr(" ");
		customer.setAddress(customerAddress);
				
				
		//Gathering the architect's information using the getStr() methods for input.
		System.out.println("\nPlease enter the Architect's details");
				
		// Creating an architect object of the personalInformation class.
		PersonalInformation architect = new PersonalInformation(personType, architectName, architectSurname,
				architectPhoneNumber, architectEmail, architectAddress);
		personType = "Architect";
		architect.setPerson(personType);
				
		// Asking the user for the architect's information using the getStr() methods for input.
		System.out.println("Architect's first name: ");
		architectName = method.getStr(" ");
		architect.setName(architectName);
			
		System.out.println("\nArchitect's surname: ");
		architectSurname = method.getStr(" ");
		architect.setSurname(architectSurname);
				
		System.out.println("\nArchitect's phone number: ");
		architectPhoneNumber = method.getStr(" ");
		architect.setPhoneNumber(architectPhoneNumber);
				
		System.out.println("\nArchitect's email address: ");
		architectEmail = method.getStr(" ");
		architect.setEmail(architectEmail);
				
		System.out.println("\nArchitect's Address: ");
		architectAddress = method.getStr(" ");
		architect.setAddress(architectAddress);
				
				
		//Gathering the contractor's information using the getStr() methods for input.
		System.out.println("\nPlease enter the Contractor's details");
				
		// Creating a contractor object of the personalInformation class.
		PersonalInformation contractor = new PersonalInformation(personType, architectName, architectSurname,
				architectPhoneNumber, architectEmail, architectAddress);
		personType = "Contractor";
		contractor.setPerson(personType);
				
		// Asking the user for the contractor's information using the getStr() methods for input.
		System.out.println("Contractor's first name: ");
		contractorName = method.getStr(" ");
		contractor.setName(contractorName);
					
		System.out.println("\nContractor's surname: ");
		contractorSurname = method.getStr(" ");
		contractor.setSurname(contractorSurname);
						
		System.out.println("\nContractor's phone number: ");
		contractorPhoneNumber = method.getStr(" ");
		contractor.setPhoneNumber(contractorPhoneNumber);
						
		System.out.println("\nContractor's email address: ");
		contractorEmail = method.getStr(" ");
		contractor.setEmail(contractorEmail);
					
		System.out.println("\nContractor's Address: ");
		contractorAddress = method.getStr(" ");
		contractor.setAddress(contractorAddress);
				
				
		// Creating an object of the projectInfo class
		ProjectInfo project = new ProjectInfo(projectName, buildingAddress, buildingType, projectDeadline,
				projectCompletion, completionDate, contractor, architect, customer, customerFee, amountPaidToDate,
				erf, projectNumber);

		//Adding code for if the user fails to enter a project name.
		if(projectName.equals("")) {
			projectName = buildingType + " " + customerSurname;
			project.setProjectName(projectName);
		}

		// Printing out the project details
		System.out.println(lineSeparator);
		System.out.println("Project details: " + "\n" + project.toString() + "\n" +lineSeparator);
		System.out.println("Customer Details: " + "\n" + customer.toString() + "\n" +lineSeparator);
		System.out.println("Architect Details: " + "\n" + architect.toString() + "\n" +lineSeparator);
		System.out.println("Contractor Details: " + "\n" + contractor.toString() + "\n" +lineSeparator);

		// Adding the newly created project to the project list
		projectList.addProject(project);
	}
}
