/*145. Binary Tree Postorder Traversal - Leetcode Iterarive and Recursive Java Solution
https://leetcode.com/problems/binary-tree-postorder-traversal/
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

/*----------------Iterative Using One Stack-------------------------*/

class PostOrderTraversal{
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode currNode = root;
        TreeNode temp;
        
        while(currNode != null || !st.isEmpty()){
            
            if(currNode != null) {
                st.push(currNode);
                currNode = currNode.left;
            }
            else {
                temp = st.peek().right;
                if(temp == null) {
                    temp = st.pop();
                    res.add(temp.val);
                    
                    while(!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        res.add(temp.val);
                    }
                }
                else 
                    currNode = temp;
            }
        }
        
        return res;
    }
}


/*----------------Iterative Using Two Stacks-------------------------*/

/*
class PostOrderTraversal
{
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> res = new LinkedList<Integer>();
        
	if(root==null) 
            return res;
        
	Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        
        s1.push(root);
        TreeNode temp=null;
        
        while(s1.size()>0)
        {
            temp=s1.pop();
            s2.push(temp);
            
            if(temp.left!=null)
                s1.push(temp.left);
            
            if(temp.right!=null)
                s1.push(temp.right);
        }
        
        while(s2.size()>0)
            res.add(s2.pop().val);
    
		return res;
        
    }
}
*/


//--------------------Recursive Solution---------------------------

/*
class Solution
{
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> res = new LinkedList<Integer>();
        
		if(root==null) 
            		return res;
        
		res.addAll(postorderTraversal(root.left));
		res.addAll(postorderTraversal(root.right));
        	res.add(root.val);
        
		return res;
        
    }
}
*/
