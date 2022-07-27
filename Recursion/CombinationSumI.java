/*39. Combination Sum - Leetcode Java Solution
https://leetcode.com/problems/combination-sum/
*/

/*
--------------------Recursion Choice Algorith-------------------
TC - O(2^t) where t=target sum  (if target = 8 and if there's an element in the array who's value is 1 and then we need to add 1, 8 times so that it adds upto target 2^t is TC )
SC - No of combinations we will be having plus the auxilliary space.

Remember an element can be chosen multiple times to add upto the given sum
*/


class CombinationSumI {
    private void util(int a[], int sum, int t, int n, List<Integer> temp, List<List<Integer>> res) {
        
        if(n < 0 || sum > t) {
            return;
        }
        
        if(sum == t) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        if(a[n] <= t) {
            temp.add(a[n]);
            util(a, sum + a[n], t, n, temp, res);
            temp.remove(temp.size()-1);
        }        
        util(a, sum, t, n-1, temp, res);
        return;
    }
    
    public List<List<Integer>> combinationSum(int[] a, int t) {
        List<List<Integer>> res = new ArrayList<>();
        util(a, 0, t, a.length-1, new ArrayList<>(), res);
        return res;
    }
}