/* Count BST nodes that lie in a given range - GeeksforGeeks Java Solutions*/

/*
---------------Recursive Solution-----------

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the BST).
*/

class CountNodesInRange
{
    public static int getCountOfNode(Node root,int l, int h)
    {
        //Your code here
        int res=0;
        if(root==null)
            return 0;
        
        if(root.data>=l && root.data<=h)
            res++;
            
        if(l<root.data)
            res+=getCountOfNode(root.left, l, h);
        
        if(h>root.data)
            res+=getCountOfNode(root.right, l, h);
        
        return res;
    }
}
