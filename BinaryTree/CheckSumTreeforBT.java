/* Sum Tree - GeeksforGeeks Java Recursive Solution*/


class CheckSumTreeforBT
{
    boolean flag;
    int check(Node root)
    {
        if(root==null)
            return 0;
            
        if(root.left==null && root.right==null)
            return root.data;
            
        int ls=check(root.left);
        int rs=check(root.right);
        
        if(root.data!=(ls+rs))
            flag=false;
        
        int sum=ls+rs+root.data;
        return sum;
    }
	boolean isSumTree(Node node)
	{
             // Your code here
            if(node==null)
                return false;

            flag=true;
            int x=check(node);
            
            return flag;
	}
}
