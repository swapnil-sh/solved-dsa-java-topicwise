/* Kth smallest element - GeeksforGeeks Solution*/


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
    for(i=0;i<k;i++)
      maxHeap.add(a[i]);
    
    
    for(i=k;i<a.length;i++) 
    {
      if(a[i]<maxHeap.peek())
      {
        maxHeap.poll();
        maxHeap.add(a[i]);
      }  
    }
    
    return maxHeap.peek();
   }
} 