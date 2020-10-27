/* Check for Balanced Tree - GeeksforGeeks Recursive Solution*/

/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */

class CheckBalBT
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
	// Your code here
	    if(root==null)
	        return true;
	    
	    if(solve(root)==-1)
	        return false;
	   
	   return true;
    }
    
    int solve(Node root)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        
        int lh=solve(root.left);
        int rh=solve(root.right);
        
        if(lh==-1 || rh==-1 || Math.abs(lh-rh)>1)
            return -1;
        
        return Math.max(lh,rh)+1;
    }
}

