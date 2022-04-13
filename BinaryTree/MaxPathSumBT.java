/*124. Binary Tree Maximum Path Sum - Leetcode Java Solution
https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
-----------------Recursive Solution (Negative CHeck Important)-------------------------------

TC - O(n)
SC - O(n)

*/

class MaxPathSumBT{
    
    private int maxSum = Integer.MIN_VALUE;
    
    private int postOrderTrav(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int ls = Math.max(0, postOrderTrav(root.left));
        int rs = Math.max(0, postOrderTrav(root.right));
        
        maxSum = Math.max(maxSum, ls+rs+root.val);
        
        return root.val + Math.max(ls, rs);
    }

    public int maxPathSum(TreeNode root) {
        
        if(root == null)
            return 0;
        
        postOrderTrav(root);
        return maxSum;
    }
}