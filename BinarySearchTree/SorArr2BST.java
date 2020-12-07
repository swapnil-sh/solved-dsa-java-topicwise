/* Sorted Array to BST  - GeeksforGeeks Java Solutions*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node 
{ 
      
    int data; 
    Node left, right; 
      
    Node(int d) 
    { 
        data = d; 
        left = right = null; 
    } 
} 

class SorArr2BST
{
    static Node root; 
  
    /* A function that constructs Balanced Binary Search Tree  
     from a sorted array */
    Node sortedArrayToBST(int arr[], int start, int end) 
    { 
  
        /* Base Case */
        if (start > end) 
            return null; 
        
  
        /* Get the middle element and make it root */
        int mid = (start + end) / 2; 
        Node node = new Node(arr[mid]); 
  
        /* Recursively construct the left subtree and make it 
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1); 
  
        /* Recursively construct the right subtree and make it 
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end); 
          
        return node; 
    } 
  
    /* A utility function to print preorder traversal of BST */
    void preOrder(Node node) 
    { 
        if (node == null) 
            return; 
        
        System.out.print(node.data + " "); 
        preOrder(node.left); 
        preOrder(node.right); 
    } 
	public static void main (String[] args)throws Exception
	{
	    
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		while(t--!=0)
		{
		    BinaryTree tree = new BinaryTree(); 
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    int i;
		    for(i=0;i<n;i++)
		        a[i]=sc.nextInt();
		    
		    root = tree.sortedArrayToBST(a, 0, n-1); 
            tree.preOrder(root);
            System.out.println(); 
		}
	}
}

/*
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
    static void arrayToBST(int a[],int l, int r)
    {
        if(l>r)
            return;
            
        int mid=l+(r-l)/2;
        System.out.print(a[mid]+" ");
        arrayToBST(a, l, mid-1);
        arrayToBST(a, mid+1, r);
        
        return;
    }
	public static void main (String[] args)throws Exception
	{
	    
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		while(t--!=0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    int i;
		    for(i=0;i<n;i++)
		        a[i]=sc.nextInt();
		    
		    arrayToBST(a, 0, n-1);
		    System.out.println();
		}
	}
}
*/