/*217. Contains Duplicate - Leetcode Java Solutions*/

/*
--------------------Optimal Solution using HashSet----------------------

TC - O(n)
SC - O(n)

*/

class ContainsDupInArr
{
    public boolean containsDuplicate(int[] nums)
    {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums)
        {
            if (set.contains(x)) 
                return true;
            set.add(x);
        }
        return false;
    }
}


/*
------------------------Better Solution using Sorting--------------------

TC - O(nlogn)
SC - O(n)
*/
/*
class Solution 
{
    public boolean containsDuplicate(int[] nums)
    {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) 
        {
            if (nums[i] == nums[i + 1]) 
                return true;
        }
        
        return false;
    }
}
*/

/*
-----------------------Brute Force Solution-----------------

TC - O(N^2)
SC - O(1)

*/
/*
class Solution 
{
    public boolean containsDuplicate(int[] nums)
    {
        for (int i = 0; i < nums.length; ++i) 
        {
            for (int j = 0; j < i; ++j) 
            {
                if (nums[j] == nums[i]) 
                    return true;  
            }
        }
        
        return false;
    }
}
*/