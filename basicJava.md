# Java Reviewer and Info Sheet
- [Java Reviewer and Info Sheet](#java-reviewer-and-info-sheet)
	- [Defining Classes and Methods](#defining-classes-and-methods)
		- [Naming Conventions](#naming-conventions)
		- [Classes](#classes)
		- [Methods](#methods)
		- [Calling Methods](#calling-methods)
		- [Parameter Methods](#parameter-methods)
		- [Return Methods](#return-methods)
		- [Applying both in One Method](#applying-both-in-one-method)
		- [Method Overloading](#method-overloading)
		- [Variables](#variables)
		- [Input](#input)
	- [Commonly Asked Questions](#commonly-asked-questions)
		- [Q1. Why use methods?](#q1-why-use-methods)
		- [Q2. What are Classes and why do they go before Methods. i.e.](#q2-what-are-classes-and-why-do-they-go-before-methods-ie)
		- [Q3. What is the point of adding public before the Method declaration. i.e.](#q3-what-is-the-point-of-adding-public-before-the-method-declaration-ie)
		- [Q4. What does adding static before the return type do? i.e.](#q4-what-does-adding-static-before-the-return-type-do-ie)
   

## Defining Classes and Methods
### Naming Conventions
* Before starting with any of Java, it is important to discuss some common conventions
* While these are not required, it is generally recommended that we follow these to ensure that everyone, including those who debug and/or work with you on your program, will be on the same page.

```java
// Class Names:
//	- Start with capital letter and capitalize succeeding words

class ClassName {

	// Method Names:
	//	- Start with a lowercase letter and capitalize succeeding words
	public void methodName() {

		// Variable Names:
		//	- Pretty much the same as Method Names
		int numberOfVariables = 1;
	}
}

// For any of the above, the following must be true:
//	- consists of letters, numbers, $ or _
//	- should start with a letter or underscore
//	- can 𝗡𝗢𝗧 contain spaces
```

---
### Classes
  * Java is an **object-oriented** programming language.
  * Everything in Java is associated with classes and objects, along with its *attributes* and *methods*. 
  * For example: in real life, a car is an **object**. The car has **attributes**, such as weight and color, and **methods** which define what a car can do, such as drive and brake.
  * Example of a Class:
```java
// To define a class, use the keyword 𝗰𝗹𝗮𝘀𝘀 and the 𝗻𝗮𝗺𝗲 of the class.
class Program {
	// Here you will be able to create/define your methods and create your variables.
	int x = 12;
}
```

> Notes:
> 1. All variables written in the class are also called attributes.
> 2. You can access these variables using by creating an object of the class 

---
### Methods
 * A block of code which **ONLY** runs when called
 * A method must be declared within a class.
 * It is defined with the **Name** of the method, followed by parentheses **( )**
 * Example of a Method:
```java
class Program{
	
	// Method is written using the following format:
	// <access specifier> <return type> <name>() { instructions go here }
	public static void main(String[] args){
		//the 𝗣𝗨𝗕𝗟𝗜𝗖 & 𝗦𝗧𝗔𝗧𝗜𝗖 keyword is considered the start of the Method
		// It is also important to have the parameter 𝗦𝘁𝗿𝗶𝗻𝗴[] 𝗮𝗿𝗴𝘀.
		// We will explain the meaning of the keyword 𝗣𝗨𝗕𝗟𝗜𝗖 & 𝗦𝗧𝗔𝗧𝗜𝗖 as well as parameters later on, so just remember it for now.
		
		// Here you will be able to define your variables and the things you want the function to do
		System.out.println("I am a Method");
		System.out.println("I am called main!");
		System.out.println("Since I am main, I am the first thing that runs.");
		System.out.println("I am also the only one that runs on its own.");
		System.out.println("Because I go first, people also call me the Base Method.");
	}
}
```
>Notes:
>1.	That the *class Program* part is not considered a part of the method itself
>2.	The main Program is the only one that can run on it's own, **unless** the file is instantiated. ‍(TBD)
>3.	There can exist multiple methods within a single class

---
### Calling Methods
aka Creating objects... aka instantiation

**Lets Say I Have Two Separate Methods or Two Separate .java files**

Method 1 (Base Method)
```java
class Program{

	public static void main(String[] args){
		System.out.println("Hi, I'm the Base");	
	}
}
```
Method 2 
```java
//note you can call the class section anything you want
class Method2{
	//same goes for the Method Name 
	public void Callable_Method(){
		//this is just a placeholder, you can put any command here
		System.out.println("I'm the Second Method");
	}
}
```

**As you know, by default only the classes with *psvm* (public static void main(String[] args)) will run.**

**Hence, Method2 won't activate or do anything**

**To change that we need to instantiate *(connect)* the second program to the main program**

**It's as simple as adding 1 line to  the Base Method**

Method 1 (Base Method)
```java
class Program{

	public static void main(String[] args){		
		System.out.println("Hi, I'm the Base");

		//instantiating the 2nd Method
		//Class_Name psudo = new Class_Name();
		// you can rename psudo to anything (perferably something that is descriptive of what it does or will do)
		Method2 m2 = new Method2;
	}
}
```

**As simple as it may be, running this won't do anything**

**All this does is connect it. We haven't actually told it do do anything yet**

**Lets make it run the specific method;** 
```java
public void Callable_Method(){
	...
}
```
Method 1 (Base Method)
```java
class Program{

	public static void main(String[] args){		
		System.out.println("Hi, I'm the Base");

		//instantiating the 2nd Method 
		Method2 m2 = new Method2;
		
		//Calling/Activating the Method itself
		m2.Callable_Method();
		//dont forget this ---> ()
	}
}
```
**The Output will look something like this:**
```
Hi, I'm the Base 
I'm the Second Method
```
---
### Parameter Methods
* Parameter Methods are regular methods that have *parameters* added in the ( ) section of the Method_Name
* Used so that information can be sent from one method to the parameter method for it to do *its own*  set of commands
Example
```java
class Method3{
 
	public void Callable_Method(/* parameters go here */){
		//commands relating to the parameters go here
	}
}
```

**To put it in simpler terms, the parameters can set a variable that only this specific method can use**

**Lets add parameters to the method above**
```java
class Method3{
 
	public void Parameter_Method(int x){
		int sum = 0;
		//just a random equation to show the use of parameters
		sum = x + 3;
		System.out.println(sum);
	}
}
```
**Instantiating it in the Base Method:**
```java
class Program{

	public static void main(String[] args){		
		System.out.println("Hi, I'm the Base");

		// Instantiating the 2nd Method 
		Method2 m2 = new Method2;
		m2.Callable_Method();

		// Instantiating the 3rd Method
		Method3 m3 = new Method3();
		
		// Now we must give information for the parameter method to work with
		// Since the parameter is an integer variable, we must give it an integer
		m3.Parameter_Method(5);
		// This should send the number you type to the method
		// It should add 3 to it
		// Then Write the sum

		// We can also send variables using parameters
		int sendnumber = 10;
		m3.Parameter_Method(sendnumber);
		
	}
}
```
**The Output will look something like this:**
```
Hi, I'm the Base 
I'm the Second Method
8                       //the sum
13                      //the 2nd sum
```
---
### Return Methods
**Before talking about Return Methods, we need to discuss Return Types**

**Return Types:**
* these are *some of the types of Methods that can be created i.e.
	* String 	---> returns a string
	* int 		---> returns a integer
	* double 	---> returns a double
	* boolean 	---> returns true or false
	* void 		---> does not need to return anything

> A full list of Data Types can be found in the [Variables Section](#variables)

Examples
```java
public String StringReturn()

public int IntegerReturn()

public double DoubleReturn()

public boolean BoolReturn()

public void NoReturn()
```
**Methods with these return types *(except the void return type)* must return a value or piece of information that corrsespond to its type** \
ie. String must return a string, int return a int, double return a double, etc.

**Functions similar to WriteLine() won't work here since it can't return non-variables**
>to return something is to send something back to from where it was called.

For example
```java
public String StringReturn(){
	//has to return a string since thats it's return type
	return "Put any string here";
}
```
Alternatively you can do this
```java
public String StringReturn(){
	String sendback = "Put any string here";
	return sendback;
}
```
they are essentially the same

---
### Applying both in One Method
**Let's say that I want to make a program that has parameters, computations and return values**

**Something similar to a Calculator. An addition calculator would do fine as an example**

**Let's start with the Addition Method with a Integer return type**
```java
class CalledProgram{
	//this time we'll use 2 parameters
	public int Addition(int x, int y){
		int sum = x + y;
		return sum;
}
```
**Next the Base Method**
```java
import java.util.Scanner;
class Program{

	public static void main(String[] args){		
		System.out.println("Addition Calculator");

		int a, b;

		// We import Scanner class to create a new Scanner that will read what we type in the console
		// You can rename 's' to anything you want
		Scanner s = new Scanner(System.in);
		System.out.print("Input the first number: ");
		
		// We need to specify the type of data we are getting so we use the dot syntax ( . ) and specify that the 𝗡𝗘𝗫𝗧 input will be an integer
		// We immediately assign that integer to the integer variable a
		a = s.nextInt();
		
		//the '\n' just means that it will make a new line before writing the "Input the Second....." part
		System.out.print('\n' + "Input the second number: ");
		b = s.nextInt();

		//instantiating the Int Addition Method Method 
		CalledProgram callP = new CalledProgram;
		
		//Since there is no print funtion within the method itself, we can imbed the activation of Addition in a System.out.println in the Base Method
		System.out.println(callP.Addition(a, b));
	}
}
```
**The Output will look something like this:**
```
Addition Calculator 
Input the first number: 5       //number I chose 
Input the second number: 7      //the second number I chose
12								//the sum
```

When using parameters, it is **IMPORTANT** to remember that Methods with parameters will not function unless a parameter is passed when used.  

example:
```java
class Program {
	public static void main(String[] args) {
		giveGreetings();
	}

	public String giveGreetings(String name) {
		// Using String.format allows us to use variable in place of certain identifiers.
		// Common identifiers include %d for integers, %s for strings (accepts any variabe type but returns string), %c for single characters
		return String.format("Hello %s", name);
	}
}
```
This program will not function since within psvm, the giveGreetings() method is not given any parameters.

We can avoid this error by either providing giveGreetings() with a string or by using Method Overloading. But what is Method Overloading?

---
### Method Overloading
* Overloading is when you have multiple methods with the **same name** but **different parameters**
* Instead of defining two methods that should do the same thing, it is better to overload one.

Let us take our example from earlier
```java
class Program {
	// What if we want greet in two similar but different ways
	// One just says hello, the other says hello and a name.
	// ex. 
	//		Hello
	//		Hello John

	public static void main(String[] args) {
		System.out.println(giveGreetings()); // normal greeting
		System.out.println(giveGreetings("John")); // greeting with a name
	}

	// We can overload the giveGreetings() method to have it accept no values.
	public String giveGreetings(/*no paramater*/) {
		return "Hello";
	}
	public String giveGreetings(String name) {
		return String.format("Hello %s", name);
	}
}
```
**The Output will look something like this:**
```
Hello
Hello John
```

With the above, any use of the giveGreetings() method (with or without a string parameter will produce an output)

You may also give the methods different return types. As long as it has the same name, the method will be overloaded.  
ex.

```java
public int plusMethod(int x, int y) {
  return x + y;
}

public double plusMethod(double x, double y) {
  return x + y;
}
```

---
### Variables
* Variables are containers that store data values
* Similar to methods, there are different **types** of variables
* Data Types include:
  * byte	- 1 byte (numbers -128 to 127)
  * short	- 2 byte (numbers -32,768 to 32,767)
  * int		- 4 byte (numbers -2,147,483,648 to 2,147,483,647)
  * long	- 8 byte (numbers -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
  * float	- 4 byte (stores fractional numbers, sufficient for storing 6-7 decimal digits)
  * double	- 8 byte (stores fractional numbers, sufficient for storing 15 decimal digits)
  * boolean	- 1 byte (stores true or false values)
  * char	- 2 byte (stores single character/letter or ASCII values)
* There are 3 categories of variables:
  * instance feilds 	- belongs to an object
  * local variables 	- belongs to a method, holds temporary computations
  * paramater variables - belongs toa method, value intialized to the ammount specified during method call

```java
// The syntax is as follows:
// type variableName; or
// type variableName = value;
int number = 1;
char letter = 'c';
float decimal = 1.06f;

boolean bool = false;

// You may have noticed that String isn't part of the data types
// This is because it is a non=primitive data type. Specifically, it is an Object with methods
// However, its declaration is the same.
String imText = "I am a string";

// Certain data types can be converted to other types simple reassignment
// This is often called Widening Casting (automatic)
// e.x.
// byte -> short -> char -> int -> long -> float -> double
double doubleValue = number;

// However, some data types must be converted via casting
// This is often called Narrowing Casting (manual)
// double -> float -> long -> int -> char -> short -> byte
// This might cause some loss in precision
int x = (int) 4.68; // x = 4

// I suppose it would also be good to mention that one must manually convert from number types to String and vise versa
// e.x
int i = 5;
double d = 34.23;
String s = Integer.toString(i);
s = Double.toString(d);

String numb = "56";
i = Integer.parseInt(numb);		// assigns 56 to i
d = Double.parseDouble(numb);	// assigns 56 to d
```

---
### Input
* To enable keyboard input in the console, we need to import the Scanner class
```java
// Importing the Scanner class
import java.util.Scanner;

class ScanConsole {
	
	public static void main(String[] args) {
		// Defining a Scanner object
		Scanner in = new Scan(System.in);
		int i =  in.nextInt();			// reads the entire next line and converts it to an integer
		double d =  in.nextdouble();	// reads the entire next line and converts it to a double
		String s =  in.nextLine();		// reads the entire next line
		String word = in.next();		// reads the next word
	}
}
```

---
## Commonly Asked Questions

### Q1. Why use methods? 

**Answer:** To reuse code: define the code once, and use it many times.

---
### Q2. What are Classes and why do they go before Methods. i.e.
```java
class FirstClass{
	//Methods go here
}
```
**Answer:** Classes is a *template for objects*, and an object is an *instance of a class*. In other words they are like ***containers***. They hold all the various methods, objects, attributes, etc.
 
---
### Q3. What is the point of adding public before the Method declaration. i.e.
```java
public void Method1();
```
**Answer:** These are *Access Modifiers*. They are used to set the access level/visibility for classes, fields, methods and properties.  The following table will show you the two main Access Types and their uses.

|Access Type | Description|
|:-:|:-:|
|`public`|The code is accessible for all classes (can be activated by other classes)|
|`private`|The code is only accessible within the same class|
 
---
### Q4. What does adding static before the return type do? i.e.
```java
public static void Method2();
```
**Answer:** In Java, static means something which *cannot be instantiated*. Take for example these two methods

Method 1 (Base Method)
```java
class Program{

	public static void main(String[] args){
		System.out.println("Hi, I'm the Base");
		
	}
}
```
Method 2 
```java
class Method2{
	//unlike previously we'll add static before void
	public static void Callable_Method(){
		System.out.println("I'm the Second Method");
	}
}
```
Now that the static keyword was used we can no longer instantiate it in the Base Method. How then would we access it, you ask. Easy.

Method 1 (Base Method)
```java
class Program{

	public static void main(String[] args){
		System.out.println("Hi, I'm the Base");
		
		//instead of doing the classic:
		//Method2 m2 = new Method2(); we just
		Method2.Callable_Method();
	}
}
```
> There is more to the static keyword than that, but that's for another time. It gets a bit more complicated.