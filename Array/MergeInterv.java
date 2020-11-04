/*56. Merge Intervals - Leetcode and GFG Java Solutions*/

/*
TC = O(nlogn)+O(n)
*/


/*---------------------Full Program GeeksforGeeks--------------------- */

import java.util.*;
import java.lang.*;
import java.io.*;

class Interval
{
    int start,end;
    Interval(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
}
class MergeInterv
{
    public static void solve(Interval arr[])
    {
     
        Arrays.sort(arr,new Comparator<Interval>(){ 
            public int compare(Interval i1,Interval i2) 
            { 
                return i1.start - i2.start; 
            } 
        }); 
    
        int index=0; 
    
        for (int i=1;i<arr.length;i++)  
        {  
             
            if (arr[index].end>= arr[i].start)  
            {  
                arr[index].end = Math.max(arr[index].end, arr[i].end);  
                arr[index].start = Math.min(arr[index].start, arr[i].start);  
                
            }  
            else 
            { 
                index++; 
                arr[index] = arr[i];  
            }     
        } 
          
        for (int i=0;i<=index;i++)  
                System.out.print(arr[i].start + " " + arr[i].end +" ");
    }
	public static void main (String[] args)throws Exception
	{
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t--!=0)
		{
		    int n=sc.nextInt();
		    int i;
		    Interval arr[]=new Interval[n]; 
            
            
            for(i=0;i<n;i++)
		    {
		        int st=sc.nextInt();
		        int end=sc.nextInt();
		        arr[i]=new Interval(st,end); 
		    }
		    
		    solve(arr);
		    System.out.println();
		}
	}
}
/*
class MergeInterv
{
    public int[][] merge(int[][] intervals)
    {
        
        List<int[]> res=new ArrayList<>();
        int n=intervals.length;
        if(n==0 || intervals==null)
            return res.toArray(new int[0][]);
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        
        int st=intervals[0][0];
        int end=intervals[0][1];
        
        for(int[] i: intervals)
        {
            if(i[0]<=end)
                end=Math.max(end,i[1]);
            else
            {
                res.add(new int[]{st,end});
                st=i[0];
                end=i[1];
            }
        }
    
        res.add(new int[]{st,end});
        return res.toArray(new int[0][]);
    }
}
*/

/*class Solution 
{
    class Pair implements Comparable<Pair>
    {
        int start;
        int end;
        Pair(int start, int end)
        {
            this.start=start;
            this.end=end;
        }
        
        public int compareTo(Pair p)
        {
            if(this.start<p.start)
                return -1;
            
            else if(this.start == p.start)
            {
                if(this.end<p.end)
                    return -1;
                else if(this.end==p.end)
                    return 0;
                else 
                    return 1;
            }
            else
                return 1;
        }
    }
    
    public int[][] merge(int[][] intervals) 
    {
        if(intervals.length <= 1)
            return intervals;
        
        LinkedList<Pair> list=new LinkedList<>();
        
        int i;
        for(i=0;i<intervals.length;i++)
            list.add(new Pair(intervals[i][0],intervals[i][1]));
        
        Collections.sort(list);
        
        int slow=0,fast=1;
        while(fast<list.size())
        
        {
            //Overlap case
            if(list.get(slow).end>=list.get(fast).start)
            {
                list.get(slow).start=Math.min(list.get(slow).start,list.get(fast).start);
                list.get(slow).end=Math.max(list.get(slow).end,list.get(fast).end);
                list.remove(fast);
                fast=slow+1;
            }else
            {
                slow=fast;
                fast=fast+1;
            }
            //Non Overlap case
        }
        
        int[][] ans=new int[list.size()][2];
        
        for(i=0;i<list.size();i++)
        {
            ans[i][0]=list.get(i).start;
            ans[i][1]=list.get(i).end;
        }
        
        return ans;
    }
}
*/