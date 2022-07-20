/* 46. Permutations - Leetcode Java Solutions
https://leetcode.com/problems/permutations/
*/


/*
----------------- Recursive Approach using additional space--------------------

TC - O(n*n!)
SC - O(n)+O(n)

*/

class Permutations {
    
    void util(int a[], List<Integer> ds, boolean flag[],  List<List<Integer>> res) {
        
        if(ds.size()==a.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        
        for(int i = 0; i < a.length; i++) {
            
            if(!flag[i]) {
                flag[i] = true;
                ds.add(a[i]);
                util(a, ds, flag, res);
                flag[i] = false;
                ds.remove(ds.size()-1);
            }
            
        }
    }
    
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> res = new ArrayList<>();  
        List<Integer> ds = new ArrayList<>();
        boolean flag[] = new boolean[a.length];
        util(a, ds, flag, res);
        return res;
    }
}

/*
----------------- Recursive Swap Element Approach--------------------

TC - O(n*n!)
SC - O(n)
*/

class Solution {
    
    void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    void util(int a[], int pos, List<List<Integer>> res) {
        
        if(pos>=a.length) {
            List<Integer> temp = Arrays.stream(a).boxed().collect(Collectors.toList());
            res.add(temp);
            return;
        }
        
        
        for(int i = pos; i < a.length; i++) {
            swap(a, i, pos);
            util(a, pos+1, res);
            swap(a, i, pos);
        }
    }
    
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> res = new ArrayList<>();        
        util(a, 0, res);
        return res;
    }
}