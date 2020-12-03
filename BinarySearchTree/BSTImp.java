/*Binary Search Tree Java Implementation*/

import java.util.*;

class Node
{
    Node left;
    Node right;
    int data;
}

class BST
{
    public Node createNewNode(int val)
    {
        Node newNode=new Node();
        newNode.data=val;
        newNode.left=null;
        newNode.right=null;

        return newNode;
    }

    public Node insert(Node root, int val)
    {
        if(root==null)
            return createNewNode(val);

        if(val>root.data)
           root.right=insert(root.right, val);
        else
            root.left=insert(root.left, val);

        return root;   
    }

    public void display(Node root)
    {
        if(root==null)
            return;
        display(root.left);
        System.out.println(root.data);
        display(root.right);
    }
}

public class BSTImp
{
    public static void main(String args[]) 
    {

        BST a=new BST();
        Node root=null;

        root=a.insert(root, 8);
        root=a.insert(root, 3);
        root=a.insert(root, 6);
        root=a.insert(root, 10);
        root=a.insert(root, 4);
        root=a.insert(root, 7);
        root=a.insert(root, 1);
        root=a.insert(root, 14);
        root=a.insert(root, 13);

        a.display(root);
    }
}