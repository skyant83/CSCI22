/**
    GreatestSum class implements the Operation interface and provides a method
    to find the greatest sum of three consecutive elements in an array. It also
    includes a method to retrieve the operation name.

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
public class GreatestSum implements Operation{

    @Override
    public void operate(Integer[] arr) {
        int currHigh = 0;
        int temp = 0;
        if (arr.length <= 3) {
            for (Integer integer : arr) {
                currHigh += integer;
            }
            System.out.printf("The greatest sum is %d.\n", currHigh);
            return;
        } else if (arr.length == 0) {
            System.out.printf("The greatest sum is %d.\n", currHigh);
        }
        for (int i = 0; i < arr.length - 2; i++) {
            temp = arr[i] + arr[i+1] + arr[i+2];
            if (temp > currHigh) {
                currHigh = temp;
            }
        }
        System.out.printf("The greatest sum is %d.\n", currHigh);
    }

    @Override
    public String getOperationName() {
        return " Greatest Sum";
    }
    
}
