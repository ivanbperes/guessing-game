package guessinggame;

import java.util.Scanner;

public class GuessingGame {
    public static void numberGuessingGame(int maxNumber, int maxTrials) {
        Scanner keyboard = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * maxNumber + 1);
        int userGuess = 0;
        int attempts;
        System.out.print("""
                \n+---------+ Number Guessing Game +---------+
                We picked a random number between 1 and %d.
                """, maxNumber);
        if(maxNumber != maxTrials) {
            System.out.println("You have up to " + maxTrials + " attempts. Try and guess it!");
        }
        System.out.println("+------------------------------------------+\n");

        for(attempts = 1; attempts <= maxTrials; attempts++) {
            System.out.println("Enter your guess:");
            userGuess = keyboard.nextInt();

            if(userGuess < 1 || userGuess > maxNumber) {
                System.out.printf("""
                        This is not a valid guess for this game.
                        Enter a number between 1 and %d. Try again!""", maxNumber);
            } else if(userGuess < randomNumber) {
                System.out.println("Your guess is less than the number we picked.\n");
            } else if(userGuess > randomNumber) {
                System.out.println("Your guess is higher than the number we picked.\n");
            } else {
                break;
            }
        }

        if(userGuess == randomNumber) {
            System.out.printf("""
                    \nCongratulations, %d is the correct answer!
                    You got it right after %d attempts.
                    """, randomNumber, attempts);
        } else {
            System.out.printf("""
                    I'm sorry, you didn't get it right within %d attempts.
                    The correct answer was %d.
                    """, maxTrials, randomNumber);
        }
    }

    public static void gameMaker() {
        Scanner keyboard = new Scanner(System.in);
        int maxNumber;
        int maxTrials;

        System.out.println("""
                \n+-----+ Make your own game +-----+
                Up to which number should we pick?""");

        maxNumber = keyboard.nextInt();

        while(maxNumber < 1) {
            System.out.println("Invalid number. Try a positive number.");
            maxNumber = keyboard.nextInt();
        }

        System.out.println("How many attempts do you want?");
        maxTrials = keyboard.nextInt();

        while(maxTrials < 1 || maxTrials > maxNumber) {
            System.out.println("Invalid number. It must be positive and less than or equal to"
                + maxNumber + ".");
            maxTrials = keyboard.nextInt();
        }

        System.out.println("+--------------------------------+");

        numberGuessingGame(maxNumber, maxTrials);
    }

    public static void gameMenu() {
        Scanner keyboard = new Scanner(System.in);
        int userOption = 0;
        
        final int MAX_NUMBER = 100;
        final int MAX_TRIALS = 5;

        do {
            System.out.println("""
                    +--+ Number Guessing Game +--+
                    + 1. Unlimited attempts      +
                    + 2. Up to 5 attempts        +
                    + 3. Make your own game      +
                    + 0. Exit                    +
                    +----------------------------+
                    
                    Choose an option:""");
            userOption = keyboard.nextInt();

            keyboard.close();

            switch (userOption) {
                case 1:
                    numberGuessingGame(MAX_NUMBER, MAX_NUMBER);
                    break;
                case 2:
                    numberGuessingGame(MAX_NUMBER, MAX_TRIALS);
                    break;
                case 3:
                    gameMaker();
                    break;
                case 0:
                    System.out.println("\n+--------+ Bye bye! +--------+");
                    break;
                default:
                    System.out.println("\nChoose a valid option.\n");
            }
        } while(userOption != 0);
    }

    public static void main(String[] args) {
        gameMenu();
    }
}
