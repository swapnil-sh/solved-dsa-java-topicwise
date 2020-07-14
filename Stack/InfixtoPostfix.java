//Infix to Postfix using Stack GeeksforGeeks

import java.util.*;
import java.io.*;

public class InfixtoPostfix
{
    static int precedence(char c) 
    { 
        if(c == '^') 
            return 3; 
        else if(c == '*' || c == '/') 
            return 2; 
        else if(c == '+' || c == '-') 
            return 1; 
        else
            return -1; 
    }
    
    static String infixToPostfix(String exp) 
    {
        int l = exp.length();
        int i;
        char c;
        Stack<Character> st = new Stack<>(); 
        String res = "";
          
        for (i=0;i<l;i++) 
        { 
            c = exp.charAt(i);
            
            if (Character.isLetterOrDigit(c)) 
                res += c; 
                
            else if(c == '(')
                st.push(c);
                
            else if(c == ')')
            {
                while(!st.isEmpty() && st.peek() !='(')
                {
                    res+= st.pop();
                }
                
                if (!st.isEmpty() && st.peek() != '(') 
                    return "Invalid Expression";
                else
                    st.pop();
            }
            
            else
            {
                while(!st.isEmpty() && precedence(c)<=precedence(st.peek()))
                {
                    if(st.peek() == '(') 
                        return "Invalid Expression"; 
                    res += st.pop(); 
                }
                    
                st.push(c);
                
            }
        }
        
        while (!st.isEmpty())
        { 
            if(st.peek() == '(') 
                return "Invalid Expression"; 
            res += st.pop(); 
         } 
        return res; 
    }

    public static void main(String[] args)throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0)
        {
            String exp = sc.next(); 
            System.out.println(infixToPostfix(exp));
        }
    }
}
