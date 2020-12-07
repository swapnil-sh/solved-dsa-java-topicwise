/* k-th smallest element in BST - GeeksforGeeks Java Solutions*/

/*
------------Inroder SOlution (Recursive)--------------------

Time Complexity: O(N).
Auxiliary Space: O(1).

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

