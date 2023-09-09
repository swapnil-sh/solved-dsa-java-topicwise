/*
Subset Sum I - GFG Java Solution
https://practice.geeksforgeeks.org/problems/subset-sums2234/1
*/

/*
-------------------Pcik and No Pick Element Algo-----------------
TC - O(2^n)
SC - O(2^n)
*/

class SubsetSumI {
    ArrayList<Integer> subsetSums(ArrayList<Integer> a, int n){
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 0)
            return res;
        
        subsetSumI(a, 0, n, res);
        return res;
    }
    
    private void subsetSumI(ArrayList<Integer> a, int sum, int n, ArrayList<Integer> res) {
        if (n == 0) {
            res.add(sum);
            return;
        }
        subsetSumI(a, sum + a.get(n-1), n-1, res);
        subsetSumI(a, sum, n-1, res);
    }
}
