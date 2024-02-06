/** 
 * The ThemePark class represents a theme park with ticket scanners,
 * attractions, and tickets. It simulates the scanning of tickets
 * at different scanners and generates a sales report.
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
public class ThemePark {
	
	/**
     * The main method that serves as the starting point for the ThemePark program.
     * It initializes arrays of TicketScanner, Attraction, and Ticket objects,
     * simulates ticket scanning, and generates a sales report.
     *
     * @param args The command line arguments (not used in this program).
     */
	public static void main( String[] args ) {
		
		// Creates an arrays of TicketScanner, Attractions, and Tickets with specified lengths
		TicketScanner[] ts = new TicketScanner[5];
		Attraction[] atn = new Attraction[3];
		Ticket[] tks = new Ticket[25];

		// Creates an instance of TicketScanner for each space in the ts array
		for ( int i = 0; i < ts.length; i++ ) {
			ts[i] = new TicketScanner();
		}
		
		// Creates an instance within the atn array for each attraction with specified prices
		atn[0] = new Attraction("Roller Coaster", 125.25);
		atn[1] = new Attraction("Ferris Wheel", 81.81);
		atn[2] = new Attraction("Carousel", 49.49);

		/*
			This loop creates multiple instances of Ticket
			and places them in the array of Tickets.
			STUDENTS MUST NOT EDIT THIS CODE.
		*/
		for( int i = 0; i < tks.length; i++ ) {
			if( i % 4 == 0 )
				tks[i] = new Ticket( 500.00 );
			else if( i % 4 == 1 )
				tks[i] = new Ticket( 49.49 );
			else if( i % 4 == 2 )
				tks[i] = new Ticket( 81.81 ); 
			else
				tks[i] = new Ticket( 125.25 );	
		}
		
		/*
			This loop performs multiple scanTicket operations on
			specific TicketScanners.
			All tickets are scanned in this loop.
			STUDENTS MUST NOT EDIT THIS CODE.
		*/
		for( int i = tks.length-1; i >= 0; i-- )
			ts[i%ts.length].scanTicket( atn[i%atn.length], tks[i] );
		
		/*
			This loop performs multiple scanTicket operations on
			specific TicketScanners.
			Only the all-access tickets are scanned again in this loop.
			STUDENTS MUST NOT EDIT THIS CODE.
		*/
		for( int i = 0; i < tks.length; i++ ) {
			if( tks[i].isAllAccess() )
				ts[i%ts.length].scanTicket( atn[i%atn.length], tks[i] );
		}
		
		// Output the sales report
		System.out.println("----------------- MY THEME PARK SALES REPORT -----------------");
        System.out.println("| Scanner   | Collection | SAT | AAT | REJECT | RC | FW | CL |");
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < ts.length; i++) {
            System.out.printf("| Scanner %d | PHP %.2f | %3d | %3d | %6d | %2d | %2d | %2d |\n", (i + 1), ts[i].getCollections(), ts[i].getSingleAccess(), ts[i].getAllAccess(), ts[i].getRejects(), ts[i].getRollerCoaster(), ts[i].getFerrisWheel(), ts[i].getCarousel());
        }
		System.out.println("--------------------------------------------------------------");

	}
	
}