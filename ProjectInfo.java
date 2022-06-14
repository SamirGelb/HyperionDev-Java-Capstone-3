/***
 * This class creates an object of the Project Information.
 * It also creates objects of each person type from the PersonalInformation class.
 */
public class ProjectInfo {

	// Declaring attributes
	String projectName;
	String buildingAddress;
	String buildingType;
	String projectDeadline;
	boolean projectCompletion;
	String completionDate;
	PersonalInformation contractor;
	PersonalInformation architect;
	PersonalInformation customer;
	int customerFee;
	int amountPaidToDate;
	int erf;
	int projectNumber;

	/***
	 *
	 * @param projectName Project Name
	 * @param buildingAddress Address of the Project
	 * @param buildingType What type of building being built
	 * @param projectDeadline When the project is due
	 * @param projectCompletion If the project has been completed
	 * @param completionDate When the project was completed
	 * @param contractor Contractor details
	 * @param architect Architect details
	 * @param customer Customer details
	 * @param customerFee How much the project will cost
	 * @param amountPaidToDate How much the customer had paid so far
	 * @param erf Project's ERF number
	 * @param projectNumber The project's index number in the text file
	 */
	// Constructor
	public ProjectInfo(String projectName, String buildingAddress, String buildingType, String projectDeadline,
					   boolean projectCompletion, String completionDate, PersonalInformation contractor,
					   PersonalInformation architect, PersonalInformation customer, int customerFee,
					   int amountPaidToDate, int erf, int projectNumber) {
		
		this.projectName = projectName;
		this.buildingAddress = buildingAddress;
		this.buildingType = buildingType;
		this.projectDeadline = projectDeadline;
		this.completionDate = completionDate;
		this.contractor = contractor;
		this.architect = architect;
		this.customer = customer;
		this.customerFee = customerFee;
		this.amountPaidToDate = amountPaidToDate;
		this.erf = erf;
		this.projectNumber = projectNumber;
		this.projectCompletion = false;
		
	}

	// Creating getters for the project information

	/***
	 *
	 * @return project deadline
	 */
	public String getProjectDeadline() {
		return this.projectDeadline;
	}

	/***
	 *
	 * @return contractor details
	 */
	public PersonalInformation getContractor() {
		return this.contractor;
	}

	public int getProjectNumber() {
		return projectNumber;
	}

	/***
	 *
	 * @return customer details
	 */
	public PersonalInformation getCustomer() {
		return this.customer;
	}
	
	// Creating setters for the project information

	/***
	 *
	 * @param newProjectName set a new project name
	 */
	public void setProjectName(String newProjectName) {
		projectName = newProjectName;
	}

	/***
	 *
	 * @param newProjectDeadline set a new project deadline
	 */
	public void setProjectDeadline(String newProjectDeadline) {
		projectDeadline = newProjectDeadline;
	}

	/***
	 *
	 * @param newAmountPaid set a new amount paid by the customer
	 */
	public void setAmountPaidToDate(int newAmountPaid) {
		amountPaidToDate = newAmountPaid;
	}

	public void setProjectCompletion() {
		projectCompletion = true;
	}

	public void setCompletionDate(String newCompletionDate){
		completionDate = newCompletionDate;
	}

	/***
	 *
	 * @return whether the project is complete or not
	 */
	// Creating a boolean method to set the projectCompletion
	public boolean isProjectCompletion() {
		return projectCompletion;
	}

	/***
	 *
	 * @return a String representation of the information entered for the console.
	 */
	// Creating a toString of the ProjectDetails
	public String toString() {
		
		String output = "Project Name: " + projectName;
		output += "\nBuilding Address: " + buildingAddress;
		output += "\nBuilding Type: " + buildingType;
		output += "\nCustomer Name: " + customer.getName() + " " + customer.getSurname();
		output += "\nProject Deadline: " + projectDeadline;
		output += "\nProject Cost: R" + customerFee;
		output += "\nAmount Paid To Date: R" + amountPaidToDate;
		output += "\nERF Number: " + erf;
		output += "\nProjectNumber: " + projectNumber;
		output += "\nProject Complete?: " + isProjectCompletion();
		output += "\nCompletion Date: " + completionDate;
		output += "\nArchitect: " + architect.getName() + " " + architect.getSurname();
		output += "\nContractor: " + contractor.getName() + " " + contractor.getSurname();
		
		return output;
	}

	/***
	 *
	 * @return a String representation of the information entered for the file
	 */
	// Creating a toFile() method to add the information as a single string in the file
	public String toFile(){
		return projectName + "; " + buildingAddress + "; " + buildingType + "; " + customer.getName() + " "
				+ customer.getSurname() + "; " + projectDeadline + "; " + customerFee + "; " + amountPaidToDate + "; "
				+ erf + "; " + projectNumber + "; " + isProjectCompletion() + "; " + completionDate + "; "
				+ customer.toFile() + "; " + architect.toFile() + "; " + contractor.toFile();
	}
}
