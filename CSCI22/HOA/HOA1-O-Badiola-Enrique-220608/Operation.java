/**
	The Operation interface represents a basic operation that can be performed on an array of integers.
	Implementations of this interface should provide a method to perform the operation on the array and retrieve
	the name of the operation.
	
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

public interface Operation {
    void operate(Integer[] arr);
    String getOperationName();
}
