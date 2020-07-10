//Max Area Rectangle in binary matrix - Stack Implementation using MHA - GeeksforGeeks

import java.util.*;
import java.lang.*;

class MaxRectBinMat 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
	{
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[1000][1000];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) 
			a[i][j] = sc.nextInt();

            GfG g = new GfG();

            System.out.println(g.maxArea(a, m, n));
      	}
    }
}


class GfG 
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
    
    public int MAH(int a[],int n)
    {
        int i;
        Vector<Integer> v1;
        Vector<Integer> v2;
        v1 = NSL(a,n);
        v2 = NSR(a,n);

        int max_area = -1;
        int area = 0;
        for(i=0;i<v1.size();i++)
        {
            area = (v2.get(i)-v1.get(i)-1)*a[i];
            if(area>max_area)
                max_area = area;
        
        }
        return max_area;
    }
    
    public int maxArea(int M[][], int m, int n) 
    {
        int a[] = new int[n];
        int i,j,maxareamatrix = 0;
        for(j=0;j<n;j++)
        {
            a[j] = M[0][j];
        }
        
        
        maxareamatrix = MAH(a,n);
        //System.out.println(x);
        for(i=1;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(M[i][j]==0)
                    a[j] = 0;
                else
                    a[j] = a[j]+M[i][j];
            }
            //System.out.println(MAH(a,n));
            maxareamatrix = Math.max(maxareamatrix, MAH(a,n));
            //System.out.println(maxareamatrix);
        }
        
        return maxareamatrix;
    }
}
