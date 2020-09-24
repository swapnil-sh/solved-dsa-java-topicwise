//33. Search in Rotated Sorted Array - Leetcode Binary Search Java Solution

class SearchinRotatedArray 
{
    public int search(int[] a, int x) 
    {
        int st=0,end=a.length-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]==x) //element is found in the mid position
                return mid;
            
            if(a[mid]<=a[end]) //if right half of an array is sorted
            {
                if(x>a[mid] && x<=a[end])
                    st=mid+1; //go searching in right sorted half
                else
                    end=mid-1; // go searching in unsorted left half
            }
            else //if left half of an array is sorted
            {
                if(x<a[mid] && x>=a[st])
                    end=mid-1;  //go searching in left sorted half
                else
                    st=mid+1;  //go searching in right unsorted half
            }
        }
        
        return -1;
    }
}
