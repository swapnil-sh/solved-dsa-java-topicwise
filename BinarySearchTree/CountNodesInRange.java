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

/*
---------------Iterative Solution using Queue-----------

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the BST).
*/

/*
class CountNodesInRange
{
    public static int getCountOfNode(Node root,int l, int h)
    {
        
        int c=0;
        if(root==null)
            return 0;

        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            Node curr=q.peek();
            q.poll();
            if(curr.data>=l && curr.data<=h)
                c++;
            if(curr.left!=null)
                q.offer(curr.left);
            if(curr.right!=null)
                q.offer(curr.right);
        }
        
        return c;
    }
}
*/