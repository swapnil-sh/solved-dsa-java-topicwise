//Balanced Parenthesis Solution Hackerrank (JAVA STACK)


import java.io.*;
import java.util.*;

public class BalancedParenthesis 
{

    public static boolean balancedParenthensies(String s)
    {
        Stack<Character> st = new Stack<Character>();
        int i;
        for(i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '(')
                st.push(c);
            else if(c == ']' || c == '}' || c == ')')
            {
                if(st.empty())
                    return false;
                switch(c)
                {
                  
                    case ']':
                        if (st.pop() != '[')
                            return false;
                        break;
                 
                    case '}':
                        if (st.pop() != '{')
                            return false;
                        break;
                    
                    case ')':
                        if (st.pop() != '(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if(st.empty())
            return true;
        else
            return false;
    }

    public static void main(String args[])throws Exception 
    {

       Scanner sc = new Scanner(System.in);

        while (sc.hasNext())
        {
            
            String s=sc.next();
            System.out.println((balancedParenthensies(s)) ? "true" : "false" );

        }     
    }
}

   

    

