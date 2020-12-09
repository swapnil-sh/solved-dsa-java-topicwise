/* Find the Closest Element in BST  - GeeksforGeeks Java Solutions*/

/*
-----------------Using Recursion---------------------

TC - O(n) (for Skewed Trees) else O(logn)
SC - O(h)
*/

class FindClosestEleBST
{
    // Return the minimum absolute difference between any tree node and the integer K
    static int solve(Node root, int k)
    {
        if(root==null)
            return Integer.MAX_VALUE;
        
        if(root.data>=k)
            return Math.min(Math.abs(k-root.data), solve(root.left, k));
        else
           return Math.min(Math.abs(root.data-k), solve(root.right, k)); 
    }
    static int maxDiff(Node  root, int K) 
    { 
        // Write your code here
        if(root==null)
            return 0;
        
        return solve(root, K);
        
    } 
}


/*
-----------------Using Inorder Traversal-------------------------

1. Normal Process
TC - O(n+n)=O(n)
SC - O(n)

2.Binary Search

TC - O(n+logn)=O(n)
SC - O(n)

*/


/*
------------------Using Morris Traversal (Read Later)-----------------

TC - O(n)
SC - O(1)
*/

/*
// Function to find the Node closest to the  
// given key in BST using Morris Traversal 
static Node closestNodeUsingMorrisTraversal(Node root,  
                                        int key) 
{ 
    int diff = Integer.MAX_VALUE; 
    Node curr = root; 
    Node closest = null; 
  
    while (curr != null)  
    { 
        if (curr.left == null)  
        { 
  
            // updating diff if the current diff is 
            // smaller than prev difference 
            if (diff > Math.abs(curr.data - key))  
            { 
                diff = Math.abs(curr.data - key); 
                closest = curr; 
            } 
  
            curr = curr.right; 
        } 
  
        else
        { 
  
            // finding the inorder predecessor 
            Node pre = curr.left; 
            while (pre.right != null && 
                pre.right != curr) 
                pre = pre.right; 
  
            if (pre.right == null)  
            { 
                pre.right = curr; 
                curr = curr.left; 
            } 
  
            // threaded link between curr and 
            // its predecessor already exists 
            else
            { 
                pre.right = null; 
  
                // if a closer Node found, then update  
                // the diff and set closest to current 
                if (diff > Math.abs(curr.data - key))  
                { 
                    diff = Math.abs(curr.data - key); 
                    closest = curr; 
                } 
  
                // moving to the right child 
                curr = curr.right; 
            } 
        } 
    } 
  
    return closest; 
} 
*/