/*56. Merge Intervals - Leetcode Java Solutions*/

/*
TC = O(nlogn)+O(n)
*/

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