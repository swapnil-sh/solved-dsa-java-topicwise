/*416. Partition Equal Subset Sum - Leetcode Java Tabulation Solution*/

/*
-------------------------DP Tabulation Solution----------------------------------

Expected Time Complexity: O(N*sum of elements)
Expected Auxiliary Space: O(N*sum of elements)
*/
class EqSubsetSumPart
{
    boolean dp[][];
    private boolean subsetSum(int a[], int n, int sum)
    {
        if(sum==0)
            return true;
        
        if(n==0 && sum!=0)
            return false;
        
        int i,j;
        for(i=0;i<n+1;i++)
        {
            for(j=0;j<sum+1;j++)
            {
                if(i==0)
                    dp[i][j]=false;
                
                if(j==0)
                    dp[i][j]=true;
            }
        }
        
        
        for(i=1;i<n+1;i++)
        {
            for(j=1;j<sum+1;j++)
            {
                if(a[i-1]<=j)
                    dp[i][j]=dp[i-1][j-a[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        
        return dp[n][sum];
    }
    public boolean canPartition(int[] a) 
    {
        if(a.length==0)
            return false;
        int i,sum=0,n=a.length;
        
        for(i=0;i<n;i++)
            sum+=a[i];
        
        if(sum%2!=0)
            return false;
        
        else
        {
            sum=sum/2;
            dp=new boolean[n+1][sum+1];
            
            if(subsetSum(a, n, sum)==true)
                return true;
        }
        
        return false;
    }
}