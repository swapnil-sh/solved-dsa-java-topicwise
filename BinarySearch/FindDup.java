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
