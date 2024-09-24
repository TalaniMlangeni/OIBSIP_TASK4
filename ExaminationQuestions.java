/**
@author Talani Malwandla Mlangeni
@version Java development task 3
*/
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ExaminationQuestions {

    int score = 0;

    public void addition() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        int num1 = rand.nextInt(20) + 1;
        int num2 = rand.nextInt(20) + 1;
        int num3 = rand.nextInt(20) + 1;
        int correctAnswer = num1 + num2 + num3;

        // Generate 4 wrong answers
        ArrayList<Integer> answers = generateWrongAnswers(correctAnswer);
        answers.add(correctAnswer);
        Collections.shuffle(answers); // Shuffle the answers to randomize their positions

        System.out.printf("%d + %d + %d = ?\n", num1, num2, num3);
        displayChoices(answers);

        char userAnswer = input.next().toLowerCase().charAt(0); // Get the user's answer as a letter
        int answerIndex = userAnswer - 'a'; // Convert 'a' to 0, 'b' to 1, etc.
        
        if (answers.get(answerIndex) == correctAnswer) {
            score++;
        } 
    }

    public void subtraction() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        int num1 = rand.nextInt(20) + 1;
        int num2 = rand.nextInt(20) + 1;
        int correctAnswer = (num1 >= num2) ? num1 - num2 : num2 - num1;

        // Generate 4 wrong answers
        ArrayList<Integer> answers = generateWrongAnswers(correctAnswer);
        answers.add(correctAnswer);
        Collections.shuffle(answers);

        if (num1 >= num2) {
            System.out.printf("%d - %d = ?\n", num1, num2);
        } else {
            System.out.printf("%d - %d = ?\n", num2, num1);
        }

        displayChoices(answers);

        char userAnswer = input.next().toLowerCase().charAt(0);
        int answerIndex = userAnswer - 'a';

        if (answers.get(answerIndex) == correctAnswer) {
            score++;
        } 
    }

    public void multiplication() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        int num1 = rand.nextInt(20) + 1;
        int num2 = rand.nextInt(10) + 1;
        int correctAnswer = num1 * num2;

        // Generate 4 wrong answers
        ArrayList<Integer> answers = generateWrongAnswers(correctAnswer);
        answers.add(correctAnswer);
        Collections.shuffle(answers);

        System.out.printf("%d x %d = ?\n", num1, num2);
        displayChoices(answers);

        char userAnswer = input.next().toLowerCase().charAt(0);
        int answerIndex = userAnswer - 'a';

        if (answers.get(answerIndex) == correctAnswer) {
            score++;
        } 
    }

    public void division() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        boolean isDivisible = false;
        while (!isDivisible) {
            int num1 = rand.nextInt(20) + 1;
            int num2 = rand.nextInt(20) + 1;

            if (num2 != 0 && num1 % num2 == 0) {
                int correctAnswer = num1 / num2;

                // Generate 4 wrong answers
                ArrayList<Integer> answers = generateWrongAnswers(correctAnswer);
                answers.add(correctAnswer);
                Collections.shuffle(answers);

                System.out.printf("%d / %d = ?\n", num1, num2);
                displayChoices(answers);

                char userAnswer = input.next().toLowerCase().charAt(0);
                int answerIndex = userAnswer - 'a';

                if (answers.get(answerIndex) == correctAnswer) {
                    score++;
                }
                isDivisible = true;
            }
        }
    }

    // Method to generate wrong answers
    private ArrayList<Integer> generateWrongAnswers(int correctAnswer) {
        Random rand = new Random();
        ArrayList<Integer> wrongAnswers = new ArrayList<>();
        while (wrongAnswers.size() < 4) {
            int wrongAnswer = correctAnswer + rand.nextInt(10) - 5; // Generate a close wrong answer
            if (wrongAnswer != correctAnswer && !wrongAnswers.contains(wrongAnswer)) {
                wrongAnswers.add(wrongAnswer);
            }
        }
        return wrongAnswers;
    }

    // Method to display the answer choices as a, b, c, d, e
    private void displayChoices(ArrayList<Integer> answers) {
        char[] options = {'a', 'b', 'c', 'd', 'e'}; // Choices as a, b, c, d, e
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(options[i] + ": " + answers.get(i));
        }
        System.out.print("Choose the correct answer (a-e): ");
    }
}
