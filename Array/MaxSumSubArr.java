/*53. Maximum Subarray - Leetcode Multiple Solutions*/

//-----------------------Kedane's Algorithm---------------------
/*
TC = O(n)
SC = O(1)
*/
class MaxSumSubArr
{
    public int maxSubArray(int[] a)
    {
        if(a.length==1)
            return a[0];
        
        int ans=Integer.MIN_VALUE,currSum=0,i;
        
        for(i=0;i<a.length;i++)
        {
            currSum=currSum+a[i];
            if(currSum<0)
            {
                ans=Math.max(ans,currSum);
                currSum=0;
            }
            else
                ans=Math.max(ans,currSum);  
        }
        
        return ans;
    }
}