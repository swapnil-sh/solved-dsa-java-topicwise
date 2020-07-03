class Solution
{
    
    public int subsetSumCount(int a[],int n,int sum)
    {
        int dp[][] = new int[n+1][sum+1];
        int i,j;

        for(i=0;i<n+1;i++)
        {
            for(j=0;j<sum+1;j++)
            {
                if(i==0)
                    dp[i][j] = 0;
                if(j==0)
                    dp[i][j] = 1;   
            }
        }

        for(i=1;i<n+1;i++)
        {
            for(j=1;j<sum+1;j++)
            {
                if(a[i-1]>j)
                    dp[i][j] = dp[i-1][j];
                else if(a[i-1]==0)
                    dp[i][j] = dp[i-1][j];
                else
                {
                    dp[i][j] = dp[i-1][j-a[i-1]] + dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    
    public int findTargetSumWays(int[] a, int S) 
    {
        
        int i,sum=0,s1=0,count=0;
        int n = a.length;
        
        if(n == 0)
          return 0;
        
        for(i=0;i<n;i++)
        {
            sum = sum+a[i];
            if(a[i]==0)
                count = count+1;
        }
        
        if(sum < S || (sum+S)%2 != 0)
            return 0;
        s1 = (sum+S)/2;
        
        return (int)Math.pow(2,count)*subsetSumCount(a,n,s1);
        
    }
}
