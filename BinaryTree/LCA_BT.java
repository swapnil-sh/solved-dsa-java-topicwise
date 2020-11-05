/* Lowest Common Ancestor in a Binary Tree - GeeksforGeeks Java Solution*/

//---------------------------Recursive Implementation-------------------------------


/*

Time Complexity: O(N).
Auxiliary Space: O(H).

*/

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class LCA_BT
{

	Node lca(Node root, int n1,int n2)
	{
		// Your code here
		
        	if(root==null)
		    return null;
		if(root.data==n1 || root.data==n2)
		    return root;
		   
		 
		 Node left=lca(root.left,n1,n2);
		 Node right=lca(root.right,n1,n2);
		 
		 if(left!=null && right!=null)
		    return root;
		 
		 else if(left!=null && right==null)
		    return left;
		 
		 else if(left==null && right!=null)
		    return right;
		 
		 else
		    return null;
		
	}
}
