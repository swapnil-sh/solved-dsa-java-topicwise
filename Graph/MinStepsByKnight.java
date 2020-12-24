/* Steps by Knight - GeeksforGeeks Java Solution*/

/*
-----------------------Using BFS--------------------

Time Complexity: O(N2).
Auxiliary Space: O(N2).
*/

class Pair implements Comparable<Pair>
{
    int first;
    int second;
 
    public Pair(int first, int second) 
    {
        this.first = first;
        this.second = second;
    }
 
    @Override
    public int compareTo(Pair o)
    {
        return second - o.second;
    }
}

class MinStepsByKnight
{
    // KnightPos : knight position coordinates
    // targetPos : target position coordinated
    // N : square matrix size
    boolean flag=false;
    private void pushNextCoords(Pair p, Queue<Pair> q, int d1, int d2, boolean vis[][], int n)
    {
        
        int s1=p.first;
        int s2=p.second;
        
        int x[]={-1, -1, 1, 1, 2, 2, -2, -2};
        int y[]={2, -2, 2, -2, 1, -1, 1, -1};
        
        int i;
        
        for(i=0;i<8;i++)
        {
            if(s1+x[i]<0 || s1+x[i]>=n || s2+y[i]<0 || s2+y[i]>=n || vis[s1+x[i]][s2+y[i]])
                continue;
            
            if(s1+x[i]==d1 && s2+y[i]==d2)
            {
                flag=true;
                return;
            }
            q.add(new Pair(s1+x[i], s2+y[i]));
            vis[s1+x[i]][s2+y[i]]=true;
        }
    }
    public int minStepToReachTarget(int knightpos[], int targetpos[], int N) 
    {
        // Write your code here
        int s1=knightpos[0]-1;
        int s2=knightpos[1]-1;
        int d1=targetpos[0]-1;
        int d2=targetpos[1]-1;
        
        int i,j,steps=0;
        
        if(s1==d1 && s2==d2)
            return steps;
        
        boolean vis[][]=new boolean[N][N];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(s1,s2));
        vis[s1][s2]=true;
        
        int count=q.size();
        while(count>0)
        {
            steps++;
            for(i=0;i<count;i++)
            {
                Pair p=q.remove();
                pushNextCoords(p, q, d1, d2, vis, N);
                
                if(flag)
                    return steps;
            }
            
            count=q.size();
        }
        
        return steps;
    }
}
