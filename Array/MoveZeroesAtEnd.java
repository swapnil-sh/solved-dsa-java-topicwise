/*283. Move Zeroes - Leetcode Java Solutions*/


/*
-----------------------------One Pass Solution---------------------------

TC - O(n)
SC - O(1)

*/

class MoveZeroesAtEnd
{
    public void moveZeroes(int[] a)
    {
        int i,n=a.length;
        int lastNonZeroFoundAt=0;
        
        for(i=0;i<n;i++)
        {
            if(a[i]!=0)
            {
                int t=a[i];
                a[i]=a[lastNonZeroFoundAt];
                a[lastNonZeroFoundAt]=t;
                
                lastNonZeroFoundAt++;
            }   
        }
    }
}


/*
-----------------------------Two Pass Solution---------------------------

TC - O(n)
SC - O(1)

*/

/*
class Solution
{
    public void moveZeroes(int[] a)
    {
        int lastNonZeroFoundAt = 0;
        int i,n=a.length;
        
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found. 
        for (i=0;i<n;i++)
        {
            if (a[i] != 0) 
                a[lastNonZeroFoundAt++]=a[i];
            
        }
        
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (i=lastNonZeroFoundAt;i<n;i++) 
            a[i]=0;
        
    }
}
*/


/*
-----------------------------Three Pass Solution---------------------------

TC - O(n)
SC - O(1)

*/
/*
class Solution
{
    public void moveZeroes(int[] a)
    {
        int countOfZeroes=0;
        int i;
        int n=a.length;
        for(i=0;i<a.length;i++)
        {
            if(a[i]==0)
                countOfZeroes++;
        }
       
        int k=0;
        for(i=0;i<n;i++)
        {
            if(a[i]!=0)
            {
                a[k++]=a[i];
            }
        }
        
        for(i=k;i<a.length;i++)
            a[k++]=0;
    }
}

*/