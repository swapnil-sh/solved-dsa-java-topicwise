/* Largest BST - GeeksforGeeks Java Solutions*/


/*
-------------------------Post Order-------------------

TC - O(n)
SC - O(1)
*/

class LargestBSTinBT
{
    // Return the size of the largest sub-tree which is also a BST
    static class pair 
    {
        boolean ans;
        int size , max , min , lsize;
        pair(boolean ans , int max , int min , int size)
        {
            this.ans = ans;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    
    static pair result(Node root) 
    {
        pair p;
        if(root == null)
            p=new pair(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        else 
        {
            pair l=result(root.left);
            pair r=result(root.right);
            
            if(l.ans && r.ans && (root.data > l.max && root.data < r.min))
                p=new pair(true, Math.max(r.max, root.data), Math.min(l.min, root.data), l.size+r.size+1);
            else
                p=new pair(false, Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(l.size, r.size));
        }
        return p;
    }
            
    static int largestBst(Node root)
    {
        // Write your code here
        if(root==null)
            return 0;
        
        pair p = result(root);
        return p.size;
    }
}


/*
----------------2 Brute Force Solutions------------------

TC - O(n^2)
SC - O(n)
*/
/*
class Solution
{
    
    // Return the size of the largest sub-tree which is also a BST
    static int ans;
    static boolean isBST(Node root, int min, int max)
    {
        if(root==null)
            return true;
        
        if(root.data<min || root.data>max)
            return false;
        
        return (isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max));
    }
    
    static int trav(Node root)
    {
        if(root==null)
            return 0;
        
        int ls=trav(root.left);
        int rs=trav(root.right);
        
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            ans=Math.max(ans, ls+rs+1);
            
        return ls+rs+1;
    }
    static int largestBst(Node root)
    {
        // Write your code here
        if(root==null)
            return 0;
        
        ans=0;
        int x=trav(root);
        return ans;
    }
    
}

*/
/*
class Solution
{
    
    // Return the size of the largest sub-tree which is also a BST
    static int ans;
    static boolean isBST(Node root, int min, int max)
    {
        if(root==null)
            return true;
        
        if(root.data<min || root.data>max)
            return false;
        
        return (isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max));
    }
    
    static int size(Node root)
    {
        if(root == null)
        return 0;
        
        return(1 + size(root.left) + size(root.right));
    }
    static int largestBst(Node root)
    {
        // Write your code here
        if(root==null)
            return 0;
        
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            return size(root);
        else
            return Math.max(largestBst(root.left), largestBst(root.right));
    }
    
}
*/