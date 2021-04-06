/*1551. Minimum Operations to Make Array Equal - Leetcode Java Solution*/

/*
---------------------Optimized-------------------
TC - O(1)
SC - O(1)
*/

class MinOpsMakeArrEq
{
    public int minOperations(int n)
    {
        int mid=n/2;       
        return mid*(mid+n%2);
    }
}

/*
---------------------Brute FOrce-------------------
TC - O(n)
SC - O(n)
*/
/*
class Solution 
{
    public int minOperations(int n)
    {
        int a[]=new int[n];
        int i,targ=0,res=0,sum=0;
        
        for(i=0;i<n;i++)
        {
            a[i]=(2*i)+1;
            sum+=a[i];
        }
        
        targ=sum/n;
        sum=0;
        for(i=0;i<n;i++)
        {
            a[i]=Math.abs(a[i]-targ);
            sum+=a[i];
        }
        
        return sum/2;
        
    }
}
*/