package eg.edu.alexu.csd.datastructure.stack.cs18011939;

import java.util.Scanner;

public class StackUI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack s= new Stack();
		Scanner sc = new Scanner(System.in);
		boolean con=true;
		String n;
		Object ob;
		while(con) {
			System.out.println("Select operaton on the Stack:");
			System.out.println("1: Push\r\n" + 
				"2: Pop\r\n" + 
				"3: Peek\r\n" + 
				"4: Get size\r\n" + 
				"5: Check if empty\n"+
				"6: Exit");
			n=sc.next();
			switch(n)
			{
			case "1":
				ob= sc.next();
				s.push(ob);
				System.out.println("Object \""+ob+"\" has been pushed to the stack.");
				break;
			case "2":
				System.out.println("Object \""+s.pop()+"\" has been poped from the stack.");
				break;
			case "3":
				System.out.println("Object \""+s.peek()+"\" is the peek of the stack.");
				break;
			case "4":
				System.out.println("Size of the stack is "+s.size()+".");
				break;
			case "5":
				if(s.isEmpty())
					System.out.println("The stack is empty.");
				else
					System.out.println("The stack is not empty.");
				break;
			case "6":
				con=false;
				break;
			default:	
				System.out.println("Invalid Entry,Please Try Again");
			}
			
		}
		
		

	}

}
