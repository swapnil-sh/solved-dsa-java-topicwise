/*852. Peak Index in a Mountain Array - Leetcode Java Binary Search Solution*/

class PeakIndexMount
{
    public int peakIndexInMountainArray(int[] a)
    {
        int st=0;
        int end=a.length;
        
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            
            if(mid>0 && mid<a.length-1)
            {
                    if(a[mid]>a[mid-1] && a[mid]>a[mid+1])
                        return mid;
                    else if(a[mid]<a[mid-1])
                        end=mid-1;
                    else if(a[mid]<a[mid+1])
                        st=mid+1;
            }
            
            else if(mid==0)
            {
                if(a[0]<a[1])
                    return 1;
                else
                    return 0;
            }
            
            else if(mid==a.length-1)
            {
                if(a[a.length-1]<a[a.length-2])
                    return a.length-2;
                else
                    return a.length-1;
            }
                
        }
        
        return 0;
    }
}
