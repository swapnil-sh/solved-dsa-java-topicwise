/*
216. Combination Sum III - Leetcode Java Solution
https://leetcode.com/problems/combination-sum-iii/
*/


/*
----------------------------Recursion Approach by Choosing Subsequence-----------------------------

TC - O(2^9)
SC - O(n)
*/


class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        util(k, n, 1, new ArrayList<>(), res);
        return res;  
    }
    private void util(int k, int t, int num, List<Integer> temp,  List<List<Integer>> res) {
        if(t == 0 && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(t < 0)
            return;

        if (temp.size() > k) 
            return;

        for(int i = num; i <= 9; i++) {
            if(i > t) 
                break;
            temp.add(i);
            util(k, t - i, i+1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}



/*
----------------------------Recursion Approach and Choice Algorithm-----------------------------
For every element of an array we have two choices, either to consider it or ignore it
if we consider the element update the sum and add it to subset and ask recursion to do the rest and undo all changes you did earlier (# Backtracking)
if we ignore it , ask the recursion to do remaining task

TC - O(2^9)
SC - O(n)

*/

class Solution {
    
    private static void util(int i, int t, int k, List<Integer> temp,  List<List<Integer>> res) {
        
        if(k < 0)
            return;
        
        if(k == 0) {
            if(t == 0)
                res.add(new ArrayList<>(temp));
            return;
        }
        
        if(i > 9) 
            return;
        
        t = t - i;
        temp.add(i);
        util(i + 1, t, k - 1, temp, res);
        t = t + i;
        temp.remove(temp.size() - 1);
        util(i + 1, t, k, temp, res);
        return;
        
    }

    public List<List<Integer>> combinationSum3(int k, int t) {
        
        List<List<Integer>> res = new ArrayList<>();
        util(1, t, k, new ArrayList<>(), res);
        return res;
        
    }
}
