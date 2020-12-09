/* Find the Closest Element in BST  - GeeksforGeeks Java Solutions*/

/*
-----------------Using Recursion---------------------

TC - O(n) (for Skewed Trees) else O(h)
SC - O(h)
*/

class FindClosestEleBST
{
    // Return the minimum absolute difference between any tree node and the integer K
    static int solve(Node root, int k)
    {
        if(root==null)
            return Integer.MAX_VALUE;
        
        if(root.data>=k)
            return Math.min(Math.abs(k-root.data), solve(root.left, k));
        else
           return Math.min(Math.abs(root.data-k), solve(root.right, k)); 
    }
    static int maxDiff(Node  root, int K) 
    { 
        // Write your code here
        if(root==null)
            return 0;
        
        return solve(root, K);
        
    } 
}


/*
-----------------Using Inorder Traversal-------------------------

1. Normal Process
TC - O(n+n)=O(n)
SC - O(n)

2.Binary Search

TC - O(n+logn)=O(n)
SC - O(n)

*/