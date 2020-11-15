/*268. Missing Number - Leetcode Java Solutions*/

/*
-------------------------Using Sum of N Nautural No's Formula----------------------

TC - O(n)
SC - O(1)

*/

class MissingNo
{
    public int missingNumber(int[] a)
    {
        int sum1=0,sum2=0,res=0,i;
        int n=a.length;
        for(i=0;i<n;i++)
        {
            sum1+=a[i];
        }
        
        sum2=n*(n+1)/2;
        res=Math.abs(sum2-sum1);
        
        return res;
    }
}