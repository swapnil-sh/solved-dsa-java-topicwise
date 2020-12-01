/*215. Kth Largest Element in an Array - Leetcode Java Solutions*/


/*
----------------------Using MinHeap---------------------------

TC - O(nLogk)
SC - O(k)
*/

class KthLargestEleArr
{
    public int findKthLargest(int[] a, int k)
    {
        if(k==1 && a.length==1)
            return a[0];
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int i;
        
        for(i=0;i<a.length;i++)
        {
            minHeap.offer(a[i]);
            
            if(minHeap.size()>k)
                minHeap.poll();
        }
        
        return minHeap.peek();
    }
}


/*
--------------------------Using MaxHeap------------------

TC - O(klogn)
SC - O(n)
*/

/*
class KthLargestEleArr
{
    public static int kthLargest(int[] a, int k) 
    { 
        //Your code here
        
        if(k==1 && a.length==1)
            return a[0];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i;
    
        for(i=0;i<a.length;i++) 
            maxHeap .add(a[i]);
        
        while(k--!=1)
            maxHeap .poll();
            
        return maxHeap.peek();
    }
}
*/

/*
--------------------------Using Sorting------------------

TC - O(nlogn)
SC - O(1)
*/

/*Sort the array and then return the kth largest index from the array.*/