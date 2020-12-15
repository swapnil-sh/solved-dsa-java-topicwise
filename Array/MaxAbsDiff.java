/*Maximum Absolute Difference - InterviewBit Java Solutions*/

/*
--------------Using Maths-----------------



f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways (Since we are looking at max value, we don’t even care if the value becomes negative as long as we are also covering the max value in some way).

(A[i] + i) - (A[j] + j)
-(A[i] - i) + (A[j] - j) 
(A[i] - i) - (A[j] - j) 
(-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)

Note that case 1 and 4 are equivalent and so are case 2 and 3.

We can construct two arrays with values: A[i] + i and A[i] - i. Then, for above 2 cases, we find the maximum value possible. For that, we just have to store minimum and maximum values of expressions A[i] + i and A[i] - i for all i.


TC - O(n)
SC - O(n)
*/

public class MaxAbsDiff
{
    public int maxArr(int[] a)
    {
        int max1=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int max2=Integer.MIN_VALUE;
        int min2=Integer.MAX_VALUE;
        int i;
        
        for(i=0;i<a.length;i++)
        {
            max1=Math.max(max1,a[i]+i);
            min1=Math.min(min1,a[i]+i);
            max2=Math.max(max2,a[i]-i);
            min2=Math.min(min2,a[i]-i);
        }
        
        return Math.max(max1-min1, max2-min2);
    }
}
