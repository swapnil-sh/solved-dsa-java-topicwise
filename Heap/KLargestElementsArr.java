/* K largest elements - GeeksforGeeks Java Solution*/

/*
-----------------Using MinHeap---------------------

TC - O((n-k)logk)+O(klogk)
SC - O(k)
*/

class KLargestElementsArr
{
    public static ArrayList<Integer> kLargest(int a[], int n, int k)
    {
        // code here 
        ArrayList<Integer> res=new ArrayList<>();
        if(k<=0)
            return res;
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int i;
        
        for(i=0;i<a.length;i++)
        {
            minHeap.offer(a[i]);
            
            if(minHeap.size()>k)
                minHeap.poll();
        }
        
        while(k--!=0)
            res.add(minHeap.poll());
        
        Collections.reverse(res);
        return res;
    }
}