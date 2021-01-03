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


/*
Complexity Analysis

    Time complexity : O(k). k refers to the number of valid permutations.

    Space complexity : O(n). The depth of recursion tree can go upto nnn. Further, numsnumsnums array of size nnn is used, where, nnn is the given number.

*/

/*
class Solution
{
    int res=0;
    public int countArrangement(int n) 
    {
        int a[]=new int[n+1];
        int i;
        
        for(i=1;i<=n;i++)
            a[i]=i;
        
        dfs(a, n);
        
        return res;
    }
    
    private void dfs(int a[], int val)
    {
        if(val==0)
        {
            res++;
            return;
        }
        
        int i;
        for(i=val;i>0;i--)
        {
            swap(a, i, val);
            if(a[val]%val==0 || val%a[val]==0)
                dfs(a, val-1);
            swap(a, i, val);
        }
    }
    
    private void swap(int a[], int i, int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
*/

/*
public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
*/