//*======= Object =======
// A thing that has type, identity, state and behavior
//? type:       belongs to a  "class" of similar objects
//? identity:   is a distinct "instance" of a class of a objects
//? state:      has a set of properties (a.k.a fields)
//? behavior:   has "methods" (things object knows how to do)

//*======= Constructor =======

import java.util.Scanner;

public class helloWorld{
    static pyRemake py = new pyRemake();
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        py.print(input.nextLine());
        py.print(input.nextInt());
        py.print(input.nextFloat());
        py.print(input.nextDouble());
        py.print(input.nextBoolean());
        System.out.println("Hello World");

        input.close();
    }
}

class pyRemake{
    public void print(String toPrint){
        System.out.println("string");
        System.out.println(toPrint);
    }
    public void print(int toPrint){
        System.out.println("int");
        System.out.println(toPrint);
    }
    public void print(float toPrint){
        System.out.println("float");
        System.out.println(toPrint);
    }
    public void print(double toPrint){
        System.out.println("double");
        System.out.println(toPrint);
    }
    public void print(Boolean toPrint){
        System.out.println("boolean");
        System.out.println(toPrint);
    }
}