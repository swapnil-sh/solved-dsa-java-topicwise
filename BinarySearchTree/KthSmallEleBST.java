/* k-th smallest element in BST - GeeksforGeeks Java Solutions*/

/*
------------Inorder Solution (Recursive)--------------------

Time Complexity: O(N).
Auxiliary Space: O(h).

*/

class KthSmallEleBST
{
    // Return the Kth smallest element in the given BST 
    public void solve(Node root, int a[])
    {
        if(a[1]<=0 || root==null)
            return;
            
        solve(root.left, a
        a[1]--;
        if(a[1]==0)
        {
            a[0]=root.data;
            return;
        }
        solve(root.right, a);
    }
    
    public int KthSmallestElement(Node root, int K) 
    {
        // Write your code here
        if(root==null)
            return 0;
        
        int a[]=new int[2];
        a[0]=0;
        a[1]=K;
        
        solve(root, a);
        
        return a[0]==0?-1:a[0];
    }
}


/*
------------Method 2: Augmented  Tree Data Structure Solution (Recursive)--------------------

Time Complexity: O(h).
Auxiliary Space: O(h).

*/

/*
   public static Node kthSmallest(Node root, int k)
    {
        // base case
        if (root == null)
            return null;
     
        int count = root.lCount + 1;
        if (count == k)
            return root;
     
        if (count > k)
            return kthSmallest(root.left, k);
     
        // else search in right subtree
        return kthSmallest(root.right, k - count);
    }
*/

/*
------------Method 3: Using Morris INorder Traversal--------------------

Time Complexity: O(n).
Auxiliary Space: O(1).

*/

/*
class Solution
{
    // Return the Kth smallest element in the given BST 
    
    private int KSmallestUsingMorris(Node root, int k)  
    {  
    // Count to iterate over elements till we  
    // get the kth smallest number  
        int count = 0;  
      
        int ksmall = -1; // store the Kth smallest  
        Node curr = root; // to store the current node  
      
        while (curr != null)  
        {  
            // Like Morris traversal if current does  
            // not have left child rather than printing  
            // as we did in inorder, we will just  
            // increment the count as the number will  
            // be in an increasing order  
            if (curr.left == null)  
            {  
                count++;  
      
                // if count is equal to K then we found the  
                // kth smallest, so store it in ksmall  
                if (count==k)  
                    ksmall = curr.data;  
      
                // go to current's right child  
                curr = curr.right;  
            }  
            else
            {  
                // we create links to Inorder Successor and  
                // count using these links  
                Node pre = curr.left;  
                while (pre.right != null && pre.right != curr)  
                    pre = pre.right;  
      
                // building links  
                if (pre.right== null)  
                {  
                    //link made to Inorder Successor  
                    pre.right = curr;  
                    curr = curr.left;  
                }  
      
                // While breaking the links in so made temporary  
                // threaded tree we will check for the K smallest  
                // condition  
                else
                {  
                    // Revert the changes made in if part (break link  
                    // from the Inorder Successor)  
                    pre.right = null;  
      
                    count++;  
      
                    // If count is equal to K then we found  
                    // the kth smallest and so store it in ksmall  
                    if (count==k)  
                        ksmall = curr.data;  
      
                    curr = curr.right;  
                }  
            }  
        }  
        return ksmall; //return the found value  
    }  
    
    public int KthSmallestElement(Node root, int K) 
    {
        // Write your code here
        if(root==null)
            return 0;
    
        return KSmallestUsingMorris(root, K);
    }
}

*/




