/* First negative integer in every window of size k - GeeksforGeeks Java Solutions*/

/*
--------------------------Using Sliding Window Technique-----------------------------

TC - O(N)
SC - O(k)
*/

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class FirstNegEleInSubarrOfK
{
    static ArrayList<Integer> solve(int K, int a[],int N)
    {
        
        int i=0,j=0,flag=0;
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        while(j<N)
        {
            if(a[j]<0)
                q.offer(a[j]);
            
            if(j-i+1==K)
            {
                if(q.size()==0)
                    res.add(0);
                else
                {
                    res.add(q.peek());
                    if(a[i]==q.peek())
                        q.poll();
                }
                
                i++;
                j++;
            }
            else
                j++;
        }
        
        return res;
    }
    
    public static void main(String[] args)throws IOException 
    { 
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t=Integer.parseInt(st.nextToken()); 
        while(t--!=0) 
        { 
            int n=Integer.parseInt(br.readLine()); 
            int a[]=new int[n];
            int i;
            
            String[] ipArr=br.readLine().split("\\s");
            for(i=0;i<n;i++)
                a[i]=Integer.parseInt(ipArr[i]);
            
            int k=Integer.parseInt(br.readLine());
            
            ArrayList<Integer> res=solve(k, a, n);
            
            for(i=0;i<res.size();i++)
                System.out.print(res.get(i)+" ");
            
            System.out.println();
        } 
        
    } 
} 




/*
--------------------------Brute Force-----------------------------

TC - O(K*N)
SC - O(1)
*/
/*
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class JavaTemp
{
    static ArrayList<Integer> solve(int K, int a[],int N)
    {
        // code here
        int i,j,flag=0;
        ArrayList<Integer> res=new ArrayList<>();
        
        for(i=0;i<=N-K;i++)
        {
            flag=0;
            for(j=i;j<i+K;j++)
            {
                if(a[j]<0)
                {
                    res.add(a[j]);
                    flag=1;
                    break;
                }
            }
            
            if(flag==0)
                res.add(0);
        }
        
        return res;
    }
    
    public static void main(String[] args)throws IOException 
    { 
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t=Integer.parseInt(st.nextToken()); 
        while(t--!=0) 
        { 
            int n=Integer.parseInt(br.readLine()); 
            int a[]=new int[n];
            int i;
            
            String[] ipArr=br.readLine().split("\\s");
            for(i=0;i<n;i++)
                a[i]=Integer.parseInt(ipArr[i]);
            
            int k=Integer.parseInt(br.readLine());
            
            ArrayList<Integer> res=solve(k, a, n);
            
            for(i=0;i<res.size();i++)
                System.out.print(res.get(i)+" ");
            
            System.out.println();
        } 
        
    } 
} 
*/