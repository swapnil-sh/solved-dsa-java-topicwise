/* Binary Tree to DLL - GeeksforGeeks Inorder Traversal Java Solution*/

//----------------Recursive Approach - 1---------------------------------

class BT2DLL
{
    Node prev=null;
    Node head;
    Node bToDLL(Node root)
    {
	    //  Your code here
	    if(root==null)
	        return null;
	   
	    bToDLL(root.left);
	    if(prev==null)
	        head=root;
	       
	    else
	    {
	        root.left=prev;
	        prev.right=root;
	    }
	    
	    prev=root;
	    bToDLL(root.right);

	   return head; 
    }
}