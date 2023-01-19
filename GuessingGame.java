package guessinggame;

import java.util.Scanner;

public class GuessingGame {
    public static void numberGuessingGame(int maxNumber, int maxTrials) {
        int randomNumber = (int) (Math.random() * maxNumber + 1);
        int userGuess = 0;
        Scanner keyboard = new Scanner(System.in);
        int i;

        System.out.println("\n+---------+ Number Guessing Game +---------+\n"
            + "We picked a random number between 1 and " + maxNumber + ".");
        if(maxNumber != maxTrials) {
            System.out.println("You have up to " + maxTrials + " attempts. Try and guess it!");
        }
        System.out.println("+------------------------------------------+\n");

        for(i = 1; i <= maxTrials; i++) {
            System.out.println("Type your guess:");
            userGuess = keyboard.nextInt();

            if(userGuess < 1 || userGuess > maxNumber) {
                System.out.println("This is not a valid guess for this game.\n"
                    + "Type a number between 1 and " + maxNumber + ". Try again!\n");
            } else if(userGuess < randomNumber) {
                System.out.println("Your guess is less than the number we picked.\n");
            } else if(userGuess > randomNumber) {
                System.out.println("Your guess is higher than the number we picked.\n");
            } else {
                break;
            }
        }

        if(userGuess == randomNumber) {
            System.out.println("Congratulations, "
                + randomNumber
                + " is the correct answer!\nYou got it right after "
                + i + " attempts.\n");
        } else {
            System.out.println("I'm sorry, you didn't get it right within your " + maxTrials
                + " trials.\n" + "The correct answer was " + randomNumber + ".\n");
        }
    }

    public static void gameMaker() {
        Scanner keyboard = new Scanner(System.in);
        int maxNumber;
        int maxTrials;

        System.out.println(
            "\n+-----+ Make your own game +-----+\n"
            + "Up to which number should we pick?"
        );
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

        do {
            System.out.println(
                 "+--+ Number Guessing Game +--+\n"
               + "+ 1. Unlimited attempts      +\n"
               + "+ 2. Up to 5 attempts        +\n"
               + "+ 3. Make your own game      +\n"
               + "+ 0. Exit                    +\n"
               + "+----------------------------+"
            );
            System.out.println("Choose an option: ");
            userOption = keyboard.nextInt();

            switch (userOption) {
                case 1:
                    numberGuessingGame(100, 100);
                    break;
                case 2:
                    numberGuessingGame(100, 5);
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