/** 
 * The GameMaster class manages the game state, players, and game actions.
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

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GameMaster {
    private final String CUSTOM_DECK = "Finals\\CardGame-J-Badiola-Enrique-220608\\newCards.txt";
    private boolean hasWon;
    private boolean randomDeal;
    private Player player1;
    private Player player2;
    private int turnCounter;
    
    private ArrayList<Card> deck = new ArrayList<Card>();
    private void assembleDeck() {
        deck.add( new Card( "Dragon", "Aquira", 174, 26 ) );
        deck.add( new Card( "Ghost", "Brawn", 130, 48 ) );
        deck.add( new Card( "Fairy", "Cerulea", 162, 29 ) );
        deck.add( new Card( "Dragon", "Demi", 147, 28 ) );
        deck.add( new Card( "Ghost", "Elba", 155, 37 ) );
        deck.add( new Card( "Fairy", "Fye", 159, 42 ) );
        deck.add( new Card( "Dragon", "Glyede", 129, 26 ) );
        deck.add( new Card( "Ghost", "Hydran", 163, 35 ) );
        deck.add( new Card( "Fairy", "Ivy", 146, 45 ) );
        deck.add( new Card( "Dragon", "Jet", 170, 24 ) );
        deck.add( new Card( "Ghost", "Kineti", 139, 21 ) );
        deck.add( new Card( "Fairy", "Levi", 160, 43 ) );
        deck.add( new Card( "Dragon", "Meadow", 134, 29 ) );
        deck.add( new Card( "Ghost", "Naidem", 165, 26 ) );
        deck.add( new Card( "Fairy", "Omi", 145, 21 ) );
        deck.add( new Card( "Dragon", "Puddles", 170, 34 ) );
        deck.add( new Card( "Ghost", "Quarrel", 151, 29 ) );
        deck.add( new Card( "Fairy", "Raven", 168, 32 ) );
        deck.add( new Card( "Dragon", "Surge", 128, 27 ) );
        deck.add( new Card( "Ghost", "Takiru", 140, 26 ) );
        deck.add( new Card( "Fairy", "Ustelia", 163, 47 ) );
        deck.add( new Card( "Dragon", "Verwyn", 145, 25 ) );
        deck.add( new Card( "Ghost", "Wyverin", 158, 32 ) );
        deck.add( new Card( "Fairy", "Xios", 155, 27 ) );
        deck.add( new Card( "Dragon", "Yora", 159, 44 ) );
        deck.add( new Card( "Ghost", "Zulu", 125, 46 ) );
    }    
    
    /**
     * Constructs a GameMaster with two players, initializing game-related variables and assembling the deck.
     *
     * @param a The first player.
     * @param b The second player.
     */
    public GameMaster(Player a, Player b) { System.out.println("norm");
        player1 = a;
        player2 = b;
        turnCounter = 1;
        randomDeal = false;

        assembleDeck();
        hasWon = false;
    }
    
    /**
     * Constructs a GameMaster with two players, initializing game-related variables, and assembling the deck.
     * Allows for optional parameters for randomness or loading from a file (not fully implemented).
     *
     * @param a         The first player.
     * @param b         The second player.
     * @param random    Flag indicating whether to shuffle the deck randomly.
     * @param fromFile  Flag indicating whether to load the deck from a file.
     */
    public GameMaster(Player a, Player b, boolean random, boolean fromFile) {
        player1 = a;
        player2 = b;
        turnCounter = 1;
        
        randomDeal = random;

        if (fromFile)   assembleFromFile();
        else assembleDeck();
        hasWon = false;
    }

    /**
     * Splits a given string into an array of substrings based on space characters.
     *
     * @param x The input string to be split.
     * @return An array of substrings obtained by splitting the input string.
     */
    private String[] split(String x) {
        String word = "";
        String character = "";
        String[] toArray = new String[4];
        int i = 0;
        for ( int j = 0; j < x.length(); j++ ) {
            character = x.substring(j, j+1);
            if ( !character.equals(" ")) word += character;
            else if (!word.equals("")) {
                toArray[i] = word;
                word = "";
                i++;
            }    
        }    
        toArray[i] = word;
        word = "";
        return toArray;
    }    

    /**
     * Reads card details from a custom deck file and adds corresponding Card objects to the deck.
     * Prompts the user to try again if the file is not found.
     */
    private void assembleFromFile() {
        boolean fileFound;
        Scanner cmdIn = new Scanner(System.in);
        do {
            fileFound = true;
            ArrayList<String> newCard = new ArrayList<String>();
            String[] cardDetails = new String[4];
            try {
                FileReader reader = new FileReader(CUSTOM_DECK);
                Scanner fileScanner = new Scanner(reader);
                while (fileScanner.hasNextLine()) 
                    newCard.add(fileScanner.nextLine());
                for (String string : newCard) {
                    cardDetails = split(string);
                    deck.add(new Card(cardDetails[0], cardDetails[1], Integer.parseInt(cardDetails[2]), Integer.parseInt(cardDetails[3])));
                }    
                fileScanner.close();
            } catch (FileNotFoundException e) {
                fileFound = false;
                System.out.println("Custom Deck File not found.");
                System.out.println("Press Enter to try again...");
                cmdIn.nextLine();
            }    
            
        } while (!fileFound);    
    }    

    /**
     * Checks if a card of type1 is resistant to type2.
     *
     * @param type1 The type of the attacking card.
     * @param type2 The type of the defending card.
     * @return True if the attacking card is resistant to the defending card, false otherwise.
     */
    public boolean checkResistance(String type1, String type2) {
        boolean isResistant = false;
        
        switch (type1) {
            case "Dragon":
                if (type2.equals("Ghost"))
                    isResistant = true;
                break;
            case "Fairy":
                if (type2.equals("Dragon"))
                    isResistant = true;
                break;
            case "Ghost":
                if (type2.equals("Fairy"))
                    isResistant = true;
                break;
        }
        return isResistant;
    }

    /**
     * Checks if a card of type1 is weak to type2.
     *
     * @param type1 The type of the attacking card.
     * @param type2 The type of the defending card.
     * @return True if the attacking card is weak to the defending card, false otherwise.
     */
    public boolean checkWeakness(String type1, String type2) {
        boolean isWeak = false;

        switch (type1) {
            case "Dragon":
                if (type2.equals("Fairy"))
                    isWeak = true;
                break;
            case "Fairy":
                if (type2.equals("Ghost"))
                    isWeak = true;
                break;
            case "Ghost":
                if (type2.equals("Dragon"))
                    isWeak = true;
                break;
        }
        return isWeak;
    }
    
    /**
     * Deals a card to the active player and manages the game state accordingly.
     *
     * @return A message describing the card dealing action.
     */
    public String dealCard() {
        Player[] playerOrder = activePlayer();
        Player currPlayer = playerOrder[0];
        String dealMessage = "";
        Card card = null;
        int index = 0;
        int deckSlot = 0;
        if (turnCounter < 11) {
            if (randomDeal)
                index = (int) (Math.random() * deck.size());
            card = deck.get(index);
            dealMessage += String.format("%s draws %s.\n", currPlayer.getName(), card.getCardName());
            currPlayer.drawCard(card);
            deck.remove(card);
                
        } else {
            try {
                currPlayer = playerOrder[1];
                Card card1 = deck.get(0);
                Card card2 = deck.get(1);
                int card1DetProd = card1.getCardHealth() * card1.getCardAttackPower();
                int card2DetProd = card2.getCardHealth() * card2.getCardAttackPower();
                Card bestCard = null;
                Card oldCard = deck.get(deckSlot);
                
                if (card1DetProd > card2DetProd) bestCard = card1;
                else {
                    bestCard = card2; 
                    deckSlot = 1; }
                
                deck.add(oldCard);
                deck.remove(oldCard);
                
                dealMessage += String.format("%s draws %s.\n", currPlayer.getName(), bestCard.getCardName());
                currPlayer.drawCard(bestCard);
                deck.remove(bestCard);
            } catch (IndexOutOfBoundsException e) {
                dealMessage += "The deck is empty.\n";
            }
        }
        if (playerOrder[0].getToken() != 2)
            turnCounter++;
        return dealMessage;
    }

    /**
     * Deals damage from the in-play card to the target card, considering resistances and weaknesses.
     *
     * @param inPlay The card currently in play.
     * @param target The target card to receive damage.
     * @return A message describing the damage dealt.
     */
    public String dealDamage(Card inPlay, Card target) {
        int damage = inPlay.getCardAttackPower();
        String targetType = target.getCardType();
        String inPlayType = inPlay.getCardType();
        String targetName = target.getCardName();
        String inPlayName = inPlay.getCardName();
        String damageMessage = "";
        
        if (checkWeakness(targetType, inPlayType)) {
            damageMessage += String.format("\t\t%s is weak to %s.\n", targetType, inPlayType);
            damage *= 2;
        }
        if (checkResistance(targetType, inPlayType)) {
            damageMessage += String.format("\t\t%s is resistant to %s\n", targetType, inPlayType);
            damage /= 2;
        }
        target.takeDamage(damage);

        damageMessage += String.format("\t%s deals %d damage on %s\n", inPlayName, damage, targetName);
        damageMessage += String.format("\t%s has %d left\n", targetName, target.getCardHealth());
        return damageMessage;
    }
    
    /**
     * Generates a summary report of the game state.
     *
     * @return A summary report of the game state.
     */
    public String gameReport() {
        Player[] playerOrder = {player1, player2};
        String report = "";
        report += "---=== GAME SUMMARY ===---\n";
        report += String.format("This game lasted %d turns.\n", turnCounter);

        for (Player player : playerOrder) {
            report += String.format("%s\n", player.getName().toUpperCase());
            report += player.statusReport() + "\n"; }
        return report;
    }

    /**
     * Checks if a player has won by reaching the token count of 3.
     *
     * @return True if a player has won, false otherwise.
     */
    public Boolean hasWinner() {
        if (player1.getToken() == 3 || player2.getToken() == 3)
            hasWon = true;
            return hasWon;
    }
    
    /**
     * Performs a player action (attack or swap) based on the provided action string.
     *
     * @param action The action to be performed ("attack" or "swap").
     * @return A message describing the outcome of the action.
     */
    public String play(String action) {
        Player[] playerOrder = activePlayer();
        Player currPlayer = playerOrder[0];
        Player enemyPlayer = playerOrder[1];
        String playMessage = "";

        switch (action.toLowerCase()) {
            case "attack":
                playMessage += String.format("\t%s attacks with %s.\n", currPlayer.getName(), currPlayer.getActiveCard().getCardName());
                playMessage += String.format("%s", dealDamage(currPlayer.getActiveCard(), enemyPlayer.getActiveCard()));
                if (enemyPlayer.getActiveCard().getCardHealth() <= 0) {
                    playMessage += String.format("\t%s discards %s.\n", enemyPlayer.getName(), enemyPlayer.getActiveCard().getCardName());
                        enemyPlayer.discard();
                        playMessage += String.format("\t%s", dealCard());
                        playMessage += String.format("\t%s gets a token!\n", currPlayer.getName());
                        currPlayer.claimToken();
                        break;
                    }
                turnCounter++;
                break;
            case "swap":
                playMessage += String.format("\t%s swaps out %s...\n", currPlayer.getName(), currPlayer.getActiveCard().getCardName());
                playMessage += String.format("\t%s\n", currPlayer.swap());
                turnCounter++;
                break;
            default:
                return "Please input a valid action.";
        }
        return playMessage;
    }

    /**
     * Determines the active player for the current turn.
     *
     * @return An array containing the active player at index 0 and the opponent at index 1.
     */
    public Player[] activePlayer() {
        Player[] playerOrder = new Player[2];
        if (turnCounter % 2 == 1) {
            playerOrder[0] = player1;
            playerOrder[1] = player2;
        } else {
            playerOrder[0] = player2;
            playerOrder[1] = player1;
        }
        return playerOrder;
    }
}
