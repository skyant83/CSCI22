/**
	The Starter class serves as the entry point for the program, demonstrating the usage
	of different Operation implementations through the MenuGen class.
	
	It creates an array of Operation objects, initializes them with specific implementations
	(Uniqueness, LargestIntegers, and GreatestSum), and then passes this array to a MenuGen
	instance. The MenuGen class is responsible for displaying a menu and executing the chosen
	operation.
	
	@author Enrique Gabriel Badiola (220608)
	@version 30 January 2024
	
	I have not discussed the Java language code in my program 
	with anyone other than my instructor or the teaching assistants 
	assigned to this course.

	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.

	If any Java language code or documentation used in my program 
	was obtained from another source, such as a textbook or website, 
	that has been clearly noted with a proper citation in the comments 
	of my program.
**/

public class Starter {
    public static void main(String[] args) {
        Operation[] o = new Operation[3];
		o[0] = new Uniqueness();
		o[1] = new LargestIntegers();
		o[2] = new GreatestSum();
		MenuGen mg = new MenuGen(o);
		mg.run();
    }
}
