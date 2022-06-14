/***
 * This class allows a user to edit the projects contained in a project file.
 * <p>
 *     The user is presented with a menu and then is able to edit a project deadline,
 *     change the amount paid by the customer, update the contractor's details,
 *     finalise a project and generate an invoice for the project, and delete a project.
 *     This is done using getters and setters.
 * </p>
 */
public class EditProjects {
    // Declaring necessary variables
    String lineSeparator = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    String contractorName;
    String contractorSurname;
    String contractorPhoneNumber;
    String contractorEmail;
    String contractorAddress;
    String newProjectDeadline;
    int customerFee = 0;
    int amountPaidToDate = 0;
    int newAmountPaid = 0;
    int outstandingAmount;

    // Creating an object of the ProjectList Class
    ProjectList projectList = ProjectList.getOnlyInstance();

    // Creating an object of the ProjectMethods Class
    ProjectMethods method = new ProjectMethods();

    // Creating an object of the ProjectFile Class
    ProjectFile file = new ProjectFile();

    // Creating an object of the ProjectInfo class
    ProjectInfo project;

    /* This method is to present the user with a menu to edit projects.
    *  And it also deals with the option selected by the user. */

    /***
     * This method shows the user their edit options.
     */
    public void Menu(){

        System.out.println("You have chosen to edit existing projects.");
        System.out.println("""
						Please select one of the following options:\s
						1 - Edit a project's deadline.
						2 - Edit the amount paid to date by the customer.
						3 - Update contractor's details.
						4 - Finalise project and print an invoice for the customer.
						5 - Delete an existing project.""");

        // gathering the user's choice using the getNum() method from the ProjectMethods Class
        int menuOption2 = method.getNum(" ");

        // Using switch-case statements for each menu option, and using break to return to the main menu
        switch (menuOption2) {

            // Allowing the user to edit a deadline
            case 1 -> EditDeadline();

            // Allowing a user to update the amount paid by the customer
            case 2 -> UpdateAmount();

            // Allowing the user to update the contractor's details
            case 3 -> UpdateContractor();

            // Allowing a user to finalise a project and print an invoice for the project
            case 4 -> FinaliseProject();

            // Allowing a user to delete a project
            case 5 -> DeleteProject();

            /* If the user does not enter a valid option,
             * an appropriate message is printed.*/
            default -> System.out.println("Please enter a valid option.");
        }
    }

    /***
     * This method allows the user to edit a project deadline.
     */
    // Creating an EditDeadline() method to change a project deadline.
    public void EditDeadline(){

        System.out.println("\nYou have chosen to edit a project's deadline.");
        System.out.println("Please enter project  number of the project you wish to edit: ");
        int prNum = projectList.getProjectNumber(method.getNum(" "));
        if(prNum > -1) {
            project = projectList.getProject(prNum);

            /* Using the dateCreator() method to edit the project deadline
             * and using the getStr() method for input*/
            System.out.println("\nPlease enter a new deadline in dd-mm-yyyy format: ");
            newProjectDeadline = method.dateCreator();
            project.setProjectDeadline(newProjectDeadline);

            // Updating the data in the file
            file.updateProjectList();
        }
    }

    /***
     * This method allows a user to edit the amount paid by a customer.
     */
    // Creating an UpdateAmount() method to change the amount paid by the customer.
    public void UpdateAmount(){

        System.out.println("\nYou have chosen to edit the amount paid by the customer.");
        System.out.println("Please enter project  number of the project you wish to edit: ");
        int prNum = projectList.getProjectNumber(method.getNum(" "));
        if(prNum > -1) {
            project = projectList.getProject(prNum);


            /* Using getters and setters to change the amount paid by the customer
             * And using the getNum() method for input*/
            System.out.println("\nPlease enter the amount paid by the customer: R");
            newAmountPaid = method.getNum(" ");
            project.setAmountPaidToDate(newAmountPaid);

            // Printing to the console that the amount the user has paid has been updated
            System.out.println("Amount paid has been updated.");

            if (customerFee == newAmountPaid) {

                // Printing a message for if the customer has paid in full
                System.out.println("\nCustomer has paid in full.");
                project.setAmountPaidToDate(customerFee);
            }

            // Updating the data in the file
            file.updateProjectList();
        }
    }

    /***
     * This method allows a user to update a contractor's details.
     */
    // Creating an UpdateContractor() method to update the contractor's details
    public void UpdateContractor(){

        System.out.println("\nYou have chosen to update a contractor's details");
        System.out.println("Please enter project  number of the project you wish to edit: ");
        int prNum = projectList.getProjectNumber(method.getNum(" "));
        if(prNum > -1) {
            project = projectList.getProject(prNum);

            // Using setters to update the contractor's details and the getStr() method to get the new information
            System.out.println("Contractor's first name: ");
            contractorName = method.getStr(" ");
            project.getContractor().setName(contractorName);

            System.out.println("\nContractor's surname: ");
            contractorSurname = method.getStr(" ");
            project.getContractor().setSurname(contractorSurname);

            System.out.println("\nContractor's phone number: ");
            contractorPhoneNumber = method.getStr(" ");
            project.getContractor().setPhoneNumber(contractorPhoneNumber);

            System.out.println("\nContractor's email address: ");
            contractorEmail = method.getStr(" ");
            project.getContractor().setEmail(contractorEmail);

            System.out.println("\nContractor's Address: ");
            contractorAddress = method.getStr(" ");
            project.getContractor().setAddress(contractorAddress);

            System.out.println("Contractor Details updated.");
            System.out.println(project.getContractor().toString());

            // Updating the data in the file
            file.updateProjectList();
        }
    }

    /***
     * This method allows a user to finalise a project and generate an invoice.
     */
    // Creating a FinaliseProject() method to finalise a project and print an invoice for that project
    public void FinaliseProject(){

        System.out.println("\nYou have chosen to finalise a project and print an invoice for the customer.");
        System.out.println("Please enter project number of the project you wish to edit: ");
        int prNum = projectList.getProjectNumber(method.getNum(" "));
        if(prNum > -1) {
            project = projectList.getProject(prNum);

            System.out.println("\nPlease enter the amount paid by the customer: R");
            newAmountPaid = method.getNum(" ");
            project.setAmountPaidToDate(newAmountPaid);

            //calculating the outstanding amount owed by the customer
            outstandingAmount = customerFee - amountPaidToDate;

            // Marking the project as complete and adding the completion date using the dateCreator() method
            System.out.println("\nPlease enter the completion date in dd-mm-yyyy format: ");
            String newCompletionDate = method.dateCreator();
            project.setCompletionDate(newCompletionDate);
            project.setProjectCompletion();

            // Printing out a customer invoice
            System.out.println(lineSeparator);
            System.out.println("Project details: ");
            System.out.println(project.getCustomer().toString() + lineSeparator
                    + project.toString() + lineSeparator + "\nAMOUNT OUTSTANDING: R" + outstandingAmount);
            System.out.println(lineSeparator);

            // Updating the data in the file
            file.updateProjectList();
        }
    }

    /***
     * This method allows a user to delete a project
     * using the deleteProject() method from the ProjectList class.
     */
    // Creating a DeleteProject() method to delete a project.
    public void DeleteProject(){
        System.out.println("You have chosen to delete a project. Please enter the project number: ");
        int prNum = projectList.getProjectNumber(method.getNum(" "));
        if(prNum > -1) {
            project = projectList.getProject(prNum);
            projectList.deleteProject(prNum);

            // Updating the data in the file
            file.updateProjectList();
        }
    }
}
