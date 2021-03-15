/*Equivalent Pairs - BinarySearch.com Java Solutions*/

/*

-----------------------------------Using HashMap-------------------------------------
Intuition
Take a Map and store the integer value from nums and their corresponding frequency in it. 
At the same time increment the counter to count the number of pairs formed because the index added will always be greater than the previous iteration of the for loop.

Implementation
Take a Map. In the for loop store the elements in the hashmap according to their value and their corresponding frequency. 
At the same time update the result counter to count the number of the pairs formed because the number is the same and the index is always greater as the loop progresses forward. At the end of the loop return the counter.

TC - O(n)
SC - O(n)
*/

import java.util.*;

class EquivPairs
{
    public int solve(int[] a)
    {
        int i,j,res=0;
        int n=a.length;
        HashMap<Integer, Integer> hm=new HashMap<>();

        for(i=0;i<n;i++)
        {
            if(hm.containsKey(a[i]))
            {
                res+=hm.get(a[i]);
                hm.put(a[i], hm.get(a[i])+1);
            }
            else
                hm.put(a[i], 1);
        }

        return res;
    }
}

/*
-----------------------------------Brute Force-------------------------------------

TC - O(n^2)
SC - O(1)
*/
/*
class Solution
{
    public int solve(int[] a)
    {
        int i,j,res=0;
        int n=a.length;
        
        for(i=0;i<n-1;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if(a[i]==a[j])
                    res++;
            }
        }

        return res;
    }
}

*/