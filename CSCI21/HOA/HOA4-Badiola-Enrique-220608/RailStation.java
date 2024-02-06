/** 
 * The RailStation class is a tester program for the TicketGate class.
 * It simulates the operation of multiple ticket gates and displays a report of there statistics
 * @author Enrique Gabriel E. Badiola (220608)
 * @version November 3, 2023
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

public class RailStation {
    
    public static void main(String[] args) {
        // Creates references to the TicketGate class and the TicketGate object called gate1, gate2 and gate3 respectively
        TicketGate gate1 = new TicketGate();
        TicketGate gate2 = new TicketGate();
        TicketGate gate3 = new TicketGate();

        // Simulates the collection of fares at each of the three gates
        gate1.collectFare(true, 180.00, 115.00);
        gate2.collectFare(true, 110.00, 120.00);
        gate3.collectFare(true, 130.00, 112.00);

        gate1.collectFare(false, 0, 114.00);
        gate2.collectFare(false, 0, 111.00);
        gate3.collectFare(true, 113.00, 114.00);

        gate1.collectFare(false, 0, 110.00);
        gate2.collectFare(true, 15.00, 111.00);
        gate2.collectFare(true, 17.00, 113.00);

        // Displays the statistics of each gate including the collected fares, the number of Single-Journey and Stored-Value 
        // tickets and the number of last ride bonuses used.
        System.out.println("---------- RAIL STATION REPORT ----------");
        System.out.println("|   Gate |      Fares | SJT | SVT | LRB |");
        System.out.println("----------------------------------------");
        System.out.printf("| Gate 1 | PHP %.2f | %3d | %3d | %3d |\n", gate1.getCollections(), gate1.getSJT(), gate1.getSVT(), gate1.getBonuses());
        System.out.printf("| Gate 2 | PHP %.2f | %3d | %3d | %3d |\n", gate2.getCollections(), gate2.getSJT(), gate2.getSVT(), gate2.getBonuses());
        System.out.printf("| Gate 3 | PHP %.2f | %3d | %3d | %3d |\n", gate3.getCollections(), gate3.getSJT(), gate3.getSVT(), gate3.getBonuses());
    }
}
