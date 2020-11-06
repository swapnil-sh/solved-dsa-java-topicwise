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


//-------------------Reverse Recursive Approach---------------------
/*
class GfG
{
    Node head;
    Node bToDLL(Node root) 
    { 
        // Base cases 
        if (root == null) 
            return null; 
  
        // Recursively convert right subtree 
        bToDLL(root.right); 
  
        // insert root into DLL 
        root.right = head; 
  
        // Change left pointer of previous head 
        if (head != null) 
            head.left = root; 
  
        // Change head of Doubly linked list 
        head = root; 
  
        // Recursively convert left subtree 
        bToDLL(root.left); 
        
        return head;
    } 
}
*/


//------------------------Recursive Apporach three fixing left and right pointers seperately---------------------------------
/*
class GfG
{
    static Node prev;
    void setLeftPtr(Node root)
    {
        if(root==null)
            return;
        
        setLeftPtr(root.left);
        root.left=prev;
        prev=root;
        setLeftPtr(root.right);
    }
    
    Node setRightPtr(Node root)
    {
        while(root.right!=null)
            root=root.right;
        
        while(root!=null && root.left != null)
        {
            Node left=root.left;
            left.right=root;
            root=left;
        }
        
        return root;
    }
    Node bToDLL(Node root) 
    { 
        // Base cases 
        if (root == null) 
            return null; 
        
        prev = null; 
  
        setLeftPtr(root); 
        return setRightPtr(root);
    } 
}
*/