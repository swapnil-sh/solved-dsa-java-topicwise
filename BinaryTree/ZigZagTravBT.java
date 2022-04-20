/* ZigZag Tree Traversal - Leetcode and GeeksforGeeks Java Solutions
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/

//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
// Print the zig zag traversal of tree.


class ZigZagTravBT
{
    // return an array containing the zig zag level order traversal of the given tree
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> res=new ArrayList<>();
	    if(root==null)
	        return res;
	   
	    Stack<Node> s1=new Stack<>();
	    Stack<Node> s2=new Stack<>();
	    
	    s1.push(root);
	    while(s1.size()>0 || s2.size()>0)
	    {
	        while(!s1.isEmpty())
	        {
	            Node temp=s1.pop();
	            res.add(temp.data);
	            if(temp.left!=null)
	                s2.push(temp.left);
	                
	            if(temp.right!=null)
	                s2.push(temp.right);
	          
	        }
	        
	        while(!s2.isEmpty())
	        {
	            Node temp=s2.pop();
	            res.add(temp.data);
	            if(temp.right!=null)
	                s1.push(temp.right);
	                
	            if(temp.left!=null)
	                s1.push(temp.left);
	        }
	    }
	   
	   return res;
	}
}

//------------------------------Leetcode Iterative Solution----------------------------------------

/*
class Solution 
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        
        s1.push(root);
        TreeNode temp;
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            List<Integer> subL=new ArrayList<>();
            while(!s1.isEmpty())
            {
                temp=s1.pop();
                subL.add(temp.val);
                if(temp.left!=null)
                    s2.push(temp.left);
                
                if(temp.right!=null)
                    s2.push(temp.right);
            }
            
            if(subL.size()>0)
                res.add(subL);
       
            subL=new ArrayList();            
            while(!s2.isEmpty())
            {
                temp=s2.pop();
                subL.add(temp.val);
                if(temp.right!=null)
                    s1.push(temp.right);
                
                if(temp.left!=null)
                    s1.push(temp.left);
            }
            
            if(subL.size()>0)
                res.add(subL);
            
            subL=new ArrayList();
        }
        
        return res;
    }
}
*/

/*-----------------------------------Leetcode Recursive Solution-----------------------------------------

TC - O(n^2) ----- due to add and remove operation of array lists
SC - O(n)
*/


/*
class Solution {
    
    private void util(TreeNode root, List<List<Integer>> res, int level) {
        
        if(root == null) {
            return;
        }
        
        boolean leftToRight = level%2==0;
        List<Integer> temp;
        
        if(res.size() == level)
            temp = new ArrayList<>();
        else
            temp = res.remove(level) ;
        
        
        if(leftToRight) {
            temp.add(root.val);
        }
        else
            temp.add(0, root.val);
        
        
        res.add(level, temp);
        util(root.left, res, level+1);
        util(root.right, res, level+1);   
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        
        util(root, res, 0);
        return res;
    }
}
*/