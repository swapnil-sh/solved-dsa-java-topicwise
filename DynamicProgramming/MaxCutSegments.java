/* Maximize The Cut Segments - GeeksforGeeks Java SOlutions*/

/*
-------------------------Tabulation Solution-------------------------

TC-O(n)
SC-O(n)
*/

class MaxCutSegments
{
    //Function to find the maximum number of cuts.
    int helper(int n, int x, int y, int z, int dp[]) 
    {
        // if length of rod is 0
           // then total cuts will
        // be 0 so, initialize
        // the dp[0] with 0
        dp[0]=0;
        int i;
        
        for(i=0;i<=n;i++)
        {
 
            // if certain length
            // is not possible
            if (dp[i] == -1)
                continue;
 
            // if a segment of
            // p is possible
            if (i+x<=n)
                dp[i+x] = Math.max(dp[i + x], dp[i] + 1);
 
            // if a segment of
            // q is possible
            if (i+y<=n)
                dp[i+y] = Math.max(dp[i + y], dp[i] + 1);
 
            // if a segment of
            // r is possible
            if (i+z<=n)
                dp[i+z] = Math.max(dp[i+z], dp[i] + 1);
        }
 
        // if no segment can be cut then return 0
        if (dp[n] == -1) 
            dp[n] = 0;
        
        // return value corresponding
        // to length l
        return dp[n];
    }
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       int res=helper(n, x, y, z, dp);
       return res<0?0:res;
    }
}

/*
-------------------------Memoization Solution-------------------------

TC-O(n)
SC-O(n)
*/

/*
class Solution
{
    //Function to find the maximum number of cuts.
    int helper(int n, int x, int y, int z, int dp[]) 
    {
        if(n==0)
            return 0;
            
        if(n<0)
            return Integer.MIN_VALUE;
            
        if(dp[n]!=-1)
            return dp[n];
            
        int a = helper(n - x, x, y, z,dp) + 1;
        int b = helper(n - y, x, y, z,dp) + 1;
        int c = helper(n - z, x, y, z,dp) + 1;
        
        dp[n]=(Math.max(Math.max(a,b),c));
        return dp[n];
    }
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       int res=helper(n, x, y, z, dp);
       return res<0?0:res;
    }
}
*/


/*
-------------------------Recursive Solution-------------------------

TC-O(n^n)
SC-O(n)
*/
/*
class Solution
{
    //Function to find the maximum number of cuts.
    int helper(int n, int x, int y, int z) 
    {
        if(n==0)
            return 0;
        if(n<0)
            return Integer.MIN_VALUE;
        int a = helper(n - x, x, y, z) + 1;
        int b = helper(n - y, x, y, z) + 1;
        int c = helper(n - z, x, y, z) + 1;
        
        return(Math.max(Math.max(a,b),c));
    }
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       return helper(n,x,y,z);
    }
}

*/