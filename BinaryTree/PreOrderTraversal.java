/*144. Binary Tree Preorder Traversal - Leetcode Java both Iterative and recursive Solution*/

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
class PreOrderTraversal
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> res=new ArrayList<Integer>();
        
        if(root==null)
            return res;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode temp;
        
        while(st.size()>0)
        {
            temp=st.pop();
            res.add(temp.val);
            
            if(temp.right!=null)
                st.push(temp.right);
             
            if(temp.left!=null)
                st.push(temp.left);   
        }
    
        return res;
    }
}

//--------------------Recursive Solution----------------------------

/*
class Solution 
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
		List<Integer> res = new LinkedList<Integer>();
        
		if(root==null) 
            		return res;
        
		res.add(root.val);
		res.addAll(preorderTraversal(root.left));
		res.addAll(preorderTraversal(root.right));
        
		return res;
	}
}

*/
