/*88. Merge Sorted Array - Leetcode Java Solution*/

/*

TC - O(n+m)
SC - O(1)
*/

class MergeSortedArr
{
    public void merge(int[] a, int m, int[] b, int n)
    {
        if(n == 0)
            return;
        if(m == 0)
        {
            System.arraycopy(b, 0, a, 0, n);
            return;
        }
        
        int p1 = m - 1;
        int p2 = n - 1;
        int i;
        for (i=m+n-1;i>=0;i--) 
        {
            if(p1 < 0 || p2 >= 0 && b[p2] >= a[p1]) 
                a[i] = b[p2--];
            else
                a[i] = a[p1--];
        }
    
    }
}