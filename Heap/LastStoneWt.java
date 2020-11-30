/*1046. Last Stone Weight - Leetcode Java Solution*/


/*
----------------------------Using MaxHeap--------------------------

*/

class LastStoneWt
{
    public int lastStoneWeight(int[] a) 
    {
        if(a.length==0)
            return 0;
        if(a.length==1)
            return a[0];
        
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        
        int i;
        
        for(i=0;i<a.length;i++)
            maxHeap.add(a[i]);
        
        while(maxHeap.size()>1)
        {
            int x=maxHeap.poll();
            int y=maxHeap.poll();
            
            if(x==y)
                continue;
            else
            {
                int diff=x-y;
                maxHeap.offer(diff);
            }
            
        }
        
        return maxHeap.size()==1?maxHeap.peek():0;
        
    }
}