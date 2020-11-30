/*703. Kth Largest Element in a Stream - Java Solution using MinHeap*/

class KthLargestEleStream
{
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    int k=0;
    public KthLargest(int k, int[] a) 
    {
        this.k=k;
        for(int i=0;i<a.length;i++)
        {
            minHeap.offer(a[i]);
            if(minHeap.size()>k)
                minHeap.poll();
        }
    }
    
    public int add(int val)
    {   
        minHeap.offer(val);
        if(minHeap.size()>k)
            minHeap.poll();
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

