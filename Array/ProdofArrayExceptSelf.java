/*
238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/description/
*/

/*
-------------------- Prefix/Suffix Prod (Sum) Pattern with Space optimization ---------------------
TC - O(n)
SC - O(1)
*/

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] a) {
        int n = a.length;
        int res[] = new int[n];
        int p=1;
        // caluclate prefix product
        for (int i=0;i<n;i++) {
            p*=a[i];
            res[i] = p;
        }
        p=1;
        // calculate suffix product while updating res array
        for (int i=n-1;i>0;i--) {
            res[i] = res[i-1]*p;
            p*=a[i];
        }
        res[0] = p;
        return res;
    }
}


/*
-------------------- Prefix/Suffix Prod (Sum) Pattern ---------------------
TC - O(n)
SC - O(n)
*/
class Solution {
    public int[] productExceptSelf(int[] a) {
        int n = a.length;
        int leftProduct[] = new int[n];
        int rightProduct[] = new int[n];
        int res [] = new int[n];
        int p=1;
        for (int i=0;i<n;i++) {
            p*=a[i];
            leftProduct[i] = p;
        }
        p=1;
        for (int i=n-1;i>=0;i--) {
            p*=a[i];
            rightProduct[i] = p;
        }
        res[0] = rightProduct[1];
        res[n-1] = leftProduct[n-2];
        for (int i=1;i<n-1;i++) {
            res[i] = leftProduct[i-1] * rightProduct[i+1];
        }
        return res;
    }
}
