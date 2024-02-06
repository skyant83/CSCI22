/**
	LargestIntegers class implements the Operation interface to find the largest integers in an array.
	It identifies the top three largest integers in the array and prints the result.
	If the array has fewer than three integers, it adjusts accordingly.
	
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

public class LargestIntegers implements Operation {
    @Override
    public void operate(Integer[] arr) {
        int top = 0;
		int mid = 0;
		int bottom = 0;
		if (arr.length == 0) {
			System.out.println("There are no integers.");
			return;
		} else if (arr.length == 1) {
			System.out.printf("The largest integer is %d.\n", arr[0]);
			return;
		}

		for (Integer integer : arr) {
			if (integer > top) {
				bottom = mid;
				mid = top;
				top = integer;
			} else if (integer > mid) {
				bottom = mid;
				mid = integer;
			} else if (integer > bottom) {
				bottom = integer;
			}
		}

		if (bottom > 0)
			System.out.printf("The largest integers are %d, %d and %d.\n", bottom, mid, top);
		else if (mid > 0)
			System.out.printf("The largest integers are %d and %d.\n", mid, top);
    }

    @Override
    public String getOperationName() {
        return " LargestIntegers";
    }
}