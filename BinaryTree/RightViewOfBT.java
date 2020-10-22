/*199. Binary Tree Right Side View - Leetcode Iterative snd Recursive Java Solution*/


//-------------------------------------Iterative Solution using Queue(LevOrdTra)-------------------------------

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
class RightViewOfBT 
{
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
    
        int level=0;
        while(q.size()>0)
        {
            level=q.size();
            
            ArrayList<TreeNode> temp=new ArrayList<>(); 
            for(int i=0;i<level;i++)
            {
                if(q.peek().left!=null)
                    q.offer(q.peek().left);
                
                if(q.peek().right!=null)
                    q.offer(q.peek().right);
                
                temp.add(q.poll());
            }
            
            res.add(temp.get(temp.size()-1).val);
        }
        
        return res;
    }
}



//------------------------------------Recursive Solution(More Efficient)---------------------------------------

/*
class Solution 
{
    int maxL=0;
    public void solve(TreeNode root,int level,List<Integer> res)
    {
        if(root==null)
            return;
        
        if(level>=maxL)
        {
            res.add(root.val);
            maxL++;
        }
        
        solve(root.right,level+1,res);
        solve(root.left,level+1,res);
    }
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        
        solve(root,0,res);
        return res;
    }
}

*/