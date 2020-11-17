/*  Maximum Depth of Binary Tree - Leetcode Java Solutions*/

/*
------------------Iterative Solution using Queue---------------------

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
class MaxDepth
{
    public int maxDepth(TreeNode root) 
    {
        if(root==null)
            return 0;
        
        int i,level=0,depth=0;
        Queue<TreeNode> q=new LinkedList<>();
        
        q.offer(root);
        while(!q.isEmpty())
        {
            level=q.size();
            for(i=0;i<level;i++)
            {
                if(q.peek().left!=null)
                    q.offer(q.peek().left);
                
                if(q.peek().right!=null)
                    q.offer(q.peek().right);
                
                q.remove();
            }
            
            depth++;
        }
        
        return depth;
            
    }
}

/*
------------------Recursive Solution---------------------

*/

/*
class Solution 
{
    public int maxDepth(TreeNode root) 
    {
        if(root==null)
            return 0;
        
        int ld=maxDepth(root.left);
        int rd=maxDepth(root.right);
        
        if(ld>rd) 
            return(ld+1); 
        else 
            return (rd+1); 
            
    }
}
*/