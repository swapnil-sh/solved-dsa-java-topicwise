/* Rotten Oranges - GeeksforGeeks Java Solution (V.V.IMP)*/

/*
---------------------------Using BFS(Queue)-------------------------

Time Complexity : O(r*c)
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

class RottenOranges
{
    private void pushNeighbours(Pair p, Queue<Pair> q, int a[][], int r, int c)
    {
        int X=p.first;
        int Y=p.second;
        
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        
        int i,j;
        
        for(i=0;i<4;i++)
        {
            if(X+x[i]<0 || X+x[i]>=r || Y+y[i]<0 || Y+y[i]>=c || a[X+x[i]][Y+y[i]]!=1)
                continue;
                
            q.add(new Pair(X+x[i], Y+y[i]));
            a[X+x[i]][Y+y[i]]=2;
        }
    }
    
    public int rotOranges(int a[][],int r, int c)
    {
        // Write your code here
        
        int time=0;
        int i,j,count=0;
        Queue<Pair> q = new LinkedList<>();
        
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if(a[i][j]==2)
                    q.add(new Pair(i,j));
            }
        }
        
        count=q.size();
        while(count>0)
        {
            for(i=0;i<count;i++)
            {
                Pair p=q.remove();
                pushNeighbours(p, q, a, r, c);
            }
            
            count=q.size();
            if(count>0)
                time++;
        }
        
        
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if(a[i][j]==1)
                    return -1;
            }
        }
        
        return time;
    }
}