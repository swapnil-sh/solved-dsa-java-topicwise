/*20. Valid Parentheses - Leetcode Java Solutions*/


/*
-----------------------Solution Using Stack-----------------------------
TC - O(n)
SC - O(n)
*/

class ValidParenthesis
{
    public boolean isValid(String s) 
    {
        if(s.length()%2!=0)
            return false;
        
        int n=s.length();
        
        int i;
        Stack<Character> st=new Stack<>();
        
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' )
                st.push(s.charAt(i));
                
            
            else
            {
                if(st.isEmpty())
                    return false;
                
                char ch=s.charAt(i);
                switch(ch)
                {
                    case ')':
                        if(st.peek()=='(')
                            st.pop();
                        
                        else
                            return false;
                        break;

                    case '}':
                        if(st.peek()=='{')
                            st.pop();
                        
                        else
                            return false;
                        break;

                    case ']':
                        if(st.peek()=='[')
                            st.pop();
                        
                        else
                            return false;
                        break;
                }
            }
            
        }
        
        if(!st.isEmpty())
            return false;
        
        return true;
            
    }
}


/*
--------------------------Using Map and Stack--------------------------

*/
   
/*
class Solution
{
    public boolean isValid(String s) 
    {
        if(s.length()%2!=0)
            return false;
        
        int n=s.length();
        
        int i;
        Map<Character, Character> mp=new HashMap<>();
        Stack<Character> st=new Stack<>();
        
        mp.put(')','(');
        mp.put('}','{');
        mp.put(']','[');
        
        
        for(i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(mp.containsValue(c))
                st.push(c);
            
            else if(st.isEmpty() || mp.get(c)!=st.pop())
                return false;
        }
        
        return st.isEmpty();
            
    }
}
*/


/*
-----------------------------Using Map and Pointer---------------------------------
TC - O(n^2)
SC - O(1)
*/
/*
class Solution
{
    Map<Character, Character> mp;
    private int getTop(String s, int i)
    {
        int right=0;
        while(i>=0)
        {
            char c=s.charAt(i);
            if(mp.containsKey(c))// ch = is closing bracket
                right++;
            else
                right--;
            
            if(right<0)
                return i; 
            i--;
        }
        
        return -1;
    }
    public boolean isValid(String s) 
    {
        if(s.length()%2!=0)
            return false;
        
        int n=s.length();
        
        int i,top=0;
        mp=new HashMap<>();
        mp.put(')','(');
        mp.put('}','{');
        mp.put(']','[');
        
        
        for(i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(mp.containsValue(c))
                top=i;
            else 
            {
                if(top==-1 || mp.get(c)!=s.charAt(top))
                    return false;
                else
                    top=getTop(s, top-1);
            }
        }
        
        return top==-1;  
    }
}
*/

/*
--------------------------Using Recursion--------------------------

*/
   
/*
import java.util.Arrays;
 
class GFG {
 
    static char findClosing(char c)
    {
        if (c == '(')
            return ')';
        if (c == '{')
            return '}';
        if (c == '[')
            return ']';
        return Character.MIN_VALUE;
    }
 
    // function to check if parenthesis are
    // balanced.
    static boolean check(char expr[], int n)
    {
        // Base cases
        if (n == 0)
            return true;
        if (n == 1)
            return false;
        if (expr[0] == ')' || expr[0] == '}' || expr[0] == ']')
            return false;
 
        // Search for closing bracket for first
        // opening bracket.
        char closing = findClosing(expr[0]);
 
        // count is used to handle cases like
        // "((()))". We basically need to
        // consider matching closing bracket.
        int i, count = 0;
        for (i = 1; i < n; i++) {
            if (expr[i] == expr[0])
                count++;
            if (expr[i] == closing) {
                if (count == 0)
                    break;
                count--;
            }
        }
 
        // If we did not find a closing
        // bracket
        if (i == n)
            return false;
 
        // If closing bracket was next
        // to open
        if (i == 1)
            return check(Arrays.copyOfRange(expr, i + 1, n), n - 2);
        // If closing bracket was somewhere
        // in middle.
        return check(Arrays.copyOfRange(expr, 1, n), i - 1) && check(Arrays.copyOfRange(expr, (i + 1), n), n - i - 1);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        char expr[] = "[(])".toCharArray();
        int n = expr.length;
        if (check(expr, n))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}
 
*/
    

