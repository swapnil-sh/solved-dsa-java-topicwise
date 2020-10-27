/* ZigZag Tree Traversal - GeeksforGeeks Java Solution using two Stacks*/

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

//-----------------------------------Leetcode Recursive Solution-----------------------------------------
/*
class Solution 
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> res=new ArrayList<>();
        solve(root, 0, res);
        
        return res;
    }
    
    private void solve(TreeNode root, int levelFromRoot, List<List<Integer>> res)
    {
        if(root!=null)
        {
            boolean leftToRight=levelFromRoot%2==0;
            if(res.size()==levelFromRoot)
                res.add(new ArrayList<>());
            
            List<Integer> resAtLevel=res.remove(levelFromRoot);
            
            if(leftToRight)
                resAtLevel.add(root.val);
            else
                resAtLevel.add(0,root.val);
            
            res.add(levelFromRoot,resAtLevel);
            solve(root.left,levelFromRoot+1,res);
            solve(root.right,levelFromRoot+1,res);
        }
    }
}
*/