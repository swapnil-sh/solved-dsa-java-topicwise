/* Unique Permutations - Leetcode and CodeStudio Java Solutions
https://leetcode.com/problems/permutations-ii/
https://www.codingninjas.com/codestudio/problems/all-unique-permutations_1094902
*/


/*
----------------- Recursive Approach using Swappping and Hashet--------------------

TC - O(n*n!)
SC - O(n)+O(n)

*/


class Solution {
    
    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void util(int a[], int pos, List<List<Integer>> res) {
        if(pos >= a.length) {
            res.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
            return;
        }
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=pos; i<a.length; i++) {
            if(!hs.contains(a[i])) {
                hs.add(a[i]);
                swap(a, i, pos);
                util(a, pos+1, res);
                swap(a, i, pos);
             }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        util(a, 0, res);
        return res;
    }
}


/*
Same as above solution but solved on Codestudio
*/
import java.util.*;

public class UniquePermutations {
   
    private static void util(ArrayList<Integer> a, int pos, ArrayList<ArrayList<Integer>> res) {
        if(pos >= a.size()) {
            res.add(new ArrayList<>(a));
            return;
        }
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=pos; i<a.size(); i++) {
            if(!hs.contains(a.get(i))) {
                hs.add(a.get(i));
                Collections.swap(a, i, pos);
                util(a, pos+1, res);
                Collections.swap(a, i, pos);
             }
        }
    }
    public static ArrayList<ArrayList< Integer >> uniquePermutations(ArrayList<Integer> a, int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        util(a, 0, res);
        return res;
    }
}

