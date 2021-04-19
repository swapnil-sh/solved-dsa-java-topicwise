/*518. Coin Change 2 - Leetcode Java SOlutions*/
/*Problem Type - DP and Unbounded Knapsack.*/

/*
--------------------------Tabulation Solution-------------------------------------
TC - O(n*n)
SC - O(n*n)
*/

class CoinChangeMaxWays
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
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
            }
        }
        
        for(i=1;i<n+1;i++)
        {
            for(j=1;j<amt+1;j++)
            {
                if(a[i-1]<=j)
                    dp[i][j]=dp[i][j-a[i-1]]+dp[i-1][j];
                
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][amt];
    }

    public int change(int amt, int[] a) 
    {

        int res=solve(a,amt,a.length);
        return res;
    }
}

/*
--------------------------Memoization Solution-------------------------------------
TC - O(2^n)
SC - O(nn)
*/
/*
class Solution
{
    int dp[][];
    private int solve(int a[], int amt, int n)
    {   
        if(amt==0)
            return 1;
        
        if(n==0)
            return 0;
        
        if(dp[n][amt]!=-1)
            return dp[n][amt];
        
        if(a[n-1]<=amt)
            dp[n][amt]=solve(a, amt-a[n-1], n)+solve(a, amt, n-1);
        else
            dp[n][amt]=solve(a, amt, n-1);
        
        return dp[n][amt];
        
    }

    public int change(int amt, int[] a) 
    {
        dp=new int[a.length+1][amt+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int res=solve(a,amt,a.length);
        return res;
    }
}
*/

/*
--------------------------Recursive Solution-------------------------------------
TC - O(2^n)
SC - O(2^n)
*/

/*class Solution
{
    private int solve(int a[], int amt, int n)
    {   
        if(amt==0)
            return 1;
        
        if(amt!=0 && n==0)
            return 0;
        
        if(n==0)
            return 0;
        
        if(a[n-1]<=amt)
            return (solve(a, amt-a[n-1], n)+solve(a, amt, n-1));
        else
            return solve(a, amt, n-1);
        
    }

    public int change(int amt, int[] a) 
    {
        int res=solve(a,amt,a.length);
        return res;
    }
}
*/