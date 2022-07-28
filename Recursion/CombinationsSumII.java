
/* 40. Combination Sum II - Leetcode Java Solutions
https://leetcode.com/problems/combination-sum-ii/
*/


/*
----------------Optimised Approach by Choosing Subsequences--------------------

Take for index 0, try to place every unique element of array at that index and then move on to the next element while keeping a check after subtracting element from target
TC - o(2^n * k) (k = inserting it into res, avg length of combination is k)
SC - O(k*x), x=combinations
*/

class CombinationsSumII {
    
    
    private void util(int a[], int t, int pos, List<Integer> temp,  List<List<Integer>> res) {
        
        if(t == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        if(t < 0)
            return;
        
        for(int i = pos; i < a.length; i++) {
            
            if(i > pos && a[i] == a[i-1])
                continue;
            
            if(a[i] > t) 
                break;
            
            temp.add(a[i]);
            util(a, t - a[i], i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] a, int t) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        util(a, t, 0, new ArrayList<>(), res);
        return res;   
    }
}


/*
----------------Recursive Approach by Choice Algorithm--------------------

TC - O(2^n)
SC - O(n), 
*/

class Solution {
    
    
    private void util(int a[], int t, int i, List<Integer> temp,  List<List<Integer>> res) {
        
        if(t == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        

        if(i >= a.length || t < 0)
            return;
        
        t = t - a[i];
        temp.add(a[i]);
        
        util(a, t, i + 1, temp, res);
        
        t = t + a[i];
        temp.remove(temp.size() - 1);
        
        while(i < a.length-1 && a[i] == a[i+1])
            i++;
        
        util(a, t , i + 1, temp, res);
    }
    
    public List<List<Integer>> combinationSum2(int[] a, int t) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        util(a, t, 0, new ArrayList<>(), res);
        return res;   
    }
}


/*
-------------------Brute Force using CombinationsSum-1  approach and HashSet-------------------------

TC - O((2^t) * (k*log(size of hashet)) * xlog(x))
x = size of subset
SC - No of combinations we will be having plus the additional space.

Time Limit Exceeded Solution
*/

class Solution {
    private void util(int a[], int sum, int t, int n, List<Integer> temp,  HashSet<List<Integer>> hs) {
        
        if(sum == t) {
            
            List<Integer> list = new ArrayList<>(temp);
            Collections.sort(list);
            hs.add(new ArrayList<>(list));
            return;
        }
        
        if(n < 0 || sum > t) {
            return;
        }
        
        
        if(a[n] <= t) {
            temp.add(a[n]);
            util(a, sum + a[n], t, n-1, temp, hs);
            temp.remove(temp.size()-1);
        }        
        
        util(a, sum, t, n-1, temp, hs);
        return;
    }
    
    public List<List<Integer>> combinationSum2(int[] a, int t) {
        
        HashSet<List<Integer>> hs = new HashSet<>();
        
        util(a, 0, t, a.length-1, new ArrayList<>(), hs);

        List<List<Integer>> res = new ArrayList<>(hs);
        
        return res;   
    }
}