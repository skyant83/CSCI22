/** 
 * The TicketGate class represents a ticket gate scanner in a railway system.
 * It tracts and the collections and ticket counts for single-journey tickets.
 * stored-value tickets and last ride bonuses
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

public class TicketGate {
    private double totalCollections;
    private int SJT;
    private int SVT;
    private int LRB;
    
    /**
     * Initializes a new TicketGate object with 0 collections and ticket counts
     */
    public TicketGate() {
        totalCollections = 0.0;
        SJT = 0;
        SVT = 0;
        LRB = 0;
    }
    
    /**
     * Collects the fare from a passenger's ticket and updates the collections
     * and ticket counts based on whether the tickt is a single-journy or
     * stored-value ticket.
     * @param svt true if the passenger is using a Stored-Value Ticket or a Single-Journey Ticket
     * @param svtCredit the ammount available on the Stored-Value Ticket
     * @param fare the ammount to be collected from the ticket
     */
    public void collectFare(boolean svt, double svtCredit, double fare) {

        if (svt) {
            SVT++;
            if (svtCredit >= fare) {
                totalCollections += fare;
            }
            else {
                totalCollections += svtCredit;
                LRB++;
            }
        }
        else {
            SJT++;
            totalCollections += fare;
        }
    }

    /**
     * Gets the total amount of fares collected by the ticket gate scanner.
     * 
     * @return the total collections
     */
    public double getCollections() {
        return totalCollections;
    }

    /**
     * Gets the total number of Single-Journey Tickets that have passed through the ticket gate scanner.
     * 
     * @return the total number of Single-Journey Tickets.
     */
    public int getSJT() {
        return SJT;
    }

    /**
     * Gets the total number of Stored-Value Tickets that have passed through the ticket gate scanner
     * 
     * @return the count of Stored-Value Tickets
     */
    public int getSVT() {
        return SVT;
    }

    /**
     * Gets the total number of last ride bonuses
     * 
     * @return the total number of last ride bonuses
     */
    public int getBonuses() {
        return LRB;
    }
}
