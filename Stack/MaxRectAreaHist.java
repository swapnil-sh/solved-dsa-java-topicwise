//Max Area of Histogram problem - Stack Implementation - GeeksforGeeks

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Collections;

class Solution 
{
    
    public static Vector<Integer> NSL(int a[],int n)
    {
        Vector<Integer> v = new Vector<>(); 
        Stack<Integer> st = new Stack<>();
        
        int i;
        int x = -1;
        
        for(i=0;i<n;i++)
        {
            if(st.size()==0)
                v.add(x);
                
            else if(st.size()>0 && a[st.peek()]<a[i])
            {
                v.add(st.peek());
            }
            
            else if(st.size()>0 && a[st.peek()]>=a[i])
            {
                while(st.size()>0 && a[st.peek()]>=a[i])
                    st.pop();
                    
                if(st.size()==0)
                    v.add(x);
                else
                    v.add(st.peek());
            }
            
            st.push(i);

        }
        
        // for(i=0;i<v.size();i++)
        //     System.out.print(v.get(i)+" ");
        // System.out.println();
        
        return v;
        
    }
    
    
    public static Vector<Integer> NSR(int a[],int n)
    {
        Vector<Integer> v = new Vector<>(); 
        Stack<Integer> st = new Stack<>();
        
        int i;
        int x = n;
        
        for(i=n-1;i>=0;i--)
        {
            if(st.size()==0)
                v.add(x);
                
            else if(st.size()>0 && a[st.peek()]<a[i])
            {
                v.add(st.peek());
            }
            
            else if(st.size()>0 && a[st.peek()]>=a[i])
            {
                while(st.size()>0 && a[st.peek()]>=a[i])
                    st.pop();
                    
                if(st.size()==0)
                    v.add(x);
                else
                    v.add(st.peek());
            }
            
            st.push(i);

        }
        
        Collections.reverse(v);
        
        return v;
        
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
	            
	       Vector<Integer> v1;
	       Vector<Integer> v2;
	       Vector<Integer> width = new Vector<>();
	       v1 = NSL(a,n);
	       v2 = NSR(a,n);
	       
	       for(i=0;i<v1.size();i++)
	            width.add(v2.get(i)-v1.get(i)-1);
	          
	
    int max_area = -1;
    int area = 0;
    for(i=0;i<width.size();i++)
    {
        area = width.get(i)*a[i];
        if(area>max_area)
            max_area = area;
        
    }
    System.out.println(max_area);
	       
	    }
	
	}
}
