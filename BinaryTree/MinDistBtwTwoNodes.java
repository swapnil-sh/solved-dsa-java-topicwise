/* Min distance between two given nodes of a Binary Tree  - GeeksforGeeks Java Solution */

class MinDistBtwTwoNodes
{
	Node lca_bt(Node root, int n1,int n2)
	{
		// Your code here
		
        	if(root==null)
		    return null;
		if(root.data==n1 || root.data==n2)
		    return root;
		   
		 
		 Node left=lca_bt(root.left,n1,n2);
		 Node right=lca_bt(root.right,n1,n2);
		 
		 if(left!=null && right!=null)
		    return root;
		 
		 else if(left!=null && right==null)
		    return left;
		 
		 else if(left==null && right!=null)
		    return right;
		 
		 else
		    return null;
		
	}
	
	int findLevel(Node root, int a, int level)
    	{
        	if (root == null)
            		return -1;
            
        	if (root.data == a)
            		return level;
            
        	int left = findLevel(root.left, a, level + 1);
        	if (left == -1)
            		return findLevel(root.right, a, level + 1);
            
        	return left;
    	}
	
	int dist(Node lca,int a,int b)
	{
	    
	    int d1=findLevel(lca,a,0);
	    int d2=findLevel(lca,b,0);
	    
	    return d1+d2;
	}

    	int findDist(Node root, int a, int b)
    	{
        
        	if(root==null)
			return 0;
        
        	// finding the lowest common ancestor first
        	Node lca=lca_bt(root,a,b);
        	// finding the minimum distnace between given nodes
        	int minDist=dist(lca,a,b);
        
        	return minDist;
    	}
}