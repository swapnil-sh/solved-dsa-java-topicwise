/*700. Search in a Binary Search Tree - Leetcode Java Solutions*/

/*
------------------Recursive Solution--------------------

TC - O(n)
SC - O(n) (Stack Space)
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
class SearchInBST
{
    public TreeNode searchBST(TreeNode root, int val)
    {
        if(root==null || root.val==val)
            return root;
        
        if(root.val<val)
            root=searchBST(root.right, val);
        else if(root.val>val)
            root=searchBST(root.left, val);
            
        return root;
    }
}