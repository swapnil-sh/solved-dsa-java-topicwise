/*Remove Duplicates from Sorted Array - Leetcode Java Solution*/

/*
-----------------------Inplace Solution-------------------------
TC - O(n)
SC - O(1)

*/
class RemDupFromSortedArray
{
    public int removeDuplicates(int[] a) 
    {
        if(a.length==0)
            return 0;
        
        int i=0,j;
        
        for(j=1;j<a.length;j++)
        {
            if(a[i]!=a[j])
            {
                i++;
                a[i]=a[j];
            }
        }
        
        return i+1;
    }
}