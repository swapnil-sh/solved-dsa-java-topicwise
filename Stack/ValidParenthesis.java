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
   

    

