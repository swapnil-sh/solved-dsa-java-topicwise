/* Preorder Traversal and BST - Geeks forGeeks Java SOlutions*/

/*
-------Using Stack - (NGE Approach)-------------

TC - O(n)
SC - O(n)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class ValidPreOrderTravBST
{
    private static int checkPreorder(int a[], int n)
    {
        if(n==0)
            return 0;
        
        Stack<Integer> st=new Stack<>();
        int i,parent=0;
        
        for(i=0;i<n;i++)
        {
            while(!st.isEmpty() && st.peek()<a[i])
                parent=st.pop();
            
            if(a[i]<parent)
                return 0;
            
            st.push(a[i]);
        }   
        
        return 1;
    }
	public static void main (String[] args)throws Exception
	{
	    
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t--!=0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    int i;
		    
		    for(i=0;i<n;i++)
		        a[i]=sc.nextInt();
		       
		    System.out.println(checkPreorder(a, n));
		}
	}
}


/*

----------------Brute FOrce Approach---------------------

A Simple Solution is to do following for every node pre[i] starting from first one.

1) Find the first greater value on right side of current node. 
   Let the index of this node be j. Return true if following 
   conditions hold. Else return false
    (i)  All values after the above found greater value are 
         greater than current node.
    (ii) Recursive calls for the subarrays pre[i+1..j-1] and 
         pre[j+1..n-1] also return true. 

Time Complexity of the above solution is O(n2)
*/