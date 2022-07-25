/*77. Combinations - Leetcode Java Solution
https://leetcode.com/problems/combinations/
*/


/*
-------------Recursion using Choice Algorithm-------------------------
TC - O(2^n)
SC - (n) (height of tree)

Slight improvement by ignoring the subsets of larger sizes than k and ignoring extra calls when we have won't be able to fir k elements
*/

class Combinations {
    
    private void util(int n, int k, int i, List<Integer> temp, List<List<Integer>> res) {
        
        if(k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        if(k > n-i+1)
            return;
        
        if(i > n)
            return;
        
        temp.add(i);
        util(n, k-1, i+1, temp, res);
        temp.remove(temp.size()-1);
        util(n, k, i+1, temp, res);
        return;
    }
    
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        util(n, k, 1, new ArrayList<>(), res);
        return res;
    }
}

/*
-------------Recursion using Choice Algorithm-------------------------
TC - O(2^n)
SC - (n) (height of tree)
*/

class Solution {
    
    private void util(int n, int k, int i, List<Integer> temp, List<List<Integer>> res) {
        
        if(i>n) {
            if(temp.size()==k)
                res.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(i);
        util(n, k, i+1, temp, res);
        temp.remove(temp.size()-1);
        util(n, k, i+1, temp, res);
        return;
    }
    
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        util(n, k, 1, new ArrayList<>(), res);
        return res;
    }
}