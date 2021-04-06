/*32. Longest Valid Parentheses - Leetcode Java Solutions*/

/*
-------------------------Space Optimized Solution----------------------------------
TC - O(n)
SC - O(1)
*/

class LongstValidParen
{
    public int longestValidParentheses(String s)
    {
        if(s.length()==0)
            return 0;
        
        int i,res=0,op=0,cl=0;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                op++;
            else
                cl++;
            
            if(op==cl)
                res=Math.max(res, op+cl);
            
            else if(cl>op)
                op=cl=0;
            
        }
        
        op=cl=0;
        for(i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='(')
                op++;
            else
                cl++;
            
            if(op==cl)
                res=Math.max(res, op+cl);
            
            else if(cl<op)
                op=cl=0;
            
        }

        return res;
        
    }
}


/*
-------------------------Using Stack----------------------------------
TC - O(n)
SC - O(n)
*/
class Solution
{
    public int longestValidParentheses(String s)
    {
        if(s.length()==0)
            return 0;
        
        Stack<Integer> st=new Stack<>();
        int i,res=0;
        
        st.push(-1);
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)==')')
            {
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                else
                {
                    int len=i-st.peek();
                    res=Math.max(res, len);
                }
                
            }
            else
                st.push(i);
        }
        
        return res;
        
    }
}