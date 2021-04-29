/*62. Unique Paths - Leetcode Java Solutions*/


/*
-----------------Using Combination concept------------------------
TC - O(m-1) or O(n-1)
SC - O(1)
*/

class UniquePaths
{

    public int uniquePaths(int m, int n)
    {
        int i;
        int N=m+n-2;
        int r=m-1;
        double res=1;
        
        for(i=1;i<=r;i++)
            res=res*(N-r+i)/i;
        
        return (int)res;        
        
    }
}
/*
----------------------Memoization Solution----------------------
TC-O(n^2)
SC-O(n^2)
*/
/*
class Solution 
{
    int dp[][];
    int solve(int i, int j, int m, int n)
    {
        if(i==m-1 && j==n-1)
            return 1;
        
        if(i>=m || j>=n)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        return dp[i][j]=solve(i+1, j, m, n)+solve(i, j+1, m, n);
    }
    public int uniquePaths(int m, int n)
    {
        dp=new int[m+1][n+1];
        for(int rows[]: dp)
            Arrays.fill(rows, -1);
        
        return solve(0, 0, m, n);
        
    }
}
*/
/*
----------------------Recursive Solution----------------------
TC-O(2^n)
SC-O(2^n)
*/
/*
class Solution 
{
    int solve(int i, int j, int m, int n)
    {
        if(i==m-1 && j==n-1)
            return 1;
        
        if(i>=m || j>=n)
            return 0;
        
        return solve(i+1, j, m, n)+solve(i, j+1, m, n);
    }
    public int uniquePaths(int m, int n)
    {
        
        return solve(0, 0, m, n);
        
    }
}
*/