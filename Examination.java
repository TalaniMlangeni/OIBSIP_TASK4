/**
@author Talani Malwandla Mlangeni
@version Java development task 3
*/
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Examination {

    private static final int TOTAL_QUESTIONS = 10; // number of questions in the test
    private static final int TOTAL_TIME = 1 * 60; // 20 minutes in seconds
    private static final int WARNING_TIME = 10 * 60; // 10 minutes in seconds

    public static void main(String[] args) {
        ArrayList<UserInfo> list = new ArrayList<>();
        ExaminationQuestions test = new ExaminationQuestions();
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        // User data initialization
        list.add(new UserInfo("Steve", "01234", "12345678"));
        // (Add other users here)

        System.out.println("Hello Student, Please enter your name:");
        String userName = input.nextLine();

        UserInfo foundUser = findUserByName(list, userName);

        if (foundUser != null) {
            System.out.print("\nPlease enter your password: ");
            String password = input.nextLine();
            if (foundUser.validateUser(password)) {
                long startTime = System.currentTimeMillis();
                boolean timeUp = false;
                int i = 0;
				showMainMenu();
                int choice = getUserChoice(input);
                while (i < TOTAL_QUESTIONS) {
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000; // in seconds
                    if (elapsedTime >= TOTAL_TIME) {
                        timeUp = true;
                        break;
                    }
                    if (elapsedTime >= WARNING_TIME) {
                        System.out.println("Warning: You have 10 minutes left!");
                    }

                    if (choice == 1) {
                        int questionType = rand.nextInt(4) + 1;
                        switch (questionType) {
                            case 1:
                                test.addition();
                                break;
                            case 2:
                                test.subtraction();
                                break;
                            case 3:
                                test.multiplication();
                                break;
                            case 4:
                                test.division();
                                break;
                        }
                        i++;
                    } else if (choice == 2 || choice == 3) {
                        break; // Quit or submit
                    }
                }

                if (timeUp) {
                    System.out.println("\nTime's up! Auto-submitting your answers...");
                }

                System.out.println("\nYou have completed the test. Congratulations.");
                System.out.println("Your final score is: " + test.score + " / " + TOTAL_QUESTIONS);
            }
        } else {
            System.out.println("User not found.");
        }
    }

    private static UserInfo findUserByName(ArrayList<UserInfo> list, String userName) {
        for (UserInfo u : list) {
            if (u.getName().equals(userName)) {
                return u;
            }
        }
        return null; // User not found
    }

    private static void showMainMenu() {
        System.out.println("\n\t\t~~MAIN MENU~~");
        System.out.println("\t1. Start");
        System.out.println("\t2. Submit");
        System.out.println("\t3. Quit\n");
    }

    private static int getUserChoice(Scanner input) {
        System.out.print("Please enter the number corresponding to what you want to do: ");
        return input.nextInt();
    }
}
