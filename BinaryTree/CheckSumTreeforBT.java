/* Sum Tree - GeeksforGeeks Java Recursive Solutions*/



//--------------------------Recursive Solution- Time Complexity: O(n^2) in worst case. Worst case occurs for a skewed tree. ----------------------

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



//----------------------Recurisve Efficient Solution GFG O(n)---------------------------------

/*
The Method 1 uses sum() to get the sum of nodes in left and right subtrees. The method 2 uses following rules to get the sum directly.
1) If the node is a leaf node then sum of subtree rooted with this node is equal to value of this node.
2) If the node is not a leaf node then sum of subtree rooted with this node is twice the value of this node (Assuming that the tree rooted with this node is SumTree).
*/
/*

class BinaryTree
{
    Node root; 
   
    /* Utility function to check if the given node is leaf or not */
    int isLeaf(Node node)  
    { 
        if (node == null) 
            return 0; 
        if (node.left == null && node.right == null) 
            return 1; 
        return 0; 
    } 
   
    /* returns 1 if SumTree property holds for the given 
       tree */
    int isSumTree(Node node)  
    { 
        int ls; // for sum of nodes in left subtree 
        int rs; // for sum of nodes in right subtree 
   
        /* If node is NULL or it's a leaf node then 
         return true */
        if (node == null || isLeaf(node) == 1) 
            return 1; 
   
        if (isSumTree(node.left) != 0 && isSumTree(node.right) != 0)  
        { 
            // Get the sum of nodes in left subtree 
            if (node.left == null) 
                ls = 0; 
            else if (isLeaf(node.left) != 0) 
                ls = node.left.data; 
            else
                ls = 2 * (node.left.data); 
   
            // Get the sum of nodes in right subtree 
            if (node.right == null) 
                rs = 0; 
            else if (isLeaf(node.right) != 0) 
                rs = node.right.data; 
            else
                rs = 2 * (node.right.data); 
               
            /* If root's data is equal to sum of nodes in left 
               and right subtrees then return 1 else return 0*/
            if ((node.data == rs + ls)) 
                return 1; 
            else
                return 0; 
        } 
   
        return 0; 
    } 



*/
