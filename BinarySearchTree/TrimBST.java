/*669. Trim a Binary Search Tree - Leetcode Java Solution*/


/*


Time Complexity: O(N), where N is the total number of nodes in the given tree. We visit each node at most once.
Space Complexity: O(N). Even though we don't explicitly use any additional memory, the call stack of our recursion could be as large as the number of nodes in the worst case.

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
class TrimBST
{
    public TreeNode trimBST(TreeNode root, int low, int high) 
    {
        if(root==null)
            return null;
    
        if(root.val<low)
            return trimBST(root.right, low, high);
        
        else if(root.val>high)
            return trimBST(root.left, low, high);
        
        root.left=trimBST(root.left, low, high);
        root.right=trimBST(root.right, low, high);
        
        return root;
    }
}