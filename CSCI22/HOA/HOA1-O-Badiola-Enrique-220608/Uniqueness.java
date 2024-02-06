/**
	The Uniqueness class implements the Operation interface and defines
    operations for checking the uniqueness of elements in an array of Integers.

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

public class Uniqueness implements Operation{

    @Override
    public void operate(Integer[] arr) {
        if (arr.length == 0) {
			System.out.println("There are no integers.");
			return;
        }

        boolean isUnique = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) break;
                if (arr[i] == arr[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (!isUnique)
                break;
        }

        if (!isUnique) {
            System.out.println("NOT all the elements are unique.");
        } else {
            System.out.println("All the elements are unique.");
        }
        
    }

    @Override
    public String getOperationName() {
        return " Uniqueness";
    }
    
}
