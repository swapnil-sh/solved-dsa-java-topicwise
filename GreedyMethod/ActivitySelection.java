/* Activity Selection - GeeksforGeeks Java Solution*/

/*
-------------------------Greedy Approach--------------------------------

TC - O(nLogn)
SC - O(n)
*/

class ActivitySelection
{
    static class Pair implements Comparable<Pair>
    {
        int st;
        int end;
        
        public Pair(int st, int end)
        {
            this.st=st;
            this.end=end;
        }
        
        public int compareTo(Pair x)
        {
            return this.end-x.end;
        }
    
    }
    public static int activitySelection(int st[], int end[], int n)
    {
        // add your code here
        ArrayList<Pair> intervals=new ArrayList<>();
        int i=1,j=0,res=1;
        
        for(i=0;i<n;i++)
            intervals.add(new Pair(st[i],end[i]));
        Collections.sort(intervals);
        
        Pair prev=intervals.get(0);
        for(i=1;i<n;i++)
        {
            if(intervals.get(i).st>prev.end)
            {
                prev=intervals.get(i);
                res++;
            }
        }
        
        return res;
    }
}