// Tower of Hanoi - Recursion GeeksforGeeks java

import java.util.*;
import java.lang.*;
import java.io.*;

class TowerOfHanoi
{
    public static void TOH(int s,int d,int h,int n,int arr[])
    {
        arr[0]++;
        if(n==1)
        {
            System.out.println("move disk "+n+" from rod "+s+" to rod "+d);
            return;
        }
            
        TOH(s,h,d,n-1,arr);
        System.out.println("move disk "+n+" from rod "+s+" to rod "+d);
        TOH(h,d,s,n-1,arr);
           
       
    }
	public static void main (String[] args)throws Exception
	{
		//code
		Scanner sc = new Scanner(System.in);
		int t;
		t=sc.nextInt();
		while(t!=0)
		{
		    int n;
		    n=sc.nextInt();

		    int s=1;
		    int h=2;
		    int d=3;
		    int cnt=0;
		    int[] arr = {cnt}; 
		    TOH(s,d,h,n,arr);
		    System.out.println(arr[0]);
		    t--;
		}
		
	}
}
