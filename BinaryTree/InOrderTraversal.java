/*94. Binary Tree Inorder Traversal - Leetcode Iterative and Recursive Solution*/


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

class InOrderTraversal
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> res = new LinkedList<Integer>();
        
		if(root==null) 
            return res;
        
        Stack<TreeNode> st=new Stack<>();
        
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
        
        TreeNode temp=null;
        while(st.size()>0)
        {
            temp=st.pop();
            res.add(temp.val);
            
            if(temp.right!=null)
            {
                TreeNode p=temp.right;
                while(p!=null)
                {
                    st.push(p);
                    p=p.left;
                }
            }
        }
        return res;
    }
}


//--------------------Recursive Solution----------------------------

/*
class Solution
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> res = new LinkedList<Integer>();
        
		if(root==null) 
            return res;
        
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));

        return res;
    }
}

/*
