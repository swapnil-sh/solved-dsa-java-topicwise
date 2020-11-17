/*101. Symmetric Tree - Leetcode Java Solutions*/


/*
------------------Iterative Solution-----------------------------

Time complexity : O(n)
Space Complexity : O(n) 

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
class SymBinTree
{
    public boolean isSymmetric(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        
        while (!q.isEmpty())
        {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            
            if (t1 == null && t2 == null) 
                continue;
            if (t1 == null || t2 == null) 
                return false;
            if (t1.val != t2.val) 
                return false;
            
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

/*
------------------Recursive Solution-----------------------------

Time complexity : O(n)
Space Complexity : O(n) (When tree is linear and height is O(n))

*/

/*class Solution 
{
    boolean isMirror(TreeNode t1,TreeNode t2)
    {
        if(t1==null && t2==null)
            return true;
        
        if(t1==null || t2==null)
            return false;
        
        if(t1.val!=t2.val)
            return false;
        
        return (isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left));
        
    }
    public boolean isSymmetric(TreeNode root)
    {
        return isMirror(root,root);
    }
}
*/


/*
Approach 3:

Level order traversal, storing each node at the end of an arraylist for that depth.

Then check that each arraylist is symmetric.

O(n) space and time.
*/