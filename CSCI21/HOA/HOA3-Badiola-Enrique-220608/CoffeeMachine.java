/** 
 * The CoffeeMachine class supports adding coffee, selling coffee, 
 * inquiring about amount of coffee left, how much coffee was sold, and how much money was collected
 * @author Enrique Gabriel E. Badiola (220608)
 * @version October 23, 2023
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

public class CoffeeMachine {
    private int cupCount;
    private double moneyCollected;
    private double coffeeAmount;
    
    /**
     * Constructor initializes the cup count and money collected to 0, and the coffee amont to 5
     */
    public CoffeeMachine() {
        cupCount = 0;
        moneyCollected = 0;

        coffeeAmount = 5;
    }

    /**
     * Adds some refill amount into the Coffee Machine
     * @param refil the amount of coffee to refil into the machine (in Liters)
     */
    public void addCoffee(double refill) {
        coffeeAmount += refill;
    }

    /** 
     * Increases the number of cups sold
     * Increases the number of money earned by 45.54 (in PHP)
     * Decreases the number of coffee in the machine (250ml per cup)
     * @param numCups the number of cups sold
     */
    public void sellCoffee(int numCups) {
        cupCount += numCups;

        coffeeAmount -= numCups * 0.25;

        moneyCollected += numCups * 45.54;
    }

    /** 
     * Gets the current coffee amount
     * @return the current coffee amount in the machine (in Liters)
     */
    public double getCoffeeLeft() {
        return coffeeAmount;
    }
    
    /** 
     * Gets the money collected
     * @return the current amount of money made by the machine (in PHP)
     */
    public double getSales() {
        return moneyCollected;
    }
    
    /** 
     * Gets the cup count
     * @return the count of cups sold
     */
    public int getCupsSold() {
        return cupCount;
    }
}
