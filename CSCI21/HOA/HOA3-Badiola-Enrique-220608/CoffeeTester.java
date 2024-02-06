/** 
 * The CoffeeTester class creates two instances of the CoffeeMachine class called kopiko and nescafe respectively.
 * It then runs a series of actions that refils and dispenses coffee from both the kopiko and nescafe instances
 * before displaying the status of each instance; their number of cups sold, remaining coffee (in Liters) and the total sales (in PHP)
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

public class CoffeeTester {
    public static void main(String[] args) {
        CoffeeMachine kopiko = new CoffeeMachine();
        CoffeeMachine nescafe = new CoffeeMachine();

        kopiko.addCoffee(3);
        kopiko.sellCoffee(16);

        nescafe.sellCoffee(13);
        
        kopiko.sellCoffee(11);

        nescafe.addCoffee(2);

        nescafe.sellCoffee(5);

        System.out.println("----- KOPIKO MACHINE -----");
        System.out.printf("Cups of Coffee Sold: %d\n", kopiko.getCupsSold());
        System.out.printf("Remaining Coffee: %.2f liters\n", kopiko.getCoffeeLeft());
        System.out.printf("Total Sales: PHP %.2f\n\n", kopiko.getSales());

        System.out.println("----- NESCAFE MACHINE -----");
        System.out.printf("Cups of Coffee Sold: %d\n", nescafe.getCupsSold());
        System.out.printf("Remaining Coffee: %.2f liters\n", nescafe.getCoffeeLeft());
        System.out.printf("Total Sales: PHP %.2f\n", nescafe.getSales());
    }
}
