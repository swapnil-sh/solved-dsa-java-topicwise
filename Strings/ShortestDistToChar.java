/*821. Shortest Distance to a Character - Leetcode Java Solution*/


/*
------------------Min Array-------------------------
TC - O(n)
SC - O(1)
*/
class ShortestDistToChar
{
    public int[] shortestToChar(String s, char c)
    {
        int i,prev=Integer.MIN_VALUE/2;
        int res[]=new int[s.length()];
        //
        System.out.println(prev);
        
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)==c)
                prev=i;
            res[i]=i-prev;
        }
        
        prev=Integer.MAX_VALUE/2;
        for(i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==c)
                prev=i;
            res[i]=Math.min(res[i],prev-i);
        }
     
        return res;
    }
}

/*
--------------------Brute Force--------------------------

TC - O(n^2)
SC - O(1)
*/
/*
class Solution 
{
    public int[] shortestToChar(String s, char c)
    {
        int i,j,diff=0,k;
        int res[]=new int[s.length()];
        
        for(i=0;i<s.length();i++)
        {
            diff=Integer.MAX_VALUE;
            for(j=i,k=i;j<s.length() || k>=0;j++,k--)
            {
                
                if(j<s.length() && s.charAt(j)==c)
                    diff=Math.min(diff,j-i);
                
                if(k>=0 && s.charAt(k)==c)
                    diff=Math.min(diff,i-k);
            }
            
            res[i]=diff;
        }
        
        return res;
        
    }
}
*/