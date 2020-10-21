/*226. Invert Binary Tree - Leetcode Iterative and Recursive Java Solution - O(n)*/

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
class MirrorOfBT 
{
    public TreeNode invertTree(TreeNode root) 
    {
        if(root==null)
            return null;
        
        if(root.left==null && root.right==null)
            return root;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        TreeNode t,x;
        while(q.size()>0)
        {
            t=q.poll();
            
            if(t.left!=null)
                q.offer(t.left);
            
            if(t.right!=null)
                q.offer(t.right);
            
            x=t.left;
            t.left=t.right;
            t.right=x;
        }
        
        return root;
        
    }
}


//------------------------------Recursive Solution ---------------------------------------

/*
class Solution 
{
    public TreeNode invertTree(TreeNode root) 
    {
        if(root==null)
            return null;
        
        if(root.left==null && root.right==null)
            return root;
        
        TreeNode l=invertTree(root.left);
        TreeNode r=invertTree(root.right);
        
    
        root.left=r;
        root.right=l;
        
        return root;
        
    }
}

*/