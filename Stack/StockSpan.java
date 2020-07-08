//Stock Span problem - Stack Implementation - GeeksforGeeks

import java.util.*;
import java.lang.*;
import java.io.*;

class StockSpan 
{
    
    public static void stockSpan(int a[],int n)
    {
        Vector<Integer> v = new Vector<>(); 
        Stack<Integer> st = new Stack<>();
        
        int i;
        int x = -1;
        
        for(i=0;i<n;i++)
        {
            if(st.size()==0)
                v.add(i-x);
                
            else if(st.size()>0 && a[st.peek()]>a[i])
            {
                v.add(i-st.peek());
            }
            
            else if(st.size()>0 && a[st.peek()]<=a[i])
            {
                while(st.size()>0 && a[st.peek()]<=a[i])
                    st.pop();
                    
                if(st.size()==0)
                    v.add(i-x);
                else
                    v.add(i-st.peek());
            }
            
            st.push(i);

        }
        
        for(i=0;i<v.size();i++)
            System.out.print(v.get(i)+" ");
        System.out.println();
        
    }
	public static void main (String[] args)throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t;
	    t = Integer.parseInt(br.readLine());
	    
	    while(t-->0)
	    {
	        int n,i;
	        n = Integer.parseInt(br.readLine());
	        int a[] = new int[n];
	        String s[] = br.readLine().split(" ");
	        for(i=0;i<n;i++)
	            a[i] = Integer.parseInt(s[i]);
	            
	        stockSpan(a,n);
	    }
	
	}
}
