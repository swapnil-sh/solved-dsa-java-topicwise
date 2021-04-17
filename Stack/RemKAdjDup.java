/*1209. Remove All Adjacent Duplicates in String II - Leetcode Java Solutions*/

/*
----------------------------Using 1 Stack-----------------------------------
TC - O(n)
SC - O(n)
*/
/
class RemKAdjDup
{
    public String removeDuplicates(String s, int k) 
    {
        if(s.length()==0 || k==0)
            return s;
        
        Stack<int[]> st=new Stack<>();
        int i,j,n=s.length();
        
        for(i=0;i<s.length();i++)
        {
            if(!st.isEmpty() && st.peek()[0]==s.charAt(i))
                st.peek()[1]++;
            else
                st.push(new int[]{s.charAt(i), 1});
            
            if(st.peek()[1]==k)
                st.pop();
        }
        
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        {
            int top[]=st.pop();
            while(top[1]-->0)
                sb.append((char)top[0]);
        }
        
        return sb.reverse().toString();
    }
}

/*
----------------------------Using 2 Stacks-----------------------------------

TC - O(n*k)
SC - O(n)
*/
/*
class Solution 
{
    public String removeDuplicates(String s, int k) 
    {
        if(s.length()==0 || k==0)
            return s;
        
        Stack<Character> st=new Stack<>();
        int i,j,n=s.length();
        
        for(i=0;i<s.length();i++)
        {
            Stack<Character> temp=new Stack<>();
            temp.push(s.charAt(i));
            
            while(!st.isEmpty() && st.peek()==s.charAt(i))
                  temp.push(st.pop());
            
            if(temp.size()!=k)
            {
                while(!temp.isEmpty())
                    st.push(temp.pop());
                
            }
        }
        
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        
        return sb.reverse().toString();
    }
} 
*/
/*
----------------------------Recursive Solution-----------------------------------
TC - O(n)
SC - O(n)
*/
/
/*
class Solution 
{
    public String removeDuplicates(String s, int k) 
    {

        int i,count=1;
        for(i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
                count++;
            else
                count=1;
            
            if(count==k)
            {
                String newstr=s.substring(0,i-k+1)+s.substring(i+1);
                return removeDuplicates(newstr, k);
            }
        }
        
        return s;
    }
}
*/