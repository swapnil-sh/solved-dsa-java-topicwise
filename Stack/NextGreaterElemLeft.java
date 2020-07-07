// Next larger element on Left using Stack - O(n) 

import java.util.*;
import java.lang.*;
import java.io.*;

class NextGreaterElemLeft
{
    public static void findNextGreaterElementLeft(long a[],int n)
    {
        Vector<Long> v = new Vector<>(); 
        Stack<Long> st = new Stack<>();
        
        int i;
        long x = -1;
        
        for(i=0;i<n;i++)
        {
            if(st.size()==0)
                v.add(x);
                
            else if(st.size()>0 && st.peek()>a[i])
            {
                v.add(st.peek());
            }
            
            else if(st.size()>0 && st.peek()<=a[i])
            {
                while(st.size()>0 && st.peek()<=a[i])
                    st.pop();
                    
                if(st.size()==0)
                    v.add(x);
                else
                    v.add(st.peek());
            }
            
            st.push(a[i]);

        }
        
        for(i=0;i<v.size();i++)
            System.out.print(v.get(i)+" ");
        System.out.println();
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
		   
		   findNextGreaterElementLeft(a,n);
		}
    		

	}
}




----------------------------------------------------------------------------------------------------

INPUT

1
4
1 3 2 4

OUTPUT

-1 -1 3 -1 

