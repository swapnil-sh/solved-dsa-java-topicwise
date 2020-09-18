//Game of Death in a circle GeeksforGeeks Java Solution using Recursion

import java.util.*;
import java.lang.*;
import java.io.*;

class GOD
{
	public static void GOD(int index,int k,ArrayList<Integer> per)
	{
		if(per.size()==1)
			return;
		
		index=(index+k)%(per.size());
		per.remove(index);
		
		GOD(index,k,per);
		
	}
    
	public static void main(String[] args)throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		    
		while(t!=0)
		{
		    
		    int n=sc.nextInt();
		    int k=sc.nextInt();
			
		    ArrayList<Integer> per = new ArrayList<Integer>();
		    for(int i=1;i<=n;i++)
		        per.add(i);
		    
		    k=k-1;
		    GOD(0,k,per);
		    System.out.println(per.get(0));

		    t--;
		}
	}
}
