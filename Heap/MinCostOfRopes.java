/* Minimum Cost of ropes - GeeksForGeeks for Java Solutions*/


/*
-----------------------Using MinHeap---------------------------
TC - O(nlogn)
SC - O(n)
*/

class MinCostOfRopes
{

    long minCost(long a[], int n) 
    {
        // your code here
        PriorityQueue<Long> minHeap=new PriorityQueue<>();
        int i;
        long res=0;
        for(i=0;i<n;i++)
            minHeap.add(a[i]);
            
        while(minHeap.size()>=2)
        {
            long x=minHeap.poll();
            long y=minHeap.poll();
            
            res=res+x+y;
            
            minHeap.offer(x+y);
        }
        
        return res;
    }
}

/*
-----------------------Using Sorting---------------------------
TC - O(n^2(logn))
SC - O(n)
*/

