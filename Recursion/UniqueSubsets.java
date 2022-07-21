/* 90. Subsets II (Unique Solutions) - Leetcode And Codestudio Java Solutions
https://leetcode.com/problems/subsets-ii/
https://www.codingninjas.com/codestudio/problems/unique-subsets_3625236
*/


/*
--------------------Leetcode Solution-----------------------
TC - O(2^n)
SC - O(n)

*/

class UniqueSubsets {
    
     private static void util(int a[], int i, List<Integer> temp, List<List<Integer>> res) {
        if(i >= a.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
       
        temp.add(a[i]);
        util(a, i+1, temp, res); 
        while(i<a.length-1 && a[i]==a[i+1]) {
            i++;
        }
        temp.remove(temp.size()-1);
        util(a, i+1, temp, res);    
    }
    
    public List<List<Integer>> subsetsWithDup(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        util(a, 0, temp, res);
        return res;
    }
}


/*
--------------------CodeStudio Solution-----------------------

*/

import java.util.*;

public class Solution {
    
    private static void util(int a[], int i, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if(i >= a.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
       
        temp.add(a[i]);
        util(a, i+1, temp, res); 
        while(i<a.length-1 && a[i]==a[i+1]) {
            i++;
        }
        temp.remove(temp.size()-1);
        util(a, i+1, temp, res);    
    }
    
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int a[]) {
        // Write your code here..
        Arrays.sort(a); 
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        util(a, 0, temp, res);
        
        res.sort((x, y) -> {
            for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
                if (x.get(i) != y.get(i)) {
                    return x.get(i) - y.get(i);
                }
            }
            return x.size() - y.size();
        });
        return res;
    }
}