/* Unique Permutations - CodeStudio Java Solutions
https://www.codingninjas.com/codestudio/problems/all-unique-permutations_1094902
*/


/*
----------------- Recursive Approach using Swappping and Hashet--------------------

TC - O(n*n!)
SC - O(n)+O(n)

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

