/*Check for BST - GeeksforGeeks Java Solutions*/

/*
---------------------Using Max and Min Value---------------------

TC - O(n^2)
SC - O(n)
*/
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