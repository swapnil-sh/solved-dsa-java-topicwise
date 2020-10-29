// Transform to Sum Tree - GeeksforGeeks Recursive Java Solution

class BT2SumTree
{
    int transform(Node root)
    {
        if(root==null)
            return 0;
        
        int ls=transform(root.left);
        int rs=transform(root.right);
        
	//first storing the value for calculating sum for upper nodes
        int sum=ls+rs+root.data;
        
        root.data=ls+rs;
        
        return sum;
    }
    public void toSumTree(Node root)
    {
         //add code here.
        if(root==null)
            return;
        
        int s=transform(root);

        
    }
}