/*189. Rotate Array - Leetcode Java Solutions*/

/*
------------------Reversal Approach Solution-----------------------

TC - O(n)
SC - O(1)

*/

class RotateArrKRight
{
    public void rev(int a[],int st,int end)
    {
        int i=st;
        int j=end;
        
        while(i<j)
        {
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
            
            i++;
            j--;
        }
    }
    public void rotate(int[] a, int k)
    {
        if(k==0)
            return;
        
        if(a.length==1)
            return;
        
        int n=a.length;
        rev(a,0,n-1);
        rev(a,0,(k%n)-1);
        rev(a,k%n,n-1);
        
        
    }
}



/*
-----------------------Using Extra Space------------------------------------

TC - O(n)
SC - O(n)

*/

/*
class Solution 
{
    public void rotate(int[] a, int k)
    {
        if(k==0)
            return;
        
        if(a.length==1)
            return;
        
        int n=a.length;
        int i;
        
        int temp[]=new int[n];
        for(i=0;i<n;i++)
            temp[(i+k)%n]=a[i];
        
        for(i=0;i<n;i++)
            a[i]=temp[i];
            
    }
}
*/

/*
------------------------------------Brute Force Solution----------------------------------

TC - O(n*k)
SC - O(1)

*/
/*
class Solution 
{
    public void rotate(int[] a, int k)
    {
        if(k==0)
            return;
        
        if(a.length==1)
            return;
        
        int n=a.length;
        int i,prev,j;
        k=k%n;
        for(i=0;i<k;i++)
        {
            prev=a[n-1];
            for(j=0;j<n;j++)
            {
                int t=a[j];
                a[j]=prev;
                prev=t;
            }
            
        }
        
        
    }
}
*/