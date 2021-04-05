/*474. Ones and Zeroes - Leetcode Java Solutions DP*/


/*
----------------------------Tabulation Solution--------------------------
*/

class OneAndZeroes
{
    
    int[][] dp;
    public int findMaxForm(String[] strs, int m, int n)
    {
        dp= new int[m+1][n+1];
        
        for(String s:strs)
        {
            int[] count = count(s);
            //zero m-count[0]  ---- 0
            //one n - count[1] ---- 0
            for(int zero=m;zero>=count[0];zero--)
            {
                for(int one=n; one>=count[1]; one--)
                {
                    dp[zero][one] = Math.max(dp[zero-count[0]][one-count[1]] +1 , dp[zero][one]);
                }
            }
        }
        
        
        return dp[m][n];
    }
    
    int[] count(String s)
    {
        int[] count=new int[2];
        
        for(char c: s.toCharArray())
            count[c-'0']++;
    
        return count;
    }
}
/*
----------------------------Memoization Solution------------------------------

*/
/*
class Solution 
{
    int dp[][][];
    private int[] count(String s)
    {
        int a[]=new int[2];
        if(s.length()==0)
            return null;
        
        for(char c: s.toCharArray())
            a[c-'0']++;
        
        return a;
    }
    
    private int solve(String[] s, int zero, int one, int i)
    {
            
        if(i==s.length || zero+one==0)
            return 0;
        
        if(dp[zero][one][i]!=0)
            return dp[zero][one][i];
        
        int a[]=count(s[i]);
        int consider=0;
        
        if(zero>=a[0] && one>=a[1])
            consider=1+solve(s, zero-a[0], one-a[1], i+1);
        
        int skip=solve(s, zero, one, i+1);
        
        dp[zero][one][i]=Math.max(consider, skip);
        
        return dp[zero][one][i];
    }
    
    
    public int findMaxForm(String[] s, int m, int n) 
    {
        if(s.length==0)
            return 0;
        
        dp=new int[m+1][n+1][s.length];
        return solve(s, m, n, 0);
    }
}
*/

/*
----------------------------Recursive Solution------------------------------

*/
/*
class Solution 
{
    private int[] count(String s)
    {
        int a[]=new int[2];
        if(s.length()==0)
            return null;
        
        for(char c: s.toCharArray())
            a[c-'0']++;
        
        return a;
    }
    
    private int solve(String[] s, int zero, int one, int i)
    {
        if(i==s.length || zero+one==0)
            return 0;
        
        int a[]=count(s[i]);
        int consider=0;
        
        if(zero>=a[0] && one>=a[1])
            consider=1+solve(s, zero-a[0], one-a[1], i+1);
        
        int skip=solve(s, zero, one, i+1);
        
        return Math.max(consider, skip);
    }
    
    
    public int findMaxForm(String[] s, int m, int n) 
    {
        if(s.length==0)
            return 0;
        
        return solve(s, m, n, 0);
    }
}
*/