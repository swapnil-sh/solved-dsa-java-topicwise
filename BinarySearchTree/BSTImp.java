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

    public Node getSuccessor(Node node)
    {
        if(node==null)
            return null;
        
        Node temp=node.right;
        while(temp.left!=null)
            temp=temp.left;
        
        return temp;
        
    }

    public Node delete(Node root, int val)
    {
        if(root==null)
            return null;

        if(val<root.data)
            root.left=delete(root.left, val);
        else if(val>root.data)
            root.right=delete(root.right, val);
        else
        {
            if(root.left==null || root.right==null)
            {
                Node temp=null;
                temp=(root.left==null)?root.right:root.left;

                if(temp==null)
                    return null;
                else
                    return temp;
            }
            else
            {
                Node successor=getSuccessor(root);
                root.data=successor.data;
                root.right=delete(root.right, successor.data);
            }
        }

        return root;
    }

    
    public void display(Node root)
    {
        if(root==null)
            return;
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
}

public class Main
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
        System.out.println();
        a.delete(root, 3);
        a.display(root);
    }
}