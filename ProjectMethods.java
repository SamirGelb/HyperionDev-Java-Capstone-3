/***
 * This class contains methods to take in user input.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* Creating a class to contain all the methods
* required for user input
* and for datetime calculations*/
public class ProjectMethods {

    // creating a static scanner object
    static Scanner input = new Scanner(System.in);

    /***
     *
     * @param instruction takes in integer input from the user
     * @return the integers the user entered
     */
    /* Creating a method called getNum() to get
     * integers from the user using a try and catch block */
    public int getNum(String instruction) {

        while (true) {

            // In the try block I return the scanner and cast the string to an integer data type
            try {
                System.out.println(instruction);
                return Integer.parseInt(input.nextLine());
            }

            // if a string is entered I show an error message
            catch (NumberFormatException e) {
                System.out.println("Please enter an integer.");
            }
        }
    }

    /***
     *
     * @param instruction takes in a String from user input
     * @return the string the user entered
     */
    /* Creating a method called getNum() to get
     * integers from the user using a try and catch block */
    public String getStr(String instruction) {

        while(true) {
            // In the try block I return the scanner and cast the string to an integer data type
            try {
                System.out.println(instruction);
                return input.nextLine();
            }

            // if a string is not entered I show an error message
            catch(Exception e) {
                System.out.println("Please enter a string of letters.");
            }
        }
    }

    /***
     *
     * @return the date entered by the user
     */
    /* Creating a method called dateCreator() to add
    * the date in a set format for each project.*/
    public String dateCreator(){
        String date;

        /* Creating an object of the SimpleDateFormat method and passing the format
        * that the user should enter.*/
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Using a while loop and try-catch block
        while(true){
            try{

                // Collecting the date from the user
                Date deadline = dateFormat.parse(getStr(" "));
                date = dateFormat.format(deadline);
                break;
            }

            /* Asking the user to enter the right format
            if they do not the first time around */
            catch(ParseException pe){
                System.out.println("Please enter the date in the format stated above.");
            }
        }

        // returning the project deadline
        return date;
    }
}
