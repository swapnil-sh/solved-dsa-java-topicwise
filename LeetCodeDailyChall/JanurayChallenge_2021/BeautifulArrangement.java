/*Beautiful Arrangement - Leetcode Java Solutions*/

/*
-------------------USing Backtracking(DFS)----------------------

TC - O(k)
SC - O(n)
*/

class BeautifulArrangement
{
    int res=0;
    public int countArrangement(int n) 
    {
        int a[]=new int[n+1];
        
        dfs(a, 1, n);
        return res;
    }
    
    private void dfs(int a[], int val, int n)
    {
        if(val>n)
        {
            res++;
            return;
        }
        
        int i;
        for(i=1;i<=n;i++)
        {
            if(a[i]==0 && (val%i==0 || i%val==0))
            {
                a[i]=val;
                dfs(a, val+1, n);
                a[i]=0;
            }   
        }
        
    }
}