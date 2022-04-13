/*543. Diameter of Binary Tree - Leetcode Java Solutions
https://leetcode.com/problems/diameter-of-binary-tree/
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
----------------Optimized Recursive Solution----------------------------
TC - O(n)
SC - O(n)
*/
class DiameterOfBT
{
    private int maxEdges=0;
    
    public int diameter(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        
        
        if((lh+rh) > maxEdges)
            maxEdges = lh+rh;
        
        return 1+Math.max(lh,rh);
    }
    
    public int diameterOfBinaryTree(TreeNode root)
    {
        if(root==null)
            return 0;
        
        diameter(root);
        return maxEdges;   
    }
}

/*
----------------Brute Force Recursive Solution----------------------------
TC - O(n^2)
SC - O(n^2)
*/

/*
class Solution
{
    private int maxEdges=0;
    private int height(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return 1+Math.max(lh, rh);
    }
    public int diameter(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if((lh+rh) > maxEdges)
            maxEdges = lh+rh;
        
        diameter(root.left);
        diameter(root.right);
        
        return 1+Math.max(lh,rh);
    }
    
    public int diameterOfBinaryTree(TreeNode root)
    {
        if(root == null)
            return 0;
        
        diameter(root);
        return maxEdges;   
    }
}
*/



/*
----------------Optimized Recursive Solution - 2----------------------------
TC - O(n)
SC - O(n)
*/
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