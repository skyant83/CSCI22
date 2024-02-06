/** 
 * The TicketScanner class represents a ticket scanner in a theme park,
 * responsible for scanning tickets and keeping track of various statistics,
 * such as collections, single access, all access, rejects, and counts for
 * specific attractions. It provides methods for scanning tickets and retrieving
 * the collected statistics.
 * @author Enrique Gabriel E. Badiola (220608)
 * @version November 20, 2023
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
public class TicketScanner {
    /**  
     * Initializing the fields associated with the Ticket Scanner's collections
     * number of single/all access tickets taken, number of rejected tickets taken
     * and number of tickets taken for the RollerCoaster, FerrisWheel, and the Carousel.
     **/
    private double collections;
    private int singleAccess;
    private int allAccess;
    private int rejects;
    private int rollerCoaster;
    private int ferrisWheel;
    private int carousel;
    
    public TicketScanner() {
        collections = 0;
        singleAccess = 0;
        allAccess = 0;
        rejects = 0;
        rollerCoaster = 0;
        ferrisWheel = 0;
        carousel = 0;
    }

    /**
     * Simulates the scanning of a ticket for a specific attraction. Updates
     * statistics based on the scanned ticket and attraction information.
     *
     * @param a The Attraction object representing the attraction to scan the ticket for.
     * @param t The Ticket object representing the ticket being scanned.
     */
    public void scanTicket(Attraction a, Ticket t) {
        String attractionName = a.getName();
        double attractionCost = a.getCost();
        if (t.getCredit() < attractionCost) {
            System.out.printf("Ticket rejected. Insufficient credit for the %s.\n", attractionName);
            rejects++;
        }
        else {
            System.out.printf("Enjoy your ride on the %s.\n", attractionName);
            if (t.isAllAccess()) {
                t.updateCredit(attractionCost);
                System.out.printf("You have PHP %.2f remining.\n", t.getCredit());
                allAccess++;
            }
            else
                singleAccess++;
            switch (attractionName) {
                case "Roller Coaster":
                    rollerCoaster++;
                    break;
                case "Ferris Wheel":
                    ferrisWheel++;
                    break;
                case "Carousel":
                    carousel++;
                    break;            
                }
            collections += attractionCost;
        }
        
    }

    /**
    * Retrieves the total collections made by the ticket scanner.
    *
    * @return The total collections made by the ticket scanner.
    */
    public double getCollections() {
        return this.collections;
    }

    /**
     * Retrieves the count of tickets with single access scanned by the ticket scanner.
     *
     * @return The count of tickets with single access.
     */
    public int getSingleAccess() {
        return this.singleAccess;
    }

    /**
     * Retrieves the count of tickets with all access scanned by the ticket scanner.
     *
     * @return The count of tickets with all access.
     */
    public int getAllAccess() {
        return this.allAccess;
    }

    /**
     * Retrieves the count of rejected tickets by the ticket scanner.
     *
     * @return The count of rejected tickets.
     */
    public int getRejects() {
        return this.rejects;
    }

    /**
     * Retrieves the count of tickets for the Roller Coaster attraction scanned by the ticket scanner.
     *
     * @return The count of tickets for the Roller Coaster attraction.
     */
    public int getRollerCoaster() {
        return this.rollerCoaster;
    }

    /**
     * Retrieves the count of tickets for the Ferris Wheel attraction scanned by the ticket scanner.
     *
     * @return The count of tickets for the Ferris Wheel attraction.
     */
    public int getFerrisWheel() {
        return this.ferrisWheel;
    }

    /**
     * Retrieves the count of tickets for the Carousel attraction scanned by the ticket scanner.
     *
     * @return The count of tickets for the Carousel attraction.
     */
    public int getCarousel() {
        return this.carousel;
    }

}
