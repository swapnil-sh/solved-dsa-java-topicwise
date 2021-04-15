/*617. Merge Two Binary Trees - Leetcode Java Solution*/

/*
----------------Recursive - (DFS,Preorder) Solution--------------------------------
TC - O(n)
TC - O(n) (For Skewed Tree)
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

/*
----------------Same Recursive Better coded - (DFS,Preorder) Solution--------------------------------
TC - O(n)
TC - O(n) (For Skewed Tree)
*/

/*
class Solution
{
    private TreeNode solve(TreeNode t1, TreeNode t2)
    {
       if(t1==null)
            return t2;
        
        if(t2==null)
            return t1;
        
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        return t1;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
        return solve(root1, root2);
        
    }
}
*/


/*
---------------Iterative Solution using Stack---------------------------------
TC - O(n)
TC - O(n) (For Skewed Tree)
*/
/*
public class Solution 
{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) 
    {
        if (t1 == null)
            return t2;
        Stack < TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) 
        {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) 
                continue;
            
            t[0].val += t[1].val;
            if (t[0].left == null) 
                t[0].left = t[1].left;
            else 
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            
            if (t[0].right == null)
                t[0].right = t[1].right;
            else 
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            
        }
        return t1;
    }
}

*/