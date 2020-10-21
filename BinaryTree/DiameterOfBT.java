/*543. Diameter of Binary Tree - Leetcode Java Solution O(n) and O(n2)*/

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
class DiameterOfBT
{
    private int maxNodes=0;
    
    public int diameter(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int lh=diameter(root.left);
        int rh=diameter(root.right);
        
        maxNodes=Math.max(lh+rh+1,maxNodes);
        
        return Math.max(lh,rh)+1;
    }
    
    public int diameterOfBinaryTree(TreeNode root)
    {
        if(root==null)
            return 0;
        
        diameter(root);
        
        return maxNodes==0?0:maxNodes-1;
        
    }
}




/*

class Solution
{
    public int height(TreeNode root)
    {
        if(root==null)
            return 0;
        
        return Math.max(height(root.left),height(root.right))+1;
    }
    public int diameterOfBinaryTree(TreeNode root)
    {
        if(root==null)
            return 0;
        
        
        int leftDiameter=diameterOfBinaryTree(root.left);
        int rightDiameter=diameterOfBinaryTree(root.right);
        
        return Math.max(height(root.left)+height(root.right),Math.max(leftDiameter,rightDiameter));
        
   

*/