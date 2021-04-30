/*18. 4Sum - Leetcode Java Solution*/


/*
---------------------Two Pointer-------------------------
TC - O(n^3)
SC - O(1)
*/

class 4Sum
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    { 
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        for(int i = 0; i < len - 3; i++)
        {
            for(int j = i + 1; j < len - 2; j++)
            {
                int low = j + 1, high = len - 1;

                while(low < high)
                {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target)
                    {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1])
                            low++;
                        while(high > 1 && nums[high] == nums[high-1])
                            high--;
                        low++;
                        high--;
                    } 
                    else if(sum < target)
                        low++;
                    else
                        high--;
                }
                
                while(j < len-1 && nums[j] == nums[j+1]) 
                    j++;
            }   
            while(i < len-1 && nums[i] == nums[i+1]) 
                i++;
        }
        
        return result;
    }
}


/*
---------------------Brute Force-------------------------
TC - O(n^3logn)
SC - O(1)

1.Sort
2.Select 3 elements 
3. Search for 4th element using Binary Search
*/
