/*Allocate minimum number of pages - GeeksforGeeks Binary Search Java Solution (HARD  & IMP)*/

import java.util.*;
import java.lang.*;
import java.io.*;

class AllocMinNoOfPages 
{
	public static boolean isValue(int a[],int n,int m,long max)
	{
		int i;
		long sum=0,student=1;
		
		for(i=0;i<n;i++)
		{
		    sum+=a[i];
		    if(sum>max)
		    {
		        sum=a[i];
		        student++;
		    }
		    
		    if(student>m)
		        return false;
		        
		}
		
		return true;
	}

	public static long AllocateMinPages(int a[],int n,int m)
	{
		if(n<m)
		    return -1;
		    
		int i;
		long max=0,st,end,sumofarr=0,res=-1;
		
		for(i=0;i<n;i++)
		{
		    if(a[i]>max)
		        max=a[i];
		}
		
		for(i=0;i<n;i++)
		    sumofarr+=a[i];
		
		
		st=max;
		end=sumofarr;
		
		while(st<=end)
		{
		    long mid=st+(end-st)/2;
		    if(isValue(a,n,m,mid)==true)
		    {
		        res=mid;
		        end=mid-1;
		    }
		    else
		        st=mid+1;
		    
		}
		
		return res;
		
	    }
	public static void main (String[] args)throws IOException
	{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		while (tc-- > 0) 
		{
		    int n = Integer.parseInt(br.readLine());
		    String[] inputLine;
		
		    int[] a = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for (int i = 0; i < n; i++)
		        a[i] = Integer.parseInt(inputLine[i]);
		    
		    int m=Integer.parseInt(br.readLine());
		    
		    System.out.println(AllocateMinPages(a,n,m));
		}
		
	}
}



/*

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= A [ i ] <= 106
1 <= M <= 106

Example:
Input:
2
4
12 34 67 90
2
3
15 17 20
2
Output:
113
32

Explaination:
Testcase 1:Allocation can be done in following ways:
{12} and {34, 67, 90}     Maximum Pages = 191
{12, 34} and {67, 90}     Maximum Pages = 157
{12, 34, 67} and {90}        Maximum Pages = 113

Therefore, the minimum of these cases is 113, which is selected as output.

Testcase 2: Allocation can be done in following ways:
{15} and {17, 20} Maximum pages = 37
{15, 17} and {20} Maximum Pages = 32

So, the output will be 32.

*/
