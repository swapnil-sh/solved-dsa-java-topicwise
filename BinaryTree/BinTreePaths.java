/*257. Binary Tree Paths - Leetcode Java Solutions*/

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
class BinTreePaths
{
    public void BTPaths(TreeNode root, String path, List<String> paths)
    {
        if (root == null) 
            return;
        
        if (root.left == null && root.right == null) 
        {
            path += root.val;
            paths.add(path);
            return;
        }
        
        BTPaths(root.left, path+root.val + "->", paths);
        BTPaths(root.right, path+root.val + "->", paths);
    }
    
    public List<String> binaryTreePaths(TreeNode root) 
    {
        
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        
        BTPaths(root,"", res);
        
        return res;
    }
}


    
    