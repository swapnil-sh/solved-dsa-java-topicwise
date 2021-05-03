/*27. Remove Element - Leetcode Java Solutions*/

/*
Time complexity : O(n). Both i and n traverse at most n steps.
In this approach, the number of assignment operations is equal to the number of elements to remove.
So it is more efficient if elements to remove are rare.
Space complexity : O(1)
*/

class RemElement
{
    public int removeElement(int[] a, int val)
    {
        int i=0;
        int n=a.length;
        while(i<n) 
        {
            if (a[i] == val)
            {
                a[i] = a[n - 1];
                n--;
            }
            else 
                i++;
        }
        
        return n;
    }
}

/*
class Solution 
{
    public int removeElement(int[] a, int val)
    {

        int i=0,j=a.length-1,res=0;
        
        while(i<a.length && i<=j)
        {
            if(a[i]==val)
            {
                res++;
                while(j>i && a[j]==val)
                {
                    j--;
                    res++;
                }
                
                if(j>i)
                {
                    int t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                    j--; 
                }   
            }
            
            i++;
        }
        
        return res==0?a.length:a.length-res;
    }
}
*/