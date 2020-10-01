/*287. Find the Duplicate Number - Leetcode Duplicate number in an immutable array | Floyd cycle detection algo*/

class FindDup 
{
    public int findDuplicate(int[] nums)
    {
        if(nums.length<=1)
            return -1;
        
        int slow=nums[0];
        int fast=nums[nums[0]];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[nums[fast]];
            
        }
        
        fast=0;
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
            
        }
        
        return fast;
        
    }
}



/*Binary Search Solution*/

/*
public int findDuplicate(int[] nums) {
	int low = 1, high = nums.length - 1;
    while (low <= high) {
        int mid = (int) (low + (high - low) * 0.5);
        int cnt = 0;
        for (int a : nums) {
            if (a <= mid) ++cnt;
        }
        if (cnt <= mid) low = mid + 1;
        else high = mid - 1;
    }
    return low;
}
*/
