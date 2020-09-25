/*Floor in a Sorted Array - GeeksforGeeks Java Binary Search Solution*/


import java.util.*;
import java.lang.*;
import java.io.*;

class FloorInSortedArr 
{
    public static int floor(int a[],int n,int x)
    {
        int st=0,end=n-1,res=-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]==x)
                return mid;
            if(a[mid]>x)
            {
                end=mid-1;
            }
            else
            {
                res=mid;
                st=mid+1;
            }
            
        }
        
        return res;
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
		    for(int i=0;i<n;i++)
		        a[i]=sc.nextInt();
		  
		    System.out.println(floor(a,n,x));
		    t--;
		    
		}
	}
}
