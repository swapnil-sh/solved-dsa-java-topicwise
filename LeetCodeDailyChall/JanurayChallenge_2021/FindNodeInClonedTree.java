/*  Find a Corresponding Node of a Binary Tree in a Clone of That Tree - Java Leetcode Solutions*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class FindNodeInClonedTree
{
    TreeNode target, res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) 
    {
        this.target=target;
        
        res=inorder(original, cloned);
        return res;
    }
    
    private TreeNode inorder(TreeNode original, TreeNode cloned)
    {
        if(original==null)
            return null;
        
        inorder(original.left, cloned.left);
        if(original==target)
            res=cloned;
        inorder(original.right, cloned.right);
        
        return res;
    }
}