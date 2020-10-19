/*107. Binary Tree Level Order Traversal II - Leetcode Java Recursive,BFS,DFS Solution */

//-------------------------Reverse Level order Traversal (Using BFS-Queue)----------------------

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

class RevLevelOrderTrav 
{
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        
        if(root == null) 
            return res;
        
        TreeNode temp=null;
        q.offer(root);
        int levelNo=0;
        int i;
        
        while(q.size()>0)
        {
            levelNo=q.size();
            List<Integer> subList = new LinkedList<Integer>();
            
            for(i=0;i<levelNo;i++)
            {
                temp=q.peek();
                if(temp.left!=null)
                    q.offer(temp.left);
                
                if(temp.right!=null)
                    q.offer(temp.right);
                
                subList.add(q.poll().val);
            }
            
            res.add(0,subList);
        }
        
        return res;
        
    }
}


//-------------------------Reverse Level order Traversal (Using DFS-Recursion)----------------------


/*
public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
            levelMaker(wrapList, root, 0);
            return wrapList;
        }
        
        public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
            if(root == null) return;
            if(level >= list.size()) {
                list.add(0, new LinkedList<Integer>());
            }
            levelMaker(list, root.left, level+1);
            levelMaker(list, root.right, level+1);
            list.get(list.size()-level-1).add(root.val);
      
	}
}


//-------------------------Reverse Level order Traversal (Using Recursion)----------------------

/*


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
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root==null) 
            return ans;
    
    
        int height = getHeight(root);
    
        for(int i=height;i>=0;i--) 
        {
            ans.add(printAtGivenLevel(root,i+1));
        }
        
        return ans;
        
    }
}

*/
