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