/*112. Path Sum - Leetcode Java Solution*/

/*
-----------------------Recursive Solution (Preorder)-------------------------------

TC-O(n)
SC-O(h)
*/

class CheckPathSum
{
    boolean res=false;
    int sum=0;
    private void solve(TreeNode root, int ts)
    {
        if(root==null)
            return;
        
        sum+=root.val;
        if(root.left==null && root.right==null)
        {
            if(sum==ts)
            {
                res=true;
                return;
            }
            
            sum-=root.val;
            return;
        }
        
        solve(root.left, ts);
        solve(root.right, ts);
        sum-=root.val;
        
        return;    
    }
    
    public boolean hasPathSum(TreeNode root, int ts) 
    {
        if(root==null)
            return false;
        
        res=false;
        solve(root, ts);
        return res;
        
    }
}