/** 
 * The Player class represents a player in the game, managing their name, token count, and card hand.
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


public class Player {
    private String name;
    private boolean isHandFull;
    private int tokenCounter;
    private ArrayList<Card> hand = new ArrayList<Card>();

    /**
     * Constructs a Player with the specified name.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        tokenCounter = 0;
        isHandFull = false;
    }

    /**
     * Increases the token count of the player by one.
     */
    public void claimToken() {
        tokenCounter++;
    }

    /**
     * Discards the first card in the player's hand and shifts the remaining cards.
     * If the hand was full, sets isHandFull to false.
     */
    public void discard() {
        if (isHandFull)
            isHandFull = false;

        hand.set(0, null);
        for (int i = 1; i < hand.size(); i++) {
            hand.set(i - 1, hand.get(i));
        }
        hand.remove(hand.size()-1);
    }

    /**
     * Draws a card and adds it to the player's hand. If the hand is full, replaces the last card.
     *
     * @param c The card to be drawn and added to the hand.
     */
    public void drawCard(Card c) {
        if (hand.size() < 5)
            hand.add(c);
        else
            hand.set(4, c);
    }

    /**
     * Retrieves the active card (the first card) in the player's hand.
     *
     * @return The active card in the player's hand.
     */
    public Card getActiveCard() {
        return hand.get(0);
    }

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the current token count of the player.
     *
     * @return The current token count of the player.
     */
    public int getToken() {
        return tokenCounter;
    }

    /**
     * Checks if the player's hand is full (contains 5 cards).
     *
     * @return True if the hand is full, false otherwise.
     */
    public boolean isHandFull() {
        if (hand.size() == 5)
            isHandFull = true;
        return isHandFull;
    }

    /**
     * Generates a status report for the player's hand, including the name, health, and name of each card.
     *
     * @return The status report of the player's hand.
     */
    public String statusReport() {
        String statRep = "";
        for (Card card : hand)
            statRep += String.format("\t%7s : %3d\n", card.getCardName(), card.getCardHealth());
        return statRep;
    }

    /**
     * Swaps the active card with the card determined by the findCard method.
     *
     * @return A message indicating the result of the swap.
     */
    public String swap() {
        int swapPoint = findCard();
        if (swapPoint != -1) {
            Card oldActive = hand.get(0);
            Card newActive = hand.get(swapPoint);
            hand.set(0, newActive);
            hand.set(swapPoint, oldActive);
            return String.format("%s is now active with %d health.", newActive.getCardName(), newActive.getCardHealth());
        } else {
            return String.format("%s has no other card to swap with. Turn forfeited.", this.name);
        }
    }

    /**
     * Finds the index of the card in the player's hand with the highest health multiplied by attack power.
     *
     * @return The index of the card with the highest health * attack power, or -1 if no suitable card is found.
     */
    private int findCard() {
        int bestCard = -1;
        int curProd = 0;
        int detProd = hand.get(0).getCardAttackPower() * hand.get(0).getCardHealth();
        for (int i = 1; i < hand.size(); i++) {
            curProd = hand.get(i).getCardHealth() * hand.get(i).getCardAttackPower();
            if (curProd > detProd) {
                detProd = curProd;
                bestCard = i;
            }
        }
        return bestCard;
    }
}
