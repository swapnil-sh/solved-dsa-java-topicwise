/*322. Coin Change - Leetcode Java Solutions*/
/*Problem Type - DP and Unbounded Knapsack.*/


/*
--------------------------Tabulation Solution-------------------------------------

TC - O(n*n)
SC - O(n*n)
*/

class CoinChangeMin
{
    int dp[][];
    private int solve(int a[], int amt, int n)
    {   
        dp=new int[a.length+1][amt+1];
        
        int i,j;
        for(i=0;i<n+1;i++)
        {
            for(j=0;j<amt+1;j++)
            {
                if(i==0)
                    dp[i][j]=Integer.MAX_VALUE-1;
                if(j==0)
                    dp[i][j]=0;
            }
        }
        
        for(i=1;i<n+1;i++)
        {
            for(j=1;j<amt+1;j++)
            {
                if(a[i-1]<=j)
                    dp[i][j]=Math.min(1+dp[i][j-a[i-1]], dp[i-1][j]);
                
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][amt];
    }
    public int coinChange(int[] a, int amt) 
    {
        int res=solve(a,amt,a.length);
        
        if(res<0 || res==Integer.MAX_VALUE-1)
            return -1;
        return res;
    }
}


/*
--------------------------Memoization Solution-------------------------------------

TC - O(2^n)
SC - O(nn)
*/

/*
class CoinChangeMin
{
    int dp[][];
    private int solve(int a[], int amt, int n)
    {   
        if(amt==0)
            return 0;
        if(amt!=0 && n==0)
            return Integer.MAX_VALUE-1;
        if(n==0)
            return 0;
        
        if(dp[n][amt]!=-1)
            return dp[n][amt];
        
        
        if(a[n-1]<=amt)
        {
            dp[n][amt]=Math.min(1+solve(a, amt-a[n-1], n), solve(a, amt, n-1));
            return dp[n][amt];
        }
        else
        {
            dp[n][amt]=solve(a, amt, n-1);
            return dp[n][amt];
        }
        
    }
    public int coinChange(int[] a, int amt) 
    {
        dp=new int[a.length+1][amt+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        int res=solve(a,amt,a.length);
        if(res<0 || res==Integer.MAX_VALUE-1)
            return -1;
        return res;
    }
}
*/



/*
--------------------------Recursive Solution-------------------------------------

TC - O(2^n)
SC - O(2^n)
*/
/*
class Solution
{
    private int solve(int a[], int amt, int n)
    {   
        if(amt==0)
            return 0;
        if(amt!=0 && n==0)
            return Integer.MAX_VALUE-1;
        
        if(n==0)
            return 0;
        
        if(a[n-1]<=amt)
            return Math.min(1+solve(a, amt-a[n-1], n), solve(a, amt, n-1));
        else
            return solve(a, amt, n-1);
        
    }
    public int coinChange(int[] a, int amt) 
    {
        int res=solve(a,amt,a.length);
        if(res<0 || res==Integer.MAX_VALUE-1)
            return -1;
        return res;
    }
}
*/