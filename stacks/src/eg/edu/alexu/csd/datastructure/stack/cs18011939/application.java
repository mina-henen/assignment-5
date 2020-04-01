package eg.edu.alexu.csd.datastructure.stack.cs18011939;

import java.util.Scanner;

public class application {
	static Scanner sc = new Scanner(System.in);
	public static boolean containsLetter(String s)
	{
		for(int i=0; i<s.length();i++)
		{
			if(Character.isLetter(s.charAt(i)))
				return true;
		}
		return false;
	}
	public static String insertString(String st,String nst, int index) 
	   { 
	        String newString = new String(); 
	        for (int i = 0; i<index; i++) 
	        { 
	            newString += st.charAt(i); 
	        }
	        newString += nst;
	        for(int i=index+1; i<st.length();i++)
	        {
	        	newString += st.charAt(i);
	        }
	             
	        return newString; 
	    }
	public static String exchanger(String s)
	{
		int i,j;
		char c;
		String nc;
		while(containsLetter(s))
		{
			for(i=0; i<s.length(); i++)
			{
				c= s.charAt(i);
				if(Character.isLetter(c))
				{
					System.out.println("Enter value of \""+c+"\"");
					nc= sc.next();
					if(nc.charAt(0)=='-')
						nc= "0 "+nc.substring(1)+ " -";
					for(j=0;j<s.length();j++)
					{
						if(s.charAt(j)==c)
							s=insertString(s,nc,j);
					}
				}
			}
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionEvaluator ev = new ExpressionEvaluator();
		String exp,postf;
		int ans;
		while(true) {
		System.out.println("Enter valid infix Expression please..");
		exp= sc.next();
		postf= ev.infixToPostfix(exp);
		System.out.println("The postfix expression is: "+ postf);
		if(containsLetter(postf))
		{
			if(postf=="Invalid Expression")
			{
				continue;
			}
			else
			{
				postf=exchanger(postf);
				ans= ev.evaluate(postf);
				System.out.println("The answer = "+ ans);
			}
		}
		else
		{
			ans= ev.evaluate(postf);
			System.out.println("The answer = "+ ans);
		}
		}	
	}

}
