# Java Reviewer and Info Sheet
- [Java Reviewer and Info Sheet](#java-reviewer-and-info-sheet)
  - [Objects-Oriented Programming](#objects-oriented-programming)
    - [Constructors](#constructors)

---
## Objects-Oriented Programming
* The execution of a collection of interacting objects
* Programming in this paradigm entails
  * Specifying what are in these objects
  * How these objects behave
* Refer to the following for identifying Objects:

![Class Definition](<pictures/Class Definition.png>)
  
**Let us return to our Program and CalledProgram Classes**
**But let us give Called program a special attribute called totalAdded**
**Let us also give it a way to display the totalAdded**
```java
class CalledProgram{

	private int totalAdded = 0;

	public int Addition(int x, int y){
		int sum = x + y;
		totalAdded += sum;
		return sum;
	}

	public void displayTotalSum() {
		System.out.println(totalAdded);
	}
}
```
```java
import java.util.Scanner;
class Program{

	public static void main(String[] args){		
		System.out.println("Addition Calculator");

		int a, b;

		Scanner s = new Scanner(System.in);
		System.out.print("Input the first number: ");
		a = s.nextInt();
		
		System.out.print('\n' + "Input the second number: ");
		b = s.nextInt();

		//instantiating CalledProgram 
		CalledProgram callP = new CalledProgram;
		
		// Calling the specific Addition Method from within CalledProgram
		System.out.println(callP.Addition(a, b));
		callP.displayTotalSum();
	}
}
```
**As the name suggests, when we instantiate CalledProgram we are creating a instance (copy) of that Object Type.**
**Each instance has its own values for it attributes**
**If we were to create another instance of CalledProgram its total sum attribute would be different to callP**
**e.x.**
```java
// Let us ask callP to add a couple pairs of numbers
callP.Addition(5, 20);
callP.Addition(65, 987);
callP.Addition(4, 12);

// Let us also create a new instance of CalledProgram call secondInstance
CalledProgram secondInstance = new CalledProgram();

// Lets have secondInstance perform one addition operation
secondInstance.Addition(215, 205);

// Now let us ask callP and secondInstance to print out the total sum of all that it has calculated
callP.displayTotalSum();
secondInstance.displayTotalSum();

// Output:
// 1093
// 420
```
**As you can see, though they share the same methods/instructions, their specific attributes are not share between instances.**

**The total collected by callP only includes the operations performed when the callP accessed the addition method**

**Similarly, the secondInstance total sum only includes the work done under secondInstance**

**Let us dive into deeper how we can program using the OOP paradigm**

---
### Constructors
