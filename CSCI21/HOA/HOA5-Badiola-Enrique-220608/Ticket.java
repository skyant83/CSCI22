/** 
 * The Ticket class represents a ticket in a theme park, containing information
 * about the credit amount and whether it provides all-access privileges.
 * This class includes methods for retrieving the credit amount, checking if
 * the ticket grants all-access, and updating the credit amount.
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
public class Ticket {
    /**  
     * Initializing the fields associated with the ticket's credit amount
     * and whether it provides all-access privileges
     **/
    private double credit;
    private boolean isAllAccess;

    /**
     * Constructs a Ticket object with the specified credit amount.
     * If the credit amount is 500, the ticket is marked as all-access.
     *
     * @param c The credit amount for the ticket.
     */
    public Ticket(double c) {
        credit = c;
        if (credit == 500)
            isAllAccess = true;
    }

    /**
     * Retrieves the credit amount associated with the ticket.
     *
     * @return The credit amount of the ticket.
     */
    public double getCredit() {
        return this.credit;
    }

    /**
     * Checks if the ticket provides all-access privileges.
     *
     * @return True if the ticket is all-access, false otherwise.
     */
    public boolean isAllAccess() {
        return this.isAllAccess;
    }
    
    /**
     * Updates the credit amount of the ticket by subtracting the specified
     * amount from the current credit.
     *
     * @param amt The amount to be subtracted from the current credit.
     */
    public void updateCredit(double amt) {
        credit -= amt;
    }
}
