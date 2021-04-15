/*617. Merge Two Binary Trees - Leetcode Java Solution*/

/*
----------------Recursive - (DFS,Preorder) Solution--------------------------------
TC - O(n)
TC - O(h)
*/

class MergeTwoBT
{
    private TreeNode solve(TreeNode r1, TreeNode r2)
    {
        if(r1==null && r2==null)
            return null;
        
        TreeNode newNode=null;
        if(r1!=null && r2!=null)
            newNode=new TreeNode(r1.val+r2.val);
        else
        {
            if(r1==null)
            {
                newNode=new TreeNode(r2.val);
                newNode.left=solve(null, r2.left);
                newNode.right=solve(null, r2.right);
                return newNode;
            }

            if(r2==null)
            {
                newNode=new TreeNode(r1.val);
                newNode.left=solve(r1.left, null);
                newNode.right=solve(r1.right, null);
                return newNode;
            }
        }
        
        newNode.left=solve(r1.left, r2.left);
        newNode.right=solve(r1.right, r2.right);
     
        return newNode;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
        return solve(root1, root2);
        
    }
}