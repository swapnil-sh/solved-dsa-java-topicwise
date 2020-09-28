/*Aggressive cows - SPOJ Java Binary-Search Solution*/

import java.util.*;
import java.lang.*;
import java.io.*;

class AGGRCOW 
{
    public static boolean validMinDistance(int a[],int n,int c,int dist)
    {
        int i,cowsCount=1,lastpos=a[0];
        
        for(i=1;i<n;i++)
        {
            if(a[i]-lastpos<dist)
                continue;
            
            cowsCount++;
            if(cowsCount==c)
                return true;
            lastpos=a[i];
        }
        return false;
    }
    public static int binarySearch(int a[],int n,int c)
    {
        
        int i,st,end,res=-1;        
        st=1;
        end=a[n-1];
        
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(validMinDistance(a,n,c,mid)==true)
            {
                res=mid;
                st=mid+1;
            }
            else
                end=mid-1;
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
		    String[] inputLine;
            inputLine=br.readLine().trim().split(" ");
            int n=Integer.parseInt(inputLine[0]);
            int c=Integer.parseInt(inputLine[1]);
		    int[] a = new int[n];
		   
		    for (int i=0;i<n;i++)
		        a[i] = Integer.parseInt(br.readLine());

            Arrays.sort(a);
		    		    
		    System.out.println(binarySearch(a,n,c));
		}
		
	}
}
