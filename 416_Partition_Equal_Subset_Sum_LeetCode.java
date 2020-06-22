class Solution 
{
    
    public boolean subsetSum(int a[],int n,int sum)
    {
        boolean dp[][] = new boolean[n+1][sum+1];
        int i,j;
        
        for(i=0;i<n;i++)
        {
            for(j=0;j<sum;j++)
            {
                if(i==0)
                    dp[i][j] = false;
                else
                    dp[i][j] = true;
            }
        }
        
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=sum;j++)
            {
                if(a[i-1]>j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
                }
            }
        }
        
        if(dp[n][sum] == true)
            return true;
        else
            return false;
        
    }
    public boolean canPartition(int[] a) 
    {
        
        int n = a.length;
        int i,sum=0;
        
        for(i=0;i<n;i++)
                sum=sum+a[i];
        
        if(sum%2!=0)
            return false;
        else            
            return (subsetSum(a,n,sum/2));
        
    }
}
