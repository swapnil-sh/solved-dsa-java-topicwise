/*1143. Longest Common Subsequence - Leetcode Java Solutions*/


/*
----------------------------Tabulation Solution--------------------------
TC - O(n^2)
SC - O(n^2)
*/
class LongComSubseq
{
    int dp[][];
    private int solve(String s1, String s2, int m, int n)
    {
        if(m==0 || n==0)
            return 0;
        
        int i,j;
        for(i=0;i<m+1;i++)
        {
            for(j=0;j<n+1;j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        
        for(i=1;i<m+1;i++)
        {
            for(j=1;j<n+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
     
        return dp[m][n];
    }
    public int longestCommonSubsequence(String s1, String s2)
    {
        int m=s1.length();
        int n=s2.length();
        
        if(m==0 || n==0)
            return 0;
        
        dp=new int[m+1][n+1];
        return solve(s1, s2, m, n);
        
    }
}

/*
----------------------------Memoization Solution--------------------------
TC - O(n^2)
SC - O(n^2)
*/

/*
class Solution 
{
    int dp[][];
    private int solve(String s1, String s2, int m, int n)
    {
        if(m==0 || n==0)
            return 0;
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return dp[m][n]=(1+solve(s1, s2, m-1, n-1));
        else
            return dp[m][n]=Math.max(solve(s1, s2, m, n-1), solve(s1, s2, m-1, n));
        
    }
    public int longestCommonSubsequence(String s1, String s2)
    {
        int m=s1.length();
        int n=s2.length();
        
        if(m==0 || n==0)
            return 0;
        
        dp=new int[m+1][n+1];
        for(int rows[]: dp)
            Arrays.fill(rows, -1);
        
        return solve(s1, s2, m, n);
        
    }
}
*/


/*
----------------------------Recursive Solution--------------------------
TC - O(2^n)
SC - O(2^n)
*/
/*
class Solution 
{
    private int solve(String s1, String s2, int m, int n)
    {
        if(m==0 || n==0)
            return 0;
        
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return (1+solve(s1, s2, m-1, n-1));
        else
            return Math.max(solve(s1, s2, m, n-1), solve(s1, s2, m-1, n));
        
    }
    public int longestCommonSubsequence(String s1, String s2)
    {
        int m=s1.length();
        int n=s2.length();
        
        if(m==0 || n==0)
            return 0;
        
        return solve(s1, s2, m, n);
        
    }
}
*/