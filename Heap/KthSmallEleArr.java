/*Kth smallest element - GeeksforGeeks Java Solutions*/


/*
--------------------------Using MaxHeap------------------

TC - O(nlogk)
SC - O(k)
*/

class KthSmallEleArr
{
    public static int kthSmallest(int[] a, int l, int r, int k) 
    { 
        //Your code here
        
        if(a.length<k)
          return -1;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i;
    
        for(i=0;i<a.length;i++) 
        {
            maxHeap.add(a[i]);
            
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        
        return maxHeap.peek();
    }
}


/*
--------------------------Using MinHeap------------------

TC - O(klogn)
SC - O(n)
*/

/*
class KthSmallEleArr
{
    public static int kthSmallest(int[] a, int l, int r, int k) 
    { 
        //Your code here
        
        if(a.length<k)
          return -1;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i;
    
        for(i=0;i<a.length;i++) 
            minHeap.add(a[i]);
        
        while(k--!=1)
            minHeap.poll();
            
        return minHeap.peek();
    }
}

*/

/*
--------------------------Using Sorting------------------

TC - O(nlogn)
SC - O(1)
*/

/*Sort the array and then return the kth smallest index from the array.*/


