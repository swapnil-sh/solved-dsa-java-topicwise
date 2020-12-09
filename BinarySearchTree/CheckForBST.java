/*Check for BST - GeeksforGeeks Java Solutions*/

/*
---------------------Using Range check(min and max values)---------------------

TC - O(n)
SC - O(n)
*/

class CheckForBST
{
    // return true if the given tree is a BST, else return false
    
    boolean solve(Node root, int min, int max)
    {
        if(root==null)
            return true;
        
        if(root.data<min || root.data>max)
            return false;
        
        return (solve(root.left, min, root.data-1) && solve(root.right, root.data+1, max));
    }
    boolean isBST(Node root)
    {
            // code here.
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}


/*
---------------------Using Max and Min Value---------------------

TC - O(n^2)
SC - O(n)
*/
/*
class CheckForBST
{
    // return true if the given tree is a BST, else return false
    
    int maxValue(Node root)
    {
        if(root==null)
            return 0;
            
        while(root.right!=null)
            root=root.right;
        
        return root.data;
    }
    
    int minValue(Node root)
    {
        if(root==null)
            return 0;
            
        while(root.left!=null)
            root=root.left;
        
        return root.data;
    }
    boolean isBST(Node root)
    {
            // code here.
        if(root==null)  
         return true;  
          
      /* false if the max of the left is > than us */
        if(root.left!=null && maxValue(root.left)>=root.data)  
            return false;  
          
      /* false if the min of the right is <= than us */
        if(root.right!=null && minValue(root.right)<=root.data)  
            return false;  
        
      /* false if, recursively, the left or right is not a BST */
        if(!isBST(root.left) || !isBST(root.right))  
            return false;  
          
        return true;
        
    }
}

*/