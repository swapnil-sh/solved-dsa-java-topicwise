/* Binary Tree to BST - GeeksforGeeks Java Solution*/


/*
-----------------Using Recursion---------------

Time Complexity: O(nlogn).
This is the complexity of the sorting algorithm which we are using after first in-order traversal, rest of the opertions take place in linear time.

Auxiliary Space: O(n).
Use of data structure ‘array’ to store in-order traversal.

*/

/*
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */
class Convert_BT_to_BST
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST

    int i=0;
    void inorderTrav(Node root, ArrayList<Integer> res)
    {
        if(root==null)
            return;
        
        inorderTrav(root.left, res);
        res.add(root.data);
        inorderTrav(root.right, res);
        
    }
    
    void convertToBST(Node root, ArrayList<Integer> a)
    {
        if(root==null || i>=a.size())
            return;
        
        convertToBST(root.left, a);
        root.data=a.get(i++);
        convertToBST(root.right, a);
        
        return;
    }
    
    Node binaryTreeToBST(Node root)
    {
       // Your code here
           
        if(root==null)
            return null;
            
        ArrayList<Integer> a=new ArrayList<>();
        
        inorderTrav(root, a);
        Collections.sort(a);
        
        convertToBST(root, a);
        
        return root;
    }
}