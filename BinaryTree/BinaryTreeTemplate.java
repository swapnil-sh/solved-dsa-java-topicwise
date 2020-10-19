import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node right;
    Node left;
}

class BinaryTree
{
    public Node createNewNode(int data)
    {
        Node newNode = new Node();
        newNode.data=data;
        newNode.left=null;
        newNode.right=null;

        return newNode;
    }

    public void preOrderTraversalRec(Node root)
    {
        if(root==null)
            return;

        System.out.print(root.data+" ");
        preOrderTraversalRec(root.left);
        preOrderTraversalRec(root.right);
    }

    public void preOrderTraversalIter(Node root)
    {
        if(root==null)
            return;
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        Node temp;
        
        while(st.size()>0)
        {
            temp=st.pop();
            System.out.print(temp.data+" ");
            
            if(temp.right!=null)
                st.push(temp.right);
             
            if(temp.left!=null)
                st.push(temp.left);   
        }
    }

}

public class BinaryTreeTemplate
{
    public static void main(String args[]) 
    {
        BinaryTree a = new BinaryTree();
    
        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        System.out.println("Recursive PreOrder Traversal");
        a.preOrderTraversalRec(root);
        System.out.println("\nIterative PreOrder Traversal");
        a.preOrderTraversalIter(root);
    }
}
