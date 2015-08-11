/* Enzo Galbo
 * This is a game of RockPaperScissors that includes extra
 * options for added complexity.
 */
package RockPaperScissors;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class RockPaperScissors {

    public static void main(String[] args) {
        String repeatGame;
        int compScore = 0;
        int playerScore = 0;
        Scanner input = new Scanner(System.in);
            // do while loop so program executes at least once and continues if
            // user does not input "no."
        do {

            // find player choice using playerThrow method
            String playerChoice = playerThrow();

            // find computer choice at random using computerThrow method
            String compChoice = computerThrow();

            // determine winner by comparing strings, show who won
            int winner = compareChoices(compChoice, playerChoice);

            // case if computer wins, adds one to comp score and
            // prints current score
            if (winner == -1) {
                compScore++;
                JOptionPane.showMessageDialog(null, "Current Score: \nComputer"
                        + " Score " + compScore + "Your Score " + playerScore);
            }

            // case of tie, score unchanged and prints current score
            if (winner == 0) {
                JOptionPane.showMessageDialog(null, "Current Score: \nComputer"
                        + " Score " + compScore + "Your Score " + playerScore);
            }

            // case if player wins, adds one to player score and
            // prints current score
            if (winner == 1) {
                playerScore++;
                JOptionPane.showMessageDialog(null, "Current Score: \n Computer"
                        + " Score: " + compScore + " Your Score: " + playerScore);
            }

            // ask if user wants to repeat game, set it to repeatGame
            repeatGame = JOptionPane.showInputDialog(null,
                    "Do you want to play again? Please type yes or no.");

            // game repeats until something other than no input
        } while (!repeatGame.equalsIgnoreCase("no"));
        JOptionPane.showMessageDialog(null, "Final Score: \n"
                + "Computer: " + compScore + " Player: " + playerScore);
    }

            // method determining player selection, repeats until
            // valid input is selected
    public static String playerThrow() {
        String playerThrow;
        do {
            playerThrow = JOptionPane.showInputDialog(null,
                    "Please choose Rock, Paper, Scissors, Lizard, or Spock");

        } while (!(playerThrow.equalsIgnoreCase("rock")) && !(playerThrow.equalsIgnoreCase("paper"))
                && !(playerThrow.equalsIgnoreCase("scissors")) && !(playerThrow.equalsIgnoreCase("lizard"))
                && !(playerThrow.equalsIgnoreCase("spock")));
        return playerThrow.toLowerCase();
    }

            // random selection of computer choice
    public static String computerThrow() {
        String compThrow = "";
        int random = (int) (Math.random() * 5);
        if (random == 0) {
            compThrow = "rock";
        } else if (random == 1) {
            compThrow = "paper";
        } else if (random == 2) {
            compThrow = "scissors";
        } else if (random == 3) {
            compThrow = "lizard";
        } else if (random == 4) {
            compThrow = "spock";
        }
        return compThrow;
    }

            // method comparing the choices based on criteria given
            // shows who won based on winner variable
    public static int compareChoices(String compThrow, String playerThrow) {
            /*-1 = computer wins
            0 = tie
            1 = user wins*/
        int winner;
        if (compThrow.equals(playerThrow)) {
            winner = 0;
        } else if (compThrow.equalsIgnoreCase("scissors") && playerThrow.equalsIgnoreCase("paper")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("paper") && playerThrow.equalsIgnoreCase("rock")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("rock") && playerThrow.equalsIgnoreCase("lizard")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("lizard") && playerThrow.equalsIgnoreCase("spock")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("spock") && playerThrow.equalsIgnoreCase("scissors")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("scissors") && playerThrow.equalsIgnoreCase("lizard")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("lizard") && playerThrow.equalsIgnoreCase("paper")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("paper") && playerThrow.equalsIgnoreCase("spock")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("spock") && playerThrow.equalsIgnoreCase("rock")) {
            winner = -1;
        } else if (compThrow.equalsIgnoreCase("rock") && playerThrow.equalsIgnoreCase("scissors")) {
            winner = -1;
        } else {
            winner = 1;
        }

        if (winner == -1) {
            JOptionPane.showMessageDialog(null, "Computer chose:  "
                    + compThrow + "  player chose: "
                    + playerThrow + ". computer wins!");
        }
        if (winner == 0) {
            JOptionPane.showMessageDialog(null, "Match ended in a tie!");
        }
        if (winner == 1) {
            JOptionPane.showMessageDialog(null, "Computer chose:  "
                    + compThrow + "  player chose: "
                    + playerThrow + ". you win the round!");

        }

        return winner;

    }

}
