/*1769. Minimum Number of Operations to Move All Balls to Each Box - Leetcode Java Solution*/

/*
----------------------Brute Force------------------------
TC - O(n^2)
SC - O(1)
*/

class MinOpsToMoveBalls
{
    public int[] minOperations(String s) 
    {
        int i,j,n=s.length();
        int res[]=new int[s.length()];
        
        for(i=0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(s.charAt(j)=='1')
                    res[i]+=i-j;
            }
            
            for(j=i+1;j<n;j++)
            {
                if(s.charAt(j)=='1')
                    res[i]+=j-i;
            }
        }
        
        return res;
    }
}