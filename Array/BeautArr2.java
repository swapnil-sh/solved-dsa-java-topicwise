/*667. Beautiful Arrangement II - Leetcode Java SOlutions*/

/*
-----------------------Solution-1--------------------------

TC - O(n)
SC - O(1)
*/

class BeautArr2
{
    public int[] constructArray(int n, int k)
    {
        int a[]=new int[n];
        int st=1,end=n,i=0;
        boolean isHigh=false;
        a[i++]=st++;
        
        while(k>1)
        {
            a[i++]=end--;
            k--;
            isHigh=true;
            
            if(k>1)
            {
                a[i++]=st++;
                k--;
                isHigh=false;
            }
        }
        
        while(i<n)
        {
            if(isHigh==true)
                a[i++]=end--;
            else
                a[i++]=st++;
        }
        
        return a;
    }
}