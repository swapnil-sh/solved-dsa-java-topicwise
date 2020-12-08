/* Lowest Common Ancestor in a BST - GeeksforGeeks Java Solutions*/


/*
--------------Recursive Solution-------------------

Time Complexity: O(Height of the BST).
Auxiliary Space: O(Height of the BST).
*/


class LCAInBST
{   
	Node LCA(Node root, int n1, int n2)
	{
        
            if(root==null)
                return null;
            
            if(root.data==n1 || root.data==n2)
                return root;
        
            Node leftLca=null,rightLca=null;
            if(n1>root.data && n2>root.data)
                rightLca=LCA(root.right, n1, n2);
        
            else if(n1<root.data && n2<root.data)
                leftLca=LCA(root.left, n1, n2);
            
            else
            {
                leftLca=LCA(root.left, n1, n2);
                rightLca=LCA(root.right, n1, n2);
            
            }
        
            if(leftLca!=null && rightLca!=null)
                return root;
            else
                return leftLca==null?rightLca:leftLca;
    
        }
    
}

/*
--------------Iterative Solution-------------------

Time Complexity: O(Height of the BST).
Auxiliary Space: O(1).
*/

/*
class BST
{   
   
	Node LCA(Node root, int n1, int n2)
	{
        
        while (root != null)  
        {  
            // If both n1 and n2 are smaller  
            // than root, then LCA lies in left  
            if(root.data > n1 && root.data > n2)  
                root = root.left;  
      
            // If both n1 and n2 are greater  
            // than root, then LCA lies in right  
            else if(root.data < n1 &&  root.data < n2)  
                root = root.right;  
      
            else 
                break;  
        }  
        
        return root;   
    }
    
}
*/