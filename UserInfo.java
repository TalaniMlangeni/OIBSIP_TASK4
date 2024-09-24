/**
@author Talani Malwandla Mlangeni
@version Java development task 3
*/

import java.util.Scanner;

public class UserInfo {

    // Fields to store user's information
    private String name;           // Stores the user's name
    private String password;       // Stores the user's password
    private String studentNumber;  // Stores the user's student number

    // Default constructor
    public UserInfo() {
        this("", "", "");  // Calls the parameterized constructor with default empty values
    }

    // Parameterized constructor to initialize user information
    public UserInfo(String name, String password, String studentNumber) {
        setName(name);               // Sets the user's name
        setPassword(password);       // Sets the user's password
        setStudentNumber(studentNumber); // Sets the user's student number
    }

    // Setters to update the values of the fields
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    // Getters to retrieve the values of the fields
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    // Method to validate the user based on the entered password
    public boolean validateUser(String password) {
        int maxAttempts = 3;             // Maximum number of password attempts allowed
        int remainingAttempts = maxAttempts - 1; // Remaining attempts, starts at 2
        Scanner input = new Scanner(System.in);  // Scanner for input
        boolean correctPassword = false;  // Flag to check if password is correct

        // Loop to allow the user to try entering the correct password
        for (int i = 0; i < maxAttempts; i++) {
            // If the entered password matches the stored password
            if (password.equals(this.password)) {
                System.out.println("Welcome " + getName());  // Display welcome message
                correctPassword = true;
                break;  // Exit loop once correct password is entered
            }

            // If password is incorrect, notify the user and display remaining attempts
            System.out.println("That password was incorrect. You have " + remainingAttempts + " attempt(s) left.");
            remainingAttempts--;  // Decrease remaining attempts

            // If no attempts are left, display a lockout message
            if (remainingAttempts == 0) {
                System.out.println("\nYOU HAVE REACHED THE MAXIMUM ATTEMPTS!!!");
                break;
            }

            // Prompt the user to re-enter their password
            System.out.print("Please re-enter your password: ");
            password = input.nextLine();  // Update password variable for the next attempt
        }

        return correctPassword;  // Return whether the password was correct or not
    }

    // Method to return a formatted string with the user's information
    @Override
    public String toString() {
        return String.format("Hello, %s. Student number: %s", getName(), getStudentNumber());
    }
}
