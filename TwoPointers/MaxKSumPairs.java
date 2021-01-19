/*Max Number of K-Sum Pairs - Leetcode Java Solutions*/

/*
------------------------Using Sorting and Two Pointers--------------------------------
TC - O(nlogn)
SC - O(1)
*/

class MaxKSumPairs
{
    public int maxOperations(int[] a, int k)
    {
        int i=0,j=a.length-1,res=0;
        Arrays.sort(a);
        
        while(i<j)
        {
            if(a[i]+a[j]==k)
            {
                i++;
                j--;
                res++;
                
            }
            else if(a[i]+a[j]>k)
                j--;
            else
                i++;
        }
        
        return res;
    }
}