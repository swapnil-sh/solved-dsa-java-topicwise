/*75. Sort Colors - Leetcode Java Solution using Dutch National Flag Algo (Sort array which includes only 0's,1's,2's)*/

/*

Idea - We need to consider 3 points low,mid and high and set low and mid to starting index of array and high to last index

From 0.....low-1 = o's (left side of low there will only be 0's)
From low.....mid-1 = o's (Between low and mid there will only be 1's)
From high+1.....n-1 = o's (right side of high there will only be 2's)

TC = O(n) - Single Pass
SC = O(1)

*/

class SortColors
{
    public void sortColors(int[] a) 
    {
        int low=0,mid=0,high=a.length-1;
        int temp;
        
        while(mid<=high)
        {
            if(a[mid]==0)
            {
                if(low!=mid)
                {
                    temp=a[low];
                    a[low]=a[mid];
                    a[mid]=temp;
                    
                }
                low++;
                mid++;
            }
            else if(a[mid]==1)
                mid++;
            else
            {
                temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }    
    }
}


/*

Other Approaches:

1. Sort array : TC = O(nlogn) and SC = O(1) 
2. Use counting Sort (Count no of 0's,1's and 2's in the array in one pass and then fill up the array with 0's,1's,2's according to their count in another pass)
	TC - O(2n)
	SC - O(1)

*/


