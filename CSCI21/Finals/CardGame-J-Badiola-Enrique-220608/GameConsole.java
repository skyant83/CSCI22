/** 
 * The GameConsole class represents the main console interface for running the card game
 * @author Enrique Gabriel E. Badiola (220608)
 * @version December 8, 2023
**/

/*
    I have not discussed the Java language code in my program
    with anyone other than my instructor or the teaching assistants
    assigned to this course.

    I have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.

    If any Java language code or documentation used in my program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
*/

import java.util.Scanner;

public class GameConsole {

    private static boolean isRand = false;
    private static boolean usingCustomDeck = false;

    /**
     * The main method that initializes the game with player names, deck options, and runs the game loop.
     *
     * @param args Command-line arguments, including player names and optional arguments for randomness and custom decks.
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: Please provide the name for both Player1 and Player2");
            return;
        }

        String p1 = args[0];
        String p2 = args[1];

        System.out.printf("Welcome %s and %s!\n", p1, p2);

        Player player1 = new Player(p1);
        Player player2 = new Player(p2);
        
        for (int i = 2; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("random"))
                isRand = true;
            if (args[i].equalsIgnoreCase("customDeck"))
                usingCustomDeck = true;
        }

        GameMaster GM = null;

        if (isRand || usingCustomDeck) GM = new GameMaster(player1, player2, isRand, usingCustomDeck);
        else GM = new GameMaster(player1, player2);
        System.out.println("The game begins.\n");

        Scanner consoleInput = new Scanner(System.in);
        while (!player2.isHandFull() || !player1.isHandFull())
            System.out.println(GM.dealCard());

        while (!GM.hasWinner()) {
            System.out.print("Attack or Swap? ");
            String action = consoleInput.next();

            System.out.println(GM.play(action));
        }

        Player currPlayer = GM.activePlayer()[0];
        System.out.printf("\b%s wins!!!\n", currPlayer.getName());
        System.out.println(GM.gameReport());
        consoleInput.close();
    }
}