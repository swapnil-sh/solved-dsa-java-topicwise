/*35. Search Insert Position - Leetcode Binary Search Java Solution*/

class SearchInsertPos 
{
    public int searchInsert(int[] a, int t) 
    {
        int st=0;
        int end=a.length-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            
            if(a[mid]>=t)
                end=mid-1;
         
            else
                st=mid+1;
        }
        return st;
    }
}
