/** 
 * The Attraction class represents an attraction within a theme park,
 * containing information about its name and the cost of admission.
 * This class provides methods for retrieving the name and cost of the attraction.
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
public class Attraction {
    /**  
     * Initializing the fields associated with the Attraction's name
     * and its cost.
     **/
    private String name;
    private double cost;

    /**
     * Constructs an Attraction object with the specified name and cost.
     *
     * @param n The name of the attraction.
     * @param c The cost of admission to the attraction.
     */
    public Attraction(String n, double c) {
        name = n;
        cost = c;
    }

    /**
     * Retrieves the name of the attraction.
     *
     * @return The name of the attraction.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the cost of admission to the attraction.
     *
     * @return The cost of admission to the attraction.
     */
    public double getCost() {
        return this.cost;
    }
}
