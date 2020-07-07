// Immediate Smaller Element

import java.util.*;
import java.lang.*;
import java.io.*;

class ImmediateSmallerElement
{
    public static void immediateSmallerElement(long a[],int n)throws IOException
    {
        Vector<Long> v = new Vector<>(); 
        Stack<Long> st = new Stack<>();
        
        int i;
        long x = -1;

        for(i=n-1;i>=0;i--)
        {
            if(i==n-1)
                v.add(x);
            else if(a[i]>a[i+1])
                v.add(a[i+1]);
            else if(a[i]<=a[i+1])
                v.add(x);
            else
                continue;
        }
        
        StringBuffer sb = new StringBuffer(); 
  
        for(i=v.size()-1;i>=0;i--)
            sb.append(v.get(i)+" ");
        System.out.println(sb);
    }
    
	public static void main (String[] args)throws IOException
	{
	    
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine());
		    long a[] = new long[n];
		    
		    String s[] = br.readLine().split(" ");
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i] = Long.parseLong(s[i]);
		    }
		   
		   immediateSmallerElement(a,n);
		}
    		

	}
}
