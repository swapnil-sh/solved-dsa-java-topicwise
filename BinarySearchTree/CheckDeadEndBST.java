/* Check whether BST contains Dead End - GeeksforGeeks Java SOlutions*/

/*
-----------------------Using Min and Max Range for each node-----------------------

TC - O(n)
SC - O(n) (Stack Space)
*/

class CheckDeadEndBST
{
    static boolean flag=false;
    public static void solve(Node root, int min ,int max)
    {
        if(root==null)
            return;
        
        if(flag)
            return;
            
        if(root.left==null && root.right==null)
        {
            if(min>=max || max==1)
            {
                flag=true;
                return;
            }
        }
            
        solve(root.left, min, root.data-1);
        solve(root.right, root.data+1, max);
    }
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        flag=false;
        solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        return flag;
        
    }
}