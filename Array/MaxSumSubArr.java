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

//-------------------------------O(n^2) Solution----------------------------------------
/*
class Solution 
{
    public int maxSubArray(int[] a)
    {
        if(a.length==1)
            return a[0];
        
        int ans=Integer.MIN_VALUE,currSum=0,i,j;
        int n=a.length;
        for(i=0;i<n;i++)
        {
            currSum=0;
            for(j=i;j<n;j++)
            {
                currSum+=a[j]; 
                ans=Math.max(ans,currSum);
            }
        }
        
        return ans;
    }
}
*/

//-------------------------------Brute Force Solution------------------------------------
/*

TC = O(n^3)
SC = O(1)

*/
/*
class Solution 
{
    public int maxSubArray(int[] a)
    {
        if(a.length==1)
            return a[0];
        
        int ans=Integer.MIN_VALUE,currSum=0,i,j,k;
        int n=a.length;
        for(i=0;i<n;i++)
        {
            for(j=i;j<n;j++)
            {
                currSum=0;
                for(k=i;k<=j;k++)
                {
                    currSum+=a[k];
                }
                
                 ans=Math.max(ans,currSum); 
            }
        }
        
        return ans;
    }
}

*/

/*

Follow up 1: If you can choose to remove one value in the given list, what's the maximum subarray sum you can get.

Input : [1,-1,3]
Output : [4] 
Explain : you will want to remove  -1, and you get a new array [1,3]

Input : [1,1,3] 
Output : [5]
Explain : you will not want to remove anything

Follow up 2 : if the array is too large to fit into the memory and you have a multi-core CPU. How can you speed things up?
Is that possible to run different thread on different part of given array and put thing together to find a solution?
(This question doesn't related to follow up 1)

Just a fruitful thought. I was asked in the interview. Hope it can help.


*/