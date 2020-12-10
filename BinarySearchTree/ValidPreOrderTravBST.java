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