/*Kth Missing Positive Number - Leetcode Java Solutions*/

/*
----------------------------Using Binary Search Approach--------------------------

TC - O(logn)
SC - O(1)
*/

class KthMissPosNoArr
{
    public int findKthPositive(int[] a, int k)
    {
        int i,n=a.length,missCount=0;
        int st=0;
        int end=n;
        int mid;
        
        while(st<end)
        {
            mid=st+(end-st)/2;
            missCount=a[mid]-(mid+1);
            if(missCount>=k)
                end=mid;
            else
                st=mid+1;
        }
        return st+k;
    } 
}

/*
----------------------------Using Naive Approach-1--------------------------

TC - O(n)
SC - O(maxEle)
*/
/*
class Solution
{
    public int findKthPositive(int[] a, int k)
    {
        int i, n=a.length, x;
        
        x=a[0]-1;
        for(i=0;i<n-1 && x<k;i++)
            x+=a[i+1]-a[i]-1;
                
        if(x>k)
            return a[i]-(x-k)-1;
        else if (x<k) 
            return a[i]+(k-x);
        else 
            return a[i] - 1;
    } 
}
*/

/*
----------------------------Using Naive Approach-2--------------------------

TC - O(n)
SC - O(1)
*/
/*
class Solution
{
    public int findKthPositive(int[] a, int k)
    {
        int i,max=Integer.MIN_VALUE;
        int n=a.length;
        for(i=0;i<a.length;i++)
        {
            if(max<a[i])
                max=a[i];
        }
        
        int x[]=new int[max+1];
        
        for(i=0;i<n;i++)
            x[a[i]]=1;
        
        for(i=1;i<max+1;i++)
        {
            if(x[i]==0)
                k--;
            
            if(k==0)
                break;
        }
        
        if(k!=0)
            return i+k-1;
        return i;
    } 
}
*/