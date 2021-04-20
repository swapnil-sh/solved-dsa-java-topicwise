/*377 - Combination Sum IV - Leetcode Java Solutions*/

/*
----------------------Tabulation Solution------------------------------
TC - O(n*target)
SC - O(Target)
*/

class CombSum4
{
    int dp[];                
    public int combinationSum4(int[] a, int t)
    {
        if(t==0)
            return 1;
        
        dp=new int[t+1];
        dp[0]=1;
        
        int i,j;
        for(i=1;i<t+1;i++)
        {
            for(j=0;j<a.length;j++)
            {
                if(a[j]<=i)
                    dp[i]=dp[i]+dp[i-a[j]];
            }
        }
        
        return dp[t];
    }
}
/*
----------------------Memoization Solution------------------------------
TC - O(n*target)
SC - O(Target)
*/
/*
class Solution
{
    int dp[];
    private int solve(int a[], int t)
    {
        if(t==0)
            return 1;
        
        if(dp[t]!=-1)
            return dp[t];
            
        int i,res=0;
        for(i=0;i<a.length;i++)
        {
            if(a[i]<=t)
                res+=solve(a,t-a[i]);
        }
        
        dp[t]=res;
        return dp[t];
    }
                            
    public int combinationSum4(int[] a, int t)
    {
        if(t==0)
            return 1;
        
        dp=new int[t+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        
        solve(a, t);
        return dp[t];
    }
}
*/
/*
----------------------Recursive Solution------------------------------
TC - O(n^target)
SC - O(Target)
*/
/*
class Solution
{
    public int combinationSum4(int[] a, int t)
    {
        
         if(t==0)
            return 1;
        
        int res=0;
        int i;
        for(i=0;i<a.length;i++)
        {
            if(a[i]<=t)
                res+=combinationSum4(a,t-a[i]);
        }
        return res;
    }
}
*/