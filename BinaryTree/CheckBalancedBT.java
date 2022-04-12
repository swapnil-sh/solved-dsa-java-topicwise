/*110. Balanced Binary Tree - Leetcode Java Solutions
https://leetcode.com/problems/balanced-binary-tree/
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


/*-------------Recursive Solution - 2 (Optimized) -------------------
TC - O(n)
SC - O(n)
*/

class CheckBalancedBT {
    
    private boolean res = true;
    
    private int check(TreeNode root) {
        
        if(root == null)
            return -1;
        
        int lh = check(root.left);
        int rh = check(root.right);
                
        if(Math.abs(lh-rh) > 1)
            res = false;
        
        return 1 + Math.max(lh, rh);
    }
    
   
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
            return res;
        
        int height = check(root);
        return res;
        
    }
}



/*-------------Recursive Solution - 1 -------------------
TC - O(n^2)
SC - O(n^2)
*/

/*
class Solution {
    
    
    private int findHeight(TreeNode root) {
        
        if(root == null)
            return -1;
        
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        
        return 1 + Math.max(lh, rh);
    }
    
    private boolean check(TreeNode root) {
        
        if(root == null)
            return true;
        
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        
        if(Math.abs(lh-rh) > 1)
            return false;
        
        return check(root.left) && check(root.right);
    }
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
            return true;
        
        return check(root);
        
    }
}
*/