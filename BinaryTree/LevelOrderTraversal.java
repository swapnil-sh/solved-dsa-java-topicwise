/*102. Binary Tree Level Order Traversal - Leetcode BFS,DFS and Simple Recursion Solution*/


//----------------------Level order Traversal(BFS-Queue)--------------------------------



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

class LevelOrderTraversal
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root==null) 
            return res;
    
    
       Queue<TreeNode> q = new LinkedList<TreeNode>();;
        
        q.add(root);
        TreeNode top=null;
        int i;
        while(q.size()>0)
        {
            int levelSize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            
	    for(i=0;i<levelSize;i++)
            {
                
			TreeNode currNode = q.poll();
			currLevel.add(currNode.val);
                
			if (currNode.left != null)
				q.add(currNode.left);
                
			if (currNode.right != null)
				q.add(currNode.right);
		}
            
			res.add(currLevel);
           
        }
        
        return res;
    }
}



//----------------------Level order Traversal(Using DFS Recursion)--------------------------------


/*
public List<List<Integer>> levelOrder(TreeNode root)
{
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		levelOrderHelper(res, root, 0);
		return res;
}
	
public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int level) 
{
		if (root == null)
			return;
		List<Integer> curr;
		if (level >= res.size()) 
		{
			curr = new ArrayList<>();
			curr.add(root.val);
			res.add(curr);
		} 
		else 
		{
			curr = res.get(level); 
			curr.add(root.val); 
			
		}
		levelOrderHelper(res, root.left, level + 1);
		levelOrderHelper(res, root.right, level + 1);
	}







//----------------------Level order Traversal(Using Recursion)--------------------------------


class Solution
{
    
    public int getHeight(TreeNode root)
    {
        if(root==null)
            return -1;
        
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }
    
    public List<Integer> printAtGivenLevel(TreeNode node, int level)
    {
        List<Integer> res = new ArrayList<Integer>();
        if(node == null) 
          return res;

        if(level == 1) 
        {
          res.add(node.val);
          return res;
        }

        res.addAll(printAtGivenLevel(node.left, level - 1));
        res.addAll(printAtGivenLevel(node.right, level - 1));
        
        return res;
     }

    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root==null) 
            return ans;
    
    
        int height = getHeight(root);
    
        for(int i=0;i<=height;i++) 
        {
            ans.add(printAtGivenLevel(root,i+1));
        }
        
        return ans;
    }
}
*/

