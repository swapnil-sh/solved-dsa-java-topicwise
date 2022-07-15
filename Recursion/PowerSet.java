/*Power Set - Codestudio
https://www.codingninjas.com/codestudio/problems/power-set_1062667?source=youtube&campaign=Recursion_Fraz&utm_source=youtube&utm_medium=affiliate&utm_campaign=Recursion_Fraz&leftPanelTab=1

Topics - Recursion, Bitwise
*/


/*
-------------------- Bitwise Approach ----------------------
: Prereq - Bitwise Formula = (n & (1<<i)) != 0 (check if ith bit is set or not)
(1<<n)-1 = (2^n) - 1
   1. Find 2^n and iterate from 0 to (1<<n)-1.
   2. Initialze temp variable and Inside this loop iterate from 0 to n
   3. Check (n & (1<<i)) != 0 and add the element at ith position to temp
   4. Add temp to ans
   
   
Basically, we traverse from 0 to 2^(n)-1 and check for every number if their bit is set or not. If the bit is set add that character to your subsequence.

Time Complexity: O(2^n * n)
Reason: O(2^n) for the outer for loop and O(n) for the inner for loop.

Space Complexity: O(1)
*/

import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> a) {
            // WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = a.size();
        
        for(int i=0;i<(1<<n);i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if((i & (1<<j))!=0) {
                    temp.add(a.get(j));
                }
            }
            res.add(temp);
        }
        
        return res;
    }
}




/*
----------------------------Recursion - 2 (Choice Algorithm)-----------------------------
Choose an element add it and continue recursion. 
Remove element, dont choose it and continue recursion.

TC - O(2^n)

*/

import java.util.*;

public class Solution {
    
    private static void util(ArrayList<Integer> a, int n, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (n >= a.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(a.get(i));
		util(a, n+1, temp, res);
		temp.remove(temp.size()-1);
		util(a, n+1, temp, res);
    }

    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> a) {
        // WRITE YOUR CODE HERE
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
        return util(a, 0, temp, res);
    }
}




/*
----------------------------Recursion - 1 -----------------------------

Keep calling recursive function with i+1
Add the result in partial answer and copy it into ans.
Add current element in partialAns and add it to ans. 

I/p - [1,2,3]
3 - {{},{3}}
2,3 - {{},{3},{2},{3,2}}
1,2,3 - {{},{3},{2},{3,2},[1},{1,3},{1,2},{1,2,3}}

TC - O(2^n * n)

*/

import java.util.*;

public class Solution {
    
    private static ArrayList<ArrayList<Integer>> util(ArrayList<Integer> a, int n) {
        if (n >= a.size()) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            temp.add(new ArrayList<Integer>());
            return temp;
        }

        ArrayList<ArrayList<Integer>> partialAns = util(a, n + 1);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (ArrayList<Integer> i : partialAns)
            ans.add(i);

        for (ArrayList<Integer> i : partialAns) {
            ArrayList<Integer> temp = new ArrayList<>(i);
            temp.add(a.get(n));
            ans.add(temp);
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> a) {
        // WRITE YOUR CODE HERE
        return util(a, 0);
    }
}

