/*Maximum of all subarrays of size k - GeeksforGeeks Java Solutions */

/*
----------------------------Brute Force------------------------
TC - O(n*k)
SC - O(1)
*/
class MaxElesFromSubarrOfK
{
    static ArrayList <Integer> max_of_subarrays(int a[], int n, int k)
    {
        // Your code here
        int i,j,max=Integer.MIN_VALUE;
        ArrayList<Integer> res=new ArrayList<>();
        
        for(i=0;i<=n-k;i++)
        {
            max=Integer.MIN_VALUE;
            for(j=i;j<i+k;j++)
            {
                if(a[j]>max)
                    max=a[j];
            }
            res.add(max);
        }
        
        return res;
    }
}