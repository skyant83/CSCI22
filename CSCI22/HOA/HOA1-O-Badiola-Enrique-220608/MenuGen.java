/*
	This class is provided to the student.
	It shall not be modified in any way.
	It must be used as directed in the activity specifications.
*/

import java.util.*;

public class MenuGen
{
	private Operation[] ops;
	private int exitKey;
	
	public MenuGen(Operation[] o)
	{
		ops = o;
	}
	
	public void run()
	{
		int x;
		ArrayList<Integer> list;
		Scanner s = new Scanner(System.in);
		
		while(true)
		{
			printMenu();
			
			x = s.nextInt();
			
			System.out.println();
			
			if(x < 0 || x > exitKey)
				System.out.println("INVALID INPUT!");
			else if(x < exitKey)
			{
				System.out.println("=============================================");
				System.out.printf("You've chosen the%s operation.\n", ops[x].getOperationName().toUpperCase());
				System.out.println("=============================================");
				
				list = new ArrayList<Integer>();
				
				String input;
				
				while(true)
				{
					System.out.print("Input an integer: ");
					input = s.next();
					
					if(input.equals("e"))
						break;
					else
					{
						try
						{
							list.add(Integer.parseInt(input));
						}
						catch(NumberFormatException e)
						{
							System.out.println("INVALID INPUT!");
						}
					}
				}
				
				Integer[] arr = new Integer[list.size()];
				list.toArray(arr);
				
				System.out.println("=============================================");
				System.out.print("RESULT: ");
				ops[x].operate(arr);
				System.out.println("=============================================");
			}
			else
				break;
		}
	}
	
	private void printMenu()
	{
		System.out.println();
		System.out.println("CHOOSE AN OPERATION");
		exitKey = 0;
		if(ops == null)
		{
			System.out.println("[0] Exit");
			System.out.print("Enter option: ");
			return;
		}
		
		while(exitKey < ops.length)
		{
			System.out.printf("[%d]%s\n", exitKey, ops[exitKey].getOperationName());
			exitKey++;
		}
		
		System.out.printf("[%d] Exit\n",exitKey);
		System.out.print("Enter choice number: ");
	}
	
	public static void main(String[] args)
	{
		Operation[] o = new Operation[1];
		o[0] = new Sum();
		MenuGen mg = new MenuGen(o);
		mg.run();
	}
}