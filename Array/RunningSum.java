/*1480. Running Sum of 1d Array - Leetcode Java Solution*/

class RunningSum
{
    public int[] runningSum(int[] a) 
    {
        int i,sum=0;
        
        for(i=0;i<a.length;i++)
        {
            sum+=a[i];
            a[i]=sum;
        }
        
        return a;
        
    }
}


/*
-----------------------Recursive Solution----------------------
*/
/*
class Solution 
{
    static int sum=0;
    private int[] solve(int a[], int i)
    {
        if(i==a.length)
            return a;
        
        sum=sum+a[i];
        a[i]=sum;
        
        solve(a, i+1);
        return a;
    }
    public int[] runningSum(int[] a) 
    {
        sum=0;
        solve(a, 0);
        return a;
        
    }
}
*/