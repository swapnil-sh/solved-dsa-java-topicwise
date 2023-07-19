/*

Subset II - Leetcode
https://leetcode.com/problems/subsets-ii/

Backtracking
We need to know when we should not add a list to the result list.
By observation, a duplicate list occurs when i >= 1 (when i = 0, duplicate cannot occur) and nums[i - 1] == nums[i] and in the previous step we did not pick nums[i - 1]. The information of whether it picks or not could be passed down by a boolean parameter isPicked.

If the above condition is satisfied:

Do not add the list to the result list.
Do not do the subproblem after picking the current element.
Only do the subproblem after not picking the current element.
Note: Be careful where we should put the numList.add(val) and nu

Time: O(N * 2^N)
Space: O(N * 2^N)
*/

class SubsetII {
    private void util(int[] a, int i, List<Integer> temp, List<List<Integer>> res) {
        if (i >= a.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(a[i]);
        util(a, i+1, temp, res);

        temp.remove(temp.size() - 1);

        while(i<a.length-1 && a[i] == a[i+1]) {
            i++;
        }
        
        util(a, i+1, temp, res);
    }
    public List<List<Integer>> subsetsWithDup(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        util(a, 0, temp, res);
        return res;
    }
}


class SubsetII {
    private void subsets(int[] nums,int i, List<Integer> numList, List<List<Integer>> result, boolean isPicked) {
        // base case
        if (i >= nums.length) {
            return;
        }
        int val = nums[i];
        // not pick
        subsets(i + 1, nums, numList, result, false);
        // duplicate check
        if (i >= 1 && nums[i - 1] == nums[i] && isPicked == false) {
            return;
        }
        // pick
        numList.add(val);
        subsets(i + 1, nums, numList, result, true);
        result.add(new ArrayList<>(numList));  // add to the result list
        numList.remove(numList.size() - 1); 
    }
    public List<List<Integer>> subsetsWithDup(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        util(a, 0, temp, res, true);
        return res;
    }
}

/*
Using For loop we will select element for each position and keep a check for duplicate elements
Time: O(N * 2^N)
Space: O(N * 2^N)
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        subsetSumII(a, 0, temp, res);
        return res;
    }
    private void subsetSumII(int[] a, int ind, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i=ind; i<a.length; i++) {
            if (i>ind && a[i]==a[i-1]) 
                continue;
            
            temp.add(a[i]);
            subsetSumII(a, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}



