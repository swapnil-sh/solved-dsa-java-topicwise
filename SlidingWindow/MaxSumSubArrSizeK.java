/* Max Sum Subarray of size K - GeeksforGeeks Java Solutions*/


/*
--------------------------Using Sliding Window Technique-----------------------------

TC - O(N)
SC - O(1)
*/

class MaxSumSubArrSizeK
{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N)
    {
        // code here
        int i=0,j=0,sum=0,res=Integer.MIN_VALUE;
        
        while(j<N)
        {
            sum+=Arr.get(j);
            
            if((j-i+1)==K)
            {
                res=Math.max(res, sum);
                sum=sum-Arr.get(i);
                i++;
                j++;
            }
            else
                j++;
        }
        
        return res;
    }
}


/*
--------------------------Brute Force-----------------------------

TC - O(K*N)
SC - O(1)
*/

/*
class Solution
{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N)
    {
        // code here
        int i,j,sum=0,res=Integer.MIN_VALUE;
        
        for(i=0;i<=N-K;i++)
        {
            sum=0;
            for(j=i;j<i+K;j++)
            {
                sum+=Arr.get(j);
            }
            
            res=Math.max(res,sum);
        }
        
        return res;
    }
}
*/