package eg.edu.alexu.csd.datastructure.stack.cs18011939;


public class ExpressionEvaluator implements IExpressionEvaluator {
	
	public static int rank(char op)
	{
		switch(op)
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}
	public static boolean valid(String ex)
	{
		String st="0123456789 /*-+";
		String s;
		char c,c2;
		int operctr=0,numctr=0,j=0;
		if(!Character.isDigit(ex.charAt(0)))
		{
			return false;
		}
		for(int i=0; i<ex.length(); i++)
		{
			c=ex.charAt(i);
			s= Character.toString(c);
			if(!st.contains(s))
			{
				return false;
			}
			if(c=='+' || c=='-' || c=='*' || c=='/')
			{
				operctr++;
			}
		}
		while(j<ex.length()-1)
		{
			c2=ex.charAt(j);
			if(Character.isDigit(c2))
			{
				numctr++;
				while(j<ex.length() && ex.charAt(j)!=' ')
				{
					j++;
				}
			}
			j++;
		}
		if(numctr>0 && operctr>0)
		{
			if(!ex.contains(Character.toString(' ')))
			{
				return false;
			}
		}
		if((numctr-operctr)!=1)
		{
			return false;
		}
		
		return true;
	}
	@Override
	public String infixToPostfix(String expression){
		// TODO Auto-generated method stub
		Stack s= new Stack();
		Stack par= new Stack();
		String result = new String("");
		int flag=1,j;
		int k=1;
		char c,c1;
		int h,r;
		boolean nfl=true;
		String op="/*-+";
		for(int i=0; i<expression.length();i++)
		{
			h=i-1;
			while(h>-1 && expression.charAt(h)==' ')
			{
				h--;
			}
			if(h>-1 && op.contains(Character.toString(expression.charAt(h))))
			{
				nfl=true;
			}
			if(expression.charAt(i)=='-' && nfl)
			{
				r=i+1;
				while(r<expression.length()&& (Character.isLetterOrDigit(expression.charAt(r))||expression.charAt(r)==' '))
				{
					r++;
				}
				expression=expression.substring(0, (i)) + "(0" + Character.toString(expression.charAt(i))+expression.substring(i+1, r) + ")" + expression.substring(r);
				i+=(r-i);
			}
			if(expression.charAt(i)==' ')
			{
				continue;
			}
			nfl=false;
		}
		for(int i=0; i <expression.length(); ++i)
		{
			c=expression.charAt(i);
			j=i+1;
			if(j<expression.length())
			{
				if(Character.isLetter(c) && Character.isLetter(expression.charAt(j)))
					return "Invalid Expression";
				while(expression.charAt(j)==' ' && j!=expression.length()-1)
				{
					j++;
				}
				c1=expression.charAt(j);
			}
			else
			{
				c1='!';
			}
			if(c==' ')
			{
				continue;
			}
			if (Character.isLetterOrDigit(c) && expression.charAt(i-1+k)!=')')
			{
				result += c;
	            flag=0;
			}
			else if (c == '(') 
			{
				par.push(c);
				s.push(c);
				flag=0;
			}
			else if (c == ')') 
            { 
				
				if(par.isEmpty())
				{
					return "Invalid Expression";
				}
				par.pop();
				flag=0;
                while (!s.isEmpty() && (char)s.peek() != '(') 
                    {
                	result+=" ";
                	result += s.pop();
                    }
                  
                if (!s.isEmpty() && (char)s.peek() != '(') 
                    {
                	return "Invalid Expression";                 
                    }
                else
                    {
                	s.pop(); 
                    }
            }
			else if (c=='+' || c=='-' || c=='*' || c=='/')
			{
				if(flag==1 || i==expression.length()-1)
				{
					return "Invalid Expression";
				}
				flag=1;
				while (!s.isEmpty() && rank(c) <= rank((char)s.peek()))
				{ 
                    if((char)s.peek() == '(') 
                        {
                    	return "Invalid Expression"; 
                        }
                    result += s.pop();
                    result+=" ";
                    
				} 
                s.push(c);
			}
			else
			{
				return "Invalid Expression"; 
			}
			if(c1=='+' || c1=='-' || c1=='*' || c1=='/')
			{
				result+=" ";
			}
			k=0;
		}
		while (!s.isEmpty()){ 
            if((char)s.peek() == '(') 
                {
            	return "Invalid Expression"; 
                }
            result+=" ";
            result += s.pop();
            
         }
		return result;
	}

	@Override
	public int evaluate(String expression){
		// TODO Auto-generated method stub
		if(!valid(expression)) {throw new RuntimeException("Invalid Expression");}
		Stack s= new Stack();
		char c;
		float val1,val2,temp;
		boolean spacef=false;
		for(int i=0; i <expression.length(); ++i)
		{
			c= expression.charAt(i);
			if(c==' ')
			{
				spacef= true;
				continue;
			}
			
			if(Character.isDigit(c) && spacef || s.isEmpty())
			{
				s.push((float)c-'0');
			}
			else if(Character.isDigit(c) && !spacef && !s.isEmpty())
			{
				temp= (float)s.pop();
				s.push((c-'0')+(temp*10));
			}
			else
			{
				val1=(float)s.pop();
				val2=(float)s.pop();
				switch(c)
				{
				case'+':
					s.push(val2+val1); 
                    break; 
                      
                case '-': 
                    s.push(val2-val1); 
                    break; 
                      
                case '/': 
                	if(val1==0){throw new IllegalStateException("Can't divide by Zero.");}
                	else{s.push(val2/val1);}
                    break; 
                      
                case '*': 
                    s.push(val2*val1); 
                    break;
				}
				
			}
			spacef= false;
				
		}
		float r=(float)s.pop();
		return (int)r;
	}

}
