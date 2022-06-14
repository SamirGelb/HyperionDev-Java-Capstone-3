/***
 * This class creates an object of a person's personal details.
 */
public class PersonalInformation {

	/* Declaring attributes. 
	 * I made the phone number a string in order to make it easier to write to a file (e.g. excel) in future. */
	String personType;
	String name;
	String surname;
	String phoneNumber;
	String emailAddress;
	String physicalAddress;

	/***
	 *
	 * @param personType Whether the person entered is an architect, contractor, or customer
	 * @param name Their first name
	 * @param surname Their surname
	 * @param phoneNumber Their phone number
	 * @param emailAddress Their email address
	 * @param physicalAddress Their physical address
	 */
	// Constructor
	public PersonalInformation(String personType, String name, String surname, String phoneNumber, String emailAddress,
							   String physicalAddress) {
		
		this.personType = personType;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
	}

	/***
	 *
	 * @return first name
	 */
	// Creating getters for personal details
	
	public String getName() {
		return this.name;
	}

	/***
	 *
	 * @return surname
	 */
	public String getSurname() {
		return this.surname;
	}

	/***
	 *
	 * @param personType set what kind of person it is
	 */
	// creating setters for personal details 
	public void setPerson(String personType) {
		this.personType = personType;
	}

	/***
	 *
	 * @param name set first name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/***
	 *
	 * @param surname set surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/***
	 *
	 * @param phoneNumber set phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/***
	 *
	 * @param emailAddress set email address
	 */
	public void setEmail(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/***
	 *
	 * @param physicalAddress set physical address
	 */
	public void setAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	/***
	 *
	 * @return a String representation of the information entered for the console.
	 */
	// Creating a toString of the personal information
	public String toString() {	
		String output = "Project Role: " + personType;
		output += "\nName: " + name;
		output += "\nSurname: " + surname;
		output += "\nPhone Number: " + phoneNumber;
		output += "\nEmail Address: " + emailAddress;
		output += "\nPhysical Address: " + physicalAddress;
			
		return output;
	}

	/***
	 *
	 * @return a String representation of the information entered for the file.
	 */
	// Creating a toFile() method to add the information as a single string in the file
	public String toFile(){
		return personType + "; " + name + "; " + surname + "; " + phoneNumber + "; " + emailAddress
				+ "; " + physicalAddress;
	}
}
