/* Bit Difference  - GeeksforGeeks Java Solution using the the concept of XOR and RSB*/


/*
Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. The first line of each test case is A and B separated by a space.

Output:
For each testcase, in a new line, print the number of bits needed to be flipped.
*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class BitDiff 
{
	public static void main (String[] args)throws Exception
	{
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t--!=0)
		{
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    
		    int c=a^b;
		    
		    int res=0;
		    int rsb=0;
		    
		    while(c!=0)
		    {
		        rsb=c & -c;
                c=c - rsb;
                res++;
		    }
		    
		    System.out.println(res);
		}
		
	}
}