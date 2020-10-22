/* Power of 2 - GeeksforGeeks Java Solution using Bitwise &*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class PowerOfTwo
{
	public static void main (String[] args)throws Exception
	{
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t--!=0)
		{
		    Long n=sc.nextLong();
	
	        if(n==0)
	            System.out.println("NO");
	        else
	            System.out.println((n&n-1)==0?"YES":"NO");
		}
	}
}