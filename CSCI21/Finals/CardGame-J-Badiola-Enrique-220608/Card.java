/** 
 * The Card class represents a game card with attributes such as type, name, health, and attack power.
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

public class Card {
    private String type;
    private String name;
    private int health;
    private int attackPower;

    /**
     * Constructs a Card object with the specified attributes.
     *
     * @param type The type of the card.
     * @param name The name of the card.
     * @param health The health points of the card.
     * @param attackPower The attack power of the card.
     */
    public Card(String type, String name, int health, int attackPower) {
        this.type = type;
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    /**
     * Retrieves the health points of the card.
     *
     * @return The health points of the card.
     */
    public int getCardHealth() {
        return this.health;
    }

    /**
     * Retrieves the name of the card.
     *
     * @return The name of the card.
     */
    public String getCardName() {
        return this.name;
    }

    /**
     * Retrieves the attack power of the card.
     *
     * @return The attack power of the card.
     */
    public int getCardAttackPower() {
        return this.attackPower;
    }

    /**
     * Retrieves the type of the card.
     *
     * @return The type of the card.
     */
    public String getCardType() {
        return this.type;
    }

    /**
     * Reduces the health points of the card by the specified amount.
     *
     * @param damage The amount of damage to be inflicted on the card.
     */
    public void takeDamage(int damage) {
        this.health -= damage;
    }

}
