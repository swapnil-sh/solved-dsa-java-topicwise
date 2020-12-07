/*BST to tree with sum of smaller keys - GeeksforGeeks Java Solution*/

class BST2SumOfSmKeys
{
    static int sum=0
    public int solve(Node root)
    {
        if(root==null)
            return;
        
        solve(root.left);
        sum+=root.data;
        root.data=sum;
        solve(root.right);

        return;
    }
}