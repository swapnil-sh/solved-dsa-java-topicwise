/*First and last occurrences of X - GeeksforGeeks Binary Search Java Solution */

import java.util.*;
import java.lang.*;
import java.io.*;

class FirstLastOccur 
{
    public static int findFirstOccur(int a[],int st,int end,int x)
    {
        int pos=-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]==x)
            {
                pos=mid;
                end=mid-1;
            }
            else if(a[mid]>x)
                end=mid-1;
            else
                st=mid+1;
            
        }
        
        return pos;
        
    }

    public static int findLastOccur(int a[],int st,int end,int x)
    {
        int pos=-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]==x)
            {
                pos=mid;
                st=mid+1;
            }
            else if(a[mid]>x)
                end=mid-1;
            else
                st=mid+1;
            
        }
        
        return pos;  
        
    }    
    
	public static void main (String[] args)throws Exception
	{
		//code
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		while(t!=0)
		{
		    int n,x;
		    n=sc.nextInt();
		    x=sc.nextInt();
		    int a[]=new int[n];
		    int i;
		    for(i=0;i<n;i++)
		        a[i]=sc.nextInt();
		        
		    if(n==1)
		        System.out.println(a[0]);
		    else
		    {
		        int ans1=findFirstOccur(a,0,n-1,x);
		        int ans2=findLastOccur(a,0,n-1,x);
		        if(ans1==-1 && ans2==-1)
		            System.out.println(-1); 
		        else
		            System.out.println(ans1+" "+ans2);   
		    }
		    t--;
		}
	}
}
